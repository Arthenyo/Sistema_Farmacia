package com.example.SistemaDeFarmacia.DTO;

import com.example.SistemaDeFarmacia.entities.Address;
import com.example.SistemaDeFarmacia.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private List<AddressDTO> addresses = new ArrayList<>();

    public UserDTO(Long id, String name, String cpf, String email, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        email = entity.getEmail();
        phone = entity.getPhone();
        for (Address dto : entity.getAddresses()){
            addresses.add(new AddressDTO(dto));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }
}
