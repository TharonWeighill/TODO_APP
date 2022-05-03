package com.example.todo_app.Controller;
import com.example.todo_app.Models.Users;
import com.example.todo_app.Service.UserService;
import com.inversoft.rest.ClientResponse;
import io.fusionauth.client.FusionAuthClient;
import io.fusionauth.domain.User;
import io.fusionauth.domain.UserRegistration;
import io.fusionauth.domain.api.user.RegistrationRequest;
import io.fusionauth.security.FusionAuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping ("/oauth-redirect")
@PreAuthorize ("hasAuthority('User')")
public class FusionAuthController {
    private UserService userService;
    public FusionAuthController( UserService userService ) {
        super();
        this.userService = userService;
    }
    @GetMapping("{id}")
    @CrossOrigin
    public ResponseEntity<Users> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<Users>(userService.getUserById(id), HttpStatus.OK);
    }
    @Value("${fusionAuth.applicationId}")
    private String appId;
    @Autowired
    private FusionAuthClient fusionAuthClient;
    @RequestMapping(value = "/register", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("permitAll()")
    public RedirectView handleRegister(@RequestBody MultiValueMap<String, String> body) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ClientResponse response;
        // User is logged in but doesn't have a registration for the current application
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof FusionAuthUserDetails) {
            FusionAuthUserDetails userDetails = (FusionAuthUserDetails) authentication.getPrincipal();
            UserRegistration registration = new UserRegistration()
                    .with(reg -> reg.id = UUID.fromString(userDetails.userId))
                    .with(reg -> reg.applicationId = UUID.fromString(appId));
            response = fusionAuthClient.register(registration.id, new RegistrationRequest(null, registration));
            // This is a new user and needs a User and a UserRegistration
        } else {
            UserRegistration registration = new UserRegistration()
                    .with(reg -> reg.applicationId = UUID.fromString(appId));

            User newUser = new User();
            response = fusionAuthClient.register(null, new RegistrationRequest(newUser, registration));
        }
        if (response.wasSuccessful()) {
            return new RedirectView("/");
        } else {
            throw new RegistrationException(response.errorResponse.toString());
        }
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @PreAuthorize("permitAll()")
    public String viewRegister() {
        return "register";
    }
    public class RegistrationException extends RuntimeException {
        RegistrationException(String cause) {
            super(cause);
        }
    }
}
