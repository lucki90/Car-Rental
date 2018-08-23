package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "logged_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String login;

    @NotBlank
    @Email
    @Column(unique = true)
    private String mail;

    @NotBlank
    @Length(min = 6)
    @Column
    private String password;

    @OneToOne
    @NotNull
    @JoinColumn(name = "id_user")
    private User user;

    public void updateFrom(LoggedUser dbLoggedUser) {
        if (dbLoggedUser.getLogin() != null) {
            this.login=dbLoggedUser.getLogin();
        }
        if (dbLoggedUser.getMail() != null) {
            this.mail=dbLoggedUser.getMail();
        }
        if (dbLoggedUser.getPassword() != null) {
            this.password=dbLoggedUser.getPassword();
        }

    }
}
