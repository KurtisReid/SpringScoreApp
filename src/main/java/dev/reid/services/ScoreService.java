package dev.reid.services;

import dev.reid.entities.Score;

import java.util.List;

public interface ScoreService {

    Score registerScore(Score score);//create

    Score getScoreById(int id);//read

    List<Score> getScoresByInitials(String initials);

    String deleteScore(int id);

    Score updateScore(Score score);

    List<Score> getListOfScores();






}
