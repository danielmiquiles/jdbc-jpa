package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "exercicios-jpa"
        );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setMaxResults(20);

        List<Usuario> usuarios = query.getResultList();

        for (Usuario usuario: usuarios) {
            System.out.println("Id ==> " + usuario.getId());
            System.out.println("nome ==> " + usuario.getNome());
            System.out.println("email ==> " + usuario.getEmail());

        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
