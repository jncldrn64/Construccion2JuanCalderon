package app.domain.services;

import app.domain.entity_models.VitalSigns;
import app.domain.entity_models.Employee;
import app.domain.entity_models.Patient;
import app.domain.entity_models.enums.Role;
import app.domain.ports.VitalSignsPort;
import app.domain.ports.EmployeePort;
import app.domain.ports.PatientPort;

public class RecordVitalSigns {
    
    private VitalSignsPort vitalSignsPort;
    private EmployeePort employeePort;
    private PatientPort patientPort;
    
    public RecordVitalSigns(VitalSignsPort vitalSignsPort, EmployeePort employeePort, PatientPort patientPort) {
        this.vitalSignsPort = vitalSignsPort;
        this.employeePort = employeePort;
        this.patientPort = patientPort;
    }
    
    public void record(VitalSigns vitalSigns, String nurseDocument) throws Exception {
        Patient patient = patientPort.findByDocument(vitalSigns.getPatientDocument());
        if (patient == null) {
            throw new Exception("Los signos vitales deben tener un paciente valido");
        }
        
        Employee nurse = employeePort.findByDocument(nurseDocument);
        if (nurse == null || !nurse.getRole().equals(Role.NURSE)) {
            throw new Exception("Los signos vitales deben ser registrados por una enfermera valida");
        }
        
        vitalSignsPort.save(vitalSigns);
    }
}