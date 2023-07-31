package com.example.SistemaDeFarmacia.entities;

import com.example.SistemaDeFarmacia.entities.enums.FormOfPayment;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;
    private String numOrder;
    private Double value;
    private FormOfPayment formOfPayment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItems> orderItems = new HashSet<>();

    public Order(){}

    public Order(Long id, Instant date, String numOrder, Double value, FormOfPayment formOfPayment, User user) {
        this.id = id;
        this.date = date;
        this.numOrder = numOrder;
        this.value = value;
        this.formOfPayment = formOfPayment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(String numOrder) {
        this.numOrder = numOrder;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public FormOfPayment getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPayment formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItems> getOrderItems() {
        return orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
