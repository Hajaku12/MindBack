package org.eci.service;

import org.eci.Score;
import org.eci.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Score saveOrUpdateScore(Score score) {
        Score existingScore = scoreRepository.findByPlayerName(score.getPlayerName());
        if (existingScore != null) {
            existingScore.setScore(existingScore.getScore() + score.getScore());
            return scoreRepository.save(existingScore);
        } else {
            return scoreRepository.save(score);
        }
    }
}