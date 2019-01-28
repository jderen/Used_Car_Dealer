package com.app.models.dao;

import com.app.models.Account;
import com.app.models.Car;
import com.app.models.dao.generic.AbstractGenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsDaoImpl  extends AbstractGenericDao<Account> implements AccountsDao  {
}
