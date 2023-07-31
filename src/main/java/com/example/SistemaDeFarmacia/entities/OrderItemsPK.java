package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable
public class OrderItemsPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    public OrderItemsPK(){}

    public OrderItemsPK(Order order, Medicine medicine) {
        this.order = order;
        this.medicine = medicine;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
