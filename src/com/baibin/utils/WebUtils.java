package com.baibin.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: Baibin
 * @Date: 2022/4/23 2:03
 * @Description: TODO
 */
public class WebUtils {
    /**
     * 不直接传入req.getParameterMap()，传入map是为了在dao和service层都能用这个工具了（他俩没有req），减少web层的耦合
     *
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParmToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将string类型转换为int
     * @param strInt
     * @param defaultInt
     * @return
     */
    public static int parseInt(String strInt,int defaultInt){
        try {
                    return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultInt;
    }
}
