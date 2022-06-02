package es.avalon.web1.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    private int isbn;
    private String titulo;
    private String autor;
    @JsonIgnore
    @ManyToOne// relacion por la que varios libros pueden tener asignada la misma persona
    @JoinColumn(name = "personas_dni")//no permite que este a una persona que no exista en la lista personas.
    private Persona persona;


    public Libro(int isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }


    public Libro(int isbn) {
        this.isbn = isbn;
    }


}