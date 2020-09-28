/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.banifou.quarkus.jpa;

import io.banifou.quarkus.Basket;
import io.banifou.quarkus.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class BookRepos implements PanacheRepository<Book> {

    private final Logger LOG = LoggerFactory.getLogger(BookRepos.class);
    
    @Inject
    EntityManager entityManager;    

    @Transactional(SUPPORTS)
    public List<Basket> findAllBaskets() {
        try {
            Query q = entityManager.createQuery("SELECT m FROM Basket m ORDER BY m.basketid DESC");

            return q.getResultList();
        } catch (NoResultException ex) {
            LOGGER.error(ex.toString());
            return null;
        } finally {
            entityManager.clear();
        }
    }
    
}
