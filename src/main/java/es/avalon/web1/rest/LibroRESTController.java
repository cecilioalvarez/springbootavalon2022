package es.avalon.web1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.avalon.web1.dominio.Libro;
import es.avalon.web1.services.LibroPersonaService;
//Este controlador es el que usamos para usar datos puros con la base de datos. Es decir a traves de JASON
//Añadimos los metodos de listar, añadir, borrar....
@RestController//Anotacion para definir como un controller de JSON(JavaScript Object Notation) "Controlador REST".
@RequestMapping("/webapi/libros")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class LibroRESTController {

    @Autowired
    //Lo que hace un autowired es buscar un objeto manejado (beans) que
    // implementen determinada interfaz para hacer referencia a él.
    // DE esta manera no es neceario crear una instancia nueva del objeto
    // cada vez que se necesite la funcionalidad de determinada clase.
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
    public void borrar(@PathVariable int isbn){
        servicio.borrarLibro(new Libro(isbn));
    }
    @GetMapping("/{isbn}")
    public Libro buscarUno(@PathVariable int isbn) {
        
        return servicio.buscarLibro(isbn);
    }
}

