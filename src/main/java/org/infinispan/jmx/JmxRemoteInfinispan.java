package org.infinispan.jmx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JmxRemoteInfinispan {

   public static void main(String... args) {
      new SpringApplicationBuilder().sources(JmxRemoteInfinispan.class).run(args);
   }
}
