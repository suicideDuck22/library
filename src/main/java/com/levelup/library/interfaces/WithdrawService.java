package com.levelup.library.interfaces;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.entities.WithdrawEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WithdrawService {
    List<WithdrawEntity> getAll();

    WithdrawEntity find(Long id);

    void insert(WithdrawEntity newWithdraw);

    void returnBook(WithdrawEntity withdrawToReturn);
}
