package com.bridgelabz.bookstore.repository;


import com.bridgelabz.bookstore.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Integer> {
    @Query(value = "SELECT * FROM user_registration where email=:email_Id", nativeQuery = true)
    public Optional<UserRegistration> findByEmailid(String email_Id);
}
