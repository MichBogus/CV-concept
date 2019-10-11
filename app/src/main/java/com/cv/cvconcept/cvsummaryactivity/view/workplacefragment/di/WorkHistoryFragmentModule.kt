package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.di

import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation.WorkHistoryFragmentMVP
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation.WorkHistoryPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class WorkHistoryFragmentModule {

    @Binds
    abstract fun bindPresenter(presenter: WorkHistoryPresenter): WorkHistoryFragmentMVP.Presenter
}