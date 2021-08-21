@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> daysAvailable;





    /* getters and setters */
}