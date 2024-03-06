package com.project.Shorty.Repository;

import com.project.Shorty.Entity.URLMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface URLMappingRepository extends JpaRepository<URLMapping, Integer> {

    public URLMapping findAllByEmailId(String emailId);
    public URLMapping findAllByRequestedURL(String requestedURL);
    public URLMapping findAllByShortenedURL(String shortenedURL);
    public URLMapping findAllByCreatedAt(Timestamp timestamp);
    public URLMapping findAllByModifiedAt(Timestamp timestamp);
    public URLMapping findAllById(int Id);
    public URLMapping findAllByQRCodeURL(String qrCodeURL);

}
