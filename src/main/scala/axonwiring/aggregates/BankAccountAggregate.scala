package axonwiring.aggregates

import java.util.UUID

import org.axonframework.commandhandling.model.AggregateIdentifier


class BankAccountAggregate() {

  /*
   * Due to the way event sourcing works with Axon, the aggregateidentifier MUST be mutable (which is why we explicitly define it as a var):
   * Axon needs to be able to create a new aggregate from the EventStream, which means it first instantiates an empty instance
   * of the aggregate, before it starts adding the information contained in the Events. Yes, it is possible to extend Axon functionality
   * with custom aggregate instantiation, so you can implement your own immutable identifier, but that goes beyond the scope of this example
   * project.
   */
  @AggregateIdentifier
  var backAccountNumber: UUID = _


}
