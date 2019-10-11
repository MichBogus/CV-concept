package com.cv.cvconcept.cvsummaryactivity.domain

import com.cv.cvconcept.cvrepository.model.CV
import io.reactivex.Single

interface CvSummaryInteractor {

    fun getCvById(id: Long): Single<CV>
}