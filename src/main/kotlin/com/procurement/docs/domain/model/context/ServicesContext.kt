package com.procurement.docs.domain.model.context

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("ac", "ev", "ms")
class ServicesContext(
    @field:JsonProperty("ac") @param:JsonProperty("ac") val ac: AC,
    @field:JsonProperty("ev") @param:JsonProperty("ev") val ev: EV,
    @field:JsonProperty("ms") @param:JsonProperty("ms") val ms: MS
) {

    @JsonPropertyOrder("date", "contract", "tender", "buyer", "supplier", "award")
    data class AC(
        val date: String, // AC.date, format - (DD.MM.YYYY)
        val contract: Contract,
        val tender: Tender,
        val buyer: Buyer,
        val supplier: Supplier,
        val award: Award
    ) {

        @JsonPropertyOrder("id", "description", "value", "endDate", "agreedMetrics")
        data class Contract(
            val id: String, // AC.contracts[0].id
            val description: String, // AC.contracts[0].description,
            val value: Double, // AC.contracts[0].value.amount
            val endDate: String, // AC.contract.period.endDate
            val agreedMetrics: AgreedMetrics
        ) {

            @JsonPropertyOrder("ccGenerel_1_1Measure",
                               "ccGenerel_1_2Measure",
                               "ccGenerel_1_3Measure",
                               "ccBuyer_1_1Measure",
                               "ccBuyer_2_1Measure",
                               "ccBuyer_2_2Measure",
                               "ccTenderer_1_1Measure",
                               "ccTenderer_1_2Measure",
                               "ccTenderer_2_1Measure",
                               "ccTenderer_2_2Measure",
                               "ccTenderer_2_3Measure",
                               "ccTenderer_2_4Measure",
                               "ccTenderer_3_1Measure",
                               "ccTenderer_3_2Measure",
                               "ccTenderer_3_3Measure"
            )
            data class AgreedMetrics(
                val ccGenerel_1_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-general].observations[id==cc-general-1-1].measure
                val ccGenerel_1_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-general].observations[id==cc-general-1-2].measure
                val ccGenerel_1_3Measure: String, // AC.contracts[0].agreedMetrics[id==cc-general].observations[id==cc-general-1-3].measure

                val ccBuyer_1_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-buyer-1].observations[id==cc-buyer-1-1].measure
                val ccBuyer_2_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-buyer-1].observations[id==cc-buyer-2-1].measure
                val ccBuyer_2_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-buyer-1].observations[id==cc-buyer-2-2].measure

                val ccTenderer_1_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-1-1].measure
                /* TODO ccTenderer_1_6Measure */
                val ccTenderer_1_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-1-2].measure
                val ccTenderer_2_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-2-1].measure
                val ccTenderer_2_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-2-2].measure
                val ccTenderer_2_3Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-2-3].measure
                val ccTenderer_2_4Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-2-4].measure
                val ccTenderer_3_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-3-1].measure
                val ccTenderer_3_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-3-2].measure
                val ccTenderer_3_3Measure: String // AC.contracts[0].agreedMetrics[id==cc-tenderer-1].observations[id==cc-tenderer-3-3].measure
            )
        }

        @JsonPropertyOrder("procurementMethodDetails", "classification")
        data class Tender(
            val procurementMethodDetails: String, // AC.tender.procurementMethodDetails
            val classification: Classification
        ) {

            @JsonPropertyOrder("id", "description")
            data class Classification(
                val id: String, // AC.tender.classification.id
                val description: String // AC.tender.classification.description
            )
        }

        @JsonPropertyOrder("address",
                           "identifier",
                           "additionalidentifieres",
                           "contactPoint",
                           "persones",
                           "details"
        )
        data class Buyer(
            val address: Address,
            val identifier: Identifier,
            val additionalidentifieres: List<AdditionalIdentifier>,
            val contactPoint: ContactPoint,
            val persones: List<Person>,
            val details: Details
        ) {

            @JsonPropertyOrder("country", "region", "locality", "streetAddress", "postalCode")
            data class Address(
                val country: String, // AC.parties[role=="buyer"].address.addressDetails.country.description
                val region: String, // AC.parties[role=="buyer"].address.addressDetails.region.description
                val locality: String, // AC.parties[role=="buyer"].address.addressDetails.locality.description
                val streetAddress: String, // AC.parties[role=="buyer"].address.streetAddress
                @field:JsonInclude(JsonInclude.Include.NON_NULL)
                val postalCode: String? // AC.parties[role=="buyer"].address.postalCode
            )

            @JsonPropertyOrder("id", "legalName")
            data class Identifier(
                val id: String, // AC.parties[role=="buyer"].identifier.id
                val legalName: String // AC.parties[role=="buyer"].identifier.legalName
            )

            @JsonPropertyOrder("scheme")
            data class AdditionalIdentifier(
                val scheme: String // AC.parties.[role=="buyer"].details.bankAccounts.additionalAccountIdentifiers[scheme=="MD-FISCAL"].id
            )

            @JsonPropertyOrder("telephone")
            data class ContactPoint(
                val telephone: String // AC.parties.[role=="buyer"].contactPoint.telephone
            )

            @JsonPropertyOrder("title", "name", "businessFunctions")
            data class Person(
                val title: String, // AC.parties[role=="buyer"].persones[*].title
                val name: String, // AC.parties[role=="buyer"].persones[*[.name
                val businessFunctions: BusinessFunctions
            ) {

                @JsonPropertyOrder("jobTitle")
                data class BusinessFunctions(
                    val jobTitle: String // AC.parties[role=="buyer"].persones[*].businessFunctions[type=="authority"].jobTitle
                )
            }

            @JsonPropertyOrder("bankAccount", "legalForm")
            data class Details(
                val bankAccount: BankAccounts,
                val legalForm: LegalForm
            ) {

                @JsonPropertyOrder("accountIdentification", "identifier", "name", "address")
                data class BankAccounts(
                    val accountIdentification: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].accountIdentification.id
                    val identifier: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].identifier.id
                    val name: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].bankName
                    val address: Address
                ) {

                    @JsonPropertyOrder("country", "region", "locality", "streetAddress", "postalCode")
                    data class Address(
                        val country: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].address.addressDetails.country.description
                        val region: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].address.addressDetails.region.description
                        val locality: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].address.addressDetails.locality.description
                        val streetAddress: String, // AC.parties.[role=="buyer"].details.bankAccounts[0].address.streetAddress
                        val postalCode: String?// AC.parties.[role=="buyer"].details.bankAccounts[0].address.postalCode
                    )
                }

                @JsonPropertyOrder("description")
                data class LegalForm(
                        val description: String // AC.parties[role=="buyer"].legalForm.description
                )
            }
        }

        @JsonPropertyOrder("address",
                           "identifier",
                           "additionalidentifieres",
                           "contactPoint",
                           "persones",
                           "details")
        data class Supplier(
            val address: Address,
            val identifier: Identifier,
            val additionalidentifieres: List<AdditionalIdentifier>,
            val contactPoint: ContactPoint,
            val persones: List<Person>,
            val details: Details
        ) {

            @JsonPropertyOrder("country", "region", "locality", "streetAddress", "postalCode")
            data class Address(
                val country: String, // AC.parties[role=="supplier"].address.addressDetails.country.description
                val region: String, // AC.parties[role=="supplier"].address.addressDetails.region.description
                val locality: String, // AC.parties[role=="supplier"].address.addressDetails.locality.description
                val streetAddress: String, // AC.parties[role=="supplier"].address.streetAddress
                val postalCode: String? // AC.parties[role=="supplier"].address.postalCode
            )

            @JsonPropertyOrder("id", "legalName")
            data class Identifier(
                val id: String, // AC.parties[role=="supplier"].identifier.id
                val legalName: String // AC.parties[role=="supplier"].identifier.legalName
            )

            @JsonPropertyOrder("scheme")
            data class AdditionalIdentifier(
                val scheme: String // AC.parties.[role=="supplier"].details.bankAccounts.additionalAccountIdentifiers[scheme=="MD-FISCAL"].id
            )

            @JsonPropertyOrder("telephone")
            data class ContactPoint(
                val telephone: String // AC.parties.[role=="supplier"].contactPoint.telephone
            )

            @JsonPropertyOrder("title", "name", "businessFunctions")
            data class Person(
                val title: String, // AC.parties[role=="supplier"].persones[*].title
                val name: String, // AC.parties[role=="supplier"].persones[*].name
                val businessFunctions: BusinessFunctions
            ) {

                @JsonPropertyOrder("jobTitle", "documents")
                data class BusinessFunctions(
                    val jobTitle: String, // AC.parties[role=="supplier"].persones.businessFunctions[type=="authority"].jobTitle
                    val documents: Documents
                ) {

                    @JsonPropertyOrder("title")
                    data class Documents(
                        val title: String // AC.parties[role=="supplier"].persones[*].businessFunctions[type=="authority"].documents[documentType=="regulatoryDocument"]
                    )
                }
            }

            @JsonPropertyOrder("bankAccount", "legalForm")
            data class Details(
                val bankAccount: BankAccounts,
                val legalForm: LegalForm
            ) {

                @JsonPropertyOrder("accountIdentification", "identifier", "name", "address")
                data class BankAccounts(
                    val accountIdentification: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].accountIdentification.id
                    val identifier: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].identifier.id
                    val name: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].bankName
                    val address: Address
                ) {

                    @JsonPropertyOrder("country", "region", "locality", "streetAddress", "postalCode")
                    data class Address(
                        val country: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].address.addressDetails.country.description
                        val region: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].address.addressDetails.region.description
                        val locality: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].address.addressDetails.locality.description
                        val streetAddress: String, // AC.parties.[role=="supplier"].details.bankAccounts[0].address.streetAddress
                        val postalCode: String? // AC.parties.[role=="supplier"].details.bankAccounts[0].address.postalCode
                    )
                }

                @JsonPropertyOrder("description")
                data class LegalForm(
                        val description: String // AC.parties[role=="supplier"].legalForm.description
                )
            }
        }

        @JsonPropertyOrder("date", "relatedLot", "items")
        data class Award(
            val date: String, //AC.awards[relatedLots[0]==AC.tender.lots[0].id].date
            val relatedLot: RelatedLot,
            val items: List<Item>
        ) {

            @JsonPropertyOrder("id")
            data class RelatedLot(
                val id: String //AC.awards.[relatedLots[0]==AC.tender.lots[0].id].id
            )

            @JsonPropertyOrder("classification", "description", "unit", "planning", "quantity", "agreedMetrics")
            data class Item(
                val classification: Classification,
                val description: String?,//AC.award.items[*].description
                val unit: Unit,
                val planning: Planning,
                val quantity: Double, //AC.award.items[*].quantity
                val agreedMetrics: AgreedMetrics
            ) {

                @JsonPropertyOrder("id", "description")
                data class Classification(
                    val id: String,// AC.award.items[*].classification.id
                    val description: String// AC.award.items[*].classification.description
                )

                @JsonPropertyOrder("name", "value")
                data class Unit(
                    val name: String,//AC.award.items[*].unit.name
                    val value: Value
                ) {

                    @JsonPropertyOrder("amountNet", "amount")
                    data class Value(
                        val amountNet: Double,//AC.award.items[*].unit.value.amountNet
                        val amount: Double//AC.award.items[*].unit.value.amount
                    )
                }

                @JsonPropertyOrder("budgetAllocation")
                data class Planning(
                    val budgetAllocation: BudgetAllocation

                ) {

                    @JsonPropertyOrder("period", "budgetBreakdownID")
                    data class BudgetAllocation(
                        val period: Period,
                        val budgetBreakdownID: String// AC.planning.budget.budgetAllocation[relatedItem==item.id].budgetBreakdownID
                    ) {

                        @JsonPropertyOrder("startDate", "endDate")
                        data class Period(
                            val startDate: String, // AC.planning.budget.budgetAllocation[relatedItem==item.id].period.startDate, format - (DD.MM.YYYY)
                            val endDate: String // AC.planning.budget.budgetAllocation[relatedItem==item.id].period.endDate, format - (DD.MM.YYYY)
                        )
                    }
                }

                @JsonPropertyOrder("ccSubject_1Measure", "ccSubject_2Measure", "ccSubject_3Measure", "ccSubject_4Measure", "ccSubject_5Measure")
                data class AgreedMetrics(
                        val ccSubject_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-subject-["item.id"]-*].observations[id==cc-subject-1].measure
                        val ccSubject_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-subject-["item.id"]-*].observations[id==cc-subject-2].measure
                        val ccSubject_3Measure: String, // AC.contracts[0].agreedMetrics[id==cc-subject-["item.id"]-*].observations[id==cc-subject-3].measure
                        val ccSubject_4Measure: String, // AC.contracts[0].agreedMetrics[id==cc-subject-["item.id"]-*].observations[id==cc-subject-4].measure
                        val ccSubject_5Measure: String // AC.contracts[0].agreedMetrics[id==cc-subject-["item.id"]-*].observations[id==cc-subject-5].measure
                )
            }
        }
    }

    @JsonPropertyOrder("publishDate", "tender")
    data class EV(
        val publishDate: String, // EV.publishDate, format - (DD.MM.YYYY)
        val tender: Tender
    ) {

        @JsonPropertyOrder("id")
        data class Tender(
            val id: String // EV.tender.id
        )
    }

    @JsonPropertyOrder("tender")
    data class MS(
        val tender: Tender
    ) {

        @JsonPropertyOrder("id", "title")
        data class Tender(
            val id: String,//MS.tender.id
            val title: String //MS.tender.title
        )
    }
}