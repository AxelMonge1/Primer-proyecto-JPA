/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.tiendajpa;

import java.util.List;

/**
 *
 * @author LABORATORIOS
 */
public class TiendaJPA {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        Producto p1 = new Producto(0, "Papita", 19.90);
        Producto p2 = new Producto(0, "Galletas", 21.90);
        Producto p3 = new Producto(0, "CocaCola", 25.90);
        Producto p4 = new Producto(0, "Gansito", 15.90);
        Producto p5 = new Producto(0, "Polnito", 100.90);
        
        productoDAO.insertar(p1);
        productoDAO.insertar(p2);
        productoDAO.insertar(p3);
        productoDAO.insertar(p4);
        productoDAO.insertar(p5);
        
        Producto pBuscado = productoDAO.buscar(p3.getId());
        System.out.println("Producto encontrado: " + pBuscado.getNombre());
        pBuscado.setPrecio(26.90);
        productoDAO.actualizar(pBuscado);
        productoDAO.eliminar(p4.getId());
        
        List<Producto> listaProductos = productoDAO.listar();
        listaProductos.forEach(p -> System.out.println(p.toString()));
    }
}
