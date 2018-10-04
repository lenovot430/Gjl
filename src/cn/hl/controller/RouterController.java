package cn.hl.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouterController {

	/**
	 * 执行页面跳转功能
	 * @param path
	 * @param fileName
	 * @return
	 * @RequestParm : required-设置id是否为必须值 defaultValue-设置默认值为-1
	 */
	//get到的技术
	@RequestMapping("router")
	public String router(String path,String fileName,Map<String,Integer> map,@RequestParam(required=false,defaultValue="-1") int id) {
	
		System.out.println(path+"/"+fileName);
		
		System.out.println("this is router ID"+id);
		
		//判断id是否为-1，如果不是则将数据添加到map中，发送出去
		if(id!=-1) {
			map.put("id", id);
		}
		
		//执行页面跳转
		return "/WEB-INF/view/"+path+"/"+fileName+".jsp";
	}
	
	//自我测试页面跳转
	@RequestMapping(value="jumps/{id}",method=RequestMethod.GET)
	public String router(@PathVariable int id ,String path,String fileName) {
		System.out.println("thi is id="+id);
		return "/WEB-INF/view/"+path+"/"+fileName+".jsp?id="+id;
	}
}
