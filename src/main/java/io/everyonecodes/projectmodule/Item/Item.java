package io.everyonecodes.projectmodule.Item;

import io.everyonecodes.projectmodule.StorageLocation.StorageLocation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate expirationDate;

    @Column(name = "wasted_Date")
    private LocalDate wastedDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "storage_location_id")

    private StorageLocation storageLocation;
}


