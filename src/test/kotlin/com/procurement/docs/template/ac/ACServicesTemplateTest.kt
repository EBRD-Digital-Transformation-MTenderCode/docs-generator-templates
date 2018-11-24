package com.procurement.docs.template.ac

import com.procurement.docs.domain.model.context.ServicesContext
import com.procurement.docs.template.AbstractTemplateTest
import com.procurement.docs.toObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.thymeleaf.context.Context
import org.xhtmlrenderer.pdf.ITextRenderer
import java.io.File
import java.io.FileOutputStream

class ACServicesTemplateTest : AbstractTemplateTest() {
    private val templateEngine = templateEngine()

    @Test
    fun test() {
        //Test context
        val storedJson = RESOURCES.load("json/domain/model/context/services.json")
        val data = mapper.toObject<ServicesContext>(storedJson)
        Assertions.assertNotNull(data)

        //Test template
        val context = Context().apply {
            this.setVariable("context", data)
        }
        val html: String = templateEngine.process("services/services", context)

        //Generate PDF
        val outputStream = FileOutputStream(File("services.pdf"))
        val renderer = ITextRenderer()
        renderer.setDocumentFromString(html)
        renderer.layout()
        renderer.createPDF(outputStream)
    }
}