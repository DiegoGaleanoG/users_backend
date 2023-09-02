package com.user.form.user.form.service.impl;

import com.google.common.collect.Iterables;
import com.user.form.user.form.client.IComuna;
import com.user.form.user.form.dto.RequestComuna;
import com.user.form.user.form.dto.ResponseComunaDto;
import com.user.form.user.form.dto.UsersDto;
import com.user.form.user.form.model.Users;
import com.user.form.user.form.repository.IUsersRepository;
import com.user.form.user.form.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServicesImpl implements IUserService {

    @Autowired
    private IComuna iComuna;

    @Autowired
    private IUsersRepository iUsersRepository;
    @Override
    public List<ResponseComunaDto> getComuna() {
        List<ResponseComunaDto> responseComunaList= new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        List<RequestComuna> comunaDtos = iComuna.getComuna();

        for (RequestComuna comunaList: comunaDtos){
            ResponseComunaDto responseComunaDto = modelMapper.map(comunaList.getComuna(), ResponseComunaDto.class);
            responseComunaList.add(responseComunaDto);
        }

        return responseComunaList;
    }

    @Override
    public ResponseEntity getUsers() {
        List<UsersDto> usersList= new ArrayList<>();
        try {
            Iterable<Users> users = iUsersRepository.findAll();
            if(Iterables.size(users)==0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usersList);
            }
            ModelMapper modelMapper = new ModelMapper();
            for (Users userList: users){
                UsersDto userDto = modelMapper.map(userList, UsersDto.class);
                usersList.add(userDto);
            }
        }catch(Exception e){
            log.error("error en getUsers"+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usersList);

        }
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @Override
    public ResponseEntity saveUser(UsersDto usuario) {
        try {
            Users saveUser = Users.builder()
                    .nombre(usuario.getNombre())
                    .apellido(usuario.getApellido())
                    .comuna(usuario.getComuna())
                    .telefono(usuario.getTelefono())
                    .codecomuna(usuario.getCodecomuna())
                    .build();
            iUsersRepository.save(saveUser);

        }catch(Exception e){
            log.error("error en saveUsers"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al guardar");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("usuario guardado exitosamente");
    }

    @Override
    public ResponseEntity updateUser(UsersDto usuario) {
        try {
            Users updateUser = Users.builder()
                    .id(usuario.getId())
                    .nombre(usuario.getNombre())
                    .apellido(usuario.getApellido())
                    .comuna(usuario.getComuna())
                    .telefono(usuario.getTelefono())
                    .codecomuna(usuario.getCodecomuna())
                    .build();
            iUsersRepository.save(updateUser);

        }catch(Exception e){
            log.error("error en updateUser"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al actualizar");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("usuario actualizado exitosamente");
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        try {

            iUsersRepository.deleteById(id);

        }catch(Exception e){
            log.error("error en deleteUser"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al eliminar un usuario");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("usuario eliminado exitosamente");
    }
}
