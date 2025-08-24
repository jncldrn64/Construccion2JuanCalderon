package app.domain.ports;

import app.domain.entity_models.MedicalRecord;

public interface MedicalRecordPort {
    
    public MedicalRecord findByPatientDocument(MedicalRecord medicalRecord) throws Exception;
    public void save(MedicalRecord medicalRecord) throws Exception;
}