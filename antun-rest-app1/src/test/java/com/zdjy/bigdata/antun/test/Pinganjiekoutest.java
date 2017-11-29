package com.zdjy.bigdata.antun.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class Pinganjiekoutest {

	@Test
	public void  test01() throws Exception{
		
		//创建客户端
		CloseableHttpClient build=HttpClientBuilder.create().build();
		
		//拼接URL
		 
		String url="http://47.94.250.65/pinganjiekou/user/add?userName=刘路宽&userSex=1&userBirth=1991-04-08&userPhone=13576534567&province=110000&city=110100&town=110101&channelCode=afangti_huhuabo_001&channelToken=-67-75-49-31-96-89-29-1191749116-528-4926-43&productCode=PA000000CXSF-CXWY-01&userIdNo=32012519947894561x";
		
		//创建get请求
		HttpGet httpGet = new HttpGet(url);
		
		//发送请求
		
		CloseableHttpResponse execute = build.execute(httpGet);
		
		
		HttpEntity entity = execute.getEntity();
		
		String string=EntityUtils.toString(entity);
		
		System.out.println(string);
	}
}
