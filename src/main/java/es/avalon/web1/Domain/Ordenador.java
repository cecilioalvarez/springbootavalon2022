package es.avalon.web1.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ordenadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordenador {

    @Id
    private String numserie;
    private String modelo;
    private String marca;

    @JsonIgnore
    public Ordenador(String numserie){
        this.numserie=numserie;
    }

}
