package com.NguyenDucThien.KiemTra.repositories;


import com.NguyenDucThien.KiemTra.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}