package com.app.models.dao;

import com.app.models.Transaction;
import com.app.models.dao.generic.AbstractGenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl extends AbstractGenericDao<Transaction> implements TransactionDao {
}
