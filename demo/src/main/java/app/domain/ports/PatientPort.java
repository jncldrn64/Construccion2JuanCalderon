package app.domain.ports;

import app.domain.entity_models.Patient;

public interface PatientPort {
    
    public Patient findByDocument(Patient patient) throws Exception;
    public Patient findByUserName(Patient patient) throws Exception;
    public void save(Patient patient) throws Exception;
}