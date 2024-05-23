package com.juan.curso.springboot.webapp.springbootweb.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping; 
import com.juan.curso.springboot.webapp.springbootweb.models.User;
import com.juan.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController    // Mezcla entre @Controller y @ResponseBody
@RequestMapping("/api")    // Ruta de primer nivel siempre es con la anotacion @RequestMapping
public class UserRestController {
    
    // @RequestMapping(path = "/details", method = RequestMethod.GET)  Forma equivalente y se puede pasar diferentes metodos HTTP
    @GetMapping("/details")   
    public UserDto details () {

        UserDto userDto = new UserDto();
        User user = new User("Juan Pablo", "Arango");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring Boot");

        return userDto;
    }

    @GetMapping("/list")     
    public List<User> list () {
        User user = new User("Juan Pablo", "Arango");
        User user2 = new User("Pepe", "Does ");
        User user3 = new User("Jhon", "Doe");
        
        // Forma mas corta de crear una lista de usuarios (no se puede modificar despues de creada)
        List<User> users = Arrays.asList(user, user2, user3); 
        
        // Crear una lista de usuarios
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    @GetMapping("/details-map")     //  Tambien hay @PostMapping, @PutMapping, @DeleteMapping
    public Map<String, Object> detailsMap () {
        User user = new User("Juan Pablo", "Arango");
        Map<String, Object> body = new HashMap<>();
    
        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
