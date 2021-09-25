package com.chris.sso.demo.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "chris_user")
public class User {

    @Id
    int id;
    String name;
    String password;


}
