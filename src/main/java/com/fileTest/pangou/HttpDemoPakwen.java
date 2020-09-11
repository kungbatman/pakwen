package com.fileTest.pangou;

import org.apache.http.*;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;

/**
 * @author kung
 * @date 2020-01-13 10:46
 * @Description
 */
public class HttpDemoPakwen {
    public static void main(String[] args){
//        httpDemo1();
        httpDemo2();

    }

    public static void httpDemo1(){
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());
    }

    public static void httpDemo2(){
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie",
                "c1=a; path=/; domain=localhost");
        response.addHeader("Set-Cookie",
                "c2=b; path=\"/\", c3=c; domain=\"localhost\"");

        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        Header[] hs = response.getHeaders("Set-Cookie");
//        HeaderIterator it = response.headerIterator("Set-Cookie");

//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }


        HeaderElementIterator it = new BasicHeaderElementIterator(
                response.headerIterator("Set-Cookie"));
        while (it.hasNext()) {
            HeaderElement elem = it.nextElement();
//            System.out.println(elem.getName() + " = " + elem.getValue());
            NameValuePair[] params = elem.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.println(" " + params[i]);
            }
        }
    }



}
