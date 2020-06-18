package com.sevenlearn.todo;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
    private long id;
    private String title;
    private boolean isCompleted;
    private int importance=IMPORTANCE_NORMAL;

    private static final int IMPORTANCE_HIGH = 2;
    private static final int IMPORTANCE_NORMAL = 1;
    private static final int IMPORTANCE_LOW = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeByte(this.isCompleted ? (byte) 1 : (byte) 0);
        dest.writeInt(this.importance);
    }

    public Task() {
    }

    protected Task(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.isCompleted = in.readByte() != 0;
        this.importance = in.readInt();
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
