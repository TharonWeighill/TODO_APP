package com.example.todo_app.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.net.HttpURLConnection;
@RestController
@CrossOrigin
@RequestMapping ("/oauth-redirect")
public class FusionAuthController {
    private String apiKey = "9b26f51e-6b0e-4d33-93a0-619d45fa3923";
    private String clientId = "a7f398aa-8337-4112-94a0-f99bc29a8136";
    private String clientSecret = "nTUHnlCcKvVnVhofP47ROBaWulWbK84N-l-xc3PzC2g";
    private String  fusionAuthURL = "http://localhost:9011";
    private String uri = ("http://localhost:9011/oauth2/token");



    public FusionAuthController() throws IOException {

        //1) \query param
        //2) \GET auth code
        //3) exchange auth code for access token
        //4) store token in cookie or as state
        //5) log out destroys state/cookie
        //6) redirect home
        //7) conditionally render nav bar to user logged in
        //8) connect cleanspeak to post todos

    }
        @GetMapping()
        @CrossOrigin
        public String exchangeOAuthCodeForAccessToken (@RequestParam("code") String authCode) throws IOException {
            URL url = new URL("http://localhost:9011/oauth2/token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            Map<String, String> params = new HashMap();
            params.put("code", authCode);
            params.put("clientSecret", clientSecret);
            params.put("clientId", clientId);
            params.put("grant_type", "authorization_code");
            params.put("redirect_uri", uri);
            String inputString = String.valueOf(params);
            System.out.println(params);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = inputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            StringBuilder response;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response);
            }
            return response.toString();
        }
}
 // return this.startAnonymous(AccessToken.class, OAuthError.class).uri("/oauth2/token").bodyHandler(new FormDataBodyHandler(parameters)).post().go();