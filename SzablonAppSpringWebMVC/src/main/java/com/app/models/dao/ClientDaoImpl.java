package com.app.models.dao;

import com.app.models.Client;
import com.app.models.MarkModelCar;
import com.app.models.dao.generic.AbstractGenericDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Repository
public class ClientDaoImpl extends AbstractGenericDao<Client> implements ClientDao {


}
