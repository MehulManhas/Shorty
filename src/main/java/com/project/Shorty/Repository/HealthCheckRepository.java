package com.project.Shorty.Repository;

import com.project.Shorty.Model.HealthCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface healtCheckRepository  extends JpaRepository<HealthCheckEntity,Integer> {
}
