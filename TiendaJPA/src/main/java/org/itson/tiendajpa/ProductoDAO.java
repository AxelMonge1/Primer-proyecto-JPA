/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.tiendajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LABORATORIOS
 */
public class ProductoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
    
    public void insertar(Producto producto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }
    
    public Producto buscar(int id){
        EntityManager em = emf.createEntityManager();
        Producto p = em.find(Producto.class, id);
        return p;
    }
    
    public void actualizar(Producto producto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();
        em.close();
    }
    
    public void eliminar(int id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Producto p = em.find(Producto.class, id);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Producto> listar(){
        EntityManager em = emf.createEntityManager();
        List<Producto> lista = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        return lista;
    }
}