package com.project.Shorty.Repository;

import com.project.Shorty.Entity.URLMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface URLMappingRepository extends JpaRepository<URLMappingEntity, Integer> {

    public URLMappingEntity findAllByEmailId(String emailId);
    public URLMappingEntity findAllByRequestedURL(String requestedURL);
    public URLMappingEntity findAllByShortenedURL(String shortenedURL);
    public URLMappingEntity findAllByCreatedAt(Timestamp timestamp);
    public URLMappingEntity findAllByModifiedAt(Timestamp timestamp);
    public URLMappingEntity findAllById(int Id);
    public URLMappingEntity findAllByQRCodeURL(String qrCodeURL);

}
