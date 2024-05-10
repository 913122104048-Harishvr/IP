import java.sql.*;

@Path("/employee")
public class EmployeeWebService {

    @GET
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") int id) {
        Employee employee = null;
        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/root/company", "root", "");

            // Creating the statement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?");
            preparedStatement.setInt(1, id);

            // Executing the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Parsing the result
            if (resultSet.next()) {
                employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                );
            }

            // Closing resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
}
