package adilson.itau.insurance_quote.domain.entities

import java.math.BigDecimal
import java.time.LocalDate

data class Quote(
    val id: Long? = null,
    var insurancePolicyId: Long? = null,
    val productId: String,
    val offerId: String,
    val category: String,
    val totalMonthlyPremiumAmount: BigDecimal,
    val totalCoverageAmount: BigDecimal,
    val coverages: Map<String, BigDecimal>,
    val assistances: List<String>,
    val customer: Customer,
) {
    data class Customer(
        val documentNumber: String,
        val name: String,
        val type: String,
        val gender: String,
        val dateOfBirth: LocalDate,
        val email: String,
        val phoneNumber: String,
    )
}