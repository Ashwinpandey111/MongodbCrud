package com.example.springmongodb.api.service;

import com.example.springmongodb.api.UserResponse.ResponseObject;
import com.example.springmongodb.api.UserResponse.UserManagementResponse;
import com.example.springmongodb.api.dto.UserDto;
import com.example.springmongodb.api.entity.UserDetails;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public interface UserDetailsService {

    ResponseObject<UserManagementResponse> create(@Valid UserDto userDto);

    ResponseObject<UserManagementResponse> updateUser(@Valid UserDetails user, String id);

    ResponseObject<UserManagementResponse> findUserByUserId(String userId);

    ResponseObject<UserManagementResponse> deleteUser(String userId);

    ResponseObject<UserManagementResponse> listOfUser(long createdOn);


    ResponseObject<UserManagementResponse> getUsersByUserStatus(String userStatus);
}
