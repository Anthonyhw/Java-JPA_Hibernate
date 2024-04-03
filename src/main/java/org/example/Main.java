package org.example;

import Domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(null, "Marcos", "marcos@hotmail.com");
        Person p2 = new Person(null, "Maria", "maria@hotmail.com");
        Person p3 = new Person(null, "Jose", "jose@hotmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();


        Person pessoaEncontrada = em.find(Person.class, 3);

        System.out.println("Pessoa encontrada: " + pessoaEncontrada);

        em.close();
        emf.close();
    }
}