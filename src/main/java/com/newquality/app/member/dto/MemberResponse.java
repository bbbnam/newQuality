package com.newquality.app.member.dto;

import com.newquality.app.member.domain.Address;
import com.newquality.app.member.domain.Member;

public class MemberResponse {
    private Long id;
    private String email;
    private Integer age;
    private String city;
    private String street;
    private String zipCode;

    public MemberResponse(Long id, String email, Integer age, String city, String street, String zipCode) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public static MemberResponse of(Member saved) {
        Address address = saved.getAddress();
        return new MemberResponse(saved.getId(), saved.getEmail(), saved.getAge(),
                address.getCity(), address.getStreet(), address.getZipCode());
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
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
