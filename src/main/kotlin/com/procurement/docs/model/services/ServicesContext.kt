package com.procurement.docs.model.services

class ServicesContext(
    val ac: AC,
    val ev: EV,
    val ms: MS
) {
    data class AC(
        val date: String, // AC.date, format - (DD.MM.YYYY)
        val contract: Contract,
        val tender: Tender,
        val buyer: Buyer,
        val supplier: Supplier,
        val award: Award,
        val planning: Planning
    ) {
        data class Contract(
            val id: String, // AC.contracts[0].id
            val description: String, // AC.contracts[0].description,
            val value: Double, // AC.contracts[0].value.amount
            val endDate: String, // AC.contract.period.endDate
            val agreedMetrics: AgreedMetrics
        )

        data class Tender(
            val procurementMethodDetails: String, // AC.tender.procurementMethodDetails
            val classification: Classification
        ) {
            data class Classification(
                val id: String, // AC.tender.classification.id
                val description: String // AC.tender.classification.description
            )
        }

        data class Buyer(
            val address: Address,
            val legalForm: LegalForm,
            val identifier: Identifier,
            val additionalidentifieres: List<AdditionalIdentifier>,
            val contactPoint: ContactPoint,
            val persones: List<Person>,
            val details: Details
        ) {
            data class Address(
                val country: String, // AC.parties[role=="buyer"].address.addressDetails.country.description
                val region: String, // AC.parties[role=="buyer"].address.addressDetails.region.description
                val locality: String, // AC.parties[role=="buyer"].address.addressDetails.locality.description
                val streetAddress: String, // AC.parties[role=="buyer"].address.streetAddress
                val postalCode: String? // AC.parties[role=="buyer"].address.postalCode
            )

            data class LegalForm(
                val description: String // AC.parties[role=="buyer"].legalForm.description
            )

            data class Identifier(
                val id: String, // AC.parties[role=="buyer"].identifier.id
                val legalName: String // AC.parties[role=="buyer"].identifier.legalName
            )

            data class AdditionalIdentifier(
                val scheme: String // AC.parties.[role=="buyer"].details.bankAccounts.additionalAccountIdentifiers[scheme=="MD-FISCAL"].id
            )

            data class ContactPoint(
                val telephone: String // AC.parties.[role=="buyer"].contactPoint.telephone
            )

            data class Person(
                val title: String, // AC.parties[role=="buyer"].persones[*].title
                val name: String, // AC.parties[role=="buyer"].persones[*[.name
                val businessFunctions: BusinessFunctions
            ) {
                data class BusinessFunctions(
                    val jobTitle: String // AC.parties[role=="buyer"].persones[*].businessFunctions[type=="authority"].jobTitle
                )
            }

            data class Details(
                val bankAccount: BankAccounts
            ) {
                data class BankAccounts(
                    val accountIdentification: String, // AC.parties.[role=="buyer"].details.bankAccounts.accountIdentification.id
                    val identifier: String, // AC.parties.[role=="buyer"].details.bankAccounts.identifier.id
                    val name: String, // AC.parties.[role=="buyer"].details.bankAccounts.bankName
                    val address: Address
                ) {
                    data class Address(
                        val country: String, // AC.parties.[role=="buyer"].details.bankAccounts.address.addressDetails.country.description
                        val region: String, // AC.parties.[role=="buyer"].details.bankAccounts.address.addressDetails.region.description
                        val locality: String, // AC.parties.[role=="buyer"].details.bankAccounts.address.addressDetails.locality.description
                        val streetAddress: String, // AC.parties.[role=="buyer"].details.bankAccounts.address.streetAddress
                        val postalCode: String?// AC.parties.[role=="buyer"].details.bankAccounts.address.postalCode
                    )
                }
            }
        }

        data class Supplier(
            val address: Address,
            val legalForm: LegalForm,
            val identifier: Identifier,
            val additionalidentifieres: List<AdditionalIdentifier>,
            val contactPoint: ContactPoint,
            val persones: List<Person>,
            val details: Details
        ) {
            data class Address(
                val country: String, // AC.parties[role=="supplier"].address.addressDetails.country.description
                val region: String, // AC.parties[role=="supplier"].address.addressDetails.region.description
                val locality: String, // AC.parties[role=="supplier"].address.addressDetails.locality.description
                val streetAddress: String, // AC.parties[role=="supplier"].address.streetAddress
                val postalCode: String? // AC.parties[role=="supplier"].address.postalCode
            )

            data class LegalForm(
                val description: String // AC.parties[role=="supplier"].legalForm.description
            )

            data class Identifier(
                val id: String, // AC.parties[role=="supplier"].identifier.id
                val legalName: String // AC.parties[role=="supplier"].identifier.legalName
            )

            data class AdditionalIdentifier(
                val scheme: String // AC.parties.[role=="supplier"].details.bankAccounts.additionalAccountIdentifiers[scheme=="MD-FISCAL"].id
            )

            data class ContactPoint(
                val telephone: String // AC.parties.[role=="supplier"].contactPoint.telephone
            )

            data class Person(
                val title: String, // AC.parties[role=="supplier"].persones[*].title
                val name: String, // AC.parties[role=="supplier"].persones[*].name
                val businessFunctions: BusinessFunctions
            ) {
                data class BusinessFunctions(
                    val jobTitle: String, // AC.parties[role=="supplier"].persones.businessFunctions[type=="authority"].jobTitle
                    val documents: Documents
                ) {
                    data class Documents(
                        val title: String // AC.parties[role=="supplier"].persones[*].businessFunctions[type=="authority"].documents[documentType=="regulatoryDocument"]
                    )
                }
            }

            data class Details(
                val bankAccount: BankAccounts
            ) {
                data class BankAccounts(
                    val accountIdentification: String, // AC.parties.[role=="supplier"].details.bankAccounts.accountIdentification.id
                    val identifier: String, // AC.parties.[role=="supplier"].details.bankAccounts.identifier.id
                    val name: String, // AC.parties.[role=="supplier"].details.bankAccounts.bankName
                    val address: Address
                ) {
                    data class Address(
                        val country: String, // AC.parties.[role=="supplier"].details.bankAccounts.address.addressDetails.country.description
                        val region: String, // AC.parties.[role=="supplier"].details.bankAccounts.address.addressDetails.region.description
                        val locality: String, // AC.parties.[role=="supplier"].details.bankAccounts.address.addressDetails.locality.description
                        val streetAddress: String, // AC.parties.[role=="supplier"].details.bankAccounts.address.streetAddress
                        val postalCode: String? // AC.parties.[role=="supplier"].details.bankAccounts.address.postalCode
                    )
                }
            }
        }

        data class AgreedMetrics(
            val ccGenerel_1_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-general].observations[id==cc-general-1-1].measure
            val ccGenerel_1_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-general].observations[id==cc-general-1-2].measure
            val ccGenerel_1_3Measure: String, // AC.contracts[0].agreedMetrics[id==cc-general].observations[id==cc-general-1-3].measure

            val ccBuyer_1_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-buyer].observations[id==cc-buyer-1-1].measure
            val ccBuyer_2_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-buyer].observations[id==cc-buyer-2-1].measure
            val ccBuyer_2_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-buyer].observations[id==cc-buyer-2-2].measure

            val ccTenderer_1_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-1-1].measure
            val ccTenderer_1_6Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-1-6].measure
            val ccTenderer_2_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-2-1].measure
            val ccTenderer_2_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-2-2].measure
            val ccTenderer_2_3Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-2-3].measure
            val ccTenderer_2_4Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-2-4].measure
            val ccTenderer_3_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-3-1].measure
            val ccTenderer_3_2Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-3-2].measure
            val ccTenderer_3_3Measure: String, // AC.contracts[0].agreedMetrics[id==cc-tenderer].observations[id==cc-tenderer-3-3].measure
            val ccSubject_1Measure: String, // AC.contracts[0].agreedMetrics[id==cc-subject].observations[id==cc-subject-1].measure
            val ccSubject_2Measure: String,// AC.contracts[0].agreedMetrics[id==cc-subject].observations[id==cc-subject-2].measure
            val ccSubject_3Measure: String,// AC.contracts[0].agreedMetrics[id==cc-subject].observations[id==cc-subject-3].measure
            val ccSubject_4Measure: String,// AC.contracts[0].agreedMetrics[id==cc-subject].observations[id==cc-subject-4].measure
            val ccSubject_5Measure: String// AC.contracts[0].agreedMetrics[id==cc-subject].observations[id==cc-subject-5].measure

        )
        data class Award(
                val date: String,//AC.awards[relatedLots[0]==AC.tender.lots[0].id].date
                val relatedLot: RelatedLot
        ) {
            data class RelatedLot(
                    val id: String //AC.awards.[relatedLots[0]==AC.tender.lots[0].id].id
            )
        }

        data class Planning(
              val  budgetAllocation: BudgetAllocation

        ) {
            data class BudgetAllocation(
                val period: String,// AC.planning.budget.budgetAllocation[reltedItem:current].period
                val  budgetBreakdownID: String// AC.budget.planning.budgetAllocation[reltedItem:current].budgetBreakdownID
            )
        }
    }

    data class EV(
        val publishDate: String, // EV.publishDate, format - (DD.MM.YYYY)
        val tender: Tender
    ) {
        data class Tender(
            val id: String // EV.tender.id
        )
    }

    data class MS(
        val tender: Tender
    )
    {
        data class Tender(
                val id: String,//MS.tender.id
                val title: String //MS.tender.title
        )
    }

}