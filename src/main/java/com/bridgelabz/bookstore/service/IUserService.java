package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.dto.UserLoginDTO;
import com.bridgelabz.bookstore.model.UserRegistration;

import java.util.List;

public interface IUserService {

    String addUser(UserDTO userDTO);

    List<UserRegistration> getAllUsers();

    ResponseDTO loginUser(UserLoginDTO userLoginDTO);

    Object getUserByToken(String token);

    String forgotPassword(String email, String password);

    Object getUserByEmailId(String emailId);

    UserRegistration updateUser(String email, UserDTO userDTO);

    String getToken(String email);

    List<UserRegistration> getAllUserDataByToken(String token);

    UserRegistration updateRecordById(Integer id, UserDTO userDTO);

}