package Multi_Platform_Chat_App;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class SimpleClient {

	private static final String SERVER_ADDRESS = "127.0.0.1";
	private static final int PORT = 59001;

	private static class IncomingMessageHandler extends Thread {
		private BufferedReader reader;
		private boolean r = true;

		public IncomingMessageHandler(BufferedReader reader) {
			this.reader = reader;

		}

		@Override
		public void run() {
			String message;

			try {
				while (r) {
					;
					while ((message = reader.readLine()) != null) {
						System.out.println(message);
					}
				}
			} catch (SocketException e2) {
//				e2.getMessage();
			}catch (IOException e) {
				System.out.println("Error reading messages from the server: " + e.getMessage());
			} 
		}
		
	}

//	}
	public static void main(String[] args) {
//		SimpleClient client = ;

		System.out.printf("Connecting to chat server at %s:%d...\n", SERVER_ADDRESS, PORT);

		Socket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;

		try {
			// Connect to the server
			socket = new Socket(SERVER_ADDRESS, PORT);
			writer = new PrintWriter(socket.getOutputStream(), true); // Picks up anything the user types
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// separate thread to handle incoming messages from the server
			// handle incoming messages from the server in a separate thread
			Thread incomingMessageHandler = new IncomingMessageHandler(reader);
			incomingMessageHandler.start();

			// main thread will handle user input and sending messages to the server
			System.out.println("Connected to the chat server");
			System.out.println("Type your message");
			Scanner sc = new Scanner(System.in);
			String line;
			while (sc.hasNextLine()) {
				String message = sc.nextLine();
				if (message != null && message.equals("QUIT")) {
					socket.close();
					break;
				}
				writer.println(message); // sends the user message to the server
			}

		} catch (IOException e) {
			System.out.println("Error connecting to the server " + e.getMessage());
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e2) {
					System.out.println("Error closing the reader: " + e2.getMessage());
				}
			}
			if (writer != null) {
				writer.close();
			}
			if (socket != null) {

				try {
					socket.close();
				} catch (IOException e2) {
					System.out.println("Error closing the socket " + e2.getMessage());
				}
			}
		}

	}

}
