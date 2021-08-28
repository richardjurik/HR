package sk.jurik.hr.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sk.jurik.hr.services.DepartmentService;
import sk.jurik.hr.services.EmployeeService;

@Component
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    EmployeeService employeeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        employeeService.createEmployee("John",25,"Human Resources");
        employeeService.createEmployee("Victoria",24,"Human Resources");
        employeeService.createEmployee("Daniel",52,"Accounting and Finance");
        employeeService.createEmployee("Thomas",28,"Accounting and Finance");
        employeeService.createEmployee("Anna",35,"Marketing");
        employeeService.createEmployee("Jack",31,"Development");
        employeeService.createEmployee("Lucy",18,"Development");
        employeeService.createEmployee("Martin",45,"Project management");
    }
}
