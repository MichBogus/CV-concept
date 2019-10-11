package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.di

import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation.MainDetailsFragmentMVP
import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation.MainDetailsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainDetailsFragmentModule {

    @Binds
    abstract fun bindPresenter(presenter: MainDetailsPresenter): MainDetailsFragmentMVP.Presenter
}