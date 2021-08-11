package repositories;

import entities.Revista;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class RevistaRepository {
    private EntityManager entityManager;

    public RevistaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Revista> save(Revista Revista){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(Revista);
            entityManager.getTransaction().commit();
            return Optional.of(Revista);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Revista> findAll(){
        return entityManager.createQuery("from Revista").getResultList();
    }
}
