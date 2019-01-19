package com.app.models.dao;

import com.app.models.Employee;
import com.app.models.dao.generic.AbstractGenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractGenericDao<Employee> implements EmployeeDao{
    /*implementation of methods from EmployeeDao -> GenericDao
    * are in GenericAbstractDao*/
}
