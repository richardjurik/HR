package sk.jurik.hr.dto;

import com.sun.istack.NotNull;
import sk.jurik.hr.model.Department;
import sk.jurik.hr.model.Person;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.Instant;

public class EmployeeDto {

    private Person person;
    private Instant startDate;
    private Instant endDate;
    private Department departmentOfEmployee;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Department getDepartmentOfEmployee() {
        return departmentOfEmployee;
    }

    public void setDepartmentOfEmployee(Department departmentOfEmployee) {
        this.departmentOfEmployee = departmentOfEmployee;
    }
}
