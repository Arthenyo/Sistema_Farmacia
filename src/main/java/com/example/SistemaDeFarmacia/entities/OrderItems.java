package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_items")
public class OrderItems {
    @EmbeddedId
    private OrderItemsPK id = new OrderItemsPK();
    private Integer quantity;
    private Double price;

    public OrderItems(Order order, Medicine medicine, Integer quantity, Double price) {
        id.setOrder(order);
        id.setMedicine(medicine);
        this.quantity = quantity;
        this.price = price;
    }
    public Order getOrder(){
        return id.getOrder();
    }

    public Medicine getMedicine(){
        return id.getMedicine();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public void setMedicine(Medicine medicine){
        id.setMedicine(medicine);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
