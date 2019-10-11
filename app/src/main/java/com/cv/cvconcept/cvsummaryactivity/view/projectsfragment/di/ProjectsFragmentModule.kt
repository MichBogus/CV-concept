package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.di

import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation.ProjectsFragmentMVP
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation.ProjectsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ProjectsFragmentModule {

    @Binds
    abstract fun bindPresenter(presenter: ProjectsPresenter): ProjectsFragmentMVP.Presenter
}