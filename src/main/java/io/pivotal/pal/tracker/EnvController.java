package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memLimit;
    String insIndex;
    String indAddr;

    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}") String memLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String insIndex, @Value("${CF_INSTANCE_ADDR:NOT SET}") String indAddr) {
        this.port = port;
        this.memLimit = memLimit;
        this.insIndex = insIndex;
        this.indAddr = indAddr;
    }
    @RequestMapping("/env")
    public Map<String, String> getEnv()
     {
         Map<String, String> env = new HashMap<String, String>();
         env.put("PORT", port);
         env.put("MEMORY_LIMIT", memLimit);
         env.put("CF_INSTANCE_INDEX", insIndex);
         env.put("CF_INSTANCE_ADDR", indAddr);
         return env;
     }
}
