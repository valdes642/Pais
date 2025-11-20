/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * 
 */
public interface CrudDAO<T> {
    void insertar(T entidad);
    
    void actualizar(T entidad);
    boolean actualizar2(T entidad);
    
    
    void eliminar(int id);
    T obtenerPorId(int id);
    List<T> listarTodos();
}

