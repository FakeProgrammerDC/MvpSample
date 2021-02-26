package com.example.mvpsample.data.task;

import com.example.mvpsample.bean.Task;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class TasksLocalDataSource implements TasksDataSource {

    private static TasksLocalDataSource INSTANCE;

    public static TasksLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TasksLocalDataSource();
        }
        return INSTANCE;
    }

    private TasksLocalDataSource() {
    }

    @Override
    public Flowable<List<Task>> getTasks() {
        return null;
    }
}
