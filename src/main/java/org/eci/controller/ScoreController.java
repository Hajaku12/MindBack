package org.eci.controller;

import org.eci.Score;
import org.eci.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @PostMapping
    public Score saveOrUpdateScore(@RequestBody Score score) {
        return scoreService.saveOrUpdateScore(score);
    }
}