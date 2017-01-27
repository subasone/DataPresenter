/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.dao;

import com.leapfrog.datapresenter.entity.Course;
import java.util.List;

/**
 *
 * @author subasone
 */
public interface CourseDAO {
    List<Course> getAll();
    Course getById(int id);
    boolean insert(Course c);
}
