//package com.ande.bridge.admin.datasource;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 
// * <pre>  
// * <b> 设置当前数据源的工具类.</b>
// * <b>Author: tianhua.lan@la-inc.cn </b> 
// * <b>date: 2018年5月23日 下午6:30:58   </b> 
// *   ----------------------------------------------------------------------------
// *   ----------------------------------------------------------------------------
// * <pre>
// */
//public class DynamicDataSourceContextHolder {
//
//    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
//    public static List<String> dataSourceIds = new ArrayList<>();
//
//    public static void setDataSourceType(String dataSourceType) {
//        contextHolder.set(dataSourceType);
//    }
//
//    public static String getDataSourceType() {
//        return contextHolder.get();
//    }
//
//    public static void clearDataSourceType() {
//        contextHolder.remove();
//    }
//
//    /**
//     * 判断指定DataSrouce当前是否存在
//     */
//    public static boolean containsDataSource(String dataSourceId){
//        return dataSourceIds.contains(dataSourceId);
//    }
//}
