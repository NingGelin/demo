package com.example.demo.model;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable
{
    private Boolean success;
    private T result;
    private String resultMessage;
    private Integer resultCode;

    public ApiResponse()
    {
        this.success = true;
        this.result = null;
        this.resultMessage = "执行成功";
        this.resultCode = 0;
    }

    public ApiResponse(T data)
    {
        this.success = true;
        this.result = data;
        this.resultMessage = "执行成功";
        this.resultCode = 0;
    }

    public ApiResponse(Boolean success, String resultMessage, Integer resultCode)
    {
        this.success = success;
        this.result = null;
        this.resultMessage = resultMessage;
        this.resultCode = resultCode;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }

    public String getResultMessage()
    {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage)
    {
        this.resultMessage = resultMessage;
    }

    public Integer getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(Integer resultCode)
    {
        this.resultCode = resultCode;
    }
}
