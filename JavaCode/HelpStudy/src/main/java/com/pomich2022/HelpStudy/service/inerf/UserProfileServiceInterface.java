package com.pomich2022.HelpStudy.service.inerf;

import org.springframework.web.multipart.MultipartFile;

public interface UserProfileServiceInterface {
     void uploadProfileImage(MultipartFile file, Long userId) throws Exception;
     byte[] getProfileImage(Long userId);
     void setBio(Long userId);
}
