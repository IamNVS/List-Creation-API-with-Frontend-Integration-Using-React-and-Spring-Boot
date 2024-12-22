package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entiy.ListContainer;
import Entiy.ListItem;
import Service.ListService;

@RestController
@RequestMapping("/api")
public class ListController {

    private final ListService listService;

    @Autowired
    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping("/lists")
    public ResponseEntity<ListContainer> createListContainer(@RequestBody ListContainer listContainer) {
        
        ListContainer savedListContainer = listService.saveListContainer(listContainer);
        return new ResponseEntity<>(savedListContainer, HttpStatus.CREATED);
    }
    
    
    
    @GetMapping("/lists")
    public ResponseEntity<List<ListContainer>> getAllLists() {
        List<ListContainer> lists = listService.getAllLists();
        return ResponseEntity.ok(lists);
    }

    
    @PutMapping("/lists")
    public ResponseEntity<String> updateLists(@RequestBody List<ListContainer> updatedLists) {
        listService.updateLists(updatedLists);
        return ResponseEntity.ok("Lists updated successfully");
    }

    
    @GetMapping("/items/{id}")
    public ResponseEntity<ListItem> getListItemById(@PathVariable int id) {
        Optional<ListItem> item = listService.getListItemById(id);
        return item.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping("/items")
    public ResponseEntity<ListItem> saveListItem(@RequestBody ListItem listItem) {
        ListItem savedItem = listService.saveListItem(listItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    
    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteListItem(@PathVariable int id) {
        listService.deleteListItemById(id);
        return ResponseEntity.ok("Item deleted successfully");
    }
}
