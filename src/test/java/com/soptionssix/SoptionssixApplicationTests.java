package com.soptionssix;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    properties = {
        "jwt.secret=Ym95c29uIHNvcHRpb25zIHNpeCBqd3QgdGVzdCBzZWNyZXQga2V5",
        "jwt.token-validity-in-seconds=86400"
    }
)
class SoptionssixApplicationTests {

    @Test
    void contextLoads() {
        // 1
        // 2
        // 3
        // 4
    }

}
