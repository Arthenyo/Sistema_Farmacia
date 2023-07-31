package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "tb_medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate expirationDate;
    private Integer quantity;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToMany
    @JoinTable(name = "tb_medicine_category",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
    @OneToMany(mappedBy = "id.medicine")
    private Set<EntryItems> entryItems = new HashSet<>();
    @OneToMany(mappedBy = "id.medicine")
    private Set<OrderItems> orderItems = new HashSet<>();
    public Medicine() {
    }
    public Medicine(Long id, String name, LocalDate expirationDate, Integer quantity, Double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<EntryItems> getEntryItems() {
        return entryItems;
    }

    public Set<OrderItems> getOrderItems() {
        return orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
