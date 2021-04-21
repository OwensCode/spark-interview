package monme

import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.funsuite.AnyFunSuite

class SampleTest extends AnyFunSuite with SharedSparkContext {
  test("test initializing spark context") {
    val list = List(1, 2, 3, 4)
    val rdd = sc.parallelize(list)
    assert(rdd.count === list.length)
  }
}
