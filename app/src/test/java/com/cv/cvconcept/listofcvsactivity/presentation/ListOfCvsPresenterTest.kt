package com.cv.cvconcept.listofcvsactivity.presentation

import com.cv.cvconcept.listofcvsactivity.domain.CvDomain
import com.cv.cvconcept.listofcvsactivity.domain.CvInteractor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class ListOfCvsPresenterTest {

    private val interactorMock: CvInteractor = mock()
    private val viewMock: ListOfCvsActivityMVP.View = mock()

    private val tested = ListOfCvsPresenter(interactorMock, Schedulers.trampoline(), Schedulers.trampoline())

    @Test
    fun shouldShowEmptyListInfo() {
        whenever(interactorMock.getAvailableCvs()).thenReturn(Single.just(emptyList()))

        tested.attach(viewMock)

        verify(viewMock).showEmptyInfo()
    }

    @Test
    fun shouldShowEmptyListBecauseOfError() {
        whenever(interactorMock.getAvailableCvs()).thenReturn(Single.error(IllegalStateException()))

        tested.attach(viewMock)

        verify(viewMock).showEmptyInfo()
    }

    @Test
    fun shouldShowList() {
        val expectedList = listOf(CvDomain(1, "", "", "", ""))
        whenever(interactorMock.getAvailableCvs()).thenReturn(Single.just(expectedList))

        tested.attach(viewMock)

        verify(viewMock).showCvList(expectedList)
    }
}