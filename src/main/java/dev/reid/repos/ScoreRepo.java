package dev.reid.repos;

import dev.reid.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Integer> {

    List<Score> findScoresByInitials(String initials);
    List<Score> findAllScoresByPoints();


}
