package com.fjmp.itess.jakartajpa.beans;

import com.fjmp.itess.jakartajpa.entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StudentBean implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Student> getStudents() {
        List<Student> studentList = null;
        try {
            // jpql                                                       
            Query query = entityManager.createQuery("SELECT s FROM Student s", 
                    Student.class);
            studentList = query.getResultList();
            
            System.out.println("studentList: " + "---------------------------------");
            for (Student st : studentList) {
               System.out.println(st); 
            }
            
            
        } catch (Exception e) {
            
        }
        return studentList;
    }
}
