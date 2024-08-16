package adilson.itau.insurance_quote.domain.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class Offer(
    val id: String,
    val productId: String,
    val name: String,
    val createdAt: LocalDateTime,
    val active: Boolean,
    val coverages: Map<String, BigDecimal>,
    val assistances: List<String>,
    val monthlyPremiumAmount: MonthlyPremiumAmount,
) {
    data class MonthlyPremiumAmount(
        val maxAmount: BigDecimal,
        val minAmount: BigDecimal,
        val suggestedAmount: BigDecimal,
    )
}
