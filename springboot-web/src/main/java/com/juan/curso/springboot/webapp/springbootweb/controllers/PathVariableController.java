package com.juan.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springbootweb.models.User;
import com.juan.curso.springboot.webapp.springbootweb.models.dto.ParamDto;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    /*
        Path variable: se utiliza para vincular el valor de la variable de ruta a un parámetro de método de controlador.
    */
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    /*
      Controlador de spring que maneja las solicitudes GET a la ruta /api/var/mix/{product}/{id}/
    */
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json; 
    } 

    /*
      (@RequestBody User user) en el método create indica que el cuerpo de la 
      solicitud HTTP debe ser convertido a un objeto User. 
    */

    @PostMapping("/create")
    public User create(@RequestBody User user ){

        //Hacer algo con el usuario (save en la BD)
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values (@Value("${config.message}") String message) {

        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        return  json;
    }
}
