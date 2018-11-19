package com.procurement.docs.model.services

class ServicesContext(
    val ac: AC,
    val ev: EV
) {
    data class AC(
        val date: String, // AC.date, format - (DD.MM.YYYY)
        val contract: Contract,
        val tender: Tender,
        val buyer: Buyer,
        val supplier: Supplier,
        val agreedMetrics: AgreedMetrics,
        val milestones: Milestones
    ) {
        data class Contract(
            val id: String, // AC.contracts[0].id
            val description: String, // AC.contracts[0].description,
            val value: Double, // AC.contracts[0].value.amount
            val endDate: String // AC.contract.period.endDate
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
            val persones: Persones,
            val details: Details
        ) {
            data class Address(
                val country: String, // AC.parties[role=="buyer"].address.addressDetails.country.description
                val region: String, // AC.parties[role=="buyer"].address.addressDetails.region.description
                val locality: String, // AC.parties[role=="buyer"].address.addressDetails.locality.description
                val streetAddress: String, // AC.parties[role=="buyer"].address.streetAddress
                val postalCode: String // AC.parties[role=="buyer"].address.postalCode
            )

            data class LegalForm(
                val description: String // AC.parties[role=="buyer"].legalForm.description
            )

            data class Identifier(
                val id: String, // AC.parties[role=="buyer"].identifier.id
                val legalName: String // AC.parties[role=="buyer"].identifier.legalName
            )

            data class AdditionalIdentifier(
                val scheme: String // AC.parties.[role=="buyer"].additionalidentifieres[scheme=="MD-FISCAL"].id
            )

            data class ContactPoint(
                val telephone: String // AC.parties.[role=="buyer"].contactPoint.telephone
            )

            data class Persones(
                val title: String, // AC.parties[role=="buyer"].persones.title
                val name: String, // AC.parties[role=="buyer"].persones.name
                val businessFunctions: BusinessFunctions
            ) {
                data class BusinessFunctions(
                    val jobTitle: String // AC.parties[role=="buyer"].persones.businessFunctions[type=="authority"].jobTitle
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
                        val postalCode: String // AC.parties.[role=="buyer"].details.bankAccounts.address.postalCode
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
            val persones: Persones,
            val details: Details
        ) {
            data class Address(
                val country: String, // AC.parties[role=="supplier"].address.addressDetails.country.description
                val region: String, // AC.parties[role=="supplier"].address.addressDetails.region.description
                val locality: String, // AC.parties[role=="supplier"].address.addressDetails.locality.description
                val streetAddress: String, // AC.parties[role=="supplier"].address.streetAddress
                val postalCode: String // AC.parties[role=="supplier"].address.postalCode
            )

            data class LegalForm(
                val description: String // AC.parties[role=="supplier"].legalForm.description
            )

            data class Identifier(
                val id: String, // AC.parties[role=="supplier"].identifier.id
                val legalName: String // AC.parties[role=="supplier"].identifier.legalName
            )

            data class AdditionalIdentifier(
                val scheme: String // AC.parties.[role=="supplier"].additionalidentifieres[scheme=="MD-FISCAL"].id
            )

            data class ContactPoint(
                val telephone: String // AC.parties.[role=="supplier"].contactPoint.telephone
            )

            data class Persones(
                val title: String, // AC.parties[role=="supplier"].persones.title
                val name: String, // AC.parties[role=="supplier"].persones.name
                val businessFunctions: BusinessFunctions
            ) {
                data class BusinessFunctions(
                    val jobTitle: String, // AC.parties[role=="supplier"].persones.businessFunctions[type=="authority"].jobTitle
                    val documents: Documents
                ) {
                    data class Documents(
                        val title: String // AC.parties[role=="supplier"].persones.businessFunctions[type=="authority"].documents[type=="regulatoryDocument"]
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
                        val postalCode: String // AC.parties.[role=="supplier"].details.bankAccounts.address.postalCode
                    )
                }
            }
        }

        data class AgreedMetrics(
            val ccGenerel_1_1Measure: String, // AC.agreedMetrics.cc-generel-1-1.measure
            val ccGenerel_1_2Measure: String, // AC.agreedMetrics.cc-generel-1-2.measure

            val ccGenerel_1_3Measure: String, // AC.agreedMetrics.cc-generel-1-3.measure

            val ccBuyer_1_1Measure: String, // AC.agreedMetrics.cc-buyer-1-1.measure
            val ccBuyer_2_1Measure: String, // AC.agreedMetrics.cc-buyer-2-1.measure
            val ccBuyer_2_2Measure: String, // AC.agreedMetrics.cc-buyer-2-2.measure

            val ccTenderer_1_1Measure: String, // AC.agreedMetrics.cc-tenderer-1-1.measure
            val ccTenderer_1_6Measure: String, // AC.agreedMetrics.cc-tenderer-1-6.measure
            val ccTenderer_2_1Measure: String, // AC.agreedMetrics.cc-tenderer-2-1.measure
            val ccTenderer_2_2Measure: String, // AC.agreedMetrics.cc-tenderer-2-2.measure
            val ccTenderer_2_3Measure: String, // AC.agreedMetrics.cc-tenderer-2-3.measure
            val ccTenderer_2_4Measure: String, // AC.agreedMetrics.cc-tenderer-2-4.measure
            val ccTenderer_3_1Measure: String, // AC.agreedMetrics.cc-tenderer-3-1.measure
            val ccTenderer_3_2Measure: String, // AC.agreedMetrics.cc-tenderer-3-2.measure
            val ccTenderer_3_3Measure: String // AC.agreedMetrics.cc-tenderer-3-3.measure
        )

        data class Milestones(
            val approval_2DateMet: String // AC.contract.milestones.[id=="approval-2"].dateMet
        )
    }

    data class EV(
        val publishDate: String, // EV.publishDate, format - (DD.MM.YYYY)
        val tender: Tender,
        val award: Award
    ) {
        data class Tender(
            val id: String // EV.tender.id
        )

        data class Award(
            val date: String // EV.awards[relatedLot==AC.tender.lots[0].id].date
        )
    }

}