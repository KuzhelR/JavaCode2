package com.pomich2022.HelpStudy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Імʼя не повинно бути пустим")
    private String firstName;
    @NotEmpty(message = "Прізвище не повинно бути пустим")
    private String lastName;

    //TODO: перевірка правильності введеного email та домена
    @Email
    @NotEmpty(message = "Поле має бути заповнене")
    private String email;
    @NotEmpty(message = "Придумайте пароль")
    private String password;
    private boolean acceptedRules;
    private LocalDateTime dateOfRegistration;
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;


    public User(String firstName, String lastName, String email, String password, boolean acceptedRules, LocalDateTime dateOfRegistration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.acceptedRules = acceptedRules;
        this.dateOfRegistration = dateOfRegistration;
    }
}
