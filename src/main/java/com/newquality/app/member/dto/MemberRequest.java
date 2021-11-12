package com.newquality.app.member.dto;

import com.newquality.app.member.domain.Address;
import com.newquality.app.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

    private String email;
    private String password;
    private Integer age;
    private String city;
    private String street;
    private String zipCode;

    public Member toMember() {
        Address address = new Address(city, street, zipCode);
        return new Member(email, password, address, age);
    }
}
