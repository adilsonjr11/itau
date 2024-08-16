package adilson.itau.insurance_quote.infrastructure.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Quote(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var insurancePolicyId: Long? = null,
    val productId: String,
    val offerId: String,
    val category: String,
    val totalMonthlyPremiumAmount: BigDecimal,
    val totalCoverageAmount: BigDecimal,
    val customerDocumentNumber: String,
    val customerName: String,
    val customerType: String,
    val customerGender: String,
    val customerDateOfBirth: LocalDate,
    val customerEmail: String,
    val customerPhoneNumber: String,
    @CreationTimestamp
    val createdAt: LocalDateTime,
    @UpdateTimestamp
    val updatedAt: LocalDateTime,
)
