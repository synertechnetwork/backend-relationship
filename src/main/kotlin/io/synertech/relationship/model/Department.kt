package io.synertech.relationship.model

import jakarta.persistence.*

/**
 *
 * @author Marcus Dashe <mqrksimon@gmail.com>
 */


@Entity
@Table(name = "department")
class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name="dept_name")
    var deptName: String? = null

    @OneToMany(mappedBy = "department", cascade = [CascadeType.ALL], orphanRemoval = true)
    var employees: MutableSet<Employee> = mutableSetOf()

}