package com.juan.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

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
}
