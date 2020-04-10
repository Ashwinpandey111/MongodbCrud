package com.example.springmongodb.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.sql.Timestamp;

@Document(collection = "user_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails implements Serializable {

    @Id
    @Field(value = "user_id")
    private String userId;

    @Field(value = "user_name")
    private String userName;

    @Field(value = "email_id")
    private String emailId;

    @Field(value = "mobile_no")
    private long mobileNo;

    @Field(value = "creted_on")
    private long createdOn;

    @Field(value = "updated_on")
    private long updatedOn;

    @Field(value="user_status")
    private String userStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public long getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(long updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo=" + mobileNo +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", userStatus=" + userStatus +
                '}';
    }
}
