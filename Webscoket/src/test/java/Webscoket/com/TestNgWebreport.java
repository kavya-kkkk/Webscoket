package Webscoket.com;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNgWebreport {

    private ExtentReports extent;
    private ExtentTest extentTest;
    private WebSocketClient webSocketClient;

	public  String formattedTime;
	public   String formattedDate;
	public   String   ReportName;
	public ExtentTest test;
    
    /*@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setUp() {

		// For date and time

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedDate = dateFormat.format(currentDate);
		// Get the current time
		Date currentTime = new Date();
		// Create a SimpleDateFormat object with the desired format
		SimpleDateFormat sdf = new SimpleDateFormat("hh'.'mm'.'ss");
		// Format the current time using the SimpleDateFormat object
		String formattedTime = sdf.format(currentTime);
		System.out.println("Current Date: " + formattedDate);
		System.out.println("Current Time: " + formattedTime);
		ReportName = "rafflox-" + formattedDate + "&" + formattedTime + ".html";
		//System.out.println("reportLocation: " + RafflouxReportLoginPath);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(RedevRaffoluxReportPath+ ReportName);
		//System.out.println("reportLocation ReportName: " + RafflouxReportLoginPath+ ReportName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}*/
			

	@BeforeMethod
	public void beforeMethod() {
		test = extent.createTest("Raffloux-ReDev Rest API", "API Testing both Positive and negative");
	}
	
    @BeforeMethod
    public void setup() throws URISyntaxException {
        // Initialize ExtentReports
        @SuppressWarnings("deprecation")
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\HP\\eclipse-workspace\\Webscoket\\Webscoket-report\\reoprtspacebands.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        URI uri = new URI("wss://spacebands-websockets-dev.azurewebsites.net/hubs/Spacebands");
        
        // Custom headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjQxNjUxMjg1LTYyODEtNDczMS05MDFkLTNjZmJiNDEzNDE3OSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6ImRlZXBhay5zaXZha3VtYXJAcmhpYmh1cy5jb20iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiZGVlcG8iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zdXJuYW1lIjoiU2l2YWt1bWFyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbW9iaWxlcGhvbmUiOiIiLCJJc0NsaWVudCI6IlRydWUiLCJDb250YWN0SWQiOiIxIiwiU3RyaXBlQ3VzdG9tZXJJZCI6ImN1c19QM0gzTFlaVVAwNGlIaiIsIlRpbWVab25lIjoiR01UIiwiQ3VycmVuY3kiOiJHQlAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJDbGllbnRBZG1pbiIsIlBlcm1pc3Npb24iOlsiUGVybWlzc2lvbnMuVXNlcnMuVmlldyIsIlBlcm1pc3Npb25zLlVzZXJzLlNlYXJjaCIsIlBlcm1pc3Npb25zLlN1cnZleS5WaWV3IiwiUGVybWlzc2lvbnMuU3VydmV5LlNlYXJjaCIsIlBlcm1pc3Npb25zLlN1cnZleUFuc3dlci5WaWV3IiwiUGVybWlzc2lvbnMuU3VydmV5QW5zd2VyLlNlYXJjaCIsIlBlcm1pc3Npb25zLkZlYXR1cmUuVmlldyIsIlBlcm1pc3Npb25zLkZlYXR1cmUuU2VhcmNoIiwiUGVybWlzc2lvbnMuRGFzaGJvYXJkcy5WaWV3IiwiUGVybWlzc2lvbnMuUHJvZmlsZS5FZGl0IiwiUGVybWlzc2lvbnMuVXNlcnMuQ3JlYXRlIiwiUGVybWlzc2lvbnMuVXNlcnMuRWRpdCIsIlBlcm1pc3Npb25zLlVzZXJzLkRlbGV0ZSIsIlBlcm1pc3Npb25zLlVzZXJzLkV4cG9ydCIsIlBlcm1pc3Npb25zLlVzZXJzLkltcG9ydCIsIlBlcm1pc3Npb25zLlN1cnZleS5DcmVhdGUiLCJQZXJtaXNzaW9ucy5TdXJ2ZXkuRWRpdCIsIlBlcm1pc3Npb25zLlN1cnZleS5EZWxldGUiLCJQZXJtaXNzaW9ucy5GZWF0dXJlLkNyZWF0ZSIsIlBlcm1pc3Npb25zLkZlYXR1cmUuRWRpdCIsIlBlcm1pc3Npb25zLkZlYXR1cmUuRGVsZXRlIiwiUGVybWlzc2lvbnMuQmlsbGluZy5WaWV3IiwiUGVybWlzc2lvbnMuQmlsbGluZy5DcmVhdGUiLCJQZXJtaXNzaW9ucy5CaWxsaW5nLkVkaXQiLCJQZXJtaXNzaW9ucy5CaWxsaW5nLkRlbGV0ZSIsIlBlcm1pc3Npb25zLkJpbGxpbmcuU2VhcmNoIiwiUGVybWlzc2lvbnMuSGFuZ2ZpcmUuVmlldyJdLCJleHAiOjE3MDE4Mzc3Mjl9.W8T64ndKsDj2ulCYWNKTwa5NILFH6I60mbvUDOvRnNo");
        headers.put("Content-Type","application/json");
        // Create WebSocket client
        // Create WebSocket client
        webSocketClient = new WebSocketClient(uri, headers) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                extentTest.log(Status.INFO, "WebSocket connection opened.");

                // Send your WebSocket messages here
                send("{\"protocol\":\"json\",\"version\":1}    ");
                // Send your WebSocket messages here
                send("{\"arguments\":[\"{\\\"MessageType\\\":0, \\\"ContentType\\\":2002, \\\"RequestStatus\\\":0, \\\"BatteryLevel\\\": 58}\"],\"invocationId\":\"0\",\"target\":\"SendMessageAsync\",\"type\":1}");
              send("{\"arguments\":[\"{\\\"MessageType\\\":0, \\\"ContentType\\\":1, \\\"RequestStatus\\\":0,}\"],\"invocationId\":\"0\",\"target\":\"SendMessageAsync\",\"type\":1}");
            
            }

            @Override
             public void onMessage(String message) {
                extentTest.log(Status.INFO, "Received message: " + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                extentTest.log(Status.INFO, "WebSocket connection closed. Code: " + code + ", Reason: " + reason + ", Remote: " + remote);
            }

            @Override
            public void onError(Exception ex) {
                extentTest.log(Status.ERROR, "WebSocket connection error:");
                extentTest.log(Status.ERROR, ex);
            }
        };

        // Connect to the WebSocket server
        webSocketClient.connect();

        // Create a test in ExtentReports
        extentTest = extent.createTest("WebSocket Test");
    }

    @Test
    public void testWebSocketCommunication() throws InterruptedException {
        // No need to put test logic here; it's in the WebSocket client callbacks
        // This method can be left empty or used for additional testing logic
        Thread.sleep(5000); // Adjust the sleep time as needed
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebSocket connection
        webSocketClient.close();

        // Flush and close ExtentReports
        extent.flush();
     
    }
}

