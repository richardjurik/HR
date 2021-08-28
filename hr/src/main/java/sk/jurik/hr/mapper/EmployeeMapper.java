package sk.jurik.hr.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.jurik.hr.dto.EmployeeDto;
import sk.jurik.hr.model.Employee;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "departmentOfEmployee", source = "department")
    EmployeeDto employeeToEmployeeDto(Employee employee);
}
