package com.cv.cvconcept.cvsummaryactivity.presentation

import com.cv.cvconcept.basedi.module.SchedulerModule.SchedulerIO
import com.cv.cvconcept.basedi.module.SchedulerModule.SchedulerUI
import com.cv.cvconcept.cvrepository.model.CV
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.MainDetailsProvider
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.ProjectsProvider
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.SkillsProvider
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.WorkHistoryProvider
import com.cv.cvconcept.cvsummaryactivity.domain.CvSummaryInteractor
import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.domain.ProjectsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.domain.SkillsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.domain.WorkHistoryCvDomainModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.Subject
import javax.inject.Inject

class CvSummaryPresenter
@Inject constructor(private val interactor: CvSummaryInteractor,
                    @SchedulerIO private val schedulerIO: Scheduler,
                    @MainDetailsProvider private val mainDetailsProviderObserver: Subject<MainDetailsCvDomainModel>,
                    @ProjectsProvider private val projectsProviderObserver: Subject<ProjectsCvDomainModel>,
                    @SkillsProvider private val skillsProviderObserver: Subject<SkillsCvDomainModel>,
                    @WorkHistoryProvider private val workHistoryProviderObserver: Subject<WorkHistoryCvDomainModel>) : CvSummaryActivityMVP.Presenter {

    private var view: CvSummaryActivityMVP.View? = null
    private val compositeDisposable = CompositeDisposable()
    private lateinit var currentCv: CV

    override fun attach(view: CvSummaryActivityMVP.View, cvId: Long) {
        this.view = view

        getCv(cvId)
    }

    private fun getCv(cvId: Long) {
        compositeDisposable.add(interactor.getCvById(cvId)
                                        .subscribeOn(schedulerIO)
                                        .subscribe({
                                                       currentCv = it

                                                       postMainDetailsData()
                                                       postProjectsData()
                                                       postSkillsData()
                                                       postWorkHistoryData()
                                                   }, {}))
    }

    private fun postMainDetailsData() {
        mainDetailsProviderObserver.onNext(MainDetailsCvDomainModel.convertFromCvToDomainModel(currentCv))
        mainDetailsProviderObserver.onComplete()
    }

    private fun postProjectsData() {
        projectsProviderObserver.onNext(ProjectsCvDomainModel(currentCv.projects))
        projectsProviderObserver.onComplete()
    }

    private fun postSkillsData() {
        skillsProviderObserver.onNext(SkillsCvDomainModel(currentCv.skills))
        skillsProviderObserver.onComplete()
    }

    private fun postWorkHistoryData() {
        workHistoryProviderObserver.onNext(WorkHistoryCvDomainModel(currentCv.workHistory))
        workHistoryProviderObserver.onComplete()
    }

    override fun detach() {
        view = null
    }
}