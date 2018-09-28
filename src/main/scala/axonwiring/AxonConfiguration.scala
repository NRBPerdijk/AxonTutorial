package axonwiring

import axonwiring.aggregates.BankAccountAggregate
import org.axonframework.config.{Configuration, DefaultConfigurer}
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine

object AxonConfiguration {

  def configuration(): Configuration = {
    DefaultConfigurer.defaultConfiguration()
      //Axon defaults to Aggregates that are based on Events, we need to provide an EventStore to store those Events in.
      //For now we just use InMemory storage, which means all event information will be gone if the application reboots.
      .configureEventStore(c => new EmbeddedEventStore(new InMemoryEventStorageEngine))
      //Axon needs to know which classes contain Axon annotations for Aggregates. You could do this with Spring's classpath scanning,
      //but if you don't know precisely what you're doing, it is quite likely your aggregates won't be found.
      //Luckily you can just tell Axon which classes to investigate and you could argue that it is much clearer and cleaner too. :-)
      .configureAggregate(classOf[BankAccountAggregate])
      .buildConfiguration()
  }


}