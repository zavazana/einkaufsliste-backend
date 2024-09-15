package de.supercode.einkaufsliste.controller;

import de.supercode.einkaufsliste.model.Item;
import de.supercode.einkaufsliste.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin // für das Frontend
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }


    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        System.out.println("Empfangener Artikel: " + item);

        // Log die einzelnen Felder
        System.out.println("Name: " + item.getItemName());
        System.out.println("Menge: " + item.getItemAnzahl());
        System.out.println("Laden: " + item.getLadenName());
        System.out.println("Gekauft: " + item.isGekauft());

        // Hier kannst du den Artikel in die Datenbank speichern
        itemService.saveItem(item);

        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTruck(@PathVariable long id){
        System.out.println("Id: " + id);
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
