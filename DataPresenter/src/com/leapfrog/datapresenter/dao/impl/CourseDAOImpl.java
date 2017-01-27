/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.dao.impl;

import com.leapfrog.datapresenter.dao.CourseDAO;
import com.leapfrog.datapresenter.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subasone
 */
public class CourseDAOImpl implements CourseDAO {
          
       private List<Course> courseList = new ArrayList<>();
    
    @Override
    public List<Course> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return courseList;
    }

    @Override
    public Course getById(int id) {
       for(Course c : courseList){
           if(c.getId() == id){
               return c;
           }
       }
       return null;
    }

    @Override
    public boolean insert(Course c) {
        return courseList.add(c);
    }
    
}
