package pl.grzegorz.projects.WEBDiabloPage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.grzegorz.projects.WEBDiabloPage.model.entity.Items;

import pl.grzegorz.projects.WEBDiabloPage.model.service.ItemsService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/Items")
@AllArgsConstructor
public class ItemsController {

    private final ItemsService itemsService;

    @PostMapping("/addItem")
    public ResponseEntity<Items> addItem(@RequestBody Items items) {
        itemsService.createItem(items);
        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<Items> deleteItemById(@PathVariable("id") Long id){
         itemsService.deleteItemById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Items> deleteAll(){
        itemsService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/OneItem")
    public String getItemsById(Long id){
        itemsService.findItemById(id);
        return "Item selected";
    }
    @GetMapping("/allItems")
    public ResponseEntity<List<Items>> getItems(){

        List<Items> items = itemsService.findAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
