/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author EQIMA
 */
public interface IDAO <T> {
    
    public T create(T obj);
    
    public T update(T obj);
    
    public  boolean delete(T obj);
    
    public T get(int id);
    
    public List<T> getAll();
    
    
    public int size();
    
}
