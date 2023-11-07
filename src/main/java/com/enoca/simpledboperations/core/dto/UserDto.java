package com.enoca.simpledboperations.core.dto;

import java.time.LocalDateTime;

public interface UserDto {


    Long id();
    String getUserName();
    String getEmail();
    String  getAge();
    LocalDateTime createdTime();

}
