package adilson.itau.insurance_quote.infrastructure.repositories

import adilson.itau.insurance_quote.domain.entities.Quote
import adilson.itau.insurance_quote.domain.repositories.QuoteRepository
import adilson.itau.insurance_quote.infrastructure.daos.AssistanceDAO
import adilson.itau.insurance_quote.infrastructure.daos.CoverageDAO
import adilson.itau.insurance_quote.infrastructure.daos.QuoteDAO
import adilson.itau.insurance_quote.infrastructure.entities.Assistance
import adilson.itau.insurance_quote.infrastructure.entities.Coverage
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDateTime

@Component
class QuoteRepositoryH2(
    private val quoteDAO: QuoteDAO,
    private val assistanceDAO: AssistanceDAO,
    private val coverageDAO: CoverageDAO,
) : QuoteRepository {

    override fun findById(quoteId: Long): Quote? {
        return quoteDAO.findByIdOrNull(quoteId)?.let {
            val assistances = assistanceDAO.findAllByQuoteId(quoteId).map { assistance ->
                assistance.name
            }
            val coverages = HashMap<String, BigDecimal>()
            coverageDAO.findAllByQuoteId(quoteId).forEach { coverage ->
                coverages[coverage.name] = coverage.amount
            }
            Quote(
                id = it.id,
                insurancePolicyId = it.insurancePolicyId,
                productId = it.productId,
                offerId = it.offerId,
                category = it.category,
                totalMonthlyPremiumAmount = it.totalMonthlyPremiumAmount,
                totalCoverageAmount = it.totalCoverageAmount,
                assistances = assistances,
                coverages = coverages,
                customer = Quote.Customer(
                    documentNumber = it.customerDocumentNumber,
                    name = it.customerName,
                    type = it.customerType,
                    gender = it.customerGender,
                    dateOfBirth = it.customerDateOfBirth,
                    email = it.customerEmail,
                    phoneNumber = it.customerPhoneNumber,
                )
            )
        }
    }

    override fun setInsurancePolicyId(quoteId: Long, insurancePolicyId: Long) {
        quoteDAO.findByIdOrNull(quoteId)?.let {
            it.insurancePolicyId = insurancePolicyId
            quoteDAO.save(it)
        }
    }

    override fun save(quote: Quote): Quote {
        val quoteSaved = quoteDAO.save(
            adilson.itau.insurance_quote.infrastructure.entities.Quote(
                productId = quote.productId,
                offerId = quote.offerId,
                category = quote.category,
                totalMonthlyPremiumAmount = quote.totalMonthlyPremiumAmount,
                totalCoverageAmount = quote.totalCoverageAmount,
                customerDocumentNumber = quote.customer.documentNumber,
                customerName = quote.customer.name,
                customerType = quote.customer.type,
                customerGender = quote.customer.gender,
                customerDateOfBirth = quote.customer.dateOfBirth,
                customerEmail = quote.customer.email,
                customerPhoneNumber = quote.customer.phoneNumber,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            )
        )
        quote.assistances.forEach {
            assistanceDAO.save(
                Assistance(
                    quote = quoteSaved,
                    name = it,
                )
            )
        }
        quote.coverages.forEach { (name, amount) ->
            coverageDAO.save(
                Coverage(
                    quote = quoteSaved,
                    name = name,
                    amount = amount,
                )
            )
        }
        return quoteSaved.id?.let {
            findById(quoteSaved.id)
        } ?: throw Exception("error_on_save")
    }

}