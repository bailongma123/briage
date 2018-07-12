package com.ande.bridge.hbase.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ande.bridge.hbase.pool.HbaseConnectionPool;
import com.ande.bridge.pool.PoolConfig;

@Service
public class HbaseUtil implements InitializingBean,DisposableBean{
	 private static final Logger logger = LogManager.getLogger(HbaseUtil.class);
	   @Value("${hbase.pool.maxTotal}")
		private int maxTotal;
	    @Value("${hbase.pool.maxIdle}")
	   	private int maxIdle;
	    @Value("${hbase.pool.maxWaitMillis}")
	   	private int maxWaitMillis;
	    @Value("${hbase.pool.minEvictableIdleTimeMillis}")
	   	private int minEvictableIdleTimeMillis;
	    @Value("${hbase.pool.timeBetweenEvictionRunsMillis}")
	   	private int timeBetweenEvictionRunsMillis;
	    @Value("${hbase.pool.testOnBorrow}")
	   	private boolean testOnBorrow;
	    
	    @Value("${hbase.zookeeper.quorum}")
	   	private String zkQuorum;
	    @Value("${hbase.zookeeper.port}")
	   	private String zkPort;
	    @Value("${hbase.master}")
	   	private String hBaseMaster;
	    
	    @Value("${hbase.client.pause}")
	   	private String pause;
	    @Value("${hbase.client.retries.number}")
	   	private String number;
	    @Value("${hbase.rpc.timeout}")
	   	private String rpcTimeout;
	    @Value("${hbase.client.operation.timeout}")
	   	private String timeout;
	    @Value("${hbase.client.scanner.timeout.period}")
	   	private String period;
	    private  HbaseConnectionPool pool;
	    @Override
		public void afterPropertiesSet() throws Exception {
		            Configuration conf = HBaseConfiguration.create();
		            conf.set("hbase.zookeeper.quorum", zkQuorum);
		    		conf.set("hbase.zookeeper.property.clientPort", zkPort);
		    		conf.set("hbase.master", hBaseMaster);
		    		
		    		conf.set("hbase.client.pause", pause); 
		            conf.set("hbase.client.retries.number", number); 
		            conf.set("hbase.rpc.timeout", rpcTimeout); 
		            conf.set("hbase.client.operation.timeout", timeout); 
		            conf.set("hbase.client.scanner.timeout.period", period);
		            
		            PoolConfig poolConfig = new PoolConfig();
		            poolConfig.setMaxTotal(maxTotal);
		            poolConfig.setMaxIdle(maxIdle);
		            poolConfig.setMaxWaitMillis(maxWaitMillis);
		            poolConfig.setTestOnBorrow(testOnBorrow);
		            poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		            poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		            
		            pool = new HbaseConnectionPool(poolConfig, conf);
		}
	   /*
     * 创建表
     */
    public void createTable(String tableName) {
        logger.info("begin to create table :" + tableName);
        Connection  conn = pool.getConnection();;
        try {
            if (null == conn) {
                logger.warn("get conn from pool failed. cannot create table");
                return;
            }
            Admin admin = conn.getAdmin();
            TableName tabName = TableName.valueOf(tableName);
            if (admin.tableExists(tabName)) {
                admin.disableTable(tabName);
                admin.deleteTable(tabName);
                System.out.println(tabName + " is exist, delete.....");
            }
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
            admin.createTable(tableDescriptor);
            admin.close();
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        logger.info("create table success");
    }
    /*
     * 根据rowkey删除某一行数据，删除整行的所有列簇、所有行、所有版本
     * 单行删除，避免使用
     */
    public void deleteRowByRowKey(String tableName, String rowkey) {
    	 Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.error("get connection from pool failed");
                return;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Delete del = new Delete(Bytes.toBytes(rowkey));
            table.delete(del);
            table.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
    }
    /*
     * 多行同时删除
     */
    public void multiDeleteRowByRowKey(String tableName, String[] rowkeys) {
        int rowNum = rowkeys.length;
   	 Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.error("get connection from pool failed");
                return;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            List<Delete> list = new ArrayList<Delete>();
            for (int i = 0; i < rowNum; ++i) {
                Delete del = new Delete(Bytes.toBytes(rowkeys[i]));
                list.add(del);
                table.delete(list);
                table.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
    }
    /*
     * 根据rowkey获取单行数据，包括所有列簇、所有列的最新版本数据
     * 单行获取，避免使用此函数
     */
    public Result getRowByRowKey(String tableName, String rowkey) {
        Result result = null;
        Connection  conn = pool.getConnection();
        try {
            TableName tabName = TableName.valueOf(tableName);
            if (null == conn) {
                logger.error("get connection from pool failed");
                return null;
            }
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
            } else {
                Get get = new Get(rowkey.getBytes());
                result = new Result();
                result = table.get(get);
            }
            table.close();
            admin.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("hbase get exception" + e.getMessage());
            return result;
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return result;
    }
    /*
     * 多行同时获取
     */
    public List<Result> multiGetRowByRowKey(String tableName, String[] rowkeys) {
        int rowNum = rowkeys.length;
        if (0 == rowNum) {
            return null;
        }
        List<Result> retList = new ArrayList<Result>();
        Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.warn("get connection from pool failed");
                return null;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
                retList = null;
            } else {
                List list = new ArrayList();
                for (int i = 0; i < rowNum; ++i) {
                    Get get = new Get(Bytes.toBytes(rowkeys[i]));
                    list.add(get);
                }
                Result[] resluts = table.get(list);
                for (int i = 0; i < resluts.length; ++i) {
                    retList.add(resluts[i]);
                }
            }
            table.close();
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("hbase multi get exception" + e.getMessage());
            return null;
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return retList;
    }
    /*
     * 新增和更新共用put，如果行键存在，则更新；否则新增
     * 单条数据插入或更新，避免调用
     */
    public int putRowByRowKey(String tableName, String rowkey, String columnFamily, String columm, String value) {
        int ret = 0;
        Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.warn("get connection from pool failed");
                return -1;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
                ret = -1;
            } else {
                Put put = new Put(Bytes.toBytes(rowkey));
                put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columm), Bytes.toBytes(value));
                table.put(put);
            }
            table.close();
            admin.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("hbase put exception:" + e.getMessage());
            return -1;
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return ret;
    }
    /*
     * 为某一个列簇所有列添加值
     */
    public int multiPutRowByRowKey(String tableName, String rowkey,
                                   String columnFamily, String[] columns, String[] values) {

        int colNum = columns.length;
        int valNum = values.length;
        if (colNum != valNum) {
            return -1;
        }
        int ret = 0;
        Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.warn("get connection from pool failed");
                return -1;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
                ret = -1;
            } else {
                Put put = new Put(Bytes.toBytes(rowkey));
                for (int i = 0; i < colNum; ++i) {
                    put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columns[i]), Bytes.toBytes(values[i]));
                }
                table.put(put);
            }
            table.close();
            admin.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("hbase multi put exception." + e.getMessage());
            return -1;
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return ret;
    }
    /*
     * 为多行，某一个列簇某一列添加值
     */
    public int multiPutRowsByRowKey(String tableName,
                                    String columnFamily,
                                    final String column,
                                    final String[] rowkeys,
                                    final String[]  valueList) {
        int ret = 0;
        int keySize = rowkeys.length;
        int listSize = valueList.length;
        if (keySize != listSize) {
            logger.warn("rowkeys size not equal to value list size");
            return -1;
        }
        Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.warn("get connection from pool failed");
                return -1;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
                ret = -1;
            } else {
                List<Put> putList = new ArrayList<Put>();
                for (int i = 0; i < keySize; ++i) {
                    Put put = new Put(Bytes.toBytes(rowkeys[i]));
                    put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(valueList[i]));
                    putList.add(put);
                }
                table.put(putList);
            }
            table.close();
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("hbase multiput exception." + e.getMessage());
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return ret;
    }
    public int multiPut(String tableName, List<Put> putList) {
    	Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.warn("get connection from pool failed");
                return -1;
            }
            TableName tabName = TableName.valueOf(tableName);
            Admin admin = conn.getAdmin();
            Table table = conn.getTable(tabName);
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
            } else {
                table.put(putList);
            }
            table.close();
            admin.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return 0;
    }

    public List<Result> scanRowByRange(String tableName, String beginRow, String endRow) {
        List<Result> list = new ArrayList<Result>();
        ResultScanner results = null;
        Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.error("get connection from pool failed");
                return null;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
                list = null;
            } else {
                Scan scan = new Scan();
                scan.setStartRow(Bytes.toBytes(beginRow));
                scan.setStopRow(Bytes.toBytes(endRow + 0)); // 包括改行
                results = table.getScanner(scan);

                for (Result result : results) {
                    list.add(result);
                }
                results.close();
            }
            table.close();
            admin.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("hbase scan exception. " + e.getMessage());
            return null;
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);
            }
        }
        return list;
    }

    public List<Result> scanRowByRange(String tableName, String columnFamily, String column,
                                       String beginRow, String endRow) {
        List<Result> list = new ArrayList<Result>();
        ResultScanner results = null;
        Connection  conn = pool.getConnection();
        try {
            if (null == conn) {
                logger.error("get connection from pool failed");
                return null;
            }
            TableName tabName = TableName.valueOf(tableName);
            Table table = conn.getTable(tabName);
            Admin admin = conn.getAdmin();
            if (!admin.isTableEnabled(tabName)) {
                logger.error("table " + tableName + " in hbase is not enable");
                list = null;
            } else {
                Scan scan = new Scan();
                scan.addFamily(Bytes.toBytes(columnFamily));
                // scan.addColumn(Bytes.toBytes(column), Bytes.toBytes(column));
                scan.setStartRow(Bytes.toBytes(beginRow));
                scan.setStopRow(Bytes.toBytes(endRow + 0)); // 包括该行
                long begin = System.currentTimeMillis();
                results = table.getScanner(scan);
                long end = System.currentTimeMillis();
                if (null != results) {
                    for (Result result : results) {
                        list.add(result);
                    }
                    results.close();
                } else {
                    logger.warn("scan from hbase result is null");
                }
                logger.info("hbase table getScanner success. result size: " + list.size() + " cost:" + (end - begin) + "ms");
            }
            table.close();
            admin.close();
            table = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
            	pool.returnConnection(conn);	
            }
        }
        return list;
    }
	@Override
	public void destroy() throws Exception {
		System.out.println("----关闭链接池----");
		pool.close();
	}
}
