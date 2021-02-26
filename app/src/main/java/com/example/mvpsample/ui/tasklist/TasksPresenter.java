package com.example.mvpsample.ui.tasklist;

import com.example.mvpsample.data.task.TasksDataSource;
import com.example.mvpsample.data.task.TasksRepository;
import com.example.mvpsample.utils.schedulers.BaseSchedulerProvider;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

import static com.google.common.base.Preconditions.checkNotNull;

public class TasksPresenter implements TasksContract.Presenter {

    private BaseSchedulerProvider mSchedulerProvider;

    private TasksRepository mTasksRepository;

    private TasksContract.View mTasksView;

    private CompositeDisposable mCompositeDisposable;

    private boolean mFirstLoad;

    public TasksPresenter(TasksRepository tasksRepository, TasksContract.View tasksView, BaseSchedulerProvider baseSchedulerProvider) {
        mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null");
        mTasksView = checkNotNull(tasksView, "tasksView cannot be null!");
        mSchedulerProvider = checkNotNull(baseSchedulerProvider, "baseSchedulerProvider cannot be null");
        mCompositeDisposable =new CompositeDisposable();
        //mTasksView.setPresenter(this);
    }

    @Override
    public void loadTasks(boolean forceUpdate) {
        //Simplification for sample: a network reload will be forced on first load.
        loadTasks(false, false);
        mFirstLoad = false;
    }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link TasksDataSource}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadTasks(boolean forceUpdate, boolean showLoadingUI) {
        if (showLoadingUI) {
            //显示加载中view
        }
        if (forceUpdate) {

        }

        mCompositeDisposable.clear();
        //Disposable disposable = mTasksRepository
    }


}
