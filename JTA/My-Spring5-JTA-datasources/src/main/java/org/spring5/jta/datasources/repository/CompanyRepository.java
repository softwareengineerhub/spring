/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spring5.jta.datasources.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.spring5.jta.datasources.model.Company;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
@Transactional
public class CompanyRepository {

    @Resource(name = "companyDataSource")
    private DataSource dataSource;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void save(Company company) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO company(company_name) VALUES(?)");
            ps.setObject(1, company.getCompanyName());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
