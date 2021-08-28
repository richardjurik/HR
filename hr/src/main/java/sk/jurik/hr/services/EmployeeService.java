package sk.jurik.hr.services;

import sk.jurik.hr.dto.EmployeeDto;
import sk.jurik.hr.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee createEmployee(String name, Integer age, String departmentName);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeesActiveDeactive(boolean active);

    Employee saveEmployee(Employee employee);

    Map<String, List<Employee>> getActiveDeactiveByDepartment(boolean active);
}
