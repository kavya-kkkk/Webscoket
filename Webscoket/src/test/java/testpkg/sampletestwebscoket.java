package testpkg;



import org.testng.annotations.Test; 



import javax.websocket.*; 

import java.io.IOException; 

import java.net.URI; 

import java.net.URISyntaxException; 

import java.util.concurrent.CountDownLatch; 

import java.util.concurrent.TimeUnit; 



@ClientEndpoint 

public class sampletestwebscoket { 



  private Session session; 

  private CountDownLatch messageLatch; 



  @Test 

  public void testWebSocketCommunication() throws URISyntaxException, IOException, DeploymentException, InterruptedException { 

      WebSocketContainer container = ContainerProvider.getWebSocketContainer(); 

      String uri = "wss://api.bitfinex.com/ws/21";  // Replace with your WebSocket URL 

      messageLatch = new CountDownLatch(1); 



      session = container.connectToServer(this, new URI(uri)); 



      // Send a message to the server 

      session.getBasicRemote().sendText("Hello, Server!"); 



      // Wait for the response message 

      messageLatch.await(5, TimeUnit.SECONDS); 



      // Close the WebSocket connection 

      session.close(); 

  } 



  @OnOpen 

  public void onOpen(Session session) { 

      System.out.println("Connected to WebSocket server"); 

  } 



  @OnMessage 

  public void onMessage(String message, Session session) { 

      System.out.println("Received message: " + message); 

      messageLatch.countDown();  // Release the latch to signal message received 

  } 



  @OnClose 

  public void onClose(Session session, CloseReason closeReason) { 

      System.out.println("WebSocket connection closed: " + closeReason.getReasonPhrase()); 

  } 

} 
