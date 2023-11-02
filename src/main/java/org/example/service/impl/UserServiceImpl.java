package org.example.service.impl;

import org.example.entity.User;
import org.example.service.UserService;

import javax.persistence.EntityManager;

public class UserServiceImpl implements UserService {
    private EntityManager manager;

    public UserServiceImpl(EntityManager manager) {
        this.manager = manager;
    }

    public void create(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }

    public User read(Long id) {
        return manager
                .createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void update(User user) {
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
    }

    public void delete(User user) {
        manager.getTransaction().begin();
        manager.remove(user);
        manager.getTransaction().commit();
    }
}
