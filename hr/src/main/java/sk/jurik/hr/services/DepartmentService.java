package sk.jurik.hr.services;

import sk.jurik.hr.model.Department;

public interface DepartmentService {

    Department createDepartment(String name);

    Department getDepartmentByName(String name);
}
