# Spring-Boot and Infinispan in Client/Server mode, JMX error reproducer

The project is using Infinispan in Client/Server mode and Spring-Boot.
Using the [Infispan Spring-Boot starter] (https://github.com/infinispan/infinispan-spring-boot/)

Run the Infinispan Server with docker:
```docker run -it -p 11222:11222 jboss/infinispan-server:latest```

Run Spring-Boot application: 
```mvn spring-boot:run```

You will get the following exception, avoidable setting the ```spring.jmx.enabled=false```

```
org.springframework.jmx.export.UnableToRegisterMBeanException: Unable to register MBean [org.infinispan.client.hotrod.RemoteCacheManager@233c942] with key 'remoteCacheManager'; nested exception is javax.management.InstanceAlreadyExistsException: MXBean already registered with name org.infinispan:type=HotRodClient,name=Default
        at org.springframework.jmx.export.MBeanExporter.registerBeanNameOrInstance(MBeanExporter.java:625) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.jmx.export.MBeanExporter.lambda$registerBeans$2(MBeanExporter.java:551) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at java.base/java.util.HashMap.forEach(HashMap.java:1336) ~[na:na]
        at org.springframework.jmx.export.MBeanExporter.registerBeans(MBeanExporter.java:551) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.jmx.export.MBeanExporter.afterSingletonsInstantiated(MBeanExporter.java:434) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:866) ~[spring-beans-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:877) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:549) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:775) ~[spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) ~[spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
        at org.springframework.boot.builder.SpringApplicationBuilder.run(SpringApplicationBuilder.java:139) ~[spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
        at org.infinispan.jmx.JmxRemoteInfinispan.main(JmxRemoteInfinispan.java:12) ~[classes/:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
        at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run(AbstractRunMojo.java:558) ~[na:na]
        at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: javax.management.InstanceAlreadyExistsException: MXBean already registered with name org.infinispan:type=HotRodClient,name=Default
        at java.management/com.sun.jmx.mbeanserver.MXBeanLookup.addReference(MXBeanLookup.java:151) ~[na:na]
        at java.management/com.sun.jmx.mbeanserver.MXBeanSupport.register(MXBeanSupport.java:160) ~[na:na]
        at java.management/com.sun.jmx.mbeanserver.MBeanSupport.preRegister2(MBeanSupport.java:173) ~[na:na]
        at java.management/com.sun.jmx.interceptor.DefaultMBeanServerInterceptor.registerDynamicMBean(DefaultMBeanServerInterceptor.java:919) ~[na:na]
        at java.management/com.sun.jmx.interceptor.DefaultMBeanServerInterceptor.registerObject(DefaultMBeanServerInterceptor.java:890) ~[na:na]
        at java.management/com.sun.jmx.interceptor.DefaultMBeanServerInterceptor.registerMBean(DefaultMBeanServerInterceptor.java:320) ~[na:na]
        at java.management/com.sun.jmx.mbeanserver.JmxMBeanServer.registerMBean(JmxMBeanServer.java:522) ~[na:na]
        at org.springframework.jmx.support.MBeanRegistrationSupport.doRegister(MBeanRegistrationSupport.java:137) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.jmx.export.MBeanExporter.registerBeanInstance(MBeanExporter.java:671) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        at org.springframework.jmx.export.MBeanExporter.registerBeanNameOrInstance(MBeanExporter.java:615) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
        ... 18 common frames omitted


```
