package com.aliboo.security.repository;

import com.aliboo.security.repository.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByNombreUsuario(String name);
}