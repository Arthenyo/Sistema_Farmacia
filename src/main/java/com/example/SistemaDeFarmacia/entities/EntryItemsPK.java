package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;
@Embeddable
public class EntryItemsPK {
    @ManyToOne
    @JoinColumn(name = "prohibited_id")
    private Prohibited prohibited;
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    public EntryItemsPK(){}

    public EntryItemsPK(Prohibited prohibited, Medicine medicine) {
        this.prohibited = prohibited;
        this.medicine = medicine;
    }

    public Prohibited getProhibited() {
        return prohibited;
    }

    public void setProhibited(Prohibited prohibited) {
        this.prohibited = prohibited;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryItemsPK that = (EntryItemsPK) o;
        return Objects.equals(prohibited, that.prohibited) && Objects.equals(medicine, that.medicine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prohibited, medicine);
    }
}
