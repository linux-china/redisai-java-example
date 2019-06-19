package org.mvnsearch.demo;

import com.redislabs.redisai.Backend;
import com.redislabs.redisai.Device;
import com.redislabs.redisai.RedisAI;
import org.junit.jupiter.api.Test;

/**
 * Redis AI test
 *
 * @author linux_china
 */
public class RedisAITest {

    @Test
    public void testOperation() {
        RedisAI client = new RedisAI("localhost", 6379);
        client.setModel("model", Backend.TF, Device.CPU, new String[]{"a", "b"}, new String[]{"mul"}, "/Users/linux_china/github/linux_china/redisai-java-example/src/test/resources/graph.pb");

        client.setTensor("a", new float[]{2, 3}, new int[]{2});
        client.setTensor("b", new float[]{2, 3}, new int[]{2});

        client.runModel("model", new String[]{"a", "b"}, new String[]{"c"});
    }
}
