package com.colco.Medical.Representative.repository;

import com.colco.Medical.Representative.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDetails,String> {

    Optional<UserDetails> findUserByUserId(String userId);
}
