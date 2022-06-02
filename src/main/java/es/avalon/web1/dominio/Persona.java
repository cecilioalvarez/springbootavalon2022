package es.avalon.web1.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;//Estas son las librerias de JPI. No son las de hibernate
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persona {
    @Id // el id debe ir justo encima de la clave primaria
    private String dni;
    private String nombre;
    private String apellidos;
    //añadimos esto para crear la relacion entra la tabla personas y libro
    //En este caso es una relacion de 1 Persona a n Libros
    @JsonIgnore//Estamos ignorando la relacion entre personas y libros a nivel de los datos JSON
    @OneToMany(mappedBy = "persona")
    private List<Libro>libros=new ArrayList<>();



    public Persona(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }



    public Persona(String dni) {
        this.dni = dni;
    }

}