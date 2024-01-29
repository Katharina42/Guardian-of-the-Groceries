package io.everyonecodes.projectmodule.Item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByStorageLocationIdAndWastedDateIsNullOrderByExpirationDateAsc(Long id);
}
