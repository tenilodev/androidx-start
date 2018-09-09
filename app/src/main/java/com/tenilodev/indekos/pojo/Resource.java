package com.tenilodev.indekos.pojo;

/**
 * Created by azisa on 1/11/2018.
 */

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.tenilodev.indekos.pojo.Status.ERROR;
import static com.tenilodev.indekos.pojo.Status.LOADING;
import static com.tenilodev.indekos.pojo.Status.SUCCESS;


/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
 */
public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    @Nullable
    public Throwable throwable;

    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message, @Nullable Throwable throwable) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.throwable = throwable;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data, @Nullable Throwable err) {
        return new Resource<>(ERROR, data, msg, err);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resource<?> resource = (Resource<?>) o;

        if (status != resource.status) {
            return false;
        }
        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public void addOnResultListener(OnResultListener<Resource<T>> resultListener) {
        if (this.status == SUCCESS) {
            resultListener.onSuccess(this);
        } else if (this.status == ERROR) {
            resultListener.onError(this.message, this.throwable);
        }

        if (this.status == LOADING)
            resultListener.onLoading(true);
        else
            resultListener.onLoading(false);
    }

    public interface OnResultListener<T> {
        void onSuccess(T data);

        void onError(String message, Throwable throwable);

        void onLoading(boolean isLoading);
    }
}
