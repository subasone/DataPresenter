/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.util;

import com.leapfrog.datapresenter.dao.CourseDAO;
import com.leapfrog.datapresenter.dao.StudentDAO;
import com.leapfrog.datapresenter.entity.Course;
import com.leapfrog.datapresenter.entity.Student;
import java.io.IOException;

/**
 *
 * @author subasone
 */
public class DataLoader {

    private CourseDAO courseDAO;
    private StudentDAO studentDAO;

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void loadCourse(String fileName) throws IOException {
        for (String s : FileHelper.readLines(fileName)) {
            String[] tokens = s.split(",");
            Course c = new Course();
            c.setId(Integer.parseInt(tokens[0]));
            c.setName(tokens[1]);
            c.setFees(Integer.parseInt(tokens[2]));
            courseDAO.insert(c);
        }
        
    }
    public void loadStudent(String fileName) throws IOException {
        for (String s : FileHelper.readLines(fileName)) {
            String[] tokens = s.split(",");
            Student std = new Student();
            std.setId(Integer.parseInt(tokens[0]));
            std.setFirstName(tokens[1]);
            std.setLastName(tokens[2]);
            std.setContactNo(tokens[3]);
            studentDAO.insert(std);
        }
    }
}

