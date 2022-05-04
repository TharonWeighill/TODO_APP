package com.example.todo_app.Controller;
import com.inversoft.error.Errors;
import com.inversoft.rest.ClientResponse;
import io.fusionauth.client.FusionAuthClient;
import io.fusionauth.domain.api.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping ("/oauth-redirect")
public class FusionAuthController {

    private String apiKey = "9b26f51e-6b0e-4d33-93a0-619d45fa3923";
    private String clientId = "a7f398aa-8337-4112-94a0-f99bc29a8136";
    private String clientSecret = "nTUHnlCcKvVnVhofP47ROBaWulWbK84N-l-xc3PzC2g";
    private String  fusionAuthURL = "http://localhost:9011";
    FusionAuthClient client = new FusionAuthClient(apiKey, "http://localhost:9011");


    public FusionAuthController() {

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
        public ClientResponse<UserResponse, Errors> getAuthCode (@RequestParam("code") String authCode){
        client.exchangeOAuthCodeForAccessToken(authCode, clientId, clientSecret, "http://localhost:9011/oauth2/token");
            System.out.println(authCode);
           return client.retrieveUserUsingJWT(authCode);
        }
}
