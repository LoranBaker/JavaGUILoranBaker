
package two;


//JDBC java.sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

//KORACI kada hocemo da se povežemo na neku bazu podataka(RELACIONA BAZA: MySQL, Derby, Oracle, Postgres)
//1. Povezati se na bazu ili na izvor podataka
//2. Šaljemo upite (SQL upite : select, insert, update, delete)
//3. Procesiramo rezultate upita
//GLAVNI IGRAČI
// 1. Connection kojeg ćemo dobiti iz DriverManager
// 2. Statement(PreparedStatement) kojeg ćemo dobiti iz Connection objekta
// 3. ResultSet kojeg ćemo dobiti iz Statement objekta
public class DatabaseExecutor {

    //URL, username, password
    public static final String URL = "jdbc:derby://localhost:1527/Social";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        //1.
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
            //2.
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM person LIMIT 100";
            //3. 
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                //procesiranje jednog reda u tabeli
                //id, LastName, FirstName, Age
                int id = resultSet.getInt(1);
                String lastName = resultSet.getString("LastName");
                Person person = new Person(id, lastName, resultSet.getString(3), resultSet.getInt(4));
                persons.add(person);
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        Consumer<Person> printConsumer = (Person p) -> System.out.println(p);
        Consumer<Person> printConsumer1 = System.out::println;
        persons.forEach(System.out::println);
    }
}