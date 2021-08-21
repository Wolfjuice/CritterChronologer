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