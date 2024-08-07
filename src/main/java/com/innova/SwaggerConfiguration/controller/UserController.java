package com.innova.SwaggerConfiguration.controller;

import com.innova.SwaggerConfiguration.dto.UserDto;
import com.innova.SwaggerConfiguration.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Mostrar todo", description = "Se mostraran todos los usuarios")
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> lista = this.userService.getAll();
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Buscar user", description = "Mostrara un usuario en especifico")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        UserDto usuario = this.userService.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @Operation(summary = "Guardar Usuario", description = "Ingresara un usuario nuevo")
    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        UserDto saved = this.userService.save(userDto);
        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Actualizar usuario", description = "Actualizara la informacion del usuario")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable("id") Long id){
        UserDto updated = this.userService.update(userDto, id);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar usuario", description = "Se eliminara un usuario de la lista de usuarios")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
