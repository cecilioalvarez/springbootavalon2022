package es.avalon.web1.controllers;

import es.avalon.web1.Services.OrdenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordenadores")
public class OrdenadorController {

    @Autowired
    OrdenadorService servicio;


    @GetMapping("/lista")
    public String lista(Model modelo){
        modelo.addAttribute("lista", servicio.searchAllOrdenadores());
        return "/lista";
    }

}
