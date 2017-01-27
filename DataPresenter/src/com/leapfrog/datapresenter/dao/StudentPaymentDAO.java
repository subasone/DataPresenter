/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.dao;

import com.leapfrog.datapresenter.entity.StudentPayment;
import java.util.List;

/**
 *
 * @author subasone
 */
public interface StudentPaymentDAO {
    List<StudentPayment> getAll();
    boolean insert(StudentPayment sp);
}
