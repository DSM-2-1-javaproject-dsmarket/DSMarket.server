package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.request.SignInRequest;
import com.dsmarket.server.dto.response.SignInResponse;
import com.dsmarket.server.error.BusinessException;
import com.dsmarket.server.services.auth.AuthService;
import com.dsmarket.server.services.aws.S3ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("accounts/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final S3ServiceImpl s3Service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) throws BusinessException {
        String jwt = authService.signIn(signInRequest.getId(), signInRequest.getPassword());

        return SignInResponse
                .builder()
                .accessToken(jwt)
                .build();
    }

    @GetMapping
    public String authget(@RequestParam(name = "image") MultipartFile image) {
        try {
            return s3Service.upload(image, "img");
        }catch(Exception exception){
            return exception.getMessage();
        }
    }
}
