package adilson.itau.insurance_quote.infrastructure.repositories

import adilson.itau.insurance_quote.domain.entities.Offer
import adilson.itau.insurance_quote.domain.repositories.OfferRepository
import adilson.itau.insurance_quote.infrastructure.daos.OfferDAO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class OfferRepositoryH2(
    private val offerDAO: OfferDAO,
    private val objectMapper: ObjectMapper,
) : OfferRepository {
    override fun findById(id: String): Offer? {
        return offerDAO.findByIdOrNull(id)?.let {
            objectMapper.convertValue(it.json, Offer::class.java)
        }
    }

}