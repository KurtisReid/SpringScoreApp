package dev.reid.controllers;

import dev.reid.entities.Score;
import dev.reid.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/scores")
    @ResponseBody
    public List<Score> getAllScores()
    {
        return this.getAllScores();
    }



    @GetMapping("/scores/{initials}")
    @ResponseBody
    public List<Score> getScoresByInitials(String initials)
    {
        return scoreService.getScoresByInitials(initials);
    }


    @GetMapping("/scores/{id}")
    @ResponseBody
    public Score getScoreById(@PathVariable String id)
    {
        int scoreId = Integer.parseInt(id);
        return scoreService.getScoreById(scoreId);
    }

    @PostMapping("/scores")
    @ResponseBody
    public ResponseEntity<Score> createScore(@RequestBody Score score)
    {
        score.setInitials(score.getInitials().toUpperCase());
        if (score.getInitials().length() > 3)
        {
            String inital = score.getInitials().substring(0, 3);
            score.setInitials(inital);
        }
        if (score.getPoints() < 0)
        {
            // return 422
            return new ResponseEntity<Score>(score, HttpStatus.BAD_REQUEST);
        }

        Score savedScore = this.scoreService.registerScore(score);
        return new ResponseEntity<Score>(savedScore, HttpStatus.CREATED);

    }

}
