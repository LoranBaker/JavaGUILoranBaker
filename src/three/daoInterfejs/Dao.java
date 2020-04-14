/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.daoInterfejs;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public interface Dao<E> {
    //READ
    List<E> getAll() throws SQLException;
    
    E get(int primaryKey) throws SQLException;
    
    //DELETE
    void delete(E entity) throws SQLException;
    //CREATE
    void save(E entity) throws SQLException;
    //UPDATE
    void update (E entity) throws SQLException;
    
}
