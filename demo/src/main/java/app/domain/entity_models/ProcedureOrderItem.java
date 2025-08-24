package app.domain.entity_models;

public class ProcedureOrderItem extends OrderItem {
    
    private String procedureName;
    private int repetitions;
    private String frequency;
    private boolean requiresSpecialist;
    private int specialtyId;
}
