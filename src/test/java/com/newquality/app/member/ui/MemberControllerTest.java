package com.newquality.app.member.ui;

import com.newquality.app.common.AcceptanceTest;
import com.newquality.app.member.dto.MemberResponse;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.newquality.app.member.ui.MemberSteps.*;

class MemberControllerTest extends AcceptanceTest {

    @DisplayName("멤버 생성 테스트")
    @Test
    void createMember() {
        Map<String, Object> params = new HashMap<>();
        params.put("email", "bbbnam@naver.com");
        params.put("password", "12345");
        params.put("age", 33);
        params.put("city", "gangwondo");
        params.put("street", "gangdong-ro");
        params.put("zipCode", "134-123");

        ExtractableResponse<Response> 생성응답 = 멤버생성요청(params);

        멤버_생성됨(생성응답);
    }

    @DisplayName("멤버 삭제 테스트")
    @Test
    void deleteMember() {
        Map<String, Object> params = new HashMap<>();
        params.put("email", "bbbnam@naver.com");
        params.put("password", "12345");
        params.put("age", 33);
        params.put("city", "gangwondo");
        params.put("street", "gangdong-ro");
        params.put("zipCode", "134-123");

        ExtractableResponse<Response> 생성응답 = 멤버생성요청(params);

        ExtractableResponse<Response> 삭제응답 = 멤버삭제요청(생성응답);

        멤버_삭제됨(삭제응답);
    }

    @DisplayName("멤버 조회 테스트")
    @Test
    void selectMember() {
        Map<String, Object> params = new HashMap<>();
        String email = "bbbnam@naver.com";
        params.put("email", email);
        params.put("password", "12345");
        params.put("age", 33);
        params.put("city", "gangwondo");
        params.put("street", "gangdong-ro");
        params.put("zipCode", "134-123");

        ExtractableResponse<Response> 생성응답 = 멤버생성요청(params);
        MemberResponse 멤버응답 = 생성응답.as(MemberResponse.class);

        ExtractableResponse<Response> 조회응답 = 멤버조회요청(멤버응답);

        멤버_조회됨(email, 조회응답);
    }

    @DisplayName("멤버 수정 테스트")
    @Test
    void updateMember() {
        Map<String, Object> params = new HashMap<>();
        String email = "bbbnam@naver.com";
        params.put("email", email);
        params.put("password", "12345");
        params.put("age", 33);
        params.put("city", "gangwondo");
        params.put("street", "gangdong-ro");
        params.put("zipCode", "134-123");

        Map<String, Object> updatedParams = new HashMap<>();
        updatedParams.put("email", "jdrake@naver.com");
        updatedParams.put("password", "54321");
        updatedParams.put("age", 35);
        updatedParams.put("city", "gangwondo");
        updatedParams.put("street", "gangdong-ro");
        updatedParams.put("zipCode", "134-123");

        ExtractableResponse<Response> 생성응답 = 멤버생성요청(params);

        ExtractableResponse<Response> 수정된응답 = 멤버정보_수정요청(생성응답, updatedParams);

        멤버_정보_수정됨(수정된응답);
    }
}
