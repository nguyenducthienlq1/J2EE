package com.NguyenDucThien.KiemTra.repositories;


import com.NguyenDucThien.KiemTra.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Lấy danh sách các học phần mà một sinh viên đã đăng ký
    List<Enrollment> findByStudentId(Long studentId);

    // Lấy danh sách các sinh viên đã đăng ký một học phần cụ thể
    List<Enrollment> findByCourseId(Long courseId);

    // Kiểm tra xem sinh viên này đã đăng ký khóa học này chưa (Tránh đăng ký trùng)
    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);
}