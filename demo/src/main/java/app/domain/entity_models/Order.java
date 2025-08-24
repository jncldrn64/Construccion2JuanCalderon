package app.domain.entity_models;

import app.domain.entity_models.enums.OrderType;
import java.time.LocalDate;

public class Order {
    
    private int orderNumber;
    private String patientDocument;
    private String doctorDocument;
    private LocalDate creationDate;
    private OrderType orderType;
}