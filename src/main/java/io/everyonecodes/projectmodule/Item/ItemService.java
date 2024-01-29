package io.everyonecodes.projectmodule.Item;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final ItemDTOMapper itemDTOMapper;


    public List<Item> findAll() {
        return repository.findAll();
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public Item crateNew(Item item) {
        return repository.save(item);
    }

    public Optional<Item> updateItem(Long id, Item item) {
        return repository
                .findById(id)
                .map(e -> {
                    if (item.getName() != null) {
                        e.setName(item.getName());
                    }
                    if (item.getExpirationDate() != null) {
                        e.setExpirationDate(item.getExpirationDate());
                    }
                    if (item.getStorageLocation() != null) {
                        e.setStorageLocation(item.getStorageLocation());
                    }
                    return repository.save(e);
                });
    }

    public List<ItemDTO> findOrderedList(Long id) {
        return repository.findByStorageLocationIdAndWastedDateIsNullOrderByExpirationDateAsc(id)
                .stream()
                .map(itemDTOMapper)
                .collect(Collectors.toList());
    }
}
