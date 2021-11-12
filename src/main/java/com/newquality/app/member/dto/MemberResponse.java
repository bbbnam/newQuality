package com.newquality.app.member.dto;

import com.newquality.app.member.domain.Address;
import com.newquality.app.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String email;
    private Integer age;
    private String city;
    private String street;
    private String zipCode;

    public static MemberResponse of(Member saved) {
        Address address = saved.getAddress();
        return new MemberResponse(saved.getId(), saved.getEmail(), saved.getAge(),
                address.getCity(), address.getStreet(), address.getZipCode());
    }
}
