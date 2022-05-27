package es.avalon.web1.rest;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/personas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class PersonaRESTController {
    @Autowired
    private LibroPersonaService servicio;
    @GetMapping
    public List<Persona> buscarTodas() {
        return servicio.buscarTodasLasPersonas();
    }

    @GetMapping("/{dni}")
    public Persona  buscarUno(@PathVariable String dni) {
       
        return servicio.buscarUnaPersona(dni);
    }

    @PostMapping ( consumes = MediaType.APPLICATION_JSON_VALUE )
    public void insertar(@RequestBody  Persona p) {
       servicio.insertarPersona(p);
    }

    @DeleteMapping("/{dni}")
    public void borrar(@PathVariable String  dni) {

        servicio.borrarPersona(new Persona(dni));
    }

    @PutMapping("/{dni}")
    public void actualizar(@PathVariable String  dni,@RequestBody Persona p) {
        Persona personaVieja=servicio.buscarUnaPersona(dni);
        //cambias los datos que te interesen
        personaVieja.setEdad(p.getEdad());
        personaVieja.setNombre(p.getNombre());
        servicio.salvarPersona(personaVieja);
    }
}
