package adilson.itau.insurance_quote.infrastructure.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Product(
    @Id
    val id: String,
    @Column(length = 1024 * 10)
    val json: String,
)