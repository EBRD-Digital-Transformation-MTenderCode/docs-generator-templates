package com.procurement.docs.template.ac

import com.lowagie.text.pdf.BaseFont
import com.procurement.docs.domain.model.context.ServicesContext
import com.procurement.docs.template.AbstractTemplateTest
import com.procurement.docs.toObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.thymeleaf.context.Context
import org.xhtmlrenderer.pdf.ITextRenderer
import java.io.File
import java.io.FileOutputStream

class ACServicesTemplateTest : AbstractTemplateTest() {
    private val templateEngine = templateEngine()

    @ParameterizedTest
    @ValueSource(strings = ["ro", "ru"])
    fun test(lang: String) {
        //Test context
        val storedJson = RESOURCES.load("json/domain/model/context/services.json")
        val data = mapper.toObject<ServicesContext>(storedJson)
        Assertions.assertNotNull(data)

        //Test template
        val context = Context().apply {
            this.setVariable("context", data)
        }
        val html: String = templateEngine.process("services/services_$lang", context)

        //Generate PDF
        val outputStream = FileOutputStream(File("services_$lang.pdf"))
        val renderer = ITextRenderer()
        val fontResourceURL = javaClass.classLoader.getResource("fonts/times-new-roman.ttf")
        renderer.fontResolver.addFont(fontResourceURL.path, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        renderer.setDocumentFromString(html)
        renderer.layout()
        renderer.createPDF(outputStream)
    }
}