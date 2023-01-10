package com.levelup.library.repositories;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.entities.WithdrawEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawRepository extends JpaRepository<WithdrawEntity, Long> {
    @Query(value = "SELECT * FROM withdrawal WHERE userId = :userId AND returnedDate IS NULL", nativeQuery = true)
    List<WithdrawEntity> getAllPendentWithdrawsByUserId(Long userId);

    @Query(value = "SELECT * FROM withdrawal WHERE userId = :userId AND returnedDate IS NOT NULL", nativeQuery = true)
    List<WithdrawEntity> getAllReturnedWithdrawsByUserId(Long userId);

    @Query(value = "SELECT * FROM withdrawal WHERE userId = :userId", nativeQuery = true)
    List<WithdrawEntity> getAllWithdrawsByUserId(Long userId);
}
