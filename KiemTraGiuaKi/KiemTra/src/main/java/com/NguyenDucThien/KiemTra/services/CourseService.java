package com.NguyenDucThien.KiemTra.services;

import com.NguyenDucThien.KiemTra.domain.Course;
import com.NguyenDucThien.KiemTra.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> searchCourses(String keyword) {
        return courseRepository.findByNameContainingIgnoreCase(keyword);
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
