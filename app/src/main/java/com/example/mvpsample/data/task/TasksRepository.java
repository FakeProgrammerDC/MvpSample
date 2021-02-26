package com.example.mvpsample.data.task;

import com.example.mvpsample.bean.Task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Flowable;

public class TasksRepository implements TasksDataSource {

    private static TasksRepository INSTANCE;

    private TasksDataSource mTasksRemoteDataSource;

    private TasksDataSource mTasksLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    private Map<String, Task> mCachedTasks;

    private boolean mCacheIsDirty;

    private TasksRepository(TasksDataSource tasksRemoteDataSource, TasksDataSource tasksLocalDataSource) {
        mTasksLocalDataSource = tasksLocalDataSource;
        mTasksRemoteDataSource = tasksRemoteDataSource;
    }

    public static TasksRepository getInstance(TasksDataSource tasksRemoteDataSource, TasksDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TasksRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public Flowable<List<Task>> getTasks() {
        //Respond immediately with cache if available and not dirty
        if (mCachedTasks != null && mCacheIsDirty) {
            return Flowable.fromIterable(mCachedTasks.values()).toList().toFlowable();
        } else if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        Flowable<List<Task>> remoteTasks = getAndSaveRemoteTasks();

        if (mCacheIsDirty) {
            return remoteTasks;
        } else {

        }

        return null;
    }

    private Flowable<List<Task>> getAndSaveRemoteTasks() {
        return null;
    }
}
