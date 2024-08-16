package adilson.itau.insurance_quote.domain.entities

import java.time.LocalDateTime

data class Product(
    val id: String,
    val name: String,
    val createdAt: LocalDateTime,
    val active: Boolean,
    val offers: List<String>,
)
