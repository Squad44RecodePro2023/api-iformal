package com.iformal.iformal.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iformal.iformal.dto.UsuarioDto;
import com.iformal.iformal.model.Endereco;
import com.iformal.iformal.model.Usuarios;
import com.iformal.iformal.services.impl.UsuariosService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000/")
public class UsuarioController {

    @Autowired
    UsuariosService usuariosService;

    @Operation(summary = "Retorna uma lista de usuários")
    @GetMapping()
    public ResponseEntity<List<Usuarios>> getAllUsers() {
        List<Usuarios> usuarioList = this.usuariosService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarioList);
    }
   
    @Operation(summary = "Retorna uma lista de usuários a partir de um nome ou parte dele")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Usuarios>> getAllUsersByName(@PathVariable (value="name") String name) {
        List<Usuarios> usuarioList = this.usuariosService.listByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioList);
    }

    @Operation(summary = "Retorna um usuário a partir de um email")
    @GetMapping("/email/{email}")
    public ResponseEntity<Usuarios> getUserByEmail(@PathVariable (value="email") String email) {
        Usuarios usuario = this.usuariosService.listByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }    
        
    @Operation(summary = "Retorna um usuário a partir de um id")
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUserById(@PathVariable (value="id") int id) {
        Usuarios usuario = this.usuariosService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @Operation(summary = "Deleta um usuario a partir de seu id")
    @DeleteMapping("/")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById (@PathParam (value="id") int id){
        this.usuariosService.delete(id);
    }


    @Operation(summary = "Salva um usuário no banco de dados")
    @PostMapping()
    public ResponseEntity<Usuarios> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {    
        var usuario = new Usuarios();
        var adress = new Endereco();
        //copia o endereço
        BeanUtils.copyProperties(usuarioDto, adress); 
        //copia o usuario
        BeanUtils.copyProperties(usuarioDto, usuario);
        //seta o endereço de usuario
        usuario.setAdress(adress);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuariosService.save(usuario));
    }


    @Operation(summary = "Atualiza um usuário no banco de dados")
    @PutMapping()
    public ResponseEntity<Usuarios> updateUsuario(@PathParam (value = "id") int id, @RequestBody @Valid UsuarioDto usuarioDto) {  
        var novoUsuario = this.usuariosService.listById(id);
        var adress = new Endereco();
        //copia o endereço 
        BeanUtils.copyProperties(usuarioDto, adress); 
        //copia o usuario
        BeanUtils.copyProperties(usuarioDto, novoUsuario);
        //seta o endereço de usuario
        novoUsuario.setAdress(adress);
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.update(novoUsuario));
    }
    
    
    
}
