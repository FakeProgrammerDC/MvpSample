package com.example.mvpsample.ui.tasklist;


import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.mvpsample.R;
import com.example.mvpsample.bean.Task;
import com.google.common.base.Preconditions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TasksAdapter extends BaseQuickAdapter<Task,BaseViewHolder> {

    private List<Task> mTasks;


    public TasksAdapter(List<Task> tasks) {
        super(R.layout.task_item,tasks);
        setList(tasks);
    }

    public void replaceData(List<Task> tasks) {
        setList(tasks);
        notifyDataSetChanged();
    }

    private void setList(List<Task> tasks){
        mTasks = Preconditions.checkNotNull(tasks);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Task task) {
        TextView titleTV=holder.getView(R.id.title);
        CheckBox completeCB=holder.getView(R.id.complete);
        titleTV.setText(task.getTitleForList());
        // Active/completed task UI
        completeCB.setChecked(task.isCompleted());
        if (task.isCompleted()) {
            holder.itemView.setBackground(getContext()
                    .getResources().getDrawable(R.drawable.list_completed_touch_feedback));
        } else {
            holder.itemView.setBackground(getContext()
                    .getResources().getDrawable(R.drawable.touch_feedback));
        }
    }


}
