package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation

import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.domain.WorkHistoryCvDomainModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.Subject
import org.junit.Test

class WorkHistoryPresenterTest {

    private val view: WorkHistoryFragmentMVP.View = mock()
    private val workHistoryProviderObserver: Subject<WorkHistoryCvDomainModel> = AsyncSubject.create()

    private val tested = WorkHistoryPresenter(workHistoryProviderObserver.hide())

    @Test
    fun shouldShowWorkHistoryList() {
        val expected = WorkHistoryCvDomainModel(listOf())

        tested.attach(view)

        workHistoryProviderObserver.onNext(expected)
        workHistoryProviderObserver.onComplete()

        verify(view).showWorkHistoryList(expected.workHistory)
    }
}