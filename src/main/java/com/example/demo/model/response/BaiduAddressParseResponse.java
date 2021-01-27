package com.example.demo.model.response;

public class BaiduAddressParseResponse<T>
{
    private Integer errno;
    private String msg;
    private T data;

    public Integer getErrno()
    {
        return errno;
    }

    public void setErrno(Integer errno)
    {
        this.errno = errno;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
