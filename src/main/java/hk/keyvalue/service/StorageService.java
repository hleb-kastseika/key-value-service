package hk.keyvalue.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class StorageService {
    private static final String HASH_NAME = "hash";
    private HashOperations hashOperations;

    public StorageService(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(String key, String value) {
        hashOperations.put(HASH_NAME, key, value);
    }

    public String get(String key) {
        return Objects.toString(hashOperations.get(HASH_NAME, key), null);
    }
}
