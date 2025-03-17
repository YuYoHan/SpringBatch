package com.example.batch_sty.repository.mysql;

import com.example.batch_sty.entity.mysql.WinEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinRepository extends JpaRepository<WinEntity, Long> {
    Page<WinEntity> findByWinCountGreaterThanEqual(Long winCount, Pageable pageable);
}
