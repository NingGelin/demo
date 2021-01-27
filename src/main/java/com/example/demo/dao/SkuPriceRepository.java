package com.example.demo.dao;

import com.example.demo.entity.SkuPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuPriceRepository extends JpaRepository<SkuPrice, String>
{
    SkuPrice findBySkuId(String skuId);
    List<SkuPrice> findByPrice(String skuPrice);
}
