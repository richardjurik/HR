package sk.jurik.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.jurik.hr.dto.EmployeeDto;
import sk.jurik.hr.mapper.EmployeeMapper;
import sk.jurik.hr.model.Department;
import sk.jurik.hr.model.Employee;
import sk.jurik.hr.services.EmployeeService;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/{personId}")
    public EmployeeDto fetchEmployeeByPersonId(@PathVariable Integer personId) {

        return employeeMapper.employeeToEmployeeDto(employeeService.getEmployeeById(personId));
    }

    @GetMapping("/active")
    public List<EmployeeDto> fetchAllActiveEmployees() {

        return employeeService.getEmployeesActiveDeactive(true).stream()
                .flatMap(employee -> Stream.of(employeeMapper.employeeToEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @GetMapping("/deactive")
    public List<EmployeeDto> fetchAllDectiveEmployees() {

        return employeeService.getEmployeesActiveDeactive(false).stream()
                .flatMap(employee -> Stream.of(employeeMapper.employeeToEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @GetMapping("/deactivate/{personId}")
    public EmployeeDto fetchDeactiveEmployee(@PathVariable Integer personId) {

        Employee employee = employeeService.getEmployeeById(personId);
        if(employee != null) {
            employee.setEndDate(Instant.now());
            employeeService.saveEmployee(employee);

            return employeeMapper.employeeToEmployeeDto(employee);
        }

        return null;
    }

    @GetMapping("/active/by-department")
    public Map<String, List<EmployeeDto>> fetchActiveEmployeesByDepartment() {

        Map<String, List<EmployeeDto>> employeesByDepartment = new HashMap<>();

        employeeService.getActiveDeactiveByDepartment(true).forEach((k,v) ->
                employeesByDepartment.put(k,v.stream()
                        .flatMap(employee -> Stream.of(employeeMapper.employeeToEmployeeDto(employee)))
                        .collect(Collectors.toList())));

        return employeesByDepartment;
    }

    @GetMapping("/deactive/by-department")
    public Map<String, List<EmployeeDto>> fetchDectiveEmployeesByDepartment() {

        Map<String, List<EmployeeDto>> employeesByDepartment = new HashMap<>();

        employeeService.getActiveDeactiveByDepartment(false).forEach((k,v) ->
                employeesByDepartment.put(k,v.stream()
                        .flatMap(employee -> Stream.of(employeeMapper.employeeToEmployeeDto(employee)))
                        .collect(Collectors.toList())));

        return employeesByDepartment;
    }
}
