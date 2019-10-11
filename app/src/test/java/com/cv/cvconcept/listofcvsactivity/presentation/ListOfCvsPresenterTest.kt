package com.cv.cvconcept.listofcvsactivity.presentation

import com.cv.cvconcept.listofcvsactivity.domain.CvInteractor
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.schedulers.Schedulers

class ListOfCvsPresenterTest {

    private val interactorMock: CvInteractor = mock()

    private val tested = ListOfCvsPresenter(interactorMock, Schedulers.trampoline())
}