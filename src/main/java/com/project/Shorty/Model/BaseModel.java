package com.project.Shorty.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
