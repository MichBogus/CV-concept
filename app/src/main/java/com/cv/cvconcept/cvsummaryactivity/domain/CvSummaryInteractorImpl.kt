package com.cv.cvconcept.cvsummaryactivity.domain

import com.cv.cvconcept.cvrepository.CvRepository
import com.cv.cvconcept.cvrepository.model.CV
import io.reactivex.Single
import java.lang.IllegalStateException
import javax.inject.Inject

class CvSummaryInteractorImpl
@Inject constructor(private val repository: CvRepository) : CvSummaryInteractor {

    override fun getCvById(id: Long): Single<CV> =
            Single.create { emitter ->
                emitter.onSuccess(repository.getCVs().listOfCvs.find { it.id == id } ?: throw IllegalStateException("there is no such CV"))
            }
}