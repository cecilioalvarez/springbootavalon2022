package es.avalon.web1.rest;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Este controlador es el que usamos para usar datos puros con la base de datos. Es decir a traves de JASON
//Añadimos los metodos de listar, añadir, borrar....
@RestController//Anotacion para definir como un controller de JSON(JavaScript Object Notation) "Controlador REST".
@RequestMapping("/webapi/personas")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST})
public class PersonaRESTController {

    @Autowired
    //Lo que hace un autowired es buscar un objeto manejado (beans) que
    // implementen determinada interfaz para hacer referencia a él.
    // DE esta manera no es neceario crear una instancia nueva del objeto
    // cada vez que se necesite la funcionalidad de determinada clase.
    private LibroPersonaService servicio;

    @GetMapping
    public List<Persona> buscarTodasLasPersonas() {
        return servicio.buscarTodasLasPersonas();
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertar(@RequestBody Persona p) {
        servicio.insertarPersona(p);

    }
    @DeleteMapping("/{dni}")
    public void borrar(@PathVariable String dni){
        servicio.borrarPersona(new Persona(dni));
    }
}
