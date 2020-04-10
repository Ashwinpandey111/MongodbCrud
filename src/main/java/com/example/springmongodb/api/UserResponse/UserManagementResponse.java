package com.example.springmongodb.api.UserResponse;

import com.example.springmongodb.api.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserManagementResponse {
    private String username;

    private String email;

    private String umr;

    private int userResponseCode;

    private UserDto userDtos;

    List<UserDto> userDetailsList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUmr() {
        return umr;
    }

    public void setUmr(String umr) {
        this.umr = umr;
    }

    public int getUserResponseCode() {
        return userResponseCode;
    }

    public void setUserResponseCode(int userResponseCode) {
        this.userResponseCode = userResponseCode;
    }

    public UserDto getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(UserDto userDtos) {
        this.userDtos = userDtos;
    }


    public List<UserDto> getUserDetailsList() {
        return userDetailsList;
    }

    public void setUserDetailsList(List<UserDto> userDetailsList) {
        this.userDetailsList = userDetailsList;
    }
}
