package com.juan.curso.springboot.webapp.springbootweb.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping; 
import com.juan.curso.springboot.webapp.springbootweb.models.User;

@RestController    //mezcla entre @Controller y @ResponseBody
@RequestMapping("/api")    //Ruta de primer nivel siempre es con la anotacion @RequestMapping
public class UserRestController {
    
    // @RequestMapping(path = "/details", method = RequestMethod.GET)  Forma equivalente y se puede pasar diferentes metodos HTTP
    @GetMapping("/details")     //  Tambien hay @PostMapping, @PutMapping, @DeleteMapping
    public Map<String, Object> details () {
        User user = new User("Juan Pablo", "Arango");
        Map<String, Object> body = new HashMap<>();
    
        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
