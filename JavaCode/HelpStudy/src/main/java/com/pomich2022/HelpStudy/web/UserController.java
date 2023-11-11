package com.pomich2022.HelpStudy.web;

import com.pomich2022.HelpStudy.models.User;
import com.pomich2022.HelpStudy.service.inerf.UserServiceInterface;
import com.pomich2022.HelpStudy.utils.exceptions.UserErrorResponce;
import com.pomich2022.HelpStudy.utils.exceptions.UserNotRegisteredException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserServiceInterface userServiceInterface;
    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }
    @PostMapping("/registrate")
    public ResponseEntity<HttpStatus> registrateUser(@RequestBody @Valid User user,
                                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorsMsg = new StringBuilder();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList){
                errorsMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");

            }
            throw new UserNotRegisteredException(errorsMsg.toString());
        }
            userServiceInterface.registerUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isAcceptedRules(), user.getDateOfRegistration());
            return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponce> handleException(UserNotRegisteredException ex){
        UserErrorResponce userErrorResponce = new UserErrorResponce(
                "Не вдалося зареєструвати користувача",
                System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponce, HttpStatus.BAD_REQUEST);
    }

}
