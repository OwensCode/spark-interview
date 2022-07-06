package monme;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class RunMeJava {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("MonMe")
                .setMaster("local")
                .set("spark.driver.host", "localhost")
                .set("spark.ui.enabled", "false");
        
        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        System.out.println("Hello World!");

        spark.stop();
    }
}
