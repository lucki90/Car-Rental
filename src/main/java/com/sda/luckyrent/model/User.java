package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private Integer phoneNumber;

//    @OneToOne(mappedBy = "user")
//    private LoggedUser loggedUser;

    public void updateForm(User user) {
        if (user.getName() != null) {
            this.name = user.getName();
        }
        if (user.getSurname() != null) {
            this.surname= user.getSurname();
        }
        if (user.getPhoneNumber() !=null){
            this.phoneNumber = user.getPhoneNumber();
        }
//        if (user.getLoggedUser() !=null){
//            this.loggedUser= user.getLoggedUser();
//        }

    }
}
