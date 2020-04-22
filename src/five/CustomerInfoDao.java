/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package five;

import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;
import three.daoInterfejs.Dao;

public class CustomerInfoDao implements Dao<CustomerInfo> {

    private final DerbyConnectionPool connectionPool;

    public CustomerInfoDao(DerbyConnectionPool connectionPool) {
        this.connectionPool = Optional.ofNullable(connectionPool).orElseThrow(()-> new RuntimeException("Ja customer info dao ne primam null connection pool"));
    }
    
    public Vector getColumnNames() {
        String sqlQuery = "SELECT * from CUSTOMER";
        try (PreparedStatement ps = connectionPool.getConnection().prepareStatement(sqlQuery);
                ResultSet rs = ps.executeQuery();) {
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            Vector<Object> columnNames = new Vector<>(columns);
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(resultSetMetaData.getColumnName(i));
            }
            return columnNames;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<CustomerInfo> getAll() throws SQLException {
        String sqlQuery = "SELECT*FROM customerInfo";
        List<CustomerInfo> listOfCustomer = new ArrayList<>();

        try (PreparedStatement ps = connectionPool.getConnection().prepareStatement(sqlQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerInfo ci = new CustomerInfo(rs.getInt("CUSTOMER_ID"),
                        rs.getString("DISCOUNT_CODE"),
                        rs.getInt("ZIP"),
                        rs.getString("NAME"),
                        rs.getString("ADDRESSLINE1"),
                        rs.getString("ADDRESSLINE2"),
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getInt("FAX"),
                        rs.getString("EMAIL"),
                        rs.getInt("CREDIT_LIMIT"));
                listOfCustomer.add(ci);
            }
            return listOfCustomer;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public CustomerInfo get(int primaryKey) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CustomerInfo entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(CustomerInfo entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CustomerInfo entity) throws SQLException {
        System.out.println(entity);
        String sql = "UPDATE PLAYERINFO SET SPORT=? WHERE id=?";
        try(PreparedStatement ps = connectionPool.getConnection().prepareStatement(sql)){
            ps.setString(1, entity.getADDRESSLINE1());
            ps.setInt(2, entity.getCUSTOMER_ID());
            ps.execute();
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }    }
}