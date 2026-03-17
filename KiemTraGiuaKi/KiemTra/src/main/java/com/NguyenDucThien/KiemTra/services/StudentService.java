package com.NguyenDucThien.KiemTra.services;

import com.NguyenDucThien.KiemTra.domain.Role;
import com.NguyenDucThien.KiemTra.domain.Student;
import com.NguyenDucThien.KiemTra.repositories.CourseRepository;
import com.NguyenDucThien.KiemTra.repositories.RoleRepository;
import com.NguyenDucThien.KiemTra.repositories.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public StudentService(StudentRepository studentRepository,
                          RoleRepository roleRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.courseRepository = courseRepository;
    }
    public void registerStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));

        // Gán quyền mặc định là STUDENT
        Role userRole = roleRepository.findByName("STUDENT").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("STUDENT");
            return roleRepository.save(newRole);
        });

        student.setRoles(Collections.singleton(userRole));
        studentRepository.save(student);
    }

    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username).orElse(null);
    }
}
