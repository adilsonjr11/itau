package adilson.itau.insurance_quote.application.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class QuoteDTO(
    @JsonProperty("product_id")
    val productId: String,
    @JsonProperty("offer_id")
    val offerId: String,
    @JsonProperty("category")
    val category: String,
    @JsonProperty("total_monthly_premium_amount")
    val totalMonthlyPremiumAmount: BigDecimal,
    @JsonProperty("total_coverage_amount")
    val totalCoverageAmount: BigDecimal,
    @JsonProperty("coverages")
    val coverages: Map<String, BigDecimal>,
    @JsonProperty("assistances")
    val assistances: List<String>,
    @JsonProperty("customer")
    val customer: Customer,
) {
    data class Customer(
        @JsonProperty("document_number")
        val documentNumber: String,
        @JsonProperty("name")
        val name: String,
        @JsonProperty("type")
        val type: String,
        @JsonProperty("gender")
        val gender: String,
        @JsonProperty("date_of_birth")
        val dateOfBirth: LocalDate,
        @JsonProperty("email")
        val email: String,
        @JsonProperty("phone_number")
        val phoneNumber: String,
    )
}