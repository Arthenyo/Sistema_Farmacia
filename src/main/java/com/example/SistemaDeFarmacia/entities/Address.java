package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String neighborhood;
    private String cep;
    private String uf;
    private String city;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @MapsId
    private Supplier supplier;
    public Address(){}

    public Address(Long id, String street, String neighborhood, String cep, String uf, String city, User user, Supplier supplier) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.uf = uf;
        this.city = city;
        this.user = user;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
