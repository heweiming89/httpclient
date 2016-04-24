package cn.heweiming.httpclient.demo01;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

public class HttpClientDemo01 {

	@Test
	public void testGet() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
		String queryStr = "?mobileCode=15800979640&userID=";
		GetMethod get = new GetMethod(url + queryStr);
		int i = client.executeMethod(get);
		System.out.println(i);
		String string = get.getResponseBodyAsString();
		System.out.println(string);

	}

	@Test
	public void testPost() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
		PostMethod post = new PostMethod(url);
		post.setParameter("mobileCode", "18973579870");
		post.setParameter("userID", "");
		if (client.executeMethod(post) == 200) {
			String responseStr = post.getResponseBodyAsString();
			System.out.println(responseStr);
		}
	}

}
