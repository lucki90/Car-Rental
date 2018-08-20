package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "logged_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String login;
    @Column(nullable = false,unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;

    @OneToOne
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
