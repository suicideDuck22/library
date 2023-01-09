package com.levelup.library.repositories;

import com.levelup.library.entities.WithdrawEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawRepository extends JpaRepository<WithdrawEntity, Long> {
}
