package pl.grzegorz.projects.WEBDiabloPage.model.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.projects.WEBDiabloPage.model.entity.Statistics;
import pl.grzegorz.projects.WEBDiabloPage.model.repository.StatisticsRepo;

import java.util.List;

@Service
@Data
public class StatisticsService {

    @Autowired
    private StatisticsRepo statisticsRepo;

    public StatisticsService(StatisticsRepo statisticsRepo) {
        this.statisticsRepo = statisticsRepo;

    }

    public List<Statistics> getAllRunes(){
        return statisticsRepo.findAll();
    }

    private List<Statistics> stats;
    public Statistics addStat(Statistics stats){
        
        return statisticsRepo.save(stats);

    }
}
