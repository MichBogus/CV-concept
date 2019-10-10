package com.cv.cvconcept.listofcvsactivity.di

import com.cv.cvconcept.cvrepository.CvRepository
import com.cv.cvconcept.cvrepository.CvRepositoryImpl
import com.cv.cvconcept.listofcvsactivity.domain.CvInteractor
import com.cv.cvconcept.listofcvsactivity.domain.CvInteractorImpl
import com.cv.cvconcept.listofcvsactivity.presentation.ListOfCvsActivityMVP
import com.cv.cvconcept.listofcvsactivity.presentation.ListOfCvsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ListOfCvsModule {

    @Binds
    abstract fun bindPresenter(presenter: ListOfCvsPresenter): ListOfCvsActivityMVP.Presenter

    @Binds
    abstract fun bindCvRepository(repository: CvRepositoryImpl): CvRepository

    @Binds
    abstract fun bindCvInteractor(interactor: CvInteractorImpl): CvInteractor
}