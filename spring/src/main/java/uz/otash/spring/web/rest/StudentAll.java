package uz.otash.spring.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.otash.spring.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentAll {

//    @GetMapping("/students")
//    public String hello(){
//        return "Hello word";
//    }

//    @RequestMapping(value = "/students",method = RequestMethod.GET)
//    public String hello(){
//        return "Hello word";
//    }

    @GetMapping("/studentGet")
    public ResponseEntity getAll(){
        Student student1 = new Student(1L,"Otabek", "Kenjayev","3-kurs");
        Student student2 = new Student(2L,"Sardor", "Nortojiyev","3-kurs");
        Student student3 = new Student(3L,"Zuhriddin", "Obidov","3-kurs");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable long id){
        Student student = new Student(id,"Zuhriddin", "Obidov","3-kurs");
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students")
    public ResponseEntity creat(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getStudents(@RequestParam Long id,
                                      @RequestParam String name,
                                      @RequestParam String lastName,
                                      @RequestParam String course){
        Student student = new Student(id,name,lastName,course);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Ma'lumot o'chirildi");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Student studentNew){
        Student student = new Student(4L,"Ulug'bek", "Shamuratov","1-kurs");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastname(studentNew.getLastname());
        student.setCourse(studentNew.getCourse());

        return ResponseEntity.ok(student);
    }
}
