package sk.jurik.hr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.jurik.hr.model.Department;
import sk.jurik.hr.repositories.DepartmentRepository;
import sk.jurik.hr.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(String name) {

        Department department = getDepartmentByName(name);

        if(department == null){
            department = new Department(name);
            departmentRepository.save(department);
        }

        return department;
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
}
