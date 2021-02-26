package com.example.mvpsample.base;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    public int code;
    public String message;
    public T data;

    public boolean isSuccess() {
        return code == 200;
    }

}
