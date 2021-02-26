package com.example.mvpsample.ui.tasklist;

import com.example.mvpsample.base.BasePresenter;
import com.example.mvpsample.base.BaseView;
import com.example.mvpsample.bean.Task;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface TasksContract {

    interface View {
         void showTasks(List<Task> tasks);
    }


    interface Presenter{
        void loadTasks(boolean forceUpdate);
    }
}
