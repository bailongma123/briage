package com.ande.bridge.kafka.config;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ande.bridge.kafka.pool.KafkaConnectionPool;
import com.ande.bridge.pool.PoolConfig;


/**
2018年5月24日上午9:12:23
@author chengzb
 **/
@Service
public class KafkaUtil implements InitializingBean,DisposableBean{
	 private static final Logger logger = LogManager.getLogger(KafkaUtil.class);
	 private Integer i=0;//分区标识
	 private Integer partNum=100;//分区数
	 @Value("${kafka.pool.maxTotal}")
		private int maxTotal;
	    @Value("${kafka.pool.maxIdle}")
	   	private int maxIdle;
	    @Value("${kafka.pool.maxWaitMillis}")
	   	private int maxWaitMillis;
	    @Value("${kafka.pool.minEvictableIdleTimeMillis}")
	   	private int minEvictableIdleTimeMillis;
	    @Value("${kafka.pool.timeBetweenEvictionRunsMillis}")
	   	private int timeBetweenEvictionRunsMillis;
	    @Value("${kafka.pool.testOnBorrow}")
	   	private boolean testOnBorrow;
	 private KafkaConnectionPool pool;
	@Override
	public void destroy() throws Exception {
		System.out.println("----关闭kafka链接池----");
		pool.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		/* poolConfig */
		 PoolConfig poolConfig = new PoolConfig();
         poolConfig.setMaxTotal(maxTotal);
         poolConfig.setMaxIdle(maxIdle);
         poolConfig.setMaxWaitMillis(maxWaitMillis);
         poolConfig.setTestOnBorrow(testOnBorrow);
         poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
         poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

		/* properties */
		Properties props = new Properties();
		props.setProperty("metadata.broker.list", "master:9092,slave1:9092,slave2:9092");
		props.setProperty("producer.type", "async");
		props.setProperty("request.required.acks", "0");
		props.setProperty("compression.codec", "snappy");
		props.setProperty("batch.num.messages", "200");
		props.setProperty("partitioner.class", "com.ande.bridge.kafka.config.MyPartitioner");
		/* connection pool */
		 pool = new KafkaConnectionPool(poolConfig, props);
	}
	public void send(String topic,String message){
		KeyedMessage<byte[], byte[]> msg=null;
		Producer<byte[], byte[]> producer=null;
		try {
			i++;
			if(i>partNum){
				i=0;//超过100后   将改值置0
			}
			msg = new KeyedMessage<byte[], byte[]>(topic,null,i+"",message.getBytes("utf-8"));
			producer = pool.getConnection();
			producer.send(msg);
		} catch (UnsupportedEncodingException e) {
			logger.error("kafka发送异常",e);
		}
		pool.returnConnection(producer);
	}
}
