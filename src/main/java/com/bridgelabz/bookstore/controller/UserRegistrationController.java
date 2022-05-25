package com.bridgelabz.bookstore.controller;


import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.dto.UserLoginDTO;
import com.bridgelabz.bookstore.model.UserRegistration;
import com.bridgelabz.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserRegistrationController {


    @Autowired
    IUserService userRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> addUserInBookStore( @Valid @RequestBody UserDTO userDTO){
        String newUser= userRegistrationService.addUser(userDTO);
        ResponseDTO responseDTO=new ResponseDTO("User Registered Successfully",newUser);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        return new ResponseEntity<ResponseDTO>(userRegistrationService.loginUser(userLoginDTO),HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<String> getAllUser() {
        List<UserRegistration> listOfUsers = userRegistrationService.getAllUsers();
        ResponseDTO dto = new ResponseDTO("User retrieved successfully (:",listOfUsers);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    @GetMapping(value = "/getAll/{token}")
    public ResponseEntity<ResponseDTO> getAllUserDataByToken(@PathVariable String token)
    {
        List<UserRegistration> listOfUser = userRegistrationService.getAllUserDataByToken(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfUser);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    @GetMapping("/getByEmailId/{emailId}")
    public ResponseEntity<ResponseDTO> getUserByEmailId(@PathVariable("emailId") String emailId) {
        return new ResponseEntity<ResponseDTO>( new
                ResponseDTO("Get User Data by Email",
                userRegistrationService.getUserByEmailId(emailId)), HttpStatus.OK);
    }
    @GetMapping("/getBy/{token}")
    public ResponseEntity<ResponseDTO> getUserByToken(@PathVariable String token) {
        return new ResponseEntity<ResponseDTO>( new
                ResponseDTO("Get User Data By Token",
                userRegistrationService.getUserByToken(token)), HttpStatus.OK);
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestParam String email, @RequestParam String password) {
        String resp = userRegistrationService.forgotPassword(email,password);
        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PutMapping("/updateUserByEmail/{email}")
    public ResponseEntity<ResponseDTO> updateUserById(@PathVariable String email,@Valid @RequestBody UserDTO userDTO){
        UserRegistration updateUser= userRegistrationService.updateUser(email,userDTO);
        ResponseDTO dto = new ResponseDTO(" User Record updated successfully",updateUser);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRecordById(@PathVariable Integer id,@Valid @RequestBody UserDTO userDTO){
        UserRegistration entity = userRegistrationService.updateRecordById(id,userDTO);
        ResponseDTO dto = new ResponseDTO("User Record updated successfully",entity);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getToken/{email}")
    public ResponseEntity<ResponseDTO> getToken(@PathVariable String email){
        String generatedToken=userRegistrationService.getToken(email);
        ResponseDTO responseDTO=new ResponseDTO("Token for mail id sent on mail successfully",generatedToken);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }


}