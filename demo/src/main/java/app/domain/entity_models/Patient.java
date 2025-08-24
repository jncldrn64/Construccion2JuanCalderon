package app.domain.entity_models;

import app.domain.entity_models.enums.Gender;

public class Patient extends Person {
    
    private String userName;
    private String password;
    private Gender gender;
    private EmergencyContact emergencyContact;
    private InsurancePolicy insurancePolicy;
}