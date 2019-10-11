package com.cv.cvconcept.cvsummaryactivity.di

import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivityMVP
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CvSummaryActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: CvSummaryPresenter): CvSummaryActivityMVP.Presenter
}