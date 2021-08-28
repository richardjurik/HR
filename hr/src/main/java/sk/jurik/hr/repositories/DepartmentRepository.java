package sk.jurik.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.jurik.hr.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    Department findByName(String name);
}
