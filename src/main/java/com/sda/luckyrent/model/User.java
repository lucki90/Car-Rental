package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String surname;

    @NotNull
    @Column
    private Integer phoneNumber;

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
