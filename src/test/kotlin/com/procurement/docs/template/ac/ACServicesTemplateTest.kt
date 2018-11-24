package com.procurement.docs.template.ac

import com.procurement.docs.domain.model.context.ServicesContext
import com.procurement.docs.template.AbstractTemplateTest
import com.procurement.docs.toObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.thymeleaf.context.Context

class ACServicesTemplateTest : AbstractTemplateTest() {
    private val templateEngine = templateEngine()

    @Test
    fun test() {
        val storedJson = RESOURCES.load("json/domain/model/context/services.json")
        val data = mapper.toObject<ServicesContext>(storedJson)
        Assertions.assertNotNull(data)

        val context = Context().apply {
            this.setVariable("context", data)
        }
        templateEngine.process("services/services", context)
    }
}