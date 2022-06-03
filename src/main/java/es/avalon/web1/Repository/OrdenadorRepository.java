package es.avalon.web1.Repository;


import es.avalon.web1.Domain.Ordenador;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrdenadorRepository {

    @PersistenceContext
    EntityManager em;

    public List<Ordenador> searchAll() {

        TypedQuery<Ordenador> consulta = em.createQuery("SELECT o FROM Ordenador o", Ordenador.class);
        return consulta.getResultList();
    }

}
