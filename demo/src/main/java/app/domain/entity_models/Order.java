package app.domain.entity_models;

import app.domain.entity_models.enums.OrderType;
import java.time.LocalDate;

public class Order {
    private int orderNumber;
    private long patientDocument;
    private long doctorDocument;
    private LocalDate creationDate;
    private OrderType orderType;
}