# eshop-services-spring

# **Documentation Resources**

## Event Sourcing and CQRS

https://www.baeldung.com/cqrs-event-sourcing-java

Good intro about the two topics, but the examples are very simple, not connected and cannot be used ina real project.

https://www.baeldung.com/axon-cqrs-event-sourcing

Explains how the Axon

https://www.baeldung.com/spring-data-ddd

Domain driven event publishing from a service or an aggegate.
The article only explains the publishing part not the listening part

https://www.baeldung.com/spring-events

Domain driven events handled through Spring syncrnously and asyncronously using an ApplicationEventListener

https://www.baeldung.com/spring-async#enable-async-support

How to use the @Async annotation in Spring


https://www.baeldung.com/spring-boot-logging

How to enable logging in Java Spring

# **Troubleshooting**

-   Faced an issue when adding the Axon dependency to the pom.xml

    The issue was that I was missing the 'version' element for that dependency

# **Support Services**

Running Axon Service

docker run -d --name axon_server -p 8024:8024 -p 8124:8124 -e AXONIQ_AXONSERVER_NAME=ordering_axon_svc axoniq/axonserver