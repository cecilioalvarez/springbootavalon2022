package es.avalon.web1.Rest;

import es.avalon.web1.Domain.Libro;
import es.avalon.web1.Services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/libros")
@CrossOrigin(origins ="*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
public class libroRESTController {
    @Autowired
    private LibroPersonaService servicio;

    @GetMapping
    public List<Libro> buscarTodosLibros(){
        return servicio.buscarTodosLibros();
    }

    @DeleteMapping("/{isbn}")
    public void borrar(@PathVariable  String isbn) {
        servicio.borrarLibro(new Libro(isbn));
    }

    @GetMapping("/{isbn}")
    public Libro buscarUnLibro(@PathVariable String isbn){
        return servicio.buscarUnoLibro(isbn);
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public void insertarLibro(@RequestBody  Libro l) {
        servicio.insertarLibro(l);
    }


}
