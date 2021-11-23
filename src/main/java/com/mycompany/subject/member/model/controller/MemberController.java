package com.mycompany.subject.member.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.subject.member.model.service.MemberService;
import com.mycompany.subject.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView memberInsert(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "signUp", method=RequestMethod.POST)
	public ModelAndView memberInsert(Member member, @RequestParam("member_id") String id,@RequestParam("member_pwd") String pwd,@RequestParam("member_nm") String name,
			HttpServletRequest request,HttpServletResponse response, RedirectAttributes rttr, ModelAndView mv) {
		int result=0;

		try {
			System.out.println("controller1" + result);
	         
	        member.setMember_id(id);
	        member.setMember_pwd(pwd);
	        member.setMember_nm(name);
	        result = memberService.signUp(member);
	        System.out.println(member);
	        System.out.println("controller2" + result);
	        if(result==1) {
	           String msg = "회원가입이 완료되었습니다.";
	           rttr.addFlashAttribute("msg", msg);
	           mv.setViewName("redirect:/index");
	        }else {
	           String msg = "회원가입에 실패했습니다.";
	           rttr.addFlashAttribute("msg", msg);
	           mv.setViewName("redirect:/index");
	        }
	        
	     } catch (Exception e) {
	        e.printStackTrace();
	     }
	     return mv;
	}
}
