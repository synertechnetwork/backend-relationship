package io.synertech.relationship.model

import jakarta.persistence.*


/**
*
* @author Marcus Dashe <mqrksimon@gmail.com>
*/


@Entity
@Table(name = "address")
class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name="street_name")
    var streetName: String? = null

    @Column(name="house_number")
    var houseNumber: String? = null

    @Column(name="zip_code")
    var zipCode: String? = null

    //    One to One Bidirectional relationship
    @OneToOne
    @JoinColumn(name="employee_id")
    var employee: Employee? = null

}