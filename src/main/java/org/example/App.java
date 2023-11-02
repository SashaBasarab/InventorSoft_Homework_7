package org.example;

import org.example.entity.User;
import org.example.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("BasicTask");
        EntityManager manager = factory.createEntityManager();

        UserServiceImpl userService = new UserServiceImpl(manager);

        User user = new User();
        user.setName("Some Name");
        userService.create(user);
        System.out.println(userService.read(1L) + " is created");

        user.setName("Updated Name");
        userService.update(user);

        User retrievedEntity = userService.read(user.getId());
        System.out.println("Retrieved Entity: " + retrievedEntity.getName());

        userService.delete(retrievedEntity);
        System.out.println(userService.read(1L));

        manager.close();
    }
}
