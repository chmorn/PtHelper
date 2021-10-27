package com.chmorn.utils;

import java.io.IOException;
import java.io.Serializable;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpPostUtil implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(HttpPostUtil.class);

    private static final long   serialVersionUID = 1L;
    private static final String CHAR_SET         = "UTF-8";
    private static final String CONTENT_TYPE     = "application/json";

    /**
     * 请求接口
     * @param requestUrl 接口请求地址
     * @param json 
     * @return	UTF-8解码返回数据
     */
    @SuppressWarnings({ "deprecation", "resource" })
    public static JSONObject doPostRequestJSON(String requestUrl, JSONObject json) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestUrl);
        JSONObject response = null;
        try {
            StringEntity string = new StringEntity(json.toString(),CHAR_SET);
            string.setContentEncoding(CHAR_SET);
            string.setContentType(CONTENT_TYPE);
            post.setEntity(string);
            HttpResponse res = client.execute(post);
            System.err.println("http status is " + res.getStatusLine().getStatusCode());
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                //UTF-8解码返回数据
                String result = EntityUtils.toString(entity,CHAR_SET);
                response = JSONObject.fromObject(result);
            }else{
                response = new JSONObject();
                try {
                    response.put("code", -1);
                    response.put("msg", "请求系统异常");
                } catch (JSONException e1) {}
            }
        } catch (IOException e) {
            response = new JSONObject();
            try {
            	response.put("code", -1);
                response.put("msg", "请求系统异常");
            } catch (JSONException e1) {}
            e.printStackTrace();
        } catch (JSONException e) {
            response = new JSONObject();
            try {
            	response.put("code", -1);
                response.put("msg", "请求系统异常");
            } catch (JSONException e1) {}
            e.printStackTrace();
        }

        return response;
    }
    

    private static JSONObject doPost(String requestUrl, JSONObject json) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestUrl);
        JSONObject response = null;
        try {
        	post.addHeader("accept", "application/json, text/javascript, */*; q=0.01");
        	post.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36");
        	post.addHeader("cookie", "");
            StringEntity string = new StringEntity(json.toString(),CHAR_SET);
            string.setContentEncoding(CHAR_SET);
            string.setContentType(CONTENT_TYPE);
            post.setEntity(string);
            HttpResponse res = client.execute(post);
            System.err.println("http status is " + res.getStatusLine().getStatusCode());
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                //UTF-8解码返回数据
                String result = EntityUtils.toString(entity,CHAR_SET);
                response = JSONObject.fromObject(result);
            }else{
                response = new JSONObject();
                try {
                    response.put("code", -1);
                    response.put("msg", "请求系统异常");
                } catch (JSONException e1) {}
            }
        } catch (IOException e) {
            response = new JSONObject();
            try {
            	response.put("code", -1);
                response.put("msg", "请求系统异常");
            } catch (JSONException e1) {}
            e.printStackTrace();
        } catch (JSONException e) {
            response = new JSONObject();
            try {
            	response.put("code", -1);
                response.put("msg", "请求系统异常");
            } catch (JSONException e1) {}
            e.printStackTrace();
        }

        return response;
    }

}
