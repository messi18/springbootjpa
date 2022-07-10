package com.lance.springbootjpa.data.repository;

import com.lance.springbootjpa.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private RedisTemplate myRedisTemplate;
    private static final String HASH_KEY = "Product";
    public Product save(Product product) {
        myRedisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return myRedisTemplate.opsForHash().values(HASH_KEY);
    }
    public Product getById(Long id) {
        return (Product) myRedisTemplate.opsForHash().get(HASH_KEY, id);
    }
    public String removeById(Long id) {
        myRedisTemplate.opsForHash().delete(HASH_KEY, id);
        return "product with id "  + id + "removed";
    }
}

