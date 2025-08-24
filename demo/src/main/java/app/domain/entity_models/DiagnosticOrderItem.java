package app.domain.entity_models;

public class DiagnosticOrderItem {
    
    private int orderNumber;
    private int itemNumber;
    private String diagnosticAidName;
    private int quantity;
    private double cost;
    private boolean requiresSpecialist;
    private int specialtyId;
}