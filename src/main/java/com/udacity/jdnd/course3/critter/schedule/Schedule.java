@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;


    private List<Long> employeeIds;

    private List<Long> petIds;

    private LocalDate date;


    private Set<EmployeeSkill> activities;





    /* getters and setters */
}