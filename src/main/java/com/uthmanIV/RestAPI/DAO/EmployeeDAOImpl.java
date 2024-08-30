package com.uthmanIV.RestAPI.DAO;

import com.uthmanIV.RestAPI.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findALl() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        TypedQuery<Employee> query =
                entityManager.createQuery("From Employee WHERE id:employeeId", Employee.class);
        query.setParameter("employeeId",id);
        return query.getSingleResult();
    }

    @Override
    public void addEmployee(Employee e) {
        entityManager.persist(e);
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void delete() {

    }
}
