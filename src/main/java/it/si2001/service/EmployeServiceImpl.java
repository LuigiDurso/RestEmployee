package it.si2001.service;

import it.si2001.model.Employee;
import it.si2001.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("employeeService")
@Transactional
public class EmployeServiceImpl implements EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeServiceImpl()
    {
    }

    public Employee findById(int id)
    {
        return employeeRepository.findEmployeeById(id);
    }

    public void saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee)
    {
        this.employeeRepository.delete(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return (List<Employee>) employeeRepository.findAll();
    }

}
