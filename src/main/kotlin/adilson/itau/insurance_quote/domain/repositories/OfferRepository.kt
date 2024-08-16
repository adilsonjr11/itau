package adilson.itau.insurance_quote.domain.repositories

import adilson.itau.insurance_quote.domain.entities.Offer

interface OfferRepository {
    fun findById(id: String): Offer?
}