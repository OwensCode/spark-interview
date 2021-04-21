package monme

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf

object RunMeScala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("MonMe")
      .setMaster("local[*]")
      .set("spark.driver.host", "localhost")
      .set("spark.ui.enabled", "false")

    val spark = SparkSession.builder.config(conf).getOrCreate()

    println("Hello World!")

    spark.stop()
  }
}
