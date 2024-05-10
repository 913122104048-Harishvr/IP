import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class EmployeeWebServiceClient {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/root/employee/1");

       Employee employee = target.request().get(Employee.class);


        if (employee != null) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Salary: " + employee.getSalary());
        } else {
            System.out.println("Employee not found");
        }
    }
}
