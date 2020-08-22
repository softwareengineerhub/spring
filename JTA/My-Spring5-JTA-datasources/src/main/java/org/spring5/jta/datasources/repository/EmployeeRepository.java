/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spring5.jta.datasources.repository;

/**
 *
 * @author Denys.Prokopiuk
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.spring5.jta.datasources.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    @Qualifier("employeeDataSource")
    private DataSource dataSource;


    public void save(Employee employee) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO employeeA(name, age) VALUES(?, ?)");
            ps.setObject(1, employee.getName());
            ps.setObject(2, employee.getAge());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
