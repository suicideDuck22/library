package com.levelup.library.services;

import com.levelup.library.entities.WithdrawEntity;
import com.levelup.library.interfaces.WithdrawService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawServiceImpl implements WithdrawService {


    @Override
    public List<WithdrawEntity> getAll() {
        return null;
    }

    @Override
    public WithdrawEntity get(Long id) {
        return null;
    }

    @Override
    public void insert(WithdrawEntity newWithdraw) {

    }

    @Override
    public void returnBook(WithdrawEntity withdrawToReturn) {

    }
}
