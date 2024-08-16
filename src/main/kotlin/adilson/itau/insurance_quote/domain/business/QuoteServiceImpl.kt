package adilson.itau.insurance_quote.domain.business

import adilson.itau.insurance_quote.domain.entities.Quote
import adilson.itau.insurance_quote.domain.repositories.OfferRepository
import adilson.itau.insurance_quote.domain.repositories.ProductRepository
import adilson.itau.insurance_quote.domain.repositories.QuoteRepository
import adilson.itau.insurance_quote.domain.services.QuoteService
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.coyote.BadRequestException
import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class QuoteServiceImpl(
    private val productRepository: ProductRepository,
    private val offerRepository: OfferRepository,
    private val quoteRepository: QuoteRepository,
    private val jmsTemplate: JmsTemplate,
    private val objectMapper: ObjectMapper,
) : QuoteService {

    override fun findQuoteById(quoteId: Long): Quote {
        return quoteRepository.findById(quoteId) ?: throw BadRequestException()
    }

    override fun insertQuote(quote: Quote): Long {
//        val product = productRepository.findById(quote.productId) ?: throw BadRequestException()
//        val offer = offerRepository.findById(quote.offerId) ?: throw BadRequestException()
        // TODO: Validar produto e oferta
        val savedQuote = quoteRepository.save(quote)
        savedQuote.id ?: throw BadRequestException()
        jmsTemplate.convertAndSend("insurance-quote-received", objectMapper.writeValueAsString(savedQuote))
        return savedQuote.id
    }

    @JmsListener(destination = "insurance-policy-created")
    override fun updateQuote(quote: String) {
        val quoteObj = objectMapper.readValue(quote, Quote::class.java)
        quoteRepository.setInsurancePolicyId(quoteObj.id!!, quoteObj.insurancePolicyId!!)
    }

}