package tests;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "person")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    // Mapping via JSON and Converter
//    @Column(name = "addresses")
//    @Convert(converter = AddressConverter.class)

    // Mapping collection field to another table:
    @ElementCollection
    @CollectionTable(name = "person_address", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "address")
    private List<String> addressList;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonInfo personInfo;

    @OneToMany(mappedBy = "person")
    private List<Workplace> workplaces;
}
