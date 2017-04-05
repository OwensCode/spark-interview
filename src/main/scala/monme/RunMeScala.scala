package monme

import org.apache.spark.{SparkConf, SparkContext}

object RunMeScala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MonMe").setMaster("local")
    val sc = SparkContext.getOrCreate(conf)

    println("Hello World!")

    sc.stop()
  }
}
