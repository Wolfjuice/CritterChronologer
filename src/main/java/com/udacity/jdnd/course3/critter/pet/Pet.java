package com.udacity.jdnd.course3.critter.pet;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet {
    @Id
    @GeneratedValue
    private Long id;


    private PetType type;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    private long ownerId;


    private LocalDate birthDate;


    private String notes;



    /* getters and setters */
}