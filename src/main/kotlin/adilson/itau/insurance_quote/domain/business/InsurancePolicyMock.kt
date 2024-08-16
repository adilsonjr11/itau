package adilson.itau.insurance_quote.domain.business

import adilson.itau.insurance_quote.domain.entities.Quote
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class InsurancePolicyMock(
    private val jmsTemplate: JmsTemplate,
    private val objectMapper: ObjectMapper,
) {

    @JmsListener(destination = "insurance-quote-received")
    fun processQuote(msg: String) {
        val quote = objectMapper.readValue(msg, Quote::class.java)
        quote.insurancePolicyId = Random().nextLong(Long.MAX_VALUE)
        jmsTemplate.convertAndSend("insurance-policy-created", objectMapper.writeValueAsString(quote))
    }

}