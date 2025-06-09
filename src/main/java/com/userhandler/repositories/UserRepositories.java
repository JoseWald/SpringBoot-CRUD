package com.userhandler.repositories;

import  org.springframework.data.jpa.repository.JpaRepository;

import  com.userhandler.entities.User;

public interface  UserRepositories extends  JpaRepository<User,Long> {
    
}
