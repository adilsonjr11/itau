package adilson.itau.insurance_quote.application.controllers

import adilson.itau.insurance_quote.application.dtos.QuoteDTO
import adilson.itau.insurance_quote.domain.entities.Quote
import adilson.itau.insurance_quote.domain.services.QuoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("quote")
class QuoteController(
    private val quoteService: QuoteService,
) {

    @PostMapping
    fun requestQuote(@RequestBody quoteDTO: QuoteDTO): Long {
        val quote = Quote(
            productId = quoteDTO.productId,
            offerId = quoteDTO.offerId,
            category = quoteDTO.category,
            totalMonthlyPremiumAmount = quoteDTO.totalMonthlyPremiumAmount,
            totalCoverageAmount = quoteDTO.totalCoverageAmount,
            coverages = quoteDTO.coverages,
            assistances = quoteDTO.assistances,
            customer = Quote.Customer(
                documentNumber = quoteDTO.customer.documentNumber,
                name = quoteDTO.customer.name,
                type = quoteDTO.customer.type,
                gender = quoteDTO.customer.gender,
                dateOfBirth = quoteDTO.customer.dateOfBirth,
                email = quoteDTO.customer.email,
                phoneNumber = quoteDTO.customer.phoneNumber,
            )
        )
        return quoteService.insertQuote(quote)
    }

    @GetMapping("{quoteId}")
    fun findById(@PathVariable quoteId: Long): QuoteDTO {
        return quoteService.findQuoteById(quoteId).let {
            QuoteDTO(
                productId = it.productId,
                offerId = it.offerId,
                category = it.category,
                totalMonthlyPremiumAmount = it.totalMonthlyPremiumAmount,
                totalCoverageAmount = it.totalCoverageAmount,
                coverages = it.coverages,
                assistances = it.assistances,
                customer = QuoteDTO.Customer(
                    documentNumber = it.customer.documentNumber,
                    name = it.customer.name,
                    type = it.customer.type,
                    gender = it.customer.gender,
                    dateOfBirth = it.customer.dateOfBirth,
                    email = it.customer.email,
                    phoneNumber = it.customer.phoneNumber,
                )
            )
        }
    }

}