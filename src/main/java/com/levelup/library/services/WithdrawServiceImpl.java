package com.levelup.library.services;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.entities.WithdrawEntity;
import com.levelup.library.interfaces.WithdrawService;
import com.levelup.library.repositories.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private WithdrawRepository withdrawRepository;

    public List<WithdrawEntity> getWithdrawsByUser(Long userId, String status){
        if(StringUtils.isEmpty(status)){
            return withdrawRepository.getAllWithdrawsByUserId(userId);
        }

        switch (status){
            case "PENDENT":
                return withdrawRepository.getAllPendentWithdrawsByUserId(userId);
            case "RETURNED":
                return withdrawRepository.getAllReturnedWithdrawsByUserId(userId);
            default:
                throw new InvalidParameterException("Parameter " + status + " is not valid.");
        }
    }
    @Override
    public List<WithdrawEntity> getAll() {
        return withdrawRepository.findAll();
    }

    @Override
    public WithdrawEntity get(Long id) {
        Optional<WithdrawEntity> withdraw = Optional.ofNullable(withdrawRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("Couldn't found this withdraw.");
        }));
        return withdraw.get();
    }

    @Override
    public List<WithdrawEntity> getAllWithdrawsByUserId(Long id) {
        return null;
    }

    @Override
    public List<WithdrawEntity> getAllPendentWithdrawsByUserId(Long user) {
        return withdrawRepository.getAllPendentWithdrawsByUserId(user);
    }

    @Override
    public List<WithdrawEntity> getAllReturnedWithdrawsByUserId(Long userId) {
        return null;
    }

    @Override
    public void insert(WithdrawEntity newWithdraw) {

    }

    @Override
    public void returnBook(WithdrawEntity withdrawToReturn) {

    }
}
