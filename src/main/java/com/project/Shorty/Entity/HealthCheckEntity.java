package com.project.Shorty.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HealthCheckEntity {

    @Id
    private Long id;

    private int result;
}
