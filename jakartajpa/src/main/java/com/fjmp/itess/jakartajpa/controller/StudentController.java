package com.fjmp.itess.jakartajpa.controller;

import com.fjmp.itess.jakartajpa.beans.StudentBean;
import com.fjmp.itess.jakartajpa.entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class StudentController implements Serializable {
    @Inject
    private Student student;
    
    @EJB
    private StudentBean studentBean;
    
    private List<Student> studentList;
    
    public List<Student> getStudentList() {
        return this.studentList;
    }
    public String getStudents() {
        studentList = studentBean.getStudents();
        
        return "information";
    }
    
}
