package com.juan.curso.springboot.webapp.springbootweb.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.juan.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details (Model model) {

        User user = new User("Juan Pablo", "Arango");
        user.setEmail("andres@correo.com");

        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        
        // model.addAttribute("users", users);
        model.addAttribute("tittle", "Listado de usuarios");

        return "list";
    }

     /*
        Nombre de atributo que se va a usar en la vista y se puede usar en cualquier metodo del controlador
        Sirve para no tener que estar pasando el objeto en cada metodo (reutilizarlo)
     */
    @ModelAttribute("users")
    public List<User> usersModel(){
        List<User> users = Arrays.asList(
            new User("Pepa", "Gonzales"), 
            new User("Lucas", "Gonzales", "lalo@correo.com"),
            new User("Juan", "Gonzales", "juan@correo.com"),
            new User("Andres", "Gonzales"));

        return users;
    }

    
}
