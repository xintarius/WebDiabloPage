package pl.grzegorz.projects.WEBDiabloPage.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.projects.WEBDiabloPage.model.entity.Statistics;
import pl.grzegorz.projects.WEBDiabloPage.model.service.StatisticsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/stats")
public class StatisticsController {

    private final StatisticsService statsService;


    @PostMapping("/addStatistics")
    public String createStatistics(@RequestBody Statistics stats) {
        statsService.addStat(stats);
        return "statistics data has been added!";
    }
    @GetMapping("/getAllStats")
    public List<Statistics> getAllRunes(){
        return statsService.getAllRunes();
    }
}
