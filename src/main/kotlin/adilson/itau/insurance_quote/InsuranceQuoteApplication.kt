package adilson.itau.insurance_quote

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jms.annotation.EnableJms

@SpringBootApplication
@EnableJms
class InsuranceQuoteApplication

fun main(args: Array<String>) {
    runApplication<InsuranceQuoteApplication>(*args)
}
