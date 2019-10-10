package com.cv.cvconcept.listofcvsactivity.di

import com.cv.cvconcept.listofcvsactivity.presentation.ListOfCvsActivityMVP
import com.cv.cvconcept.listofcvsactivity.presentation.ListOfCvsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ListOfCvsModule {

    @Binds
    abstract fun bindPresenter(presenter: ListOfCvsPresenter): ListOfCvsActivityMVP.Presenter
}