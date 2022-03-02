package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "exercicios-jpa"
        );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Usuario usuario = new Usuario("Daniel", "daniel@email.com.br");

        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();

        System.out.println("O id gerado foi: " + usuario.getId());

        entityManager.close();
        entityManagerFactory.close();
    }
}
