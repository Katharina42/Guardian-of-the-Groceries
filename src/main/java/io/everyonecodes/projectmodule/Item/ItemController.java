package io.everyonecodes.projectmodule.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    List<Item> findAll() {
        return itemService.findAll();
    }

    @DeleteMapping("/items/delete/{id}")
    void deleteOneItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @PostMapping("/items")
    Item createNewItem(@RequestBody Item item) {
        return itemService.crateNew(item);
    }

    @PatchMapping("items/patch/{id}")
    Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find Item"));
    }

    @GetMapping("/storage_location/ordered/{id}")
    public List<ItemDTO> showAllItemsOrdered(@PathVariable Long id) {
        return itemService.findOrderedList(id);
    }
}
