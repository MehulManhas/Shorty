package com.project.Shorty.Repository;

import com.project.Shorty.Model.URLMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.sql.Time;
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
