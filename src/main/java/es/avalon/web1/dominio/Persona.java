package es.avalon.web1.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name="Personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    private String dni;
    private String nombre;
    private int edad;
    @JsonIgnore
    @OneToMany(mappedBy = "persona")

    private final List<Libro> libros= new ArrayList<>();

    public Persona(String dni) {
        this.dni = dni;
    }
}
