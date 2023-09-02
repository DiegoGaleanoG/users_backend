package com.user.form.user.form.controller;

import com.user.form.user.form.dto.RequestComuna;
import com.user.form.user.form.dto.ResponseComunaDto;
import com.user.form.user.form.dto.UsersDto;
import com.user.form.user.form.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/getcomuna")
    public ResponseEntity<List<ResponseComunaDto>> getComuna(){
        return new ResponseEntity<>(iUserService.getComuna(), HttpStatus.OK);
    }


    @GetMapping("/getusers")
    public ResponseEntity<List<UsersDto>> getUsers(){
        return iUserService.getUsers();
    }

    @PostMapping("/saveuser")
    public ResponseEntity<?> getUsers(@RequestBody UsersDto usersDto ){
        return iUserService.saveUser(usersDto);
    }
    @PostMapping("/updateuser")
    public ResponseEntity<?> updateUser(@RequestBody UsersDto usersDto ){
        return iUserService.updateUser(usersDto);
    }
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> delteUser(@PathVariable("id") Long id ){
        return iUserService.deleteUser(id);
    }

}
