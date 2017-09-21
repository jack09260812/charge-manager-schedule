package com.astral.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.astral.util.ResponseCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author jinwei.li
 */
public class BaseController {


    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;
    private static final Log logger = LogFactory.getLog(BaseController.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        logger.error("系统错误日志:" + e);
        return failMsg(ResponseCode.SYS_ERROR);
    }


    /**
     * @return
     */
    protected String successMsg() {
        return successMsg(null);
    }

    /**
     * @param object
     * @return
     */
    protected String successMsg(Object object) {
        JSONObject json = new JSONObject();
        json.put("data", object);
        return successMsg(json, null);
    }

    /**
     * @param json
     * @param message
     * @return
     */
    protected String successMsg(JSONObject json, String message) {
        json.put("code", 200);
        json.put("message", message == null ? "success" : message);
        return json.toJSONString();
    }

    /**
     * 返回成功数据  格式：{"code":200,"data":{}}
     * @param object 需要返回的数据
     * @param code code
     * @return json
     */
    protected String successMsg(Object object,Integer code,String message){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("data",object);
        json.put("message", message == null ? "success" : message);
        return JSON.toJSONString(json);
    }

    /**
     * 错误信息
     *
     * @param code
     * @return
     */
    protected String failMsg(Integer code) {
        JSONObject json = new JSONObject();
        return failMsg(json, code, ResponseCode.getMessage(code));
    }

    /**
     * 错误信息
     *
     * @param message
     * @return
     */
    protected String failMsg(int code, String message) {
        JSONObject json = new JSONObject();
        return failMsg(json, code, message);
    }

    /**
     * 错误信息
     *
     * @param json
     * @param message
     * @return
     */
    protected String failMsg(JSONObject json, int code, String message) {
        json.put("code", code);
        json.put("message", message == null ? "failed" : message);
        return json.toJSONString();
    }

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
