@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeRequest {
    @Id
    @GeneratedValue
    private Long id;

    private Set<EmployeeSkill> skills;
    private LocalDate date;


    /* getters and setters */
}