package adilson.itau.insurance_quote.domain.repositories

import adilson.itau.insurance_quote.domain.entities.Product

interface ProductRepository {
    fun findById(id: String): Product?
}