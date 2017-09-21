package com.astral.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求响应信息
 */
public class ResponseCode {

    public static final Integer SYS_SUCCESS = 200;
    
    public static final Integer SYS_OPER_SUCCESS = 20010;
    public static final Integer SYS_OPER_FAIL = 20011;

    public static final Integer SYS_ERROR = 500;
    
    public static final Integer SYS_SESSION_FAIL = 300;
    private static Map<Integer, String> codeMap = Collections.unmodifiableMap(new HashMap<Integer, String>() {
        {
            put(SYS_SUCCESS, "请求成功");
            put(SYS_OPER_SUCCESS, "操作成功");
            put(SYS_OPER_FAIL, "操作失败");
            put(SYS_ERROR, "系统内部错误");
            put(SYS_SESSION_FAIL,"用户未登陆");
        }
    });

    /**
     * 获取编码对应信息
     *
     * @param code
     * @return
     */
    public static String getMessage(Integer code) {
        if (codeMap.containsKey(code))
            return codeMap.get(code);
        return null;
    }
}