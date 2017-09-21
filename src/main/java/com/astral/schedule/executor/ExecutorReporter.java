package com.astral.schedule.executor;

import com.astral.constant.Constant;
import com.github.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/9/20.
 * 执行报警接口
 */
public class ExecutorReporter {

    private final Logger logger = LoggerFactory.getLogger(ExecutorReporter.class);

    public ExecutorReporter(){

    }

    /**
     * 调用报警接口
     */
    public void reporter(){
        Map<String,String> map = new HashMap<>();
        try {
            String message = HttpHelper.doPostAsString(Constant.SPRING_ASTRAL_REPORT_REST_API,map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
