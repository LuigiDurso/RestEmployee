package it.si2001.controller;


import it.si2001.model.Employee;
import it.si2001.model.Skill;
import it.si2001.repository.EmployeeRepository;
import it.si2001.service.EmployeeService;
import it.si2001.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    final
    EmployeeService employeeService;
    final
    SkillService skillService;

    @Autowired
    public RestController(EmployeeService employeeService, SkillService skillService) {
        this.employeeService = employeeService;
        this.skillService = skillService;
    }

    //-------------------Retrieve All Employees--------------------------------------------------------

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllUsers() {

        List<Employee> employees = (List<Employee>) employeeService.findAllEmployees();
        if(employees.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    //-------------------Retrieve All Skills--------------------------------------------------------

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public ResponseEntity<List<Skill>> listAllSkills() {

        List<Skill> skills = (List<Skill>) skillService.findAllSkills();
        if(skills.isEmpty()){
            return new ResponseEntity<List<Skill>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Skill>>(skills, HttpStatus.OK);
    }

    //-------------------Retrieve Single User--------------------------------------------------------

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getUser(@PathVariable("id") int id) {

        Employee employee = employeeService.findById(id);
        if (employee == null) {

            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }



    //-------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);

        return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
    }

    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        employeeService.deleteEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
