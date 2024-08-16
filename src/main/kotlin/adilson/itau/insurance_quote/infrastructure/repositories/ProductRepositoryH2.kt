package adilson.itau.insurance_quote.infrastructure.repositories

import adilson.itau.insurance_quote.domain.entities.Product
import adilson.itau.insurance_quote.domain.repositories.ProductRepository
import adilson.itau.insurance_quote.infrastructure.daos.ProductDAO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductRepositoryH2(
    private val productDAO: ProductDAO,
    private val objectMapper: ObjectMapper,
) : ProductRepository {
    override fun findById(id: String): Product? {
        return productDAO.findByIdOrNull(id)?.let {
            objectMapper.convertValue(it.json, Product::class.java)
        }
    }

}