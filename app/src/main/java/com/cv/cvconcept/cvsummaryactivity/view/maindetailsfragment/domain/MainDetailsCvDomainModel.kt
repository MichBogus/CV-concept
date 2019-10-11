package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain

import com.cv.cvconcept.cvrepository.model.CV
import com.cv.cvconcept.cvrepository.model.CvEducation

data class MainDetailsCvDomainModel(val id: Long,
                                    val name: String,
                                    val surname: String,
                                    val phone: String,
                                    val email: String,
                                    val address: String,
                                    val zipCode: String,
                                    val city: String,
                                    val quickSummary: String,
                                    val education: List<CvEducation>) {

    companion object {
        fun convertFromCvToDomainModel(cv: CV) = MainDetailsCvDomainModel(cv.id,
                                                                          cv.name,
                                                                          cv.surname,
                                                                          cv.phone,
                                                                          cv.email,
                                                                          cv.address,
                                                                          cv.zipCode,
                                                                          cv.city,
                                                                          cv.quickSummary,
                                                                          cv.education)
    }
}