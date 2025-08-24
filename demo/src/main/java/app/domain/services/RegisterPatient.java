package app.domain.services;

import app.domain.entity_models.Patient;
import app.domain.ports.PatientPort;

public class RegisterPatient {
    
    private PatientPort patientPort;
    
    public RegisterPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }
    
    public void register(Patient patient) throws Exception {
        Patient existingPatient = patientPort.findByDocument(patient.getDocument());
        if (existingPatient != null) {
            throw new Exception("Ya existe un paciente con esta cedula");
        }
        Patient existingUsername = patientPort.findByUserName(patient.getUserName());
        if (existingUsername != null) {
            throw new Exception("Ya existe un paciente con este nombre de usuario");
        }
        patientPort.save(patient);
    }
}