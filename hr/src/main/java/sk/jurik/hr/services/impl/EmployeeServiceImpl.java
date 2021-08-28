package sk.jurik.hr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.jurik.hr.dto.EmployeeDto;
import sk.jurik.hr.model.Department;
import sk.jurik.hr.model.Employee;
import sk.jurik.hr.model.Person;
import sk.jurik.hr.repositories.DepartmentRepository;
import sk.jurik.hr.repositories.EmployeeRepository;
import sk.jurik.hr.services.DepartmentService;
import sk.jurik.hr.services.EmployeeService;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentService departmentService;

    @Override
    public Employee createEmployee(String name, Integer age, String departmentName) {

        Department department = departmentService.createDepartment(departmentName);

        Person person = new Person(Integer.valueOf((int) employeeRepository.count()+1),name,age);

        Employee employee = new Employee();
        employee.setPerson(person);
        employee.setStartDate(Instant.now());
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        return employeeRepository.findByPersonId(id);
    }

    @Override
    public List<Employee> getEmployeesActiveDeactive(boolean active) {

        if (active){
            return employeeRepository.findByEndDateIsNull();
        } else {
            return employeeRepository.findByEndDateIsNotNull();
        }
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Map<String, List<Employee>> getActiveDeactiveByDepartment(boolean active) {
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();

        getEmployeesActiveDeactive(active)
                .stream()
                .flatMap(employee -> Stream.of(employee.getDepartment()))
                .distinct()
                .forEach(d -> employeesByDepartment.put(d.getName(),
                        getEmployeesActiveDeactive(active)
                                .stream()
                                .filter(employee -> employee.getDepartment().getId() == d.getId())
                                .collect(Collectors.toList()))
                );

        return employeesByDepartment;
    }
}
