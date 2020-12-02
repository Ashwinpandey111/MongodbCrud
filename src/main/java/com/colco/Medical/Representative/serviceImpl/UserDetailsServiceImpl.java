package com.colco.Medical.Representative.serviceImpl;

import com.colco.Medical.Representative.RsponseClass.ResponseObject;
import com.colco.Medical.Representative.RsponseClass.ResponseStatusCode;
import com.colco.Medical.Representative.dto.response.UserResponse;
import com.colco.Medical.Representative.model.DrugsEntity;
import com.colco.Medical.Representative.model.UserDetails;
import com.colco.Medical.Representative.repository.UserRepository;
import com.colco.Medical.Representative.service.UserDetailsService;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Override
    public ResponseObject<UserResponse> create(UserDetails userDto) {
        UserResponse userresponse = new UserResponse();
        userRepository.save(userDto);
        userresponse.setFirstName(userDto.getFirstName());
        userresponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        return ResponseObject.success(userresponse);
    }

    @Override
    public ResponseObject<UserResponse> deleteUser(String userId) {
        UserResponse userManagementResponse = new UserResponse();
        Optional<UserDetails> optionalUserDetails = Optional.empty();
        try {
            optionalUserDetails =
                    userRepository.findUserByUserId(userId);
        } catch (MongoException ex) {
            System.out.println("user not found");
        }
        if (optionalUserDetails.isPresent()) {
            UserDetails userDetails = optionalUserDetails.get();
            userRepository.delete(userDetails);
            userManagementResponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        } else {
            userManagementResponse.setUserResponseCode(
                    ResponseStatusCode.INVALID_REQUEST.getCode());
        }
        return ResponseObject.success(userManagementResponse);
    }

    @Override
    public ResponseObject<UserResponse> findUserByUserId(String userId) {
        UserResponse userManagementResponse = new UserResponse();
        Optional<UserDetails> optionalUserDetails = Optional.empty();
        try {
            optionalUserDetails =
                    userRepository.findUserByUserId(userId);
        } catch (MongoException ex) {
            System.out.println("user not found");
        }

        if (optionalUserDetails.isPresent()) {

            UserDetails userDetails = optionalUserDetails.get();
            userManagementResponse.setUserDetails(userDetails);
            userManagementResponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        } else {
            userManagementResponse.setUserResponseCode(
                    ResponseStatusCode.INVALID_REQUEST.getCode());
        }
        return ResponseObject.success(userManagementResponse);

    }

    @Override
    public List<Object> findUsers() {
        List<Object> display = new ArrayList<>();
        Iterable<UserDetails> user = userRepository.findAll();
        display.add(user);
        return display;
    }

    @Override
    public ResponseObject<UserResponse> updateUser( UserDetails user, String id) {
        UserResponse userresponse = new UserResponse();
        Optional<UserDetails> optionalUserDetails = Optional.empty();
        try {
            optionalUserDetails = userRepository.findUserByUserId(id);
        } catch (MongoException ex) {
            LOG.error(
                    "-- updateUserProfile() >> Encountered exception while fetching the user details through username from DB. Exception :: ",
                    ex);

        }
        if (optionalUserDetails.isPresent()) {
            user.setUserId(id);
            user.setEmailId(user.getEmailId());
            user.setMobileNo(user.getMobileNo());
            user.setEmailId(user.getEmailId());
            user.setAddress(user.getAddress());
            user.setPersonalContactNumber(user.getPersonalContactNumber());
            userRepository.save(user);
            userresponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        }
        return ResponseObject.success(userresponse);
    }
}



