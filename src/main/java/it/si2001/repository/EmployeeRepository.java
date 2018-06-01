package it.si2001.repository;

import it.si2001.model.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findEmployeeById(int id);
}
