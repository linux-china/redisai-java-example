package org.mvnsearch.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Redis test
 *
 * @author linux_china
 */
public class RedisTest {
    private Jedis jedis;

    @BeforeAll
    public void setUp() {
        this.jedis = new Jedis("localhost");
    }

    @AfterAll
    public void tearDown() {
        this.jedis.close();
    }

    @Test
    public void testSet() {
        jedis.set("hello", "你好");
        assertThat(jedis.get("hello")).isEqualTo("你好");
    }
}
