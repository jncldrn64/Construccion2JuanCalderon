package app.domain.services;

import app.domain.entity_models.MedicalRecord;
import app.domain.entity_models.Employee;
import app.domain.entity_models.Patient;
import app.domain.entity_models.enums.Role;
import app.domain.ports.MedicalRecordPort;
import app.domain.ports.EmployeePort;
import app.domain.ports.PatientPort;

public class CreateMedicalRecord {
    
    private MedicalRecordPort medicalRecordPort;
    private EmployeePort employeePort;
    private PatientPort patientPort;
    
    public CreateMedicalRecord(MedicalRecordPort medicalRecordPort, EmployeePort employeePort, PatientPort patientPort) {
        this.medicalRecordPort = medicalRecordPort;
        this.employeePort = employeePort;
        this.patientPort = patientPort;
    }
    
    public void create(MedicalRecord medicalRecord) throws Exception {
        Patient patient = patientPort.findByDocument(medicalRecord.getPatientDocument());
        if (patient == null) {
            throw new Exception("El registro debe tener un paciente valido");
        }
        
        Employee doctor = employeePort.findByDocument(medicalRecord.getDoctorDocument());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("El registro clinico debe ser creado por un medico valido");
        }
        
        medicalRecordPort.save(medicalRecord);
    }
}