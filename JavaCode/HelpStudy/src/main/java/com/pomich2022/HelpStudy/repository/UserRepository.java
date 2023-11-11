package com.pomich2022.HelpStudy.repository;

import com.pomich2022.HelpStudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByFirstName(String name);
    User findByEmail(String email);
    @Query("SELECT u FROM UserProfile as u WHERE u.phoneNumber=:phoneNumber")
    User findByPhoneNumber(@Param("phoneNumber")String phoneNumber);

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);
}
