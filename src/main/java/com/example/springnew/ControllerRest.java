
package com.example.springnew;

import com.example.springnew.domain.Individuo;
import lombok.extern.slf4j.Slf4j;
import com.example.springnew.dao.IndividuoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControllerRest {
    
    @Autowired
    private IndividuoDao individuoDao;
    
    @GetMapping("/")
    public String index(Model model){
       
        Iterable<Individuo> individuos = individuoDao.findAll();
        
        log.info("Estoy ejecutando el controlador MVC");
        model.addAttribute("individuos", individuos);
        return "index";
    }
}
