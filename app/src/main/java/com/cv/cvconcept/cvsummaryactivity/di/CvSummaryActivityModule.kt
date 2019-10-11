package com.cv.cvconcept.cvsummaryactivity.di

import com.cv.cvconcept.cvrepository.CvRepository
import com.cv.cvconcept.cvrepository.CvRepositoryImpl
import com.cv.cvconcept.cvsummaryactivity.domain.CvSummaryInteractor
import com.cv.cvconcept.cvsummaryactivity.domain.CvSummaryInteractorImpl
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivityMVP
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CvSummaryActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: CvSummaryPresenter): CvSummaryActivityMVP.Presenter

    @Binds
    abstract fun bindCvRepository(repository: CvRepositoryImpl): CvRepository

    @Binds
    abstract fun bindInteractor(interactor: CvSummaryInteractorImpl): CvSummaryInteractor
}