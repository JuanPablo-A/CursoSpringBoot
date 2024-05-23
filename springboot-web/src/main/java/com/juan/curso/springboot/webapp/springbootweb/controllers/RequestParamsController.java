package com.juan.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.juan.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
/*
   RequesMapping: todas las solicitudes que comiencen con /api/params serán manejadas 
   por los métodos en la clase RequestParamsController.
*/
@RequestMapping("/api/params")
public class RequestParamsController {
    
    /*
       @RequestParam: se utiliza para vincular los parámetros de solicitud a un método de controlador.
       En este caso, el parámetro message se vincula al valor de la solicitud.
    */
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No hay mensaje") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam() Integer code) {
        
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

}
