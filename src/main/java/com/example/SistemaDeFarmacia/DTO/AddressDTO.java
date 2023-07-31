package com.example.SistemaDeFarmacia.DTO;

import com.example.SistemaDeFarmacia.entities.Address;

public class AddressDTO {
    private Long id;
    private String street;
    private String neighborhood;
    private String cep;
    private String uf;
    private String city;

    public AddressDTO(Long id, String street, String neighborhood, String cep, String uf, String city) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.uf = uf;
        this.city = city;
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        street = entity.getStreet();
        neighborhood = entity.getNeighborhood();
        cep = entity.getCep();
        uf = entity.getUf();
        city = entity.getCity();
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }

    public String getCity() {
        return city;
    }
}
