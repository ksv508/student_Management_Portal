package ksv.student_management_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int admnNo){
        return studentRepository.getStudent(admnNo);
    }

    public String addStudent(Student student) {

        return studentRepository.addStudent(student);
    }

    public String getStudentByPathVariable(int admnNo, String message) {

        Student s = studentRepository.getStudentByPathVariable(admnNo);
        return s + message;
    }
    public String deleteStudent(int admnNo){
        String s = studentRepository.deleteStudent(admnNo);
        return s;
    }
    public Student updateCourse(int admnNo, String newCourse){
        Student s = studentRepository.updateCourse(admnNo,newCourse);
        return s;
    }
    public int getTotalStudent(){
        return studentRepository.getTotalStudent();
    }
}