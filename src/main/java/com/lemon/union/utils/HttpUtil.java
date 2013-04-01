package com.lemon.union.utils;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class HttpUtil {
    static final int TIMEOUT = 900000;

    static final String CHARSET = "utf-8";

    public static String methodPost4DJ(String baseUrl, String page, NameValuePair[] data, String beginDate, String endDate) {


        String url = baseUrl + page;
        String response = "";//要锟斤拷锟截碉拷response锟斤拷息
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        // 锟斤拷锟�锟斤拷值锟斤拷锟斤拷postMethod锟斤拷  
        postMethod.setRequestBody(data);
        // 执锟斤拷postMethod  
        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(postMethod);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // HttpClient锟斤拷锟斤拷要锟斤拷锟斤拷芎锟教凤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絇OST锟斤拷PUT锟饺诧拷锟斤拷锟皆讹拷锟斤拷锟斤拷转锟斤拷  
        // 301锟斤拷锟斤拷302  
        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
            // 锟斤拷头锟斤拷取锟斤拷转锟斤拷牡锟街� 
            Header locationHeader = postMethod.getResponseHeader("location");
            String location = null;
            if (locationHeader != null) {
                location = locationHeader.getValue();
                System.out.println("The page was redirected to:" + location);
//                response= methodPost(baseUrl,location,null);//锟斤拷锟斤拷转锟斤拷锟揭筹拷锟斤拷锟斤拷锟斤拷锟斤拷锟� 
                PostMethod pM = new PostMethod(baseUrl + "download_detail.asp?act=srch");
                // 锟斤拷锟斤拷post锟斤拷息
                NameValuePair[] pMData = {
                        new NameValuePair("dt", beginDate),
                        new NameValuePair("dt2", endDate),
                        new NameValuePair("gameid", ""),
                        new NameValuePair("sum", "1"),
                };
                pM.setRequestBody(pMData);
                try {
                    httpClient.executeMethod(pM);
                    System.out.println("Redirect:" + pM.getStatusLine().toString());
                    return pM.getResponseBodyAsString();

                } catch (Exception e) {

                    e.printStackTrace();
                } finally {
                    pM.releaseConnection();
                }

            } else {
                System.err.println("Location field value is null.");
            }
        } else {
            System.out.println(postMethod.getStatusLine());

            try {
                response = postMethod.getResponseBodyAsString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            postMethod.releaseConnection();
        }
        return response;
    }

    /**
     * POST锟斤拷锟斤拷锟斤拷锟�
     *
     * @param url
     * @return
     */
    public static byte[] putDataAsStream(String url, byte[] postData) {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                TIMEOUT);
        client.getParams().setParameter("http.socket.timeout", TIMEOUT);
        client.getParams().setContentCharset(CHARSET);
        PutMethod method = new PutMethod();
        try {
            method.setURI(new URI(url, true, CHARSET));
        } catch (URIException ex) {
            LogUtil.exception(ex);
        } catch (NullPointerException ex) {
            LogUtil.exception(ex);
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
        method.setRequestEntity(new ByteArrayRequestEntity(postData));
        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                LogUtil.error("POST DATA FAILED!HTTP STATUS:" + statusCode);
                return null;
            } else {
                byte[] responseBody = null;
                Header contentEncodingHeader = method
                        .getResponseHeader("Content-Encoding");
                if (contentEncodingHeader != null
                        && contentEncodingHeader.getValue().equalsIgnoreCase(
                        "gzip")) {
                    GZIPInputStream is = new GZIPInputStream(method
                            .getResponseBodyAsStream());
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    IOUtils.copy(is, os);
                    responseBody = os.toByteArray();
                } else {
                    responseBody = method.getResponseBody();
                }

                byte[] data = formatData(responseBody);
                String encoding = CHARSET;
                Header contentTypeHeader = method
                        .getResponseHeader("Content-Type");
                if (contentTypeHeader != null) {
                    String contentType = contentTypeHeader.getValue();
                    // System.out.println("content-type:" + contentType);
                    int offset = contentType.indexOf("=");
                    if (offset != -1)
                        encoding = contentType.substring(offset + 1);
                    else {
                        String body = new String(data, encoding);
                        offset = body.indexOf("encoding");
                        if (offset != -1) {
                            int begin = body.indexOf("\"", offset);
                            int end = body.indexOf("\"", begin + 1);
                            encoding = body.substring(begin + 1, end);
                        }
                    }
                }
                return data;
            }
        } catch (HttpException ex) {
            LogUtil.exception(ex);
        } catch (IOException ex) {
            LogUtil.exception(ex);
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
        return null;
    }

    /**
     * POST锟斤拷锟斤拷锟斤拷锟�
     *
     * @param url
     * @return
     */
    public static byte[] postDataAsStream(String url, byte[] postData) {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                TIMEOUT);
        client.getParams().setParameter("http.socket.timeout", TIMEOUT);
        client.getParams().setContentCharset(CHARSET);
        PostMethod method = new PostMethod();
        try {
            method.setURI(new URI(url, true, CHARSET));
        } catch (URIException ex) {
            LogUtil.exception(ex);
        } catch (NullPointerException ex) {
            LogUtil.exception(ex);
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
        method.setRequestEntity(new ByteArrayRequestEntity(postData));
        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                LogUtil.error("POST DATA FAILED!HTTP STATUS:" + statusCode);
                return null;
            } else {
                byte[] responseBody = null;
                Header contentEncodingHeader = method
                        .getResponseHeader("Content-Encoding");
                if (contentEncodingHeader != null
                        && contentEncodingHeader.getValue().equalsIgnoreCase(
                        "gzip")) {
                    GZIPInputStream is = new GZIPInputStream(method
                            .getResponseBodyAsStream());
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    IOUtils.copy(is, os);
                    responseBody = os.toByteArray();
                } else {
                    responseBody = method.getResponseBody();
                }

                byte[] data = formatData(responseBody);
                String encoding = CHARSET;
                Header contentTypeHeader = method
                        .getResponseHeader("Content-Type");
                if (contentTypeHeader != null) {
                    String contentType = contentTypeHeader.getValue();
                    // System.out.println("content-type:" + contentType);
                    int offset = contentType.indexOf("=");
                    if (offset != -1)
                        encoding = contentType.substring(offset + 1);
                    else {
                        String body = new String(data, encoding);
                        offset = body.indexOf("encoding");
                        if (offset != -1) {
                            int begin = body.indexOf("\"", offset);
                            int end = body.indexOf("\"", begin + 1);
                            encoding = body.substring(begin + 1, end);
                        }
                    }
                }
                return data;
            }
        } catch (HttpException ex) {
            LogUtil.exception(ex);
        } catch (IOException ex) {
            LogUtil.exception(ex);
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
        return null;
    }

    /**
     * POST锟斤拷锟斤拷锟斤拷锟�
     *
     * @param url
     * @return
     */
    public static String postData(String url, String postData) {
        LogUtil.info("锟斤拷锟斤拷:" + url);
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                TIMEOUT);
        client.getParams().setParameter("http.socket.timeout", TIMEOUT);
        client.getParams().setContentCharset(CHARSET);
        PostMethod method = new PostMethod();
        try {
            method.setURI(new URI(url, true, CHARSET));
        } catch (URIException ex) {
            LogUtil.exception(ex);
        } catch (NullPointerException ex) {
            LogUtil.exception(ex);
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
        method.setRequestEntity(new StringRequestEntity(postData));
        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                LogUtil.error("POST DATA FAILED!HTTP STATUS:" + statusCode);
                return null;
            } else {
                byte[] responseBody = null;
                Header contentEncodingHeader = method
                        .getResponseHeader("Content-Encoding");
                if (contentEncodingHeader != null
                        && contentEncodingHeader.getValue().equalsIgnoreCase(
                        "gzip")) {
                    GZIPInputStream is = new GZIPInputStream(method
                            .getResponseBodyAsStream());
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    IOUtils.copy(is, os);
                    responseBody = os.toByteArray();
                } else {
                    responseBody = method.getResponseBody();
                }

                byte[] data = formatData(responseBody);
                String encoding = CHARSET;
                Header contentTypeHeader = method
                        .getResponseHeader("Content-Type");
                if (contentTypeHeader != null) {
                    String contentType = contentTypeHeader.getValue();
                    // System.out.println("content-type:" + contentType);
                    int offset = contentType.indexOf("=");
                    if (offset != -1)
                        encoding = contentType.substring(offset + 1);
                    else {
                        String body = new String(data, encoding);
                        offset = body.indexOf("encoding");
                        if (offset != -1) {
                            int begin = body.indexOf("\"", offset);
                            int end = body.indexOf("\"", begin + 1);
                            encoding = body.substring(begin + 1, end);
                        }
                    }
                }
                return new String(data, encoding);
            }
        } catch (HttpException ex) {
            LogUtil.exception(ex);
        } catch (IOException ex) {
            LogUtil.exception(ex);
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
        return null;
    }

    /**
     * @param url
     * @return
     * @throws java.io.IOException
     */
    public static byte[] requestHttpContentAsStream(String url)
            throws IOException {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                TIMEOUT);
        client.getParams().setParameter("http.socket.timeout", TIMEOUT);
        GetMethod method = new GetMethod();
        try {
            method.setURI(new URI(url, false, "utf-8"));

        } catch (URIException ex) {
            LogUtil.exception(ex);
        } catch (NullPointerException ex) {
            LogUtil.exception(ex);
        }
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(8, false));
        try {

            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                LogUtil.error("GET HTTP CONTENT FAILED!HTTP STATUS NOT OK");
                return null;
            }
            byte[] responseBody = null;
            Header contentEncodingHeader = method
                    .getResponseHeader("Content-Encoding");
            if (contentEncodingHeader != null
                    && contentEncodingHeader.getValue()
                    .equalsIgnoreCase("gzip")) {
                GZIPInputStream is = new GZIPInputStream(method
                        .getResponseBodyAsStream());
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                IOUtils.copy(is, os);
                responseBody = os.toByteArray();
            } else {
                responseBody = method.getResponseBody();
            }

            return responseBody;

        } catch (HttpException ex) {
            LogUtil.exception(ex);
        } catch (IOException ex) {
            LogUtil.exception(ex);
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    /**
     * Get http content from url
     *
     * @param url
     * @return
     * @throws java.io.IOException
     */
    public static String requestHttpContent(String url) throws IOException {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                TIMEOUT);
        client.getParams().setParameter("http.socket.timeout", TIMEOUT);
        GetMethod method = new GetMethod();
        try {
            method.setURI(new URI(url, false, "utf-8"));

        } catch (URIException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(8, false));
        try {

            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                LogUtil.error("GET HTTP CONTENT FAILED!HTTP STATUS NOT OK . status=" + statusCode);
                return null;
            }
			byte[] responseBody = null;
			Header contentEncodingHeader = method
					.getResponseHeader("Content-Encoding");
			if (contentEncodingHeader != null
					&& contentEncodingHeader.getValue()
							.equalsIgnoreCase("gzip")) {
				GZIPInputStream is = new GZIPInputStream(method
						.getResponseBodyAsStream());
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				IOUtils.copy(is, os);
				responseBody = os.toByteArray();
			} else {
				responseBody = method.getResponseBody();
			}

			byte[] data = formatData(responseBody);
			String encoding = CHARSET;
			Header contentTypeHeader = method.getResponseHeader("Content-Type");
			if (contentTypeHeader != null) {
				String contentType = contentTypeHeader.getValue();
				// System.out.println("content-type:" + contentType);
				int offset = contentType.indexOf("=");
				if (offset != -1)
					encoding = contentType.substring(offset + 1);
				else {
					String body = new String(data, encoding);
					offset = body.indexOf("encoding");
					if (offset != -1) {
						int begin = body.indexOf("\"", offset);
						int end = body.indexOf("\"", begin + 1);
						encoding = body.substring(begin + 1, end);
					}
				}
			}
			return new String(data, encoding);

        } catch (HttpException ex) {
            LogUtil.exception(ex);
        } catch (IOException ex) {
            LogUtil.exception(ex);
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public static String requestHttpChunkContent(String url) throws Exception {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(
                TIMEOUT);
        client.getParams().setParameter("http.socket.timeout", TIMEOUT);
        GetMethod method = new GetMethod();
        try {
            method.setURI(new URI(url, false, "utf-8"));

        } catch (URIException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(8, false));
        try {

            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                LogUtil.error("GET HTTP CONTENT FAILED!HTTP STATUS NOT OK . status=" + statusCode);
                return null;
            }
            Header header = method.getResponseHeader("Transfer-Encoding");
            if (header.getValue().equals("chunked")) {
                InputStream is = method.getResponseBodyAsStream();
                byte [] buf = new byte[2048];
                int len = 0;
                while((len=is.read(buf))!=-1){
                    String ss = new String(buf,0,len);
                    System.out.println(ss);
                }
//                while (is.read() != -1) ;
            }
        } catch(Exception e){

        }
        return null;
    }

    /**
     * @param data
     * @return
     */
    private static byte[] formatData
    (
            byte[] data) {
        return data;
        // if (data == null) {
        // return null;
        // }
        // int k = 0;
        // for (; k < data.length && data[k] <= 32; k++) {
        // ;
        // }
        //
        // if (k == data.length) {
        // return null;
        // }
        // byte[] formatData = new byte[data.length - k];
        // java.lang.System.arraycopy(data, k, formatData, 0,
        // formatData.length);
        //
        // return formatData;
    }
}
