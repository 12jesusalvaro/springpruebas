
package com.example.springnew;

import com.example.service.IndividuoService;
import com.example.springnew.domain.Individuo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerRest {
    
    @Autowired
    private IndividuoService individuoService;
    
    @GetMapping("/")
    public String index(Model model){
       
        List<Individuo> individuos = individuoService.listaIndividuos();
        
        log.info("Estoy ejecutando el controlador MVC");
        model.addAttribute("individuos", individuos);
        return "index";
    }
    
    @GetMapping("/anexar")
    public String anexar(Individuo individuo){
        return "editar";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid Individuo individuo, Errors error){
        if(error.hasErrors()){
            return "editar";
        }
        individuoService.salvar(individuo); 

        return "redirect:/";
    }
    
    @GetMapping("/cambiar/{id}")
    public String editar(Individuo individuo, Model model){
        individuo = individuo = individuoService.localizarIndividuo(individuo);
        model.addAttribute("individuo", individuo);
        return "editar";
    }
    
    @GetMapping("/borrar")
    public String borrar(Individuo individuo){
        individuoService.borrar(individuo);
        return "redirect:/";
    }
}   
