package com.userhandler.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import  jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import  lombok.Getter;
import  lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(name="name",nullable=false)
    String name;

    @Column(name="password",nullable=false)
    String password;

    @Column(name="photo_path")
    String photoPath;

     @Column(name="role")
    Boolean isAdmin=false;//1:admin ; 0:employee

}
