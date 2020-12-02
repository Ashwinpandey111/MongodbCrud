package com.colco.Medical.Representative.service;

import com.colco.Medical.Representative.RsponseClass.ResponseObject;
import com.colco.Medical.Representative.dto.response.UserResponse;
import com.colco.Medical.Representative.model.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserDetailsService {
    ResponseObject<UserResponse> create( UserDetails userDto);

    ResponseObject<UserResponse> deleteUser(String userId);

    ResponseObject<UserResponse> findUserByUserId(String userId);

    List<Object> findUsers();

    ResponseObject<UserResponse> updateUser(UserDetails userdto, String id);
}
