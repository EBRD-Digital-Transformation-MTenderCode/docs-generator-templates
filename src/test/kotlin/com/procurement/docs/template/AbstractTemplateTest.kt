package com.procurement.docs.template

import com.procurement.docs.AbstractBase
import org.thymeleaf.TemplateEngine
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.FileTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver

abstract class AbstractTemplateTest : AbstractBase() {

    protected fun templateEngine(): TemplateEngine {
        val engine = SpringTemplateEngine()
        engine.addDialect(Java8TimeDialect())
        engine.addTemplateResolver(stringTemplateResolver())
        return engine
    }

    private fun stringTemplateResolver(): ITemplateResolver {
        val templateResolver = FileTemplateResolver()
        templateResolver.prefix = "src/main/resources/templates/"
        templateResolver.suffix = ".html"
        templateResolver.templateMode = TemplateMode.HTML
        templateResolver.isCacheable = false
        return templateResolver
    }
}