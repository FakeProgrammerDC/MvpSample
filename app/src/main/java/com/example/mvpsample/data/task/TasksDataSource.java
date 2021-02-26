package com.example.mvpsample.data.task;

import com.example.mvpsample.bean.Task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Flowable;

public interface TasksDataSource {

    Flowable<List<Task>> getTasks();

}
