//package com.ande.bridge.admin.datasource;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
///**
// * 
// * <pre>  
// * <b> 取得当前数据源.</b>
// * <b>Author: tianhua.lan@la-inc.cn </b> 
// * <b>date: 2018年5月23日 下午6:29:39   </b> 
// *   ----------------------------------------------------------------------------
// *   ----------------------------------------------------------------------------
// * <pre>
// */
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return DynamicDataSourceContextHolder.getDataSourceType();
//    }
//
//}
