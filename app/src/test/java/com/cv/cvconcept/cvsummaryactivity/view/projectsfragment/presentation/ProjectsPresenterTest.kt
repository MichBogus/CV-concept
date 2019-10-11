package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation

import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.domain.ProjectsCvDomainModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.Subject
import org.junit.Test

class ProjectsPresenterTest {

    private val view: ProjectsFragmentMVP.View = mock()
    private val projectsProviderObserver: Subject<ProjectsCvDomainModel> = AsyncSubject.create()

    private val tested = ProjectsPresenter(projectsProviderObserver.hide())

    @Test
    fun shouldShowProjectsList() {
        val expected = ProjectsCvDomainModel(listOf())

        tested.attach(view)

        projectsProviderObserver.onNext(expected)
        projectsProviderObserver.onComplete()

        verify(view).showProjectList(expected.projects)
    }
}