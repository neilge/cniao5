package io.neo.controller;

import io.neo.model.Account;
import io.neo.service.AccountService;
import io.neo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanInfo;
import java.util.List;

/**
 * @author Neo
 * @since 10/10/2020-7:37 PM
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.getAllAccount();
    }

    @GetMapping("/account/{id}")
    public Account findById(@PathVariable("id") long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/account/reg/{mobi}")
    public Account findByMobi(@PathVariable("mobi") String mobi) {
        return accountService.getAccountByMobi(mobi);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return account;
    }

    @PutMapping("/account")
    public Account updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return account;
    }

    @PostMapping("/login")
    public String getJwtToken(@RequestBody Account account) {
        Account storageAccount = accountService.getAccountByMobi(account.getMobi());
        if (storageAccount.getPassword().equals(account.getPassword())) {
            return jwtUtil.generateToken(account.getMobi());
        }
        throw new RuntimeException("mobi or password does not match");
    }
}
