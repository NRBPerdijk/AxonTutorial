# AxonTutorial

This is an example project for the Axon Framework. It is built using Scala, which has some major advantages over Java when
dealing with Event Sourcing in particular. In order to make clear what functionality is Axon specific, rather than Spring(Boot) magic,
none of the Axon integration with Spring is used and Spring is not even a dependency.

Why Scala:
Axon is a CQRS/Event Sourcing framework. Which means that Events are at the very core of your domain. 
This means you will be using a lot of classes that are basically just data objects. Java standards require a lot of boilerplate for
those kind of classes, while this is something where the Scala `case class` really shines.
Another important aspect of EventSourcing is that your Events are supposed to be immutable: they are a record of your actual application
history. This means that you should be prevented from accidentally (or purposely) altering them when you retrieve them from storage.
(This is a very real issue when you use an ORM such as Hibernate). Scala case classes, as pretty much anything else in Scala,
are immutable by default, meaning you can't change your events by accident.

Why not use the Axon Spring integration?
Spring uses a lot of annotations to perform a lot of magic that is intended to make the life of a programmer easier. 
When learning a new framework that isn't Spring, Spring can be quite a barrier to understanding the subject, expecially if the subject
has its own annotations (which is the case with Axon Framework). A lot of configuration and wiring can be handled by Spring implicitly
which means a simple error in your Spring wiring can result in your application not working as expected, with very hard to debug errors
(if you receive any errors at all) that really detract from the subject matter. 
Besides, Axon is not that hard to configure without Spring and you'll understand more of what is going on.
