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
		//��ӡ������Ϣ
		System.out.println("MeetingResolver is do....");
		
		//�����Զ����쳣����
		MeetException exception=null;
		
		//�ж��Ƿ�ʱMeetException(��֪�쳣)
		if (ex instanceof MeetException) {
			
			exception=(MeetException)ex;
			
		}else {
			
			//δ֪�쳣
			exception=new MeetException("ϵͳ����δ֪�쳣���������Ա��ϵ");
			
		}
		
		//����ModelAndView����
		
		ModelAndView mv=new ModelAndView("/WEB-INF/error.jsp");
		
		//���쳣������ӵ�ModelAndView
		
		mv.addObject("exception", exception);
		
		
		return mv;
	}

}
