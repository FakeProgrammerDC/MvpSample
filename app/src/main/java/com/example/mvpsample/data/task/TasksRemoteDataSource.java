package com.example.mvpsample.data.task;

import com.example.mvpsample.bean.Task;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class TasksRemoteDataSource implements TasksDataSource {

    private static TasksRemoteDataSource INSTANCE;

    public static TasksRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TasksRemoteDataSource();
        }
        return INSTANCE;
    }

    private TasksRemoteDataSource() {
    }

    @Override
    public Flowable<List<Task>> getTasks() {
        return null;
    }
}
