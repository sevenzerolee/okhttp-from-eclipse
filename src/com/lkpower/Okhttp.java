package com.lkpower;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 
 * @author linger
 *
 * @since 2016年6月2日
 *
 */
public class Okhttp {
	
	static Logger log = Logger.getLogger(Okhttp.class.getSimpleName());

	public static void main(String[] args) throws IOException {
		
		String url = "http://192.168.1.246:2800";
		url = "http://www.baidu.com";
		
		get(url);

	}
	
	static OkHttpClient client = new OkHttpClient();
	
	static void get(String url) throws IOException {
		Request req = new Request.Builder().url(url).build();
		
		Response res = client.newCall(req).execute();
		
		if (res.isSuccessful()) {
			log.info("get 执行成功 " + url);
			ResponseBody rb = res.body();
			log.info(rb.string());
		}
		else {
			log.info(res.message());
		}
	}

}
