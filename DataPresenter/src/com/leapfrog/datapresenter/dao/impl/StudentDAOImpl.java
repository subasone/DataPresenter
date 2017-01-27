/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.dao.impl;

import com.leapfrog.datapresenter.dao.StudentDAO;
import com.leapfrog.datapresenter.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subasone
 */
public class StudentDAOImpl implements StudentDAO {

        private List<Student> studentList = new ArrayList<>();
    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public Student getById(int id) {
        for(Student s : studentList){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean insert(Student s) {
       return studentList.add(s);
    }
    
}
