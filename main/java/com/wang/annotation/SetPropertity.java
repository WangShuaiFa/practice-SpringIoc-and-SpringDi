package com.wang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 *
 * @methodDesc: 功能描述:(自定义字段属性)
 * @author: 王帅发
 * @param: @return
 * @createTime:2020年2月27日
 * @returnType:@return String
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface SetPropertity {

    String name();
    int len();

}
