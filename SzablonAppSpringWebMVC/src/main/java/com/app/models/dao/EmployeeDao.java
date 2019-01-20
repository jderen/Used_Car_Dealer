package com.app.models.dao;

import com.app.models.Client;
import com.app.models.Employee;
import com.app.models.dao.generic.GenericDao;

import java.util.Optional;

public interface EmployeeDao extends GenericDao<Employee> {
    /*methods are in generic dao
    * here are only specific to employee methods*/
    public Optional<Employee> findByUsernameAndPassword(String username, String password);
}
