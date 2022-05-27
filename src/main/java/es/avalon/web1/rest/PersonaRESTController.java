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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}) //Permitimos peticiones desde JAVASCRIPT  https://www.arquitecturajava.com/spring-rest-cors-y-su-configuracion/
public class PersonaRESTController {

    @Autowired
    private LibroPersonaService servicio;

    @GetMapping
    public List<Persona> buscarTodasLasPersonas() {
        return servicio.buscarTodasLasPersonas();
    }

    @GetMapping("/{dni}")
    public Persona buscarUno(@PathVariable String dni) {
        return servicio.buscarUnaPersona(dni);
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertar(@RequestBody Persona p){
        servicio.insertarPersona(p);
    }

    @DeleteMapping("/{dni}")
    public void borrar(@PathVariable String dni) {
        servicio.borrarPersona(new Persona(dni));
    }

    @PutMapping("/{dni}")
    public void actualizar(@PathVariable String dni, @RequestBody Persona p) {
        Persona personaVieja = servicio.buscarUnaPersona(dni); //Buscamos la persona a actualizar por su dni
        
        //Actualizamos datos de la persona de la BBDD con la nueva
        personaVieja.setEdad(p.getEdad());
        personaVieja.setNombre(p.getNombre());

        //Actualizamos la persona
        servicio.salvarPersona(personaVieja);
    }


}
