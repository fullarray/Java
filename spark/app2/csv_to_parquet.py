import sys

if sys.version >= '3':
    basestring = unicode = str

from py4j.java_gateway import JavaClass

from pyspark import RDD, since
from pyspark import SparkContext
from pyspark.sql import SQLContext
from pyspark.rdd import ignore_unicode_prefix
from pyspark.sql.column import _to_seq
from pyspark.sql.types import *
from pyspark.sql import SparkSession
from pyspark.sql.utils import to_str
import pandas as pd

'''import pyspark 
from pyspark import SparkContext
from pyspark.sql import SQLContext
from pyspark.sql.types import *
import pandas as pd
import os
'''


if __name__ == "__main__":
    #spark = SparkSession.builder.master("local[1]") \
    #                .appName('app1Session') \
    #                .getOrCreate()


    sc = SparkContext(appName="app1")
    sqlContext = SQLContext.getOrCreate(sc)
    
    #schema = StructType([
    #            StructField('sepallength', DoubleType(), True),
    #            StructField('sepalwidth', DoubleType(), True),
    #            StructField('petallength', DoubleType(), True),
    #            StructField('petalwidth', DoubleType(), True),
    #            StructField('class', StringType(), True)
    #        ])
            
    dataSchemaColumns = StructType([
                StructField('col1', IntegerType(), True),
                StructField('col2', IntegerType(), True),
                StructField('col3', StringType(), True),
                StructField('col4', StringType(), True),
                StructField('col5', StringType(), True),
                StructField('col6', DoubleType(), True)
            ])
    
    rddData = pd.read_csv('dataset.csv', names = ['col1','col2','col3','col4','col5','col6'])
    #rddData = sc.textFile("dataset.csv").map(lambda line: line.split(','))
    #data = sc.textFile("dataset.csv")
    #rddData = spark.read.csv(data)
    #rddData.collect()
    #rdd = sc.parallelize(csv)
    #rdd = sc.textFile("./iris_csv.csv").parallelize(schema))
    #rdd = sc.read.schema(schema).csv("./iris_csv.csv")
    df = sqlContext.createDataFrame(rddData, dataSchemaColumns)
    #print(df.schema)
    #df.show()
    df.write.parquet("./people/people.parquet", mode="overwrite")
