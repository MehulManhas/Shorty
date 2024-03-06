package com.project.Shorty.Repository;

import com.project.Shorty.Entity.HealthCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCheckRepository extends JpaRepository<HealthCheckEntity,Long> {

    @Query(value = "SELECT 1+1 as result",nativeQuery = true)
    public  int FetchHealthStatus();
}
