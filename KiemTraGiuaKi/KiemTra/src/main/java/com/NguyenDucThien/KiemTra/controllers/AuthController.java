package com.NguyenDucThien.KiemTra.controllers;



import com.NguyenDucThien.KiemTra.domain.Student;
import com.NguyenDucThien.KiemTra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về trang login.html
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register/save")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentService.registerStudent(student);
        return "redirect:/login?success";
    }
}