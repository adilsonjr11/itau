package adilson.itau.insurance_quote.infrastructure.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Coverage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "quote_id")
    val quote: Quote,
    val name: String,
    val amount: BigDecimal,
)
