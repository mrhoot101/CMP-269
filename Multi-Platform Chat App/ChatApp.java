package Multi_Platform_Chat_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicReference;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ChatApp extends Application {

	private static final String SERVER_ADDRESS = "127.0.0.1";
	private static final int PORT = 59001;

	private static javafx.scene.control.TextArea messagesPost = new javafx.scene.control.TextArea();

	private static class IncomingMessageHandler extends Thread {
		private BufferedReader reader;

		public IncomingMessageHandler(BufferedReader reader) {
			this.reader = reader;

		}

		@Override
		public void run() {
			String message;

			try {
				sleep(1000);

				while ((message = reader.readLine()) != null) {

					AtomicReference<String> m = new AtomicReference<String>(message);

					Platform.runLater(() -> {
						messagesPost.appendText(m.get() + "\n");
					});

				}
			} 
			catch (SocketException e) {
				
			}catch (IOException e) {
				System.out.println("Error reading messages from the server: " + e.getMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		System.out.printf("Connecting to chat server at %s:%d...\n", SERVER_ADDRESS, PORT);

		launch(args);
	}
	Socket socket = null;
	PrintWriter writer = null;
	BufferedReader reader = null;

	public void start(Stage primaryStage) throws Exception {
		
//		PrintWriter writer = null;
		
		try {

			socket = new Socket(SERVER_ADDRESS, PORT);
			writer = new PrintWriter(socket.getOutputStream(), true); // Picks up anything the user types
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			Thread incomingMessageHandler = new IncomingMessageHandler(reader);
			incomingMessageHandler.start();

//		app.connectServer(socket,writer,reader);

			BorderPane chat = new BorderPane();
			chat.setPadding(new Insets(60));

			// Area where messages are posted

			messagesPost.setMinHeight(100);
			messagesPost.autosize();
			messagesPost.setEditable(false);
			chat.setCenter(messagesPost);

			// area used to enter messages

			HBox messageBox = new HBox();
			messageBox.setMaxWidth(Double.MAX_VALUE);

			TextField inputMessages = new TextField();
			inputMessages.setFont(new javafx.scene.text.Font("Arial", 15));


			inputMessages.setMinHeight(30);
			messageBox.setHgrow(inputMessages, Priority.ALWAYS);

			Button sendButton = new Button("Send");
			sendButton.setPrefSize(50, 30);
			sendButton.setDefaultButton(true);

			sendButton.setOnAction(event -> {
				writer.println(inputMessages.getText());
				inputMessages.setText("");
			});

			messageBox.getChildren().addAll(inputMessages, sendButton);

			chat.setBottom(messageBox);

			Scene scene = new Scene(chat, 640, 480);
			primaryStage.setTitle("Chat ");
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(event -> {
				
				incomingMessageHandler.interrupt();
				try {
					if (socket != null) {socket.close();}
					if (reader != null) {reader.close();}
					if (writer != null) {socket.close();}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Platform.exit();
			});
			primaryStage.show();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (reader != null && socket.isClosed()) {
				try {
					reader.close();
				} catch (IOException e2) {
					System.out.println("Error closing the reader: " + e2.getMessage());
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
}
