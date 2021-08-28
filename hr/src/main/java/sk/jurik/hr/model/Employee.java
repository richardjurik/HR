package sk.jurik.hr.model;

import com.sun.istack.NotNull;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.Instant;

@Entity
public class Employee {

    @EmbeddedId
    private Person person;

    @NotNull
    private Instant startDate;

    private Instant endDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    /**
     * Employee constructor
     */
    public Employee() {
    }

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
