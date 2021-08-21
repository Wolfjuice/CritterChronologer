@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Costomer {
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    private String phoneNumber;
    private String notes;

    private List<Long> petIds;





    /* getters and setters */
}