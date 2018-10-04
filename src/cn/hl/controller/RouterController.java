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
	 * ִ��ҳ����ת����
	 * @param path
	 * @param fileName
	 * @return
	 * @RequestParm : required-����id�Ƿ�Ϊ����ֵ defaultValue-����Ĭ��ֵΪ-1
	 */
	//get���ļ���
	@RequestMapping("router")
	public String router(String path,String fileName,Map<String,Integer> map,@RequestParam(required=false,defaultValue="-1") int id) {
	
		System.out.println(path+"/"+fileName);
		
		System.out.println("this is router ID"+id);
		
		//�ж�id�Ƿ�Ϊ-1�����������������ӵ�map�У����ͳ�ȥ
		if(id!=-1) {
			map.put("id", id);
		}
		
		//ִ��ҳ����ת
		return "/WEB-INF/view/"+path+"/"+fileName+".jsp";
	}
	
	//���Ҳ���ҳ����ת
	@RequestMapping(value="jumps/{id}",method=RequestMethod.GET)
	public String router(@PathVariable int id ,String path,String fileName) {
		System.out.println("thi is id="+id);
		return "/WEB-INF/view/"+path+"/"+fileName+".jsp?id="+id;
	}
}
