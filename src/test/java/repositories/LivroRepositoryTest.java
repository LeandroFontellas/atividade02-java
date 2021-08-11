package repositories;

import entities.Livro;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LivroRepositoryTest {
    @Test
    public void saveTest(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Livro livro = new Livro("TituloTest","Fulano",2020);

        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();

        Livro response = entityManager.find(Livro.class, livro);

        System.out.println(response);

        assertTrue(response.getTitulo() ==livro.getTitulo());
    }

    @Test
    public void findAllTest(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Livro> response = entityManager.createQuery("from Livro").getResultList();

        assertTrue(response instanceof List && ((List) response).stream().noneMatch((o -> !(o instanceof Livro))));
    }
}
