package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Usuario;

public class UsuarioDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public UsuarioDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("contratamais");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public String teste() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("INSERT INTO USUARIO (PRIMEIRONOME) VALUES ('TESTE')");
            query.executeUpdate();
            entityManager.getTransaction().commit();
            entityManagerFactory.close();
            return "SUCESSO";
        } catch (Exception e) {
            return "FALHA";
        }

    }

    public void adicionar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }

    public List<Usuario> buscarNome(String busca) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT * FROM USUARIO WHERE PEIMEIRONOME LIKE '%" + busca + "%'");
        List<Usuario> listaRetorno = query.getResultList();
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return listaRetorno;
    }
}
