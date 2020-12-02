package com.colco.Medical.Representative.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "user_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails implements Serializable {

    @Id
    private String userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String emailId;

    private long mobileNo;

    private String address;

    private long personalContactNumber;

    private List<DrugsEntity> drugsEntities;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPersonalContactNumber() {
        return personalContactNumber;
    }

    public void setPersonalContactNumber(long personalContactNumber) {
        this.personalContactNumber = personalContactNumber;
    }

    public List<DrugsEntity> getDrugsEntities() {
        return drugsEntities;
    }

    public void setDrugsEntities(List<DrugsEntity> drugsEntities) {
        this.drugsEntities = drugsEntities;
    }
}
