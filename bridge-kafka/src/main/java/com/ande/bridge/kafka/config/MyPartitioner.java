package com.ande.bridge.kafka.config;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;



public class MyPartitioner implements Partitioner {  
  public MyPartitioner(VerifiableProperties props) {  

  }  
  @Override  
  public int partition(Object key, int partitionCount) {  
      return Integer.valueOf((String)key) % partitionCount;  
  }  
}  
