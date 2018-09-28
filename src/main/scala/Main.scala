import axonwiring.AxonConfiguration

object Main extends App {

  AxonConfiguration.configuration().start() //calling start on a Configuration will tell Axon to get to work. :-)

}