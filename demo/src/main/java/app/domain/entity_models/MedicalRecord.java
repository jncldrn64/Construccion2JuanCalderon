package app.domain.entity_models;

import java.time.LocalDate;
import java.util.Map;

public class MedicalRecord {
    
    private long patientDocument;
    private LocalDate consultationDate;
    private long doctorDocument;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;
    private Map<String, Object> additionalData;
}