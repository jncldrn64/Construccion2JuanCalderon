package app.domain.services;

import app.domain.entity_models.Order;
import app.domain.entity_models.Employee;
import app.domain.entity_models.Patient;
import app.domain.entity_models.enums.Role;
import app.domain.ports.OrderPort;
import app.domain.ports.EmployeePort;
import app.domain.ports.PatientPort;

public class CreateOrder {
    
    private OrderPort orderPort;
    private EmployeePort employeePort;
    private PatientPort patientPort;
    
    public CreateOrder(OrderPort orderPort, EmployeePort employeePort, PatientPort patientPort) {
        this.orderPort = orderPort;
        this.employeePort = employeePort;
        this.patientPort = patientPort;
    }
    
    public void create(Order order) throws Exception {
        Patient patient = patientPort.findByDocument(order.getPatientDocument());
        if (patient == null) {
            throw new Exception("La orden debe tener un paciente valido");
        }
        
        Employee doctor = employeePort.findByDocument(order.getDoctorDocument());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("La orden debe ser creada por un medico valido");
        }
        
        Order existingOrder = orderPort.findByOrderNumber(order.getOrderNumber());
        if (existingOrder != null) {
            throw new Exception("Ya existe una orden con este numero");
        }
        
        orderPort.save(order);
    }
}