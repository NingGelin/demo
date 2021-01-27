package com.example.demo.dao;

import com.example.demo.entity.SkuConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuConfigRepository extends JpaRepository<SkuConfig, String>
{
    SkuConfig findBySkuId(String skuId);
}
