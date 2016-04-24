package cn.heweiming.httpclient.demo01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

@SuppressWarnings("deprecation")
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
		String mobileCode = "18973579870";
		post.setParameter("mobileCode", mobileCode);
		post.setParameter("userID", "");
		if (client.executeMethod(post) == 200) {
			String responseStr = post.getResponseBodyAsString();
			System.out.println(responseStr);
		}
	}

	@Test
	public void testSoap1_1() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx";
		PostMethod post = new PostMethod(url);
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("soap/getMobileCodeInfo_soap1.1.xml");
		post.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
		post.setRequestBody(input);
		int i = client.executeMethod(post);
		System.out.println(i);
		if (i == 200) {
			String responseStr = post.getResponseBodyAsString();
			System.out.println(responseStr);
		}
	}

	@Test
	public void testSoap1_2() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx";
		PostMethod post = new PostMethod(url);
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("soap/getMobileCodeInfo_soap1.2.xml");
		post.setRequestHeader("Content-Type",
				"application/soap+xml; charset=utf-8");
		post.setRequestBody(input);
		int i = client.executeMethod(post);
		System.out.println(i);
		if (i == 200) {
			String responseStr = post.getResponseBodyAsString();
			System.out.println(responseStr);
		}
	}

}
