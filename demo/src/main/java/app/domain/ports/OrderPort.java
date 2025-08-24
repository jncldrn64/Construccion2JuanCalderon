package app.domain.ports;

import app.domain.entity_models.Order;

public interface OrderPort {
    
    public Order findByOrderNumber(Order order) throws Exception;
    public void save(Order order) throws Exception;
}