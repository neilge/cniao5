package io.neo.dao;

import io.neo.model.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Neo
 * @since 10/10/2020-7:13 PM
 */
public interface AccountDao {

    /**
     * 查询所有用户.
     */
    List<Account> findAll();

    /**
     * 根据id查询用户
     */
    Account findById(long id);

    /**
     * 根据email查询用户
     */
    Account findByMobi(String email);

    /**
     * 保存用户
     */
    void createAccount(Account account);

    /**
     * 更新用户
     */
    void updateAccount(Account account);
}
