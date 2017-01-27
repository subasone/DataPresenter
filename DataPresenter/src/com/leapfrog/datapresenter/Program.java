/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter;

import com.leapfrog.datapresenter.dao.CourseDAO;
import com.leapfrog.datapresenter.dao.StudentDAO;
import com.leapfrog.datapresenter.dao.StudentPaymentDAO;
import com.leapfrog.datapresenter.dao.impl.CourseDAOImpl;
import com.leapfrog.datapresenter.dao.impl.StudentDAOImpl;
import com.leapfrog.datapresenter.dao.impl.StudentPaymentDAOImpl;
import com.leapfrog.datapresenter.entity.Course;
import com.leapfrog.datapresenter.entity.Student;
import com.leapfrog.datapresenter.entity.StudentPayment;
import static com.leapfrog.datapresenter.system.config.VAT_PERCENT;
import com.leapfrog.datapresenter.util.DataLoader;
import com.leapfrog.datapresenter.util.FileHelper;

import java.io.IOException;

/**
 *
 * @author subasone
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String courseFile = "/home/subasone/Desktop/helloWorld/class3/course.csv";
        String studentFile = "/home/subasone/Desktop/helloWorld/class3/student.csv";
         String paymentFile = "/home/subasone/Desktop/helloWorld/class3/payment.csv";
        CourseDAO courseDAO = new CourseDAOImpl();
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentPaymentDAO paymentDAO = new StudentPaymentDAOImpl();
        DataLoader loader = new DataLoader();
        
        try{
             loader.setCourseDAO(courseDAO);
             loader.loadCourse(courseFile);
             
             loader.setStudentDAO(studentDAO);
             loader.loadStudent(studentFile);
             
              for(String s : FileHelper.readLines(paymentFile)){
                String[] tokens = s.split(",");
                if(tokens.length > 2){
                    int sId = Integer.parseInt(tokens[0]);
                    Student student = studentDAO.getById(sId);
                    if(student != null){
                         int cId = Integer.parseInt(tokens[1]);
                         Course course = courseDAO.getById(cId);
                         if(course != null){
                             StudentPayment spp = new StudentPayment();
                             spp.setStudent(student);
                             spp.setCourse(course);
                             spp.setAmount(Integer.parseInt(tokens[2]));
                             paymentDAO.insert(spp);
                         }
                    }
                }
            }
              for(StudentPayment sp : paymentDAO.getAll()){
                  int remaining = sp.getCourse().getFees() - sp.getAmount();
                  double vat = (sp.getAmount() * VAT_PERCENT)/100.0;
                  String line = sp.getStudent().getFirstName() + 
                                " " + sp.getStudent().getLastName() + 
                                " " + sp.getCourse().getName() +
                                " " + sp.getCourse().getFees() + 
                                " " + sp.getAmount() + 
                                " " + remaining + 
                                " " + vat;
                  
                  System.out.println(line);
              }
            
           }catch(IOException ioe){
            System.out.println(ioe.getMessage());
           }
    }
    
}
