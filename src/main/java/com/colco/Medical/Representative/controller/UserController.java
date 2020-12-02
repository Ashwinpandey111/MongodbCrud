package com.colco.Medical.Representative.controller;

import com.colco.Medical.Representative.RsponseClass.ResponseObject;
import com.colco.Medical.Representative.dto.response.UserResponse;
import com.colco.Medical.Representative.model.UserDetails;
import com.colco.Medical.Representative.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
   UserDetailsService userDetailsService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    UserRepository repo;
//
    /*
    /Api For creating a new medical representative
     */

    @PostMapping(value="/create")
    public ResponseEntity<ResponseObject<UserResponse>> create(@RequestBody UserDetails userDto)
    {
        ResponseObject <UserResponse> user=userDetailsService.create(userDto);
        return ResponseEntity.ok(user);

    }

    /*/
    Get a User Based On UserId
     */
    @GetMapping(value="/getOneUser/{userId}")
    public  ResponseEntity<ResponseObject<UserResponse>> getOneUser(@PathVariable String userId)
    {
        ResponseObject<UserResponse> userManagementResponseResponseObject= userDetailsService.findUserByUserId(userId);
        return ResponseEntity.ok(userManagementResponseResponseObject);
    }


    @GetMapping(value="/getAllUser")
    public List<Object> getAllUser()
    {

        LOG.trace("-->ENTRY-->getUsers() ");
        return userDetailsService.findUsers();

    }

    // Update User
    @PutMapping(value="/update/{id}")
    public ResponseEntity<ResponseObject<UserResponse>> updateUser(@RequestBody UserDetails userdto, @PathVariable String id)
    {
        ResponseObject <UserResponse> userupdate=userDetailsService.updateUser(userdto,id);
        return ResponseEntity.ok(userupdate);
    }


    /*/
    delete user based on userId
     */

    @PostMapping(value="/delete/{userId}")
    public  ResponseEntity<ResponseObject<UserResponse>> deleteUser(@PathVariable String userId)
    {
        ResponseObject<UserResponse> userManagementResponseResponseObject= userDetailsService.deleteUser(userId);
        return ResponseEntity.ok(userManagementResponseResponseObject);
    }


}