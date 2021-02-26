package com.example.mvpsample.ui.tasklist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpsample.R;
import com.example.mvpsample.bean.Task;
import com.example.mvpsample.view.ScrollChildSwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TasksFragment extends Fragment implements TasksContract.View {

    private TasksContract.Presenter mPresenter;

    private TasksAdapter mTasksAdapter;

    @BindView(R.id.tasks_recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.noTasks)
    View mNoTasksView;

    @BindView(R.id.noTasksIcon)
    ImageView mNoTaskIcon;

    @BindView(R.id.noTasksMain)
    TextView mNoTaskMainView;

    @BindView(R.id.noTasksAdd)
    TextView mNoTaskAddView;

    @BindView(R.id.tasksLL)
    LinearLayout mTasksView;

    @BindView(R.id.filteringLabel)
    TextView mFilteringLabelView;

    @BindView(R.id.fab_add_task)
    FloatingActionButton mFloatingActionButton;

    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout mSwipeRefreshLayout;


    public static TasksFragment newInstance() {
        return new TasksFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTasksAdapter = new TasksAdapter(new ArrayList<>(0));
    }

    @Override
    public void onResume() {
        super.onResume();
       // mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        //mPresenter.unSubscribe();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tasks_frag, container, false);
        //set up tasks view
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mTasksAdapter);

        mFloatingActionButton.setImageResource(R.drawable.ic_add);

        // Set up progress indicator
        mSwipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );
        // Set the scrolling view in the custom SwipeRefreshLayout.
        mSwipeRefreshLayout.setScrollUpChild(mRecyclerView);

        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.loadTasks(false));

        setHasOptionsMenu(true);
        return root;
    }

    @OnClick(R.id.fab_add_task)
    void clickAddTask(){

    }

    @Override
    public void showTasks(List<Task> tasks) {

    }

//    @Override
//    public void setPresenter(TasksContract.Presenter presenter) {
//        mPresenter = Preconditions.checkNotNull(presenter);
//    }
}
