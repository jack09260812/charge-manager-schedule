package com.astral.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.astral.model.TTaskConfig;
import com.astral.schedule.TaskSchedule;
import com.astral.service.TaskConfigService;
import com.astral.util.ResponseCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskConfigController extends BaseController {

	@Resource
	private TaskConfigService taskConfigService;

	@RequestMapping("/task/list")
	public String list(TTaskConfig task){
		JSONObject json = new JSONObject();
		List<TTaskConfig> list = taskConfigService.list(task);
		if (list != null){
			json.put("code",ResponseCode.SYS_SUCCESS);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_SUCCESS));
			json.put("data",JSON.toJSONString(list));
		}else {
			json.put("code",ResponseCode.SYS_ERROR);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_FAIL));
			json.put("data",JSON.toJSONString(null));
		}
		return json.toString();
	}
	@RequestMapping("/task/add")
	public String save(TTaskConfig task){
		/*写入数据库成功后,再写入调度队列*/
		boolean flg = taskConfigService.add(task);
		JSONObject json = new JSONObject();
		if (flg){
			/*将任务写入到执行队列中*/
			TaskSchedule taskSchedule = new TaskSchedule(task);
			taskSchedule.run();
			json.put("code", ResponseCode.SYS_SUCCESS);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_SUCCESS));
		}else {
			json.put("code", ResponseCode.SYS_ERROR);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_FAIL));
		}
		return json.toString();
	}
	@RequestMapping("/task/delete")
	public String delete(TTaskConfig taskConfig){
		boolean flg = taskConfigService.delete(taskConfig.getId());
		if (flg){
			TaskSchedule taskSchedule = new TaskSchedule(new TTaskConfig());
			taskSchedule.remove(taskConfig.getId());
		}
		return responseMessage(flg).toString();
	}
	private JSONObject responseMessage(boolean flg){
		JSONObject json = new JSONObject();
		if (flg){
			json.put("code", ResponseCode.SYS_SUCCESS);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_SUCCESS));
		}else{
			json.put("code", ResponseCode.SYS_ERROR);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_FAIL));
		}
		return json;
	}
	@RequestMapping("/task/update")
	public String update(TTaskConfig taskConfig){
		boolean flg = taskConfigService.update(taskConfig);
		if (flg) {
			TaskSchedule taskSchedule = new TaskSchedule(taskConfig);
			//对schedule进行删除操作
			taskSchedule.remove(taskConfig.getId());
			//追加更新后的任务
			taskSchedule.run();
		}
		return responseMessage(flg).toString();
	}

	@RequestMapping("/task/get")
	public String getByKey(TTaskConfig task){
		JSONObject json = new JSONObject();
		TTaskConfig taskConfig = taskConfigService.get(task);
		if (taskConfig != null){
			json.put("code",ResponseCode.SYS_SUCCESS);
			json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_SUCCESS));
			json.put("data",JSONObject.toJSONString(taskConfig));
		}else {
			json.put("code",ResponseCode.SYS_ERROR);
			json.put("message","无数据");
			json.put("data", JSON.toJSONString(null));
		}
		return json.toString();
	}

	@RequestMapping("/task/graph")
	public String getGraph(TTaskConfig taskConfig){
		Map<Integer,String> maps = new HashMap<>();
		List<TTaskConfig> list = taskConfigService.list(taskConfig);
		for (TTaskConfig tTaskConfig : list){
			maps.put(tTaskConfig.getId(),tTaskConfig.getTaskDeploy());
		}
		return JSON.toJSONString(maps);
	}
}
