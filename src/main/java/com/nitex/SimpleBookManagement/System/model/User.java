package com.nitex.SimpleBookManagement.System.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false, unique = true, length = 100)
    private String userName;


    @Column(nullable = false, length = 100)
//    @JsonIgnore
    private String password;


    @Column(nullable = false, length = 100)
    private String fullName;


    @Column(nullable = false, unique = true, length = 100)
    private String email;


    @Column(nullable = false, length = 100)
    private Date dateRegistered;

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = new Date();
    }





}
