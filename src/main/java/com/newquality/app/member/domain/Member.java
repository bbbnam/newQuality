package com.newquality.app.member.domain;

import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Where(clause = "is_deleted = 0")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @Embedded
    private Address address;
    private Integer age;

    @Column(name="is_deleted")
    private boolean deleted;

    protected Member() {
    }

    public Member(String email, String password, Address address, Integer age) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.age = age;
    }

    public void delete() {
        deleted = true;
    }

    public void update(Member member) {
        this.email = member.email;
        this.password = member.password;
        this.address = member.address;
        this.age = member.age;
    }
}
