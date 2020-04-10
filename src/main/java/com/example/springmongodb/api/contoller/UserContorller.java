package com.example.springmongodb.api.contoller;

import com.example.springmongodb.api.UserResponse.ResponseObject;
import com.example.springmongodb.api.UserResponse.UserManagementResponse;
import com.example.springmongodb.api.dto.UserDto;
import com.example.springmongodb.api.entity.UserDetails;
import com.example.springmongodb.api.repository.UserRepository;
import com.example.springmongodb.api.service.UserDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/user/v1")
public class UserContorller {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserRepository repo;

    /*
    /Api For creating a new user
     */

    @PostMapping(value="/create")
    public ResponseEntity<ResponseObject<UserManagementResponse>> create(@RequestBody UserDto userDto)
    {
        ResponseObject <UserManagementResponse> user=userDetailsService.create(userDto);
        return ResponseEntity.ok(user);

    }

    /*/
    Get a User Based On UserId
     */
     @GetMapping(value="/getOneUser/{userId}")
     public  ResponseEntity<ResponseObject<UserManagementResponse>> getOneUser(@PathVariable String userId)
     {
         ResponseObject<UserManagementResponse> userManagementResponseResponseObject= userDetailsService.findUserByUserId(userId);
         return ResponseEntity.ok(userManagementResponseResponseObject);
     }

    @GetMapping(value="/getAllUser")
    public List<Object> getAllUser()
    {
        List<Object> display=new ArrayList<>();
        Iterable<UserDetails> user=repo.findAll();
        display.add(user);
        return display;
    }

    // Update User
    @PutMapping(value="/update/{id}")
    public ResponseEntity<ResponseObject<UserManagementResponse>> updateUser(@RequestBody UserDto userdto, @PathVariable String id)
    {
        UserDetails user=new UserDetails();
        BeanUtils.copyProperties(userdto, user);
        ResponseObject <UserManagementResponse> userupdate=userDetailsService.updateUser(user,id);
        return ResponseEntity.ok(userupdate);
    }

    /*/
    delete user based on userId
     */

   @PostMapping(value="/delete/{userId}")
   public  ResponseEntity<ResponseObject<UserManagementResponse>> deleteUser(@PathVariable String userId)
   {
       ResponseObject<UserManagementResponse> userManagementResponseResponseObject= userDetailsService.deleteUser(userId);
       return ResponseEntity.ok(userManagementResponseResponseObject);
   }

   /*/
   List Of User Based on Created Date
    */

    @GetMapping(value="/getListUser/{createdOn}")
    public  ResponseEntity<ResponseObject<UserManagementResponse>> getOneUser(@PathVariable long createdOn)
    {
        ResponseObject<UserManagementResponse> userManagementResponseResponseObject= userDetailsService.listOfUser(createdOn);
        return ResponseEntity.ok(userManagementResponseResponseObject);
    }


    @GetMapping(value="/getUsersByUserStatus/{userStatus}")
    public  ResponseEntity<ResponseObject<UserManagementResponse>> getUsersByUserStatus(@PathVariable String userStatus)
    {
        ResponseObject<UserManagementResponse> userManagementResponseResponseObject= userDetailsService.getUsersByUserStatus(userStatus);
        return ResponseEntity.ok(userManagementResponseResponseObject);
    }


}
