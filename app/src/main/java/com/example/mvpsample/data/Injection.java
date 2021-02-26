package com.example.mvpsample.data;

import android.content.Context;

import com.example.mvpsample.data.demo.DemoLocalDataSource;
import com.example.mvpsample.data.demo.DemoRemoteDataSource;
import com.example.mvpsample.data.demo.DemoRepository;
import com.example.mvpsample.data.task.TasksDataSource;
import com.example.mvpsample.data.task.TasksLocalDataSource;
import com.example.mvpsample.data.task.TasksRemoteDataSource;
import com.example.mvpsample.data.task.TasksRepository;
import com.example.mvpsample.utils.schedulers.BaseSchedulerProvider;
import com.example.mvpsample.utils.schedulers.SchedulerProvider;
import com.google.common.base.Preconditions;

/**
 * Enables injection of mock implementations for
 * {@link TasksDataSource} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

    public static TasksRepository provideTasksRepository(Context context){
        Preconditions.checkNotNull(context);
        return TasksRepository.getInstance(TasksRemoteDataSource.getInstance(), TasksLocalDataSource.getInstance());
    }

    public static DemoRepository provideDemoRepository(Context context){
        Preconditions.checkNotNull(context);
        return DemoRepository.getInstance(DemoRemoteDataSource.getInstance(), DemoLocalDataSource.getInstance());
    }

    public static BaseSchedulerProvider providerSchedulerProvider(){
        return SchedulerProvider.getInstance();
    }
}
