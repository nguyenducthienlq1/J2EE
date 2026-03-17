package com.NguyenDucThien.KiemTra.controllers;

import com.NguyenDucThien.KiemTra.domain.Course;
import com.NguyenDucThien.KiemTra.domain.Enrollment;
import com.NguyenDucThien.KiemTra.domain.Student;
import com.NguyenDucThien.KiemTra.services.CourseService;
import com.NguyenDucThien.KiemTra.services.EnrollmentService;
import com.NguyenDucThien.KiemTra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enroll/{id}")
    public String enrollCourse(@PathVariable("id") Long courseId, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        String username = principal.getName();
        Student student = studentService.findByUsername(username);
        Course course = courseService.getCourseById(courseId);

        if (student != null && course != null) {
            enrollmentService.enrollCourse(student, course);
        }

        return "redirect:/my-courses";
    }

    @GetMapping("/my-courses")
    public String viewMyCourses(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        String username = principal.getName();
        Student student = studentService.findByUsername(username);

        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(student.getId());
        model.addAttribute("enrollments", enrollments);

        return "my_courses"; // Trả về trang my_courses.html
    }
}