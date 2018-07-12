package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.ande.bridge.common.DateUtil;

public class HttpClient {
	
//	public static String doPost(String httpUrl, String param) {
//
//        HttpURLConnection connection = null;
//        InputStream is = null;
//        OutputStream os = null;
//        BufferedReader br = null;
//        String result = null;
//        try {
//            URL url = new URL(httpUrl);
//            // 通过远程url连接对象打开连接
//            connection = (HttpURLConnection) url.openConnection();
//            // 设置连接请求方式
//            connection.setRequestMethod("POST");
//            // 设置连接主机服务器超时时间：15000毫秒
//            connection.setConnectTimeout(15000);
//            // 设置读取主机服务器返回数据超时时间：60000毫秒
//            connection.setReadTimeout(60000);
//
//            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
//            connection.setDoOutput(true);
//            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
//            connection.setDoInput(true);
//            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
//            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
//            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
//            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
//            // 通过连接对象获取一个输出流
//            os = connection.getOutputStream();
//            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
//            os.write(param.getBytes());
//            // 通过连接对象获取一个输入流，向远程读取 
//            if (connection.getResponseCode() == 200) {
//
//                is = connection.getInputStream();
//                System.out.println(JSON.toJSON(is));
//                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
//                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//
//                StringBuffer sbf = new StringBuffer();
//                String temp = null;
//                // 循环遍历一行一行读取数据
//                while ((temp = br.readLine()) != null) {
//                    sbf.append(temp);
//                    sbf.append("\r\n");
//                }
//                result = sbf.toString();
//                System.out.println("result = :"+result);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            if (null != br) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != os) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != is) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 断开与远程地址url的连接
//            connection.disconnect();
//        }
//        return result;
//    }
	
	
	 /**
     * 
     * <pre>
     * <b> HTTP POST请求工具.</b>
     * <b>Description:</b> 
     *    传输json数据
     * <b>Author:</b> 
     * <b>Date:</b> 
     * @param url
     * @param json
     * @param charset
     * @return
     * @return Map<String,Object>   
     * @see  
     *<pre>
     */
	public static Map<String, Object> sendPostUrl(String url, String json) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        String response = "";
        long startTime = 0L;
        long endTime = 0L;
        int status = 0;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // RequestConfig requestconfig =
        // RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        // .setConfig(requestconfig);
        try {
            if (null != json) {
                //  解决中文乱码问题  
                StringEntity entity = new StringEntity(json.toString());
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
           System.out.println("URL路径：" + url);
            System.out.println("请求数据：" + json);
            startTime = System.currentTimeMillis();
            CloseableHttpResponse result = httpclient.execute(httpPost);
            endTime = System.currentTimeMillis();
            System.out.println("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
            status = result.getStatusLine().getStatusCode();
            HttpEntity entity = result.getEntity();
            // 请求发送成功，并得到响应  
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                try {
                    // 读取服务器返回过来数据
                    response = EntityUtils
                            .toString(result.getEntity(), "utf-8");
                    System.out.println("返回值：" + response);
                    responseMap.put("statusCode", result.getStatusLine()
                            .getStatusCode());
                    if (entity != null) {
                        responseMap.put("contentEncoding",
                                entity.getContentEncoding());
                        responseMap.put("responseContent", response);
                    }
                }
                catch (Exception e) {
                   System.out.println("post请求失败");
                }
            }
        }
        catch (Exception e) {
           System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //  使用finally块来关闭输出流、输入流  
        finally {
            System.out.println("请求状态status=" + status);
            httpPost.releaseConnection();
            System.out.println(DateUtil.getDatetime()+"==============END===========================================");
        }
        return responseMap;
    }
	
	 /**
     * <pre>
     * <b> HTTP POST请求<Map数据传输>.</b>
     * <b>Description:</b> 
     *    map数据
     * <b>Author:</b> 
     * <b>Date:</b>  
     * @param url
     * @param map
     * @param charset
     * @return
     * @return String   
     * @see  
     *<pre>
     */
	public static String doPost(String url, Map<String, Object> map) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            // 设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> elem = (Entry<String, Object>) iterator
                        .next();
                list.add(new BasicNameValuePair(elem.getKey(), (String) elem
                        .getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,
                        "UTF-8");
                httpPost.setEntity(entity);
            }
            response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "UTF-8");
                    System.out.println("返回值：" + result);
                }
            }
        }
        catch (Exception ex) {
           System.out.println("HttpClientUtil 发送http请求错误:"+ex);
        }
        finally {
            if (httpPost != null) {
                try {
                    httpPost.releaseConnection();
                }
                catch (Exception e) {
                   System.out.println("HttpClientUtil httpPost释放连接错误:"+e);
                }
            }
        }
        return result;
    }
	
	/**
     * 
      *<pre>
      *<b>HTTP模拟表单POST提交.</b>
      *<b>Description:</b> 
      *    
      *<b>Author:</b> 
      *<b>Date:</b> 
      * @param: @param url
      * @param: @param list
      * @param: @param charset
      * @param: @return      
      * @return:     
      * @throws   
      *<pre>
     */
    public static void sendFormPostUrl(String url, Map<String, String> params) {
        String response = "";// 返回数据
        long startTime = 0L;
        long endTime = 0L;
        int status = 0;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // RequestConfig requestconfig =
        // RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        // .setConfig(requestconfig);
        try {
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            for (String key : params.keySet()) {
                list.add(new BasicNameValuePair(key, params.get(key)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            System.out.println("URL路径：" + url);
            System.out.println("请求数据:" + list);
            startTime = System.currentTimeMillis();
            CloseableHttpResponse result = httpclient.execute(httpPost);
            endTime = System.currentTimeMillis();
            System.out.println("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
            status = result.getStatusLine().getStatusCode();
            // 请求发送成功，并得到响应  
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                try {
                    // 读取服务器返回过来的json字符串数据
                    response = EntityUtils
                            .toString(result.getEntity(), "utf-8");
                    System.out.println("返回值：" + response);
                }
                catch (Exception e) {
                   System.out.println("post请求失败");
                }
            }
        }
        catch (Exception e) {
           System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //  使用finally块来关闭输出流、输入流  
        finally {
            System.out.println("请求状态status=" + status);
            httpPost.releaseConnection();
        }
    }

}
