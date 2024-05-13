package com.project.Shorty.Repository;

import com.project.Shorty.Entity.BlockedURLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedURLRepository extends JpaRepository<BlockedURLEntity, Integer> {
    public boolean existsByUrlLike(final String url);
    public BlockedURLEntity findByUrlLike(final String url);
}
