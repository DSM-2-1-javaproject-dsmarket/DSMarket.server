package controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import services.Auth.AuthServiceImpl;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public SignInResponse signIn(){}
}
