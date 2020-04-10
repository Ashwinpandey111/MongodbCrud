package com.example.springmongodb.api.serviceimpl;

import ch.qos.logback.classic.Logger;
import com.example.springmongodb.api.UserResponse.ResponseObject;
import com.example.springmongodb.api.UserResponse.UserManagementResponse;
import com.example.springmongodb.api.dto.UserDto;
import com.example.springmongodb.api.entity.UserDetails;
import com.example.springmongodb.api.repository.UserRepository;
import com.example.springmongodb.api.service.UserDetailsService;
import com.example.springmongodb.api.user.ResponseStatusCode;
import com.mongodb.MongoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    UserRepository userRepository;

    public ResponseObject<UserManagementResponse> create(final UserDto userDto) {

        UserDetails userDetails = new UserDetails();
        BeanUtils.copyProperties(userDto, userDetails);
        UserManagementResponse userresponse = new UserManagementResponse();

        userDetails.setCreatedOn(userDto.getCreatedOn());
        userDetails.setUpdatedOn(userDto.getUpdatedOn());
        userDetails.setUserStatus(userDto.getUserStatus());
        userRepository.save(userDetails);
        userresponse.setEmail(userDetails.getEmailId());
        userresponse.setUsername(userDetails.getUserName());
        userresponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        return ResponseObject.success(userresponse);

    }

//    public UserDetails findByUserName(String name)
//    {
//        return userRepository.findByUserName(name);
//    }
   @Override
   public ResponseObject<UserManagementResponse> updateUser(@Valid UserDetails user, String id){
        UserManagementResponse userresponse= new UserManagementResponse();
        user.setUserId(id);
        user.setEmailId(user.getEmailId());
        user.setUserName(user.getUserName());
        user.setCreatedOn(user.getCreatedOn());
        user.setUpdatedOn(user.getUpdatedOn());
        user.setMobileNo(user.getMobileNo());
        user.setUserStatus(user.getUserStatus());
        userRepository.save(user);
       userresponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
       return ResponseObject.success(userresponse);


   }

    @Override
    public ResponseObject<UserManagementResponse> findUserByUserId(String userId) {

    UserManagementResponse userManagementResponse= new UserManagementResponse();
    Optional<UserDetails> optionalUserDetails = Optional.empty();
        try {
            optionalUserDetails =
                    userRepository.findUserByUserId(userId);
        } catch (MongoException ex) {
            System.out.println("user not found");
        }

        if (optionalUserDetails.isPresent()) {

            UserDetails userDetails = optionalUserDetails.get();
            UserDto userDto = new UserDto();
            userDto.setUserId(userDetails.getUserId());
            userDto.setEmailId(userDetails.getEmailId());
            userDto.setCreatedOn(userDetails.getCreatedOn());
            userDto.setMobileNo(userDetails.getMobileNo());
            userDto.setUpdatedOn(userDetails.getUpdatedOn());
            userDto.setUserName(userDetails.getUserName());
            userDto.setUserStatus(userDetails.getUserStatus());
            userManagementResponse.setUserDtos(userDto);
            userManagementResponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        } else {
            userManagementResponse.setUserResponseCode(
                    ResponseStatusCode.INVALID_REQUEST.getCode());
        }
        return ResponseObject.success(userManagementResponse);

    }

    @Override
    public ResponseObject<UserManagementResponse> deleteUser(String userId) {
        UserManagementResponse userManagementResponse = new UserManagementResponse();
        Optional<UserDetails> optionalUserDetails = Optional.empty();
        try {
            optionalUserDetails =
                    userRepository.findUserByUserId(userId);
        } catch (MongoException ex) {
            System.out.println("user not found");
        }
        if(optionalUserDetails.isPresent()) {
            UserDetails userDetails = optionalUserDetails.get();
            userRepository.delete(userDetails);
        }else {
            userManagementResponse.setUserResponseCode(
                    ResponseStatusCode.INVALID_REQUEST.getCode());
        }
        return ResponseObject.success(userManagementResponse);
    }

    @Override
    public ResponseObject<UserManagementResponse> listOfUser(long createdOn) {
        List<UserDto> userDetailsList=new ArrayList<>();
        Optional<List<UserDetails>> optionalUserDetails=Optional.empty();
        UserManagementResponse userManagementResponse= new UserManagementResponse();
        try{
            optionalUserDetails=userRepository.findByCreatedOn(createdOn);
        }
        catch(MongoException e){
            e.printStackTrace();
        }
        if(optionalUserDetails.isPresent()){
            optionalUserDetails.get().forEach(userDetails -> {
                UserDto userDto= new UserDto();
                userDto.setUserName(userDetails.getUserName());
                userDto.setEmailId(userDetails.getEmailId());
                userDto.setMobileNo(userDetails.getMobileNo());
                userDto.setUserStatus(userDetails.getUserStatus());
                userDto.setCreatedOn(userDetails.getCreatedOn());
                userDto.setUpdatedOn(userDetails.getUpdatedOn());
                userDetailsList.add(userDto);
            });
            userManagementResponse.setUserDetailsList(userDetailsList);
            userManagementResponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        }
        else{
            userManagementResponse.setUserResponseCode(ResponseStatusCode.FAIL.getCode());
        }
        return ResponseObject.success(userManagementResponse);
    }

    @Override
    public ResponseObject<UserManagementResponse> getUsersByUserStatus(String userStatus) {
        Optional<List<UserDetails>> optionalUserDetails=Optional.empty();
        List<UserDto> userDetailsList=new ArrayList<>();
        UserManagementResponse userManagementResponse= new UserManagementResponse();
        try{
            optionalUserDetails=userRepository.findByUserStatus(userStatus);
        }
        catch(MongoException e){
            e.printStackTrace();
        }
        if(optionalUserDetails.isPresent()){
            optionalUserDetails.get().forEach(userDetails -> {
                UserDto userDto= new UserDto();
                userDto.setUserName(userDetails.getUserName());
                userDto.setEmailId(userDetails.getEmailId());
                userDto.setMobileNo(userDetails.getMobileNo());
                userDto.setUserStatus(userDetails.getUserStatus());
                userDto.setCreatedOn(userDetails.getCreatedOn());
                userDto.setUpdatedOn(userDetails.getUpdatedOn());
                userDetailsList.add(userDto);
            });
            userManagementResponse.setUserDetailsList(userDetailsList);
            userManagementResponse.setUserResponseCode(ResponseStatusCode.SUCCESS.getCode());
        }
        else{
            userManagementResponse.setUserResponseCode(ResponseStatusCode.FAIL.getCode());
        }
        return ResponseObject.success(userManagementResponse);
    }

}
