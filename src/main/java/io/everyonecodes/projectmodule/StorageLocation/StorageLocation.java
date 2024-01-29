package io.everyonecodes.projectmodule.StorageLocation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.everyonecodes.projectmodule.Item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StorageLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String locationName;

    @JsonBackReference
    @OneToMany(mappedBy = "storageLocation")
    private List<Item> items;
}
