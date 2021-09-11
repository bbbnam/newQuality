package com.newquality.app.member.dto;

import com.newquality.app.member.domain.Address;
import com.newquality.app.member.domain.Member;

public class MemberRequest {

    private String email;
    private String password;
    private Integer age;
    private String city;
    private String street;
    private String zipCode;

    public MemberRequest() {
    }

    public MemberRequest(String email, String password, Integer age, String city, String street, String zipCode) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Member toMember() {
        Address address = new Address(city, street, zipCode);
        return new Member(email, password, address, age);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
}
