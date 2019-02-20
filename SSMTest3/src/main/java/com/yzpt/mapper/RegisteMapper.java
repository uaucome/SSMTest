package com.yzpt.mapper;

import com.yzpt.entity.Account;
import com.yzpt.entity.User;

/**
 * Description:注册持久层
 *
 * @author yzp
 *
 * @date 2019年2月19日
 *
 */
public interface RegisteMapper {

	int addUser(User user);

	int addAccount(Account accountinfo);

}
