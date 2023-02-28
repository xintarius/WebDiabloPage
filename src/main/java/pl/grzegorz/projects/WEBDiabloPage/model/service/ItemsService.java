package pl.grzegorz.projects.WEBDiabloPage.model.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Data;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.grzegorz.projects.WEBDiabloPage.model.entity.Items;
import pl.grzegorz.projects.WEBDiabloPage.model.entity.Statistics;
import pl.grzegorz.projects.WEBDiabloPage.model.exceptions.ItemNotFoundException;
import pl.grzegorz.projects.WEBDiabloPage.model.repository.ItemsRepo;
import pl.grzegorz.projects.WEBDiabloPage.model.repository.StatisticsRepo;

import java.util.List;
import java.util.UUID;

@Service
@Data
public class ItemsService {
    private final ItemsRepo itemsRepo;
    private final StatisticsRepo statsRepo;
    private List<Statistics> itemStats;

    @Autowired
    public ItemsService(ItemsRepo itemsRepo, StatisticsRepo statsRepo, List<Statistics> itemStats) {
        this.itemsRepo = itemsRepo;
        this.statsRepo = statsRepo;
        this.itemStats = itemStats;
    }

    public void createItem(Items items){
        items.setItemCode(UUID.randomUUID().toString());
        itemsRepo.save(items);
    }

    public String deleteItemById(Long id) {
        try {
            itemsRepo.deleteById(id);
        }catch (Exception e){
            return "Item was not found";
        }
        return "Deleted";
    }

    public String deleteAll(){
        try {
            itemsRepo.deleteAllData();
            return "All data has been deleted";
        }catch (Exception e) {
                return "No data";
        }
    }
    public Items findItemById(Long id) {
        return itemsRepo.findItemById(id).orElseThrow(() -> new ItemNotFoundException("Item by id" + " " + id + " " + "was not found"));
    }

    public List<Items> findAllItems() {
        return itemsRepo.findAll();
    }
}

