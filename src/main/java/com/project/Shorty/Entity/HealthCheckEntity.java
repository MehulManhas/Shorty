package com.project.Shorty.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HealthCheckEntity {

    @Id
    private int result;
}
