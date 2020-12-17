package com.example.demo.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Proxy(lazy = false)
@Entity
@Table(name = "sku_price")
public class SkuPrice
{
    @Id
    private String id;

    private String skuId;

    private String price;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setSkuId(String skuId)
    {
        this.skuId = skuId;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }
}
