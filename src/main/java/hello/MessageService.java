/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author nishida
 */
@ApplicationScoped
@Transactional
public class MessageService {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public Message create(String message){
        Message entity = new Message();
        entity.setMessage(message);
        entityManager.persist(entity);
        return entity;
    }
    
    public List<Message> findAll(){
        return entityManager.createQuery("SELECT x FROM Message x", Message.class).getResultList();
    }
    
     
}
