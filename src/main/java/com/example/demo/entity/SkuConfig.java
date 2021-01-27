package com.example.demo.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Proxy(lazy = false)
@Entity
@Table(name = "sku_config")
public class SkuConfig
{
    @Id
    private String skuId;

    private String status;

    public String getSkuId()
    {
        return skuId;
    }

    public void setSkuId(String skuId)
    {
        this.skuId = skuId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
