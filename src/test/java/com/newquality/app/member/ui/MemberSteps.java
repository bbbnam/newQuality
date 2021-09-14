package com.newquality.app.member.ui;

import com.newquality.app.member.dto.MemberResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MemberSteps {

    public static ExtractableResponse<Response> 멤버삭제요청(ExtractableResponse<Response> response) {
        String uri = response.header("Location");

        return RestAssured.given().log().all()
                .when()
                .delete(uri)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 멤버생성요청(Map<String, Object> params) {
        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/member")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 멤버조회요청(MemberResponse response) {
        return RestAssured.given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/member/{id}", response.getId())
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 멤버정보_수정요청(ExtractableResponse<Response> response,
                                                    Map<String, Object> updatedParams) {
        String uri = response.header("Location");
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(updatedParams)
                .when()
                .put(uri)
                .then().log().all()
                .extract();
    }

    public static void 멤버_삭제됨(ExtractableResponse<Response> 삭제응답) {
        assertThat(삭제응답.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    public static void 멤버_생성됨(ExtractableResponse<Response> 생성응답) {
        assertThat(생성응답.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(생성응답.header("Location")).isNotBlank();
    }

    public static void 멤버_조회됨(String email, ExtractableResponse<Response> 조회응답) {
        assertThat(조회응답.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(조회응답.as(MemberResponse.class)).isNotNull();
        assertThat(조회응답.as(MemberResponse.class).getEmail()).isEqualTo(email);
    }

    public static void 멤버_정보_수정됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.as(MemberResponse.class).getEmail()).isEqualTo("jdrake@naver.com");
    }
}
