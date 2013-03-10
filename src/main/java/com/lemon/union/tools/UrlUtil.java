package com.lemon.union.tools;

/**
 * Created with IntelliJ IDEA.
 * User: zhouwang
 * Date: 12-9-3
 * Time: 下午5:53
 * To change this template use File | Settings | File Templates.
 */
public class UrlUtil {
    public static String  delNumParam(String url,String name){
        if (url.contains("&"+name)) {
            url = url.replaceAll("&" + name + "=\\d*", "");
        } else if (url.contains(name+"=")) {
            url = url.replaceAll(name + "=\\d*&*", "");
        }
        return url;
    }
    public static String andQuery(String url,String query){
        return url+(url.contains("?")?"&":"?")+query;
    }

    public static String correctUrl(String url){
        url = url.replaceAll(" ","");
        return  url;
    }

    public static void main(String[] args) {
        System.out.println(delNumParam("http://localhost:8080/source/list?channelId=2&weight=5&fetchStatus=0&sourceName=36","message"));
//        System.out.println(delNumParam(delNumParam("http://localhost:8080/source/list?a=2&b=1&c=1", "message"), "pageNum"));
    }
}
