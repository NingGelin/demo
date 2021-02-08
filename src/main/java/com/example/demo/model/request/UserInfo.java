package com.example.demo.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserInfo
{
    @NotNull
    String name;
    @NotBlank(message = "age不能为空")
    String age;
    @NotBlank(message = "sex不能为空")
    String sex;
    @NotEmpty(message = "爱好不能为空")
    List<String> favorList;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public List<String> getFavorList()
    {
        return favorList;
    }

    public void setFavorList(List<String> favorList)
    {
        this.favorList = favorList;
    }

    @Override
    public String toString()
    {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", favorList=" + favorList +
                '}';
    }
}
