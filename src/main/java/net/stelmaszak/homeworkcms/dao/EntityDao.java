package net.stelmaszak.homeworkcms.dao;

import net.stelmaszak.homeworkcms.entity.InterfaceEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class EntityDao {

    @PersistenceContext
    EntityManager entityManager;

    public void detachEntity(InterfaceEntity entity) {
        entityManager.detach(entity);
    }

}
