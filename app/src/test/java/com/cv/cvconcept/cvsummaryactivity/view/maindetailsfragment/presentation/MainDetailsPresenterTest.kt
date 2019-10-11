package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation

import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.Subject
import org.junit.Test

class MainDetailsPresenterTest {

    private val mainDetailsProviderObserver: Subject<MainDetailsCvDomainModel> = AsyncSubject.create()
    private val view: MainDetailsFragmentMVP.View = mock()

    private val tested = MainDetailsPresenter(mainDetailsProviderObserver.hide())

    @Test
    fun shouldShowMainDetailsInfo() {
        val expected = MainDetailsCvDomainModel(1,
                                                "a",
                                                "b",
                                                "c",
                                                "d",
                                                "e",
                                                "",
                                                "",
                                                "",
                                                listOf())

        tested.attach(view)

        mainDetailsProviderObserver.onNext(expected)
        mainDetailsProviderObserver.onComplete()

        verify(view).showView(expected)
    }
}