package monme;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

public class RunMeJava {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("MonMe");
        SparkContext sc = SparkContext.getOrCreate(conf);

        System.out.println("Hello World!");

        sc.stop();
    }
}
