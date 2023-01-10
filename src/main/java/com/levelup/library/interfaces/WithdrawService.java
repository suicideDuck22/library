package com.levelup.library.interfaces;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.entities.WithdrawEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WithdrawService {
    List<WithdrawEntity> getAll();

    WithdrawEntity get(Long id);

    List<WithdrawEntity> getAllWithdrawsByUserId(Long id);

    List<WithdrawEntity> getAllPendentWithdrawsByUserId(Long user);

    List<WithdrawEntity> getAllReturnedWithdrawsByUserId(Long userId);

    void insert(WithdrawEntity newWithdraw);

    void returnBook(WithdrawEntity withdrawToReturn);
}
