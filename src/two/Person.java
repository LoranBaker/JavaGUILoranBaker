package two;

public class Person {
     private final int id;
     private final String lastName;
     private final String firstName;
     private final int Age;

    public Person(int id, String lastName, String firstName, int Age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.Age = Age;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return Age;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
     
    
     
}
