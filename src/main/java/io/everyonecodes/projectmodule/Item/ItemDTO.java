package io.everyonecodes.projectmodule.Item;

import io.everyonecodes.projectmodule.StorageLocation.StorageLocation;

import java.time.LocalDate;

public class ItemDTO {
    private Long id;
    private String name;
    private LocalDate expirationDate;
    private LocalDate wastedDate;
    private StorageLocation storageLocation;
    private String timeDiff;


    public ItemDTO(Long id, String name, LocalDate expirationDate, LocalDate wastedDate, StorageLocation storageLocation) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.wastedDate = wastedDate;
        this.storageLocation = storageLocation;
    }
    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getWastedDate() {
        return wastedDate;
    }

    public StorageLocation getStorageLocation() {
        return storageLocation;
    }

    public String getTimeDiff() {
        return timeDiff;
    }
}
