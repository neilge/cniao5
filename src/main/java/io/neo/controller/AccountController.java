package io.neo.controller;

import io.neo.dao.AccountDao;
import io.neo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Neo
 * @since 10/10/2020-7:37 PM
 */
@RestController
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @GetMapping("/account/{id}")
    public Account findById(@PathVariable("id") long id) {
        return accountDao.findById(id);
    }

    @GetMapping("/account/reg/{mobi}")
    public Account findByMobi(@PathVariable("mobi") String mobi) {
        return accountDao.findByMobi(mobi);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        accountDao.createAccount(account);
        return account;
    }

    @PutMapping("/account")
    public Account updateAccount(@RequestBody Account account) {
        accountDao.updateAccount(account);
        return account;
    }
}
