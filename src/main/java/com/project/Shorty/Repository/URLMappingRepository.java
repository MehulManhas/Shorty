package com.project.Shorty.Repository;

import com.project.Shorty.Entity.URLMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface URLMappingRepository extends JpaRepository<URLMappingEntity, Integer> {

    public URLMappingEntity findAllByEmailId(String emailId);
    public URLMappingEntity findAllByRequestedURL(String requestedURL);
    public Optional<URLMappingEntity> findAllByShortenedURL(String shortenedURL);
    public URLMappingEntity findAllByCreatedAt(Timestamp timestamp);
    public URLMappingEntity findAllByModifiedAt(Timestamp timestamp);
    public URLMappingEntity findAllById(int Id);
    public URLMappingEntity findAllByQRCodeURL(String qrCodeURL);
    public boolean existsByShortenedURL(String shortenedURL);
}
