
package com.itess.jakartahello.beans;

import com.itess.jakartahello.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class StudentBean {
    @PersistenceContext
    private EntityManager entityManager;
    
    public void saveStudent(Student student) {        
        if (student.getStudentId() == null) {
            saveNewStudent(student);
        } else {
            updateStudent(student);
        }      
    }

    private void saveNewStudent(Student student) {
        entityManager.persist(student);
    }

    private void updateStudent(Student student) {
        entityManager.merge(student);
    }
    
    public Student getStudent(Long studentId) {
        Student student;

        student = entityManager.find(Student.class, studentId);

        return student;
    }
            
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }
    
    public List<Student> getStudents() {
        List<Student> studentList = null;
        
        try {
            // jpql                                                      
            Query query = entityManager.createQuery("SELECT s FROM Student s", 
                    Student.class);
            studentList = query.getResultList();

        } catch (Exception e) {
            
        }
        return studentList;
    }
}
