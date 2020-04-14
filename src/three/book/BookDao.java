/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import three.daoInterfejs.Dao;
//1. Connection 
//2. Statement, PreparedStatement(Callable) -> connection
//3. ResultSet 

public class BookDao implements Dao<Book> {

    private final Connection connection;

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public Book get(int primaryKey) throws SQLException {
        String sqlQuery = "SELECT *FROM Book WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, primaryKey);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return new Book(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDate(5));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Book entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Book entity) throws SQLException {

        //java.sql.Date
        //java.util.Date
        //java.time.LocalDate
        String sqlInsertStatement = "INSERT INTO book (`bookName`, `authorName`, `publisher`, `publishingDate`)\n"
                + "VALUES(?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlInsertStatement)) {
            statement.setString(1, entity.getBookName());
            statement.setString(2, entity.getAuthorName());
            statement.setString(3, entity.getPublisher());
            statement.setDate(4, entity.getPublishingDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Book entity) throws SQLException {
        String sqlStatement = "UPDATE book SET `bookName`=?, `authorName`=?, publisher=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sqlStatement);
        ps.setString(1, entity.getBookName());
        ps.setString(2, entity.getAuthorName());
        ps.setString(3, entity.getPublisher());
        ps.setInt(4, entity.getId());
        ps.executeUpdate();
    }

}
