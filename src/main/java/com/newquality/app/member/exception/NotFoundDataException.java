package com.newquality.app.member.exception;

public class NotFoundDataException extends RuntimeException {
    private static final String NOT_FOUND_DATA_MESSAGE = "해당 데이터를 조회할 수 없습니다.";

    public NotFoundDataException() {
        super(NOT_FOUND_DATA_MESSAGE);
    }
}
