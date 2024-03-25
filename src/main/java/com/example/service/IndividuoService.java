
package com.example.service;

import com.example.springnew.domain.Individuo;
import java.util.List;

public interface IndividuoService {
    
    public List<Individuo> listaIndividuos();
       
    public void salvar(Individuo individuo);
    
    public void borrar(Individuo individuo);
    
    public Individuo localizarIndividuo(Individuo individuo);
}
