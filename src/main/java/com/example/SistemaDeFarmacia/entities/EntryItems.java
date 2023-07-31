package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_entry_items")
public class EntryItems {
    @EmbeddedId
    private EntryItemsPK id = new EntryItemsPK();
    private Integer quantity;
    private Double price;

    public EntryItems(Prohibited prohibited, Medicine medicine,Integer quantity, Double price) {
        id.setProhibited(prohibited);
        id.setMedicine(medicine);
        this.quantity = quantity;
        this.price = price;
    }
    public Prohibited getProhibited(){
        return id.getProhibited();
    }

    public Medicine getMedicine(){
        return id.getMedicine();
    }

    public void setProhibited(Prohibited prohibited){
        id.setProhibited(prohibited);
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
