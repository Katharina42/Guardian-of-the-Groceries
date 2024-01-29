package io.everyonecodes.projectmodule.StorageLocation;

import io.everyonecodes.projectmodule.Item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping("/storage_location")
    List<StorageLocation> findAll() {
        return storageService.findAll();
    }

    @DeleteMapping("/storage_location/delete/{id}")
    void deleteStorageLocation(@PathVariable Long id) {
        storageService.deleteStorageLocation(id);
    }

    @PostMapping("/storage_location/create")
    StorageLocation createNewStorageLocation(@RequestBody StorageLocation storageLocation) {
        return storageService.createNew(storageLocation);
    }

    @PatchMapping("/storage_location/patch/{id}")
    StorageLocation updateStorageLocation(@PathVariable Long id, @RequestBody StorageLocation storageLocation) {
        return storageService.updateStorageLocation(id, storageLocation).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find Storage Location"));
    }

    @GetMapping("/storage_location/{id}")
    List<Item> showAllItems(@PathVariable Long id) {
        return storageService.findAllItems(id);
    }

}
