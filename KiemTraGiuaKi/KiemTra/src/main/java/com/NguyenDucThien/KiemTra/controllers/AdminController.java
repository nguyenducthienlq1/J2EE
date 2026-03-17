package com.NguyenDucThien.KiemTra.controllers;

import com.NguyenDucThien.KiemTra.domain.Course;
import com.NguyenDucThien.KiemTra.repositories.CategoryRepository;
import com.NguyenDucThien.KiemTra.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/admin/courses")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "admin/course_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/course_form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/course_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/admin/courses";
    }
}
