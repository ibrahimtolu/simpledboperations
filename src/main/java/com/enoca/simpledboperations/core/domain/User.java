package com.enoca.simpledboperations.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User extends  BaseEntity {

    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_ID_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "USER_ID_GENERATOR")
    @Id
    private Long id;

    @Column(name = "USER_NAME",length = 100,nullable = false,unique = true)
    private String userName;

    @Column(name = "EMAIL",length = 100,nullable = false,unique = true)
    private String email;

    @Column(name = "AGE")
    private String age;

    @Column(name = "PASSWORD")
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
