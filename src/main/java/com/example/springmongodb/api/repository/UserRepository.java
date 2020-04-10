package com.example.springmongodb.api.repository;

import com.example.springmongodb.api.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDetails,String> {

    UserDetails findByUserName(@Param("name") String name);

    UserDetails findByUserId(String id);

    Optional<UserDetails> findUserByUserId(String userId);


    Optional<List<UserDetails>> findByUserStatus(String userStatus);

    Optional<List<UserDetails>> findByCreatedOn(long createdOn);
}
