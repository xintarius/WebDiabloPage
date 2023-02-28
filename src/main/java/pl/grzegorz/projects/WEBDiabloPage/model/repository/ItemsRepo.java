package pl.grzegorz.projects.WEBDiabloPage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.grzegorz.projects.WEBDiabloPage.model.entity.Items;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Long> {

    @Modifying
    @Query(
            value = "TRUNCATE TABLE items Restart IDENTITY;",
            nativeQuery = true
    )
    void deleteAllData();
    Optional<Items> findItemById(Long id);
}
