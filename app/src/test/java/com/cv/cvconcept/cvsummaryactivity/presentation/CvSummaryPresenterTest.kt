package com.cv.cvconcept.cvsummaryactivity.presentation

import com.cv.cvconcept.cvrepository.model.CV
import com.cv.cvconcept.cvrepository.model.CvEducation
import com.cv.cvconcept.cvrepository.model.CvProject
import com.cv.cvconcept.cvrepository.model.CvSkill
import com.cv.cvconcept.cvrepository.model.CvWorkHistory
import com.cv.cvconcept.cvsummaryactivity.domain.CvSummaryInteractor
import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.domain.ProjectsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.domain.SkillsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.domain.WorkHistoryCvDomainModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject
import org.junit.Test

class CvSummaryPresenterTest {

    private val interactor: CvSummaryInteractor = mock()
    private val view: CvSummaryActivityMVP.View = mock()
    private val mainDetailsProviderObserver: Subject<MainDetailsCvDomainModel> = mock()
    private val projectsProviderObserver: Subject<ProjectsCvDomainModel> = mock()
    private val skillsProviderObserver: Subject<SkillsCvDomainModel> = mock()
    private val workHistoryProviderObserver: Subject<WorkHistoryCvDomainModel> = mock()

    private val tested = CvSummaryPresenter(interactor,
                                            Schedulers.trampoline(),
                                            mainDetailsProviderObserver,
                                            projectsProviderObserver,
                                            skillsProviderObserver,
                                            workHistoryProviderObserver)

    @Test
    fun shouldSendAllDataToProviders() {
        whenever(interactor.getCvById(1)).thenReturn(Single.just(CV(1,
                                                                    "",
                                                                    "",
                                                                    "",
                                                                    "",
                                                                    "",
                                                                    "",
                                                                    "",
                                                                    "",
                                                                    listOf(CvEducation("", "", "", "")),
                                                                    listOf(CvWorkHistory("", "", "" ,"" ,"")),
                                                                    listOf(CvSkill("")),
                                                                    listOf(CvProject("", "", "")))))

        tested.attach(view, 1)

        verify(mainDetailsProviderObserver).onNext(any())
        verify(projectsProviderObserver).onNext(any())
        verify(skillsProviderObserver).onNext(any())
        verify(workHistoryProviderObserver).onNext(any())
    }
}