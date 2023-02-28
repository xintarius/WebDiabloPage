package pl.grzegorz.projects.WEBDiabloPage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.grzegorz.projects.WEBDiabloPage.model.entity.Statistics;

@Repository
public interface StatisticsRepo extends JpaRepository<Statistics, Integer> {
    @Modifying
    @Query(
            value = "truncate table statistics;",
            nativeQuery = true
    )
    void deleteAllStatistics();

}
