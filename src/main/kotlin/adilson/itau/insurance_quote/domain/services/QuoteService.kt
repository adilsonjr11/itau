package adilson.itau.insurance_quote.domain.services

import adilson.itau.insurance_quote.domain.entities.Quote

interface QuoteService {
    fun findQuoteById(quoteId: Long): Quote
    fun insertQuote(quote: Quote): Long
    fun updateQuote(quote: String)
}