package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation

import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.domain.SkillsCvDomainModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.Subject
import org.junit.Test

class SkillsPresenterTest {

    private val view: SkillsFragmentMVP.View = mock()
    private val skillsProviderObserver: Subject<SkillsCvDomainModel> = AsyncSubject.create()

    private val tested = SkillsPresenter(skillsProviderObserver.hide())

    @Test
    fun shouldShowSkillList() {
        val expected = SkillsCvDomainModel(listOf())

        tested.attach(view)

        skillsProviderObserver.onNext(expected)
        skillsProviderObserver.onComplete()

        verify(view).showList(expected.skills)
    }
}