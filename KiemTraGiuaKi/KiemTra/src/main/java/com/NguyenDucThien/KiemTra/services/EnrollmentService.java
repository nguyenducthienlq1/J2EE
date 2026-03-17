package com.NguyenDucThien.KiemTra.services;

import com.NguyenDucThien.KiemTra.domain.Course;
import com.NguyenDucThien.KiemTra.domain.Enrollment;
import com.NguyenDucThien.KiemTra.domain.Student;
import com.NguyenDucThien.KiemTra.repositories.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    public boolean enrollCourse(Student student, Course course) {
        if (enrollmentRepository.existsByStudentIdAndCourseId(student.getId(), course.getId())) {
            return false;
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollDate(LocalDate.now());

        enrollmentRepository.save(enrollment);
        return true;
    }

    // Câu 7: Lấy danh sách học phần đã đăng ký của sinh viên
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
}
