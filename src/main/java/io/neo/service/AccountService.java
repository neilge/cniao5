package io.neo.service;


import io.neo.model.Account;

import java.util.List;

/**
 * @author Neo
 * @since 10/13/2020-10:44 PM
 */
public interface AccountService {

    Account getAccountById(long id);

    Account getAccountByMobi(String mobi);

    List<Account> getAllAccount();

    Account createAccount(Account account);

    Account updateAccount(Account account);
}
