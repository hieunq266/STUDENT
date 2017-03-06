/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.StudentFacade;
import entities.Student;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author MINH QUAN
 */
@Named(value = "studentView")
@RequestScoped
public class StudentView {

    @EJB
    private StudentFacade studentFacade;
    private Student student;
    private Student detail;
    /**
     * Creates a new instance of StudentView
     */
    public StudentView() {
        this.student = new Student();
    }

    // Calls getMessage to retrieve the message
    public Student getStudent() {
       return student;
    }

    // Returns the total number of messages
    public int getNumberOfStudents(){
       return studentFacade.findAll().size();
    }
    
    public List<Student> getStudents(){
        return studentFacade.findAll();
    }
    // Saves the message and then returns the string "theend"
    public String createStudent(){
       this.studentFacade.create(student);
       return "index";
    }
    
    public Student getDetail(){
       return detail;
    }
    
    public Student getStudentDetail(int id){  
       detail = this.studentFacade.find(new Long(id));
       return detail;
    }
    
}
