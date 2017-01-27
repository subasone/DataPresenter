/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.dao.impl;

import com.leapfrog.datapresenter.dao.StudentPaymentDAO;
import com.leapfrog.datapresenter.entity.StudentPayment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subasone
 */
public class StudentPaymentDAOImpl implements StudentPaymentDAO {

    private List<StudentPayment> studentPaymentList = new ArrayList<>();
    
    @Override
    public List<StudentPayment> getAll() {
       return studentPaymentList;
    }

    @Override
    public boolean insert(StudentPayment sp) {
        return studentPaymentList.add(sp);
    }
    
}
