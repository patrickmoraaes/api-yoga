package com.api.yoga.repositories;

import com.api.yoga.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {

        boolean existsByEmail(String email);

    Optional<UsersModel> findByEmail(String email);
}
