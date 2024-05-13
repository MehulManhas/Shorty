package com.project.Shorty.Entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Blocked_URL")
public class BlockedURLEntity extends BaseEntity{
    private String url;
}
