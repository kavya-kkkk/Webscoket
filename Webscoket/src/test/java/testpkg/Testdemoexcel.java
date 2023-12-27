package testpkg;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testdemoexcel {

    private static ExtentReports extent;
    private static ExtentTest test;
    public static void main(String[] args) throws URISyntaxException {
        // Initialize ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // WebSocket URL with custom headers
        URI uri = new URI("wss://spacebands-websockets-dev.azurewebsites.net/hubs/Spacebands");

        // Custom headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjQxNjUxMjg1LTYyODEtNDczMS05MDFkLTNjZmJiNDEzNDE3OSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6ImRlZXBhay5zaXZha3VtYXJAcmhpYmh1cy5jb20iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiZGVlcG8iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zdXJuYW1lIjoiU2l2YWt1bWFyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbW9iaWxlcGhvbmUiOiIiLCJJc0NsaWVudCI6IlRydWUiLCJDb250YWN0SWQiOiIxIiwiU3RyaXBlQ3VzdG9tZXJJZCI6ImN1c19QM0gzTFlaVVAwNGlIaiIsIlRpbWVab25lIjoiR01UIiwiQ3VycmVuY3kiOiJHQlAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJDbGllbnRBZG1pbiIsIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuVXNlcnMuVmlldyIsIlBlcm1pc3Npb25zLlVzZXJzLlNlYXJjaCIsIlBlcm1pc3Npb25zLlN1cnZleS5WaWV3IiwiUGVybWlzc2lvbnMuU3VydmV5LlNlYXJjaCIsIlBlcm1pc3Npb25zLlN1cnZleUFuc3dlci5WaWV3IiwiUGVybWlzc2lvbnMuU3VydmV5QW5zd2VyLlNlYXJjaCIsIlBlcm1pc3Npb25zLkZlYXR1cmUuVmlldyIsIlBlcm1pc3Npb25zLkZlYXR1cmUuU2VhcmNoIiwiUGVybWlzc2lvbnMuRGFzaGJvYXJkcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZmlsZS5FZGl0IiwiUGVybWlzc2lvbnMuVXNlcnMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuVXNlcnMuRWRpdCIsIlBlcm1pc3Npb25zLlVzZXJzLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlVzZXJzLkV4cG9ydCIsIlBlcm1pc3Npb25zLlVzZXJzLkltcG9ydCIsIlBlcm1pc3Npb25zLlN1cnZleS5DcmVhdGUiLCJQZXJtaXNzaW9ucy5TdXJ2ZXkuRWRpdCIsIlBlcm1pc3Npb25zLlN1cnZleS5EZWxldGUiLCJQZXJtaXNzaW9ucy5GZWF0dXJlLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkZlYXR1cmUuRWRpdCIsIlBlcm1pc3Npb25zLkZlYXR1cmUuRGVsZXRlIiwiUGVybWlzc2lvbnMuQmlsbGluZy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbGluZy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CaWxsaW5nLkVkaXQiLCJQZXJtaXNzaW9ucy5CaWxsaW5nLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxpbmcuU2VhcmNoIiwiUGVybWlzc2lvbnMuSGFuZ2ZpcmUuVmlldyJdLCJleHAiOjE3MDIxODc3NDR9.cEKe65Sd0QPUv52bzSx_I2kX82weQFBOs9syDlTp-No");
        headers.put("Content-Type", "application/json");

        // Create WebSocket client
        WebSocketClient webSocketClient = new WebSocketClient(uri, headers) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                test = extent.createTest("WebSocket Connection Test", "Verify WebSocket connection is opened.");

                System.out.println("WebSocket connection opened.");
                test.log(Status.INFO, "WebSocket connection opened.");

                 // Send your WebSocket messages here
                 send("{\"protocol\":\"json\",\"version\":1}    ");
                 send("{\"arguments\":[\"{\\\"MessageType\\\":0, \\\"ContentType\\\":2002, \\\"RequestStatus\\\":0, \\\"BatteryLevel\\\": 58}\"],\"invocationId\":\"0\",\"target\":\"SendMessageAsync\",\"type\":1}");
                 send("{\"arguments\":[\"{\\\"MessageType\\\":0, \\\"ContentType\\\":1, \\\"RequestStatus\\\":0,}\"],\"invocationId\":\"0\",\"target\":\"SendMessageAsync\",\"type\":1}");
              //  send("");
                 
            }

            @Override 
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
                test.log(Status.INFO, "Received message: " + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("WebSocket connection closed. Code: " + code + ", Reason: " + reason + ", Remote: " + remote);
                test.log(Status.INFO, "WebSocket connection closed. Code: " + code + ", Reason: " + reason + ", Remote: " + remote);
                extent.flush(); // Flush the extent reports
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
                test.log(Status.ERROR, ex.getMessage());
            }
        };

        // Connect to the WebSocket server
        webSocketClient.connect();
    }
}


