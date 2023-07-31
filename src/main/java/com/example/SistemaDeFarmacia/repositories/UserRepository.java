package com.example.SistemaDeFarmacia.repositories;

import com.example.SistemaDeFarmacia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
