package com.pomich2022.HelpStudy.web;

import com.pomich2022.HelpStudy.models.UserProfile;
import com.pomich2022.HelpStudy.service.impl.UserProfileServiceImpl;
import com.pomich2022.HelpStudy.service.inerf.UserProfileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class UserProfileController {
    @Autowired
    private UserProfileServiceInterface userProfileService;
    //TODO: ID буде отримуватись з HTTP сесії. Зробити власні виключення
    @PostMapping("/image")
    public ResponseEntity<HttpStatus> uploadProfileImage(@RequestParam ("file")MultipartFile file, Long userId, BindingResult bindingResult) throws Exception{

         if (bindingResult.hasErrors()){
             throw new Exception("Image wasn't upload");
         }
        userProfileService.uploadProfileImage(file, 1L);
         return ResponseEntity.ok(HttpStatus.OK);
    }
}
