package com.pomich2022.HelpStudy.repository;

import com.pomich2022.HelpStudy.models.User;
import com.pomich2022.HelpStudy.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
UserProfile findByUserId(Long userId);

}
