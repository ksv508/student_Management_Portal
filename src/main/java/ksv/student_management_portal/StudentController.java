package ksv.student_management_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo) {
        Student s = studentService.getStudent(admnNo);
        if (s == null) {
            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student) {
        String s = studentService.addStudent(student);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}/{message}")
    public String getStudentByPathVariable(@PathVariable("id") int admnNo, @PathVariable("message") String message) {
        return studentService.getStudentByPathVariable(admnNo, message);
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admnNo){
        return studentService.deleteStudent(admnNo);
    }
    @PutMapping("/update_course")
    public Student updateCourse(@RequestParam("id") int admnNo,@RequestParam("course") String newCourse){
        Student s = studentService.updateCourse(admnNo,newCourse);
        return s;
    }
    @GetMapping("/getTotalStudent")
    public int getTotalStudent(){
        return studentService.getTotalStudent();
    }
}