package io.neo.service.impl;

import io.neo.dao.AccountDao;
import io.neo.model.Account;
import io.neo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Neo
 * @since 10/13/2020-10:50 PM
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Account getAccountById(long id) {
        return accountDao.findById(id);
    }

    @Override
    public Account getAccountByMobi(String mobi) {
        return accountDao.findByMobi(mobi);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        accountDao.createAccount(account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        accountDao.updateAccount(account);
        return account;
    }
}
