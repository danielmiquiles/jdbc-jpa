package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario3 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "exercicios-jpa"
        );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Usuario usuario = entityManager.find(Usuario.class, 2L);
        entityManager.detach(usuario);

        usuario.setNome("Paulo Henrique Miquiles");

        entityManager.merge(usuario);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();
    }
}
