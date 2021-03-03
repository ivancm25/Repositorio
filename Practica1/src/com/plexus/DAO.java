package com.plexus;

import java.util.List;

public interface DAO<T> { 
    
    /**
     * Gets the all.
     *
     * @return the all
     */
    List<T> getAll();     
    
    /**
     * Save.
     *
     * @param t the t
     * @return true, if successful
     */
    public boolean save(T t);     
    
    /**
     * Update.
     *
     * @param t the t
     * @return true, if successful
     */
    public boolean update(T t);     
    
    /**
     * Delete.
     *
     * @param t the t
     * @return true, if successful
     */
    public boolean delete(T t);

}
