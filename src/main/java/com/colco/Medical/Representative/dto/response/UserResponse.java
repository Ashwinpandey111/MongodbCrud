package com.colco.Medical.Representative.dto.response;

import com.colco.Medical.Representative.model.UserDetails;

public class UserResponse {

    private String firstName;

    private int userResponseCode;

    private UserDetails userDetails;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getUserResponseCode() {
        return userResponseCode;
    }

    public void setUserResponseCode(int userResponseCode) {
        this.userResponseCode = userResponseCode;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
