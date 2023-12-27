package Webscoket.com;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;

public class Websocketspaceband {

    @Test
    public void testWebSocketCommunication() throws URISyntaxException, InterruptedException {
        // Define WebSocket URL
        URI uri = new URI("wss://localhost:6001");

        // Create WebSocket client
        WebSocketClient webSocketClient = new WebSocketClient(uri) {
            public void onOpen(ServerHandshake handshakedata) {
                // WebSocket connection is open
                System.out.println("WebSocket connection opened.");
                // Send your request message here
                String requestMessage = "{\r\n"
                		+ "   \"message type\":0,\r\n"
                 	 	+ "   \"content type\":2014,\r\n"
                		+ "   \"request status\":?,\r\n"
                 		+ "   \"serial number\": \"WEA248FZK\", \r\n"
                		+ "   \"time\": \"2021-02-14T15:42:09Z\", \r\n"
                		+ "   \"beacon number\":11,\r\n"
                		+ "   \"duration\": 0,\r\n"
                		+ "   \"alert dismissed\":0\r\n"
                		+ "}";
                send(requestMessage);
            }

            public void onMessage(String message) {
                // Handle received messages
                System.out.println("Received message: " + message);
                // Parse the response message and assert its correctness
                String expectedResponse = "{\"message type\":1,\"content type\":2008,\"request status\":\"?\"}";
                assertEquals(expectedResponse, message);
                // Close the WebSocket connection after receiving the response
                close();
            }

            public void onClose(int code, String reason, boolean remote) {
                // WebSocket connection closed
                System.out.println("WebSocket connection closed.");
                System.out.println("WebSocket connection closed with code: " + code + ", reason: " + reason + ", remote: " + remote);
            }

            public void onError(Exception ex) {
                // Handle errors
                ex.printStackTrace();
            }
        };

        // Connect to the WebSocket server
        webSocketClient.connect();

        // Wait for the WebSocket connection to be established and the response to be received
        Thread.sleep(5000); // Adjust the sleep time as needed
    }
}
