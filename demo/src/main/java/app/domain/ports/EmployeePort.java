package app.domain.ports;

import app.domain.entity_models.Employee;

public interface EmployeePort {
    
    public Employee findByDocument(Employee employee) throws Exception;
    public void save(Employee employee) throws Exception;
    public void delete(Employee employee) throws Exception;
}