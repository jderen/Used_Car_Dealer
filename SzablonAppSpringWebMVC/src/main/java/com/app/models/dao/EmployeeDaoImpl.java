package com.app.models.dao;

import com.app.models.Client;
import com.app.models.Employee;
import com.app.models.MarkModelCar;
import com.app.models.dao.generic.AbstractGenericDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl extends AbstractGenericDao<Employee> implements EmployeeDao{
    /*implementation of methods from EmployeeDao -> GenericDao
    * are in GenericAbstractDao*/

    private Class<Employee> eClass = (Class<Employee>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];

    @Override
    public Optional<Employee> findByUsernameAndPassword(String username, String password) {
        Optional<Employee> result = Optional.empty();
        if (username != null && password != null && getEntityManager() != null){
            Query query = getEntityManager().createQuery("SELECT e FROM" + geteClass() + " e JOIN Accounts a WHERE a.login = :username AND a.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);

            result = Optional.ofNullable((Employee) query.getSingleResult());
        }
        return result;
    }
}
