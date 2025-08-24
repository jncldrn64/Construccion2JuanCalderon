package app.domain.entity_models;

public class DiagnosticOrderItem extends OrderItem {
    
    private String diagnosticAidName;
    private int quantity;
    private boolean requiresSpecialist;
    private int specialtyId;
}