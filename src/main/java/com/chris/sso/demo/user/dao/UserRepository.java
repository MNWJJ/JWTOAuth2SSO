package com.chris.sso.demo.user.dao;

import com.chris.sso.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

   List <User> findByName(String name);
}
