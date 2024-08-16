package adilson.itau.insurance_quote.domain.repositories

import adilson.itau.insurance_quote.domain.entities.Quote

interface QuoteRepository {
    fun findById(quoteId: Long): Quote?
    fun save(quote: Quote): Quote
    fun setInsurancePolicyId(quoteId: Long, insurancePolicyId: Long)
}