package adilson.itau.insurance_quote.infrastructure.daos

import adilson.itau.insurance_quote.infrastructure.entities.Quote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteDAO : JpaRepository<Quote, Long>