package sk.jurik.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.jurik.hr.model.Employee;
import sk.jurik.hr.model.Person;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Person> {

    List<Employee> findByEndDateIsNull();

    List<Employee> findByEndDateIsNotNull();

    Employee findByPersonId(Integer id);
}
