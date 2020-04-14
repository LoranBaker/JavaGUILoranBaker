/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.book;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author PC
 */
public class ConnectionPool {
    
    private List<Connection> availableConnections;
    private List<Connection> usedConnections;
}
