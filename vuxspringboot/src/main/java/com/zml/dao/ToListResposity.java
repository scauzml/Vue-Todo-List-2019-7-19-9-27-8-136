package com.zml.dao;

import com.zml.entity.ToListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToListResposity extends JpaRepository<ToListEntity,Integer> {
    ToListEntity findByTitle(String title);
}
