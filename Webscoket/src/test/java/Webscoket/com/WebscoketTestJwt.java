package Webscoket.com;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WebscoketTestJwt {

    public static void main(String[] args) throws URISyntaxException {
        // WebSocket URL with custom headers
        URI uri = new URI("ws://localhost:5000/hubs/Spacebands");
 
        // Custom headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjQxNjUxMjg1LTYyODEtNDczMS05MDFkLTNjZmJiNDEzNDE3OSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6ImRlZXBhay5zaXZha3VtYXJAcmhpYmh1cy5jb20iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiRGVlcGFrIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc3VybmFtZSI6IlNpdmFrdW1hciIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL21vYmlsZXBob25lIjoiOTk5OTk5OTk5OSIsIklzQ2xpZW50IjoiVHJ1ZSIsIkNvbnRhY3RJZCI6IjEiLCJTdHJpcGVDdXN0b21lcklkIjoiY3VzX1AzSDNMWVpVUDA0aUhqIiwiVGltZVpvbmUiOiJHTVQiLCJDdXJyZW5jeSI6IkdCUCIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IkNsaWVudEFkbWluIiwiUGVybWlzc2lvbiI6WyJQZXJtaXNzaW9ucy5Vc2Vycy5WaWV3IiwiUGVybWlzc2lvbnMuVXNlcnMuU2VhcmNoIiwiUGVybWlzc2lvbnMuU3VydmV5LlZpZXciLCJQZXJtaXNzaW9ucy5TdXJ2ZXkuU2VhcmNoIiwiUGVybWlzc2lvbnMuU3VydmV5QW5zd2VyLlZpZXciLCJQZXJtaXNzaW9ucy5TdXJ2ZXlBbnN3ZXIuU2VhcmNoIiwiUGVybWlzc2lvbnMuRmVhdHVyZS5WaWV3IiwiUGVybWlzc2lvbnMuRmVhdHVyZS5TZWFyY2giLCJQZXJtaXNzaW9ucy5EYXNoYm9hcmRzLlZpZXciLCJQZXJtaXNzaW9ucy5Qcm9maWxlLkVkaXQiLCJQZXJtaXNzaW9ucy5Vc2Vycy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5Vc2Vycy5FZGl0IiwiUGVybWlzc2lvbnMuVXNlcnMuRGVsZXRlIiwiUGVybWlzc2lvbnMuVXNlcnMuRXhwb3J0IiwiUGVybWlzc2lvbnMuVXNlcnMuSW1wb3J0IiwiUGVybWlzc2lvbnMuU3VydmV5LkNyZWF0ZSIsIlBlcm1pc3Npb25zLlN1cnZleS5FZGl0IiwiUGVybWlzc2lvbnMuU3VydmV5LkRlbGV0ZSIsIlBlcm1pc3Npb25zLkZlYXR1cmUuQ3JlYXRlIiwiUGVybWlzc2lvbnMuRmVhdHVyZS5FZGl0IiwiUGVybWlzc2lvbnMuRmVhdHVyZS5EZWxldGUiLCJQZXJtaXNzaW9ucy5CaWxsaW5nLlZpZXciLCJQZXJtaXNzaW9ucy5CaWxsaW5nLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkJpbGxpbmcuRWRpdCIsIlBlcm1pc3Npb25zLkJpbGxpbmcuRGVsZXRlIiwiUGVybWlzc2lvbnMuQmlsbGluZy5TZWFyY2giLCJQZXJtaXNzaW9ucy5IYW5nZmlyZS5WaWV3Il0sImV4cCI6MTcwMTUxODMzMn0.xEbr9cXEvkFHURguGvyxgJkCkz7f3tzXwqH8EnYUJ_E");
        headers.put("Content-Type","application/json");
        // Create WebSocket client
        WebSocketClient webSocketClient = new WebSocketClient(uri, headers) {
            @Override 
            public void onOpen(ServerHandshake handshakedata) {
                System.out.println("WebSocket connection opened.");
 
                 // Send your WebSocket messages  here
                send("{\"protocol\":\"json\",\"version\":1}    ");
              // send("{\"arguments\":[\"{\\\"MessageType\\\":0, \\\"ContentType\\\":2002, \\\"RequestStatus\\\":0, \\\"BatteryLevel\\\": 58}\"],\"invocationId\":\"0\",\"target\":\"SendMessageAsync\",\"type\":1}");
            } 

            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
            }

            @Override 
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("WebSocket connection closed. Code: " + code + ", Reason: " + reason + ", Remote: " + remote);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        };

        // Connect to the WebSocket server
        webSocketClient.connect();
    }
}

