package com.example.SistemaDeFarmacia.Servicies;

import com.example.SistemaDeFarmacia.DTO.AddressDTO;
import com.example.SistemaDeFarmacia.DTO.UserDTO;
import com.example.SistemaDeFarmacia.Servicies.exceptions.DataBaseException;
import com.example.SistemaDeFarmacia.Servicies.exceptions.ResourceNotFound;
import com.example.SistemaDeFarmacia.entities.Address;
import com.example.SistemaDeFarmacia.entities.User;
import com.example.SistemaDeFarmacia.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServicie {
    @Autowired
    private UserRepository userRepository;
    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable){
        Page<User> page = userRepository.findAll(pageable);
        return page.map(x->new UserDTO(x));
    }
    @Transactional(readOnly = true)
    public UserDTO findById (Long id){
        User dto = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Usuario nao encontrado"));
        return new UserDTO(dto);
    }
    @Transactional
    public UserDTO insert(UserDTO userDTO){
        User user = new User();
        entityToDto(user,userDTO);
        user = userRepository.save(user);
        return new UserDTO(user);
    }
    @Transactional
    public UserDTO update(Long id,UserDTO userDTO){
        try{
            User user = userRepository.getReferenceById(id);
            entityToDto(user,userDTO);
            user = userRepository.save(user);
            return new UserDTO(user);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFound("Usuario nao encontrado");
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFound("Usuario nao encontrado");
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("nao é possivel apagar o usuario, erro de integridade");
        }
    }

    public void entityToDto(User entity, UserDTO dto){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        for (AddressDTO addressDTO : dto.getAddresses()){
            Address address = new Address();
            address.setId(addressDTO.getId());
            entity.getAddresses().add(address);
        }
    }
}
