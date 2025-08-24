package app.domain.services;

import app.domain.entity_models.Employee;
import app.domain.ports.EmployeePort;

public class CreateEmployee {
    
    private EmployeePort employeePort;
    
    public CreateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }
    
    public void create(Employee employee) throws Exception {
        Employee existingEmployee = employeePort.findByDocument(employee.getDocument());
        if (existingEmployee != null) {
            throw new Exception("Ya existe un empleado con esta cedula");
        }
        employeePort.save(employee);
    }
}