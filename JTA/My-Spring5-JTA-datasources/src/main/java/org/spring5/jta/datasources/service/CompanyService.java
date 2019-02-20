/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spring5.jta.datasources.service;

import javax.transaction.Transactional;
import org.spring5.jta.datasources.model.Company;
import org.spring5.jta.datasources.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
//@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    
    public void save(Company company) {
        companyRepository.save(company);
    }
    
}
