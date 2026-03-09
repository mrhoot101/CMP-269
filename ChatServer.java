package Multi_Platform_Chat_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ChatServer {

	private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

	public static final int PORT = 59001;

	TextField inputMessages;

	private static class ClientHandler extends Thread {

		private Socket socket;

		public ClientHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			System.out.println("Handling client communication in thread: " + Thread.currentThread());

			BufferedReader reader = null;
			PrintWriter writer = null;
			String username = null;

			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);

				clientWriters.add(writer); // Add the client's writer to the set of client writers for broadcasting
											// messages

				// Ask the client for the username
				writer.println("SERVER: Enter your username:");
				username = reader.readLine();
				System.out.println("Client " + socket.getRemoteSocketAddress() + " set username to: " + username);

				// broadcast to all clients that a new user joined the chat
				broadcastMessage("SERVER: " + username + " has joined the chat!");

				String message;
				while ((message = reader.readLine()) != null) {
					System.out.println("Received message from " + username + ": " + message);
					broadcastMessage(username + ": " + message);
				}

			} catch (IOException e) {
				System.out.println("Error handling client communication: " + e.getMessage());
			} finally {
				try {
					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();
					if (username != null) {
						broadcastMessage("Server: " + username + " has left the chat");
					}
				} catch (Exception e2) {
					System.out.println("Error closing client resources: " + e2.getMessage());
				}
			}
		}

		private void broadcastMessage(String message) {
			synchronized (clientWriters) {
				for (PrintWriter writer : clientWriters) {
					writer.println(message);
				}
			}
		}
	}

	

	public static void main(String[] args) {

		System.out.println("The chat server is runing. Awaiting for connection at port " + PORT + "...");

		try (ServerSocket listener = new ServerSocket(PORT)) {

			while (true) {

				// accept a new client connection
				var socket = listener.accept(); // blocks until a user connct
				System.out.println("New Client connected: " + socket.getRemoteSocketAddress());


				// how do we handle client communication
				ClientHandler handler = new ClientHandler(socket);
				handler.start(); // starts the thread to handle client communication
			}

		} catch (IOException e) {
			System.out.println("Error starting the server: " + e.getMessage());
		}

	}

}
