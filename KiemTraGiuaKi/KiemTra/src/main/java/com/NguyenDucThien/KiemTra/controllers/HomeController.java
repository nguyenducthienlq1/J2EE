package com.NguyenDucThien.KiemTra.controllers;

import com.NguyenDucThien.KiemTra.domain.Course;
import com.NguyenDucThien.KiemTra.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final CourseService courseService;
    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = {"/", "/home", "/courses"})
    public String viewHomePage(Model model,
                               @RequestParam(value = "keyword", required = false) String keyword) {

        if (keyword != null && !keyword.isEmpty()) {
            // Câu 8: Tìm kiếm
            List<Course> listCourses = courseService.searchCourses(keyword);
            model.addAttribute("listCourses", listCourses);
            model.addAttribute("keyword", keyword);
        } else {
            List<Course> listCourses = courseService.getAllCourses();
            model.addAttribute("listCourses", listCourses);
        }

        return "index"; // Trả về trang index.html
    }
}
