package io.synertech.relationship.model

import jakarta.persistence.*

/**
 *
 * @author Marcus Dashe <mqrksimon@gmail.com>
 */


@Entity
@Table(name = "mission")
class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name="name")
    var name: String? = null

    @Column(name="duration")
    var duration: Int? = null

    @ManyToMany(mappedBy = "missions")
    var employees: MutableSet<Employee> = mutableSetOf()
}
