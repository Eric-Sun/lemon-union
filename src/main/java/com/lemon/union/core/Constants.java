package com.lemon.union.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-4-11
 * Time: 下午2:22
 * To change this template use File | Settings | File Templates.
 */
public class Constants {

    public static Map<String, String> provinceMap = new ConcurrentHashMap<String, String>();

    static {
        provinceMap.put("山东", "shandong");
        provinceMap.put("江苏", "jiangsu");
        provinceMap.put("安徽", "anhui");
        provinceMap.put("北京", "beijing");
        provinceMap.put("天津", "tianjin");
        provinceMap.put("上海", "shanghai");
        provinceMap.put("广东", "guangdong");
        provinceMap.put("湖北", "hubei");
        provinceMap.put("浙江", "zhejiang");
        provinceMap.put("甘肃", "gansu");
        provinceMap.put("河北", "hebei");
        provinceMap.put("重庆", "chongqing");
        provinceMap.put("辽宁", "liaoning");
        provinceMap.put("四川", "sichuan");
        provinceMap.put("陕西", "shan3xi");
        provinceMap.put("福建", "fujian");
        provinceMap.put("海南", "hainan");
        provinceMap.put("广西", "guangxi");
        provinceMap.put("江西", "jiangxi");
        provinceMap.put("山西", "shan1xi");
        provinceMap.put("湖南", "hunan");
        provinceMap.put("河南", "henan");
        provinceMap.put("青海", "qinghai");
        provinceMap.put("贵州", "guizhou");
        provinceMap.put("宁夏", "ningxia");
        provinceMap.put("云南", "yunnan");
        provinceMap.put("吉林", "jilin");
        provinceMap.put("内蒙古", "neimenggu");
        provinceMap.put("新疆", "xinjiang");
        provinceMap.put("黑龙江", "heilongjiang");
        provinceMap.put("西藏", "xizang");
        provinceMap.put("未知", "weizhi");
    }

}
