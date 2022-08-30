package dev.reid.services;

import dev.reid.entities.Score;
import dev.reid.repos.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreRepo scoreRepo;


    @Override
    public Score registerScore(Score score) {
        Score savedScore = this.scoreRepo.save(score);
        return savedScore;
    }

    @Override
    public Score getScoreById(int id) {
        Optional<Score> possibleScore = this.scoreRepo.findById(id);
        if (possibleScore.isPresent())
        {
            return possibleScore.get();
        }
        else
        {
            throw new RuntimeException("no score found");
        }

    }

    @Override
    public List<Score> getScoresByInitials(String initials) {

        return this.scoreRepo.findScoresByInitials(initials);
    }

    @Override
    public String deleteScore(int id) {
        Score score = this.getScoreById(id);
        this.scoreRepo.delete(score);
        return "deleted";
    }

    @Override
    public Score updateScore(Score score) {

        return this.scoreRepo.save(score);
    }

    @Override
    public List<Score> getListOfScores() {
        // sort by score
        List<Score> scoreList = this.scoreRepo.findAllScoresByPoints();



        return scoreList;
    }
}
