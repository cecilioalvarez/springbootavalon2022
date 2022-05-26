package es.avalon.web1.rest;


import es.avalon.web1.dominio.Libro;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotacion SF
@RestController
@RequestMapping("/webapi/libros")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class LibroRESTController {

    @Autowired
    private LibroPersonaService servicio;

    @GetMapping
    public List<Libro> buscarTodosLosLibros() {
        return servicio.buscarTodosLosLibros();
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertar(@RequestBody Libro l) {
        servicio.insertarLibro(l);
    }

    @DeleteMapping("/{isbn}")
    public void borrarÇ(@PathVariable String isbn) {
        servicio.borrarLibro(new Libro(isbn));
    }



}
