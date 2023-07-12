package io.shiftleft.model;
import java.sql.*;


// Employee class
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Method to share salary with a third party
    public void shareSalaryWithThirdParty() {
        // Implement code to share the salary with the third party
        System.out.println("Sharing salary $" + salary + " with the third party.");
    }

    // Method to store salary in the database
    public void storeSalaryInDatabase() {
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            // Prepare the SQL statement
            String sql = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, salary);

            // Execute the statement
            stmt.executeUpdate();

            // Close the resources
            stmt.close();
            conn.close();

            System.out.println("Salary $" + salary + " stored in the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
