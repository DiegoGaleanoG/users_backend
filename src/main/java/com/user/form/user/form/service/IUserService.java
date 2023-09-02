package com.user.form.user.form.service;

import com.user.form.user.form.dto.RequestComuna;
import com.user.form.user.form.dto.ResponseComunaDto;
import com.user.form.user.form.dto.UsersDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    List<ResponseComunaDto> getComuna();


    ResponseEntity getUsers();

    ResponseEntity saveUser(UsersDto usuario);

    public ResponseEntity updateUser(UsersDto usuario);

    public ResponseEntity deleteUser(Long id);
}
