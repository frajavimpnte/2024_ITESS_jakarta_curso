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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
    public List<Student> getStudentList() {
        return this.studentList;
    }
    
    public String  saveStudent() {
        try {
            studentBean.saveStudent(student);
        } catch (Exception e){
            return "error";
        }
        return getStudents();
    }
    
    public String getStudents() {
        studentList = studentBean.getStudents();
        
        return "information";
    }
    
}
