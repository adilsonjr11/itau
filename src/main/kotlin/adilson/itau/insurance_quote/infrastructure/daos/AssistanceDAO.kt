package adilson.itau.insurance_quote.infrastructure.daos

import adilson.itau.insurance_quote.infrastructure.entities.Assistance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssistanceDAO : JpaRepository<Assistance, Long> {
    fun findAllByQuoteId(quoteId: Long): List<Assistance>

}