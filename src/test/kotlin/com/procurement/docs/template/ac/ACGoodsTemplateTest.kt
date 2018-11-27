package com.procurement.docs.template.ac

import com.lowagie.text.pdf.BaseFont
import com.procurement.docs.domain.model.context.GoodsContext
import com.procurement.docs.template.AbstractTemplateTest
import com.procurement.docs.toObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.thymeleaf.context.Context
import org.xhtmlrenderer.pdf.ITextRenderer
import java.io.File
import java.io.FileOutputStream

class ACGoodsTemplateTest : AbstractTemplateTest() {
    private val templateEngine = templateEngine()

    @Test
    fun test() {
        //Test context
        val storedJson = RESOURCES.load("json/domain/model/context/goods.json")
        val data = mapper.toObject<GoodsContext>(storedJson)
        Assertions.assertNotNull(data)

        //Test template
        val context = Context().apply {
            this.setVariable("context", data)
        }
        val html: String = templateEngine.process("goods/goods", context)

        //Generate PDF
        val outputStream = FileOutputStream(File("goods.pdf"))
        val renderer = ITextRenderer()
        val fontResourceURL = javaClass.classLoader.getResource("fonts/times-new-roman.ttf")
        renderer.fontResolver.addFont(fontResourceURL.path, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        renderer.setDocumentFromString(html)
        renderer.layout()
        renderer.createPDF(outputStream)
    }
}