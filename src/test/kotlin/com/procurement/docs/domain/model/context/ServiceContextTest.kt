package com.procurement.docs.domain.model.context

import com.procurement.docs.AbstractBase
import com.procurement.docs.toJson
import com.procurement.docs.toObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ServiceContextTest : AbstractBase() {
    @Test
    fun test() {
        val storedJson = RESOURCES.load("json/domain/model/context/services.json")
        val snapshotData = mapper.toObject<ServicesContext>(storedJson)
        Assertions.assertNotNull(snapshotData)

        val jsonFromObj = mapper.toJson(snapshotData)
        Assertions.assertEquals(storedJson, jsonFromObj)
    }
}