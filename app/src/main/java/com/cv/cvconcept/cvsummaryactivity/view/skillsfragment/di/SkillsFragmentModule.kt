package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.di

import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation.SkillsFragmentMVP
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation.SkillsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SkillsFragmentModule {

    @Binds
    abstract fun bindPresenter(presenter: SkillsPresenter): SkillsFragmentMVP.Presenter
}