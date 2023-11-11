package com.pomich2022.HelpStudy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProfile {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "userProfile")
    private User user;
    private String phoneNumber;
    @Lob
    @Basic(fetch=LAZY)
    private String bio;
    @Lob
    @Basic(fetch=LAZY)
    private String profileImage;

    private boolean banned;



}
