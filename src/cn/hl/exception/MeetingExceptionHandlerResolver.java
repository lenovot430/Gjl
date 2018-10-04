package cn.hl.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MeetingExceptionHandlerResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ex.printStackTrace();
		//打印错误信息
		System.out.println("MeetingResolver is do....");
		
		//声明自定义异常对象
		MeetException exception=null;
		
		//判断是否时MeetException(已知异常)
		if (ex instanceof MeetException) {
			
			exception=(MeetException)ex;
			
		}else {
			
			//未知异常
			exception=new MeetException("系统发生未知异常，请与管理员联系");
			
		}
		
		//创建ModelAndView对象
		
		ModelAndView mv=new ModelAndView("/WEB-INF/error.jsp");
		
		//将异常对象添加到ModelAndView
		
		mv.addObject("exception", exception);
		
		
		return mv;
	}

}
