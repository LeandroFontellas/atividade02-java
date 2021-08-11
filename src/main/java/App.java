import entities.MaterialBibliografico;
import repositories.LivroRepository;
import repositories.RevistaRepository;
import tela.Tela;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        LivroRepository livroRepository = new LivroRepository(entityManager);
        RevistaRepository revistaRepository = new RevistaRepository(entityManager);

        SwingUtilities.invokeLater(() -> new Tela(new MaterialBibliografico(livroRepository,revistaRepository)));

        entityManager.close();

        entityManagerFactory.close();
    }
}
