package io.synertech.relationship.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "employee")
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name="identifier", nullable = false, unique = true)
    var identifier: String? = null

    @Column(name="first_name")
    var firstName: String? = null

    @Column(name="last_name")
    var lastName: String? = null

    @Column(name="email", nullable = false, unique = true)
    var email: String? = null

    @Column(name="daob", nullable = false, unique = true)
    var birthDate: LocalDate? = null

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    var employeeRole: AppEnums.EmployeeRole = AppEnums.EmployeeRole.ANOM

//    One to One Unidirectional relationship
    @OneToOne
    @JoinColumn(name="address_id")
    var address: Address? = null

//    Many to One Relationship
    @ManyToOne
    @JoinColumn(name = "dapartment_id")
    var department: Department? = null

    @ManyToMany
    @JoinTable(
        name = "employee_mission",
        joinColumns = [JoinColumn(name = "employee_id")],
        inverseJoinColumns = [JoinColumn(name = "mission_id")]
    )
    var missions: MutableSet<Mission> = mutableSetOf()
}