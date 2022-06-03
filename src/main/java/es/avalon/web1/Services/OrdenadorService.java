package es.avalon.web1.Services;

import es.avalon.web1.Domain.Ordenador;
import es.avalon.web1.Domain.Persona;
import es.avalon.web1.Repository.OrdenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenadorService {

    @Autowired
    private OrdenadorRepository ordenadorRepo;

    public List<Ordenador> searchAllOrdenadores(){

        return ordenadorRepo.searchAll();
    }
}
