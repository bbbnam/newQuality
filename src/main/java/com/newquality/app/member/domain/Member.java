package com.newquality.app.member.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @Embedded
    private Address address;
    private Integer age;

    protected Member() {
    }

    public Member(String email, String password, Address address, Integer age) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.age = age;
    }
}
