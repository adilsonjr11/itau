package adilson.itau.insurance_quote.infrastructure.daos

import adilson.itau.insurance_quote.infrastructure.entities.Coverage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoverageDAO : JpaRepository<Coverage, Long> {
    fun findAllByQuoteId(quoteId: Long): List<Coverage>

}