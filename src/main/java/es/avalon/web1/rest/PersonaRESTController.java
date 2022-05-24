package es.avalon.web1.rest;


import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

//Anotacion SF
@RestController
@RequestMapping("/webapi/personas") //Le pasamos ruta donde nos devolvera o trabajara los datos en formato JSON
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}) //Permitimos peticiones desde JAVASCRIPT  https://www.arquitecturajava.com/spring-rest-cors-y-su-configuracion/
public class PersonaRESTController {

    @Autowired
    private LibroPersonaService servicio;

    @GetMapping
    public List<Persona> buscarTodasLasPersonas() {
        return servicio.buscarTodasLasPersonas();
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertar(@RequestBody Persona p){
        servicio.insertarPersona(p);
    }

    @DeleteMapping("/{dni}")
    public void borrar(@PathVariable String dni) {
        servicio.borrarPersona(new Persona(dni));
    }
}
