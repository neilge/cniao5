package io.neo.dao;

import io.neo.model.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Neo
 * @since 10/10/2020-7:13 PM
 */
public interface AccountDao {

    Account get(@Param("id") long id);

    /**
     * 查询所有用户.
     */
    List<Account> findAll();

    /**
     * 根据id查询用户
     */
    Account findById(long id);

    /**
     * 根据mobi查询用户
     */
    Account findByMobi(String mobi);

    /**
     * 保存用户
     */
    void createAccount(Account account);

    /**
     * 更新用户
     */
    void updateAccount(Account account);

    /**
     * 删除用户
     */
    void deleteAccount(long id);
}
