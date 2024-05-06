package com.project.Shorty.Repository;

import com.project.Shorty.Entity.QRCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeMappingRepository extends JpaRepository<QRCodeEntity, Integer> {
    public QRCodeEntity findByShortURL(String shortURL);
}
