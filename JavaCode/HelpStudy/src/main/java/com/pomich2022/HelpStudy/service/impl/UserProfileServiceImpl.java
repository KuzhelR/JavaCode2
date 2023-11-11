package com.pomich2022.HelpStudy.service.impl;

import com.pomich2022.HelpStudy.models.UserProfile;
import com.pomich2022.HelpStudy.repository.UserProfileRepository;
import com.pomich2022.HelpStudy.service.inerf.UserProfileServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UserProfileServiceImpl implements UserProfileServiceInterface {
    private final UserProfileRepository userProfileRepository;
    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
//TODO: зробити власні обробки виключень
    @Override
    public void uploadProfileImage(MultipartFile file, Long userId) throws Exception {

    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    if(fileName.contains("..")){
        throw new Exception("Filename contains invalid path sequence" + fileName);
    }
    if (file.getBytes().length > (1024 * 1024)){
        throw new Exception("File size exceeds maximum limit");
        }
        UserProfile userProfile = userProfileRepository.findByUserId(userId);
        userProfile.setProfileImage(file.getBytes());
        userProfileRepository.save(userProfile);
    }

    @Override
    public byte[] getProfileImage(Long userId) {
        return new byte[0];
    }

    @Override
    public void setBio(Long userId) {

    }
}
