package app.domain.ports;

import app.domain.entity_models.VitalSigns;

public interface VitalSignsPort {
    
    public VitalSigns findByPatientDocument(VitalSigns vitalSigns) throws Exception;
    public void save(VitalSigns vitalSigns) throws Exception;
}