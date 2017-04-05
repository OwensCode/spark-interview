# Sample project for interviews

An example project for reading some sample weather station or olympic medal
data.  The intention is to give a simple starting point for a coding exercise
during a technical interview.  The candidate does not necessarily need to
implement everything successfully; it's also useful to see how the troubleshoot
and figure things out.

The project has a Scala and a Java component in case the candidate is more
familiar with one language over the other.  Prefer Scala over Java if possible.

**Note** that the code intentionally does not run on a local machine in it's
current state. This should be an easy fix for a Spark developer. Also note that
the Spark libraries are not marked as "provided" in build.sbt, which means
assembling a jar will not work; just change them to "provided".

Some ideas of tasks to work on with the weather data:

* Read the data into an RDD or a DataFrame. See what the candidate prefers for
  different tasks, and whether they use a CSV library.
* Print the schema from the DataFrame
* Count the number of records
* Get a distinct list of weather station names
* Get the weather station names in all lowercase (or capitalized if in Scala)
* Sort the data by weather station name
* Count of the weather stations per province
* Find the furthest north / south / west / east weather station

Similar exercises could be performed with the Olympic medals.

Other ideas including getting them to run test code, or commenting on how they
could make their code more testable.
