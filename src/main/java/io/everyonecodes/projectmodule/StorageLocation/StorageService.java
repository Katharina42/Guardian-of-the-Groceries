package io.everyonecodes.projectmodule.StorageLocation;

import io.everyonecodes.projectmodule.Item.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StorageService {
    private final StorageRepository storageRepository;

    public List<Item> findAllItems(Long id) {
        return storageRepository.findById(id).get().getItems();
    }

    public List<StorageLocation> findAll() {
        return storageRepository.findAll();
    }

    public List<StorageLocation> findAllSortedByLocationName() {
        return storageRepository.findAllByOrderByLocationName();
    }

    public void deleteStorageLocation(Long id) {
        storageRepository.deleteById(id);
    }

    public Optional<StorageLocation> updateStorageLocation(Long id, StorageLocation storageLocation) {
        return storageRepository
                .findById(id)
                .map(e -> {
                    if (storageLocation.getLocationName() != null) {
                        e.setLocationName(storageLocation.getLocationName());
                    }
                    return storageRepository.save(e);
                });
    }

    public StorageLocation createNew(StorageLocation storageLocation) {
        return storageRepository.save(storageLocation);
    }
}
