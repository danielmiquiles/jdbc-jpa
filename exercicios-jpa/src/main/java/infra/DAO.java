package infra;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO <E>{
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<E> classe;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (Exception e) {
            // logs
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public DAO<E> abrirTransacao(){
        entityManager.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao(){
        entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade){
        entityManager.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public DAO<E> alterar(E entidade){
        entityManager.merge(entidade);
        return this;
    }

    public DAO<E> alterarAtomico(E entidade){
        return this.abrirTransacao().alterar(entidade).fecharTransacao();
    }

    public DAO<E> excluir(E entidade){
        entityManager.remove(entidade);
        return this;
    }

    public DAO<E> excluirAtomico(E entidade){
        return this.abrirTransacao().excluir(entidade).fecharTransacao();
    }

    public List<E> obterTodos(){
        return this.obterTodos(10,0);
    }

    public List<E> obterTodos(int qtd, int deslocamento){
        if (classe == null ) throw new UnsupportedOperationException("Classe nula");

        String jpql = "SELECT u FROM "+ classe.getName() + " u";
        TypedQuery<E> query = entityManager.createQuery(jpql, classe);
        query.setMaxResults(qtd);
        query.setFirstResult(deslocamento);

        return query.getResultList();
    }

    public void fecharDAO(){
        entityManager.close();
    }





}
