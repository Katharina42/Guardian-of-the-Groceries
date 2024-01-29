package io.everyonecodes.projectmodule.StorageLocation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageRepository extends JpaRepository<StorageLocation, Long> {

    List<StorageLocation> findAllByOrderByLocationName();

}
