package com.sevenlearn.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> tasks = new ArrayList<>();
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
//        holder.bindTask(tasks.get(position));
    }

    public void addItem(Task task) {
        tasks.add(0, task);
        notifyItemInserted(0);
    }

    public void updateItem(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getId() == tasks.get(i).getId()) {
                tasks.set(i, task);
                notifyItemChanged(i);
            }
        }
    }

    public void addItems(List<Task> tasks) {
        this.tasks.addAll(tasks);
        notifyDataSetChanged();
    }

    public void deleteItem(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }

    public void clearItems() {
        this.tasks.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private ImageView checkBoxIv;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.taskCheckBox);
            checkBoxIv = itemView.findViewById(R.id.checkBoxIv);
        }

        public void bindTask(final Task task) {
            titleTv.setText(task.getTitle());
            if (task.isCompleted()) {
                checkBoxIv.setBackgroundResource(R.drawable.shape_checkbox_checked);
                checkBoxIv.setImageResource(R.drawable.ic_check_white_24dp);
            } else {
                checkBoxIv.setImageResource(0);
                checkBoxIv.setBackgroundResource(R.drawable.shape_checkbox_default);
            }



        }
    }



}
