package com.app.models.dao;

import com.app.models.Client;
import com.app.models.dao.generic.AbstractGenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends AbstractGenericDao<Client> implements ClientDao {
}
