package com.project.Shorty.Repository;

import com.project.Shorty.Entity.CustomURLMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomURLMappingRepository extends JpaRepository<CustomURLMappingEntity, Integer> {
    public boolean existsByCustomAlias(String customAlias);
    public CustomURLMappingEntity findCustomURLMappingEntitiesByCustomAlias(String customAlias);
}
