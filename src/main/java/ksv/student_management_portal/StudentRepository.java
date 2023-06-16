package ksv.student_management_portal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> studentsDb = new HashMap<>(); // db - key - admnNo

    public Student getStudent(int admnNo){
        return studentsDb.get(admnNo);
    }

    public String addStudent(Student student){

        if(studentsDb.containsKey(student.getAdmnNo())){
            return "Student already present";
        }

        studentsDb.put(student.getAdmnNo(),student);
        return "Student added successfully";
    }

    public Student getStudentByPathVariable(int admnNo) {

        return studentsDb.get(admnNo);
    }
    public String deleteStudent(int admnNo){
        studentsDb.remove(admnNo);
        return "Student deleted Successfully";
    }
    public Student updateCourse(int admnNo, String newCourse){
        if(!studentsDb.containsKey(admnNo)){
            throw new RuntimeException("Student doesn't exist");
        }
        Student student = studentsDb.get(admnNo);
        student.setCourse(newCourse);
        return student;
    }
    public int getTotalStudent(){
        int total = 0;
        for(int admnNo: studentsDb.keySet()){
            if(studentsDb.get(admnNo).getAge() >= 25)
                total++;
        }
        return total;
    }
}
