package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insertPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insert");
		Student student=new Student();
		mv.addObject("student",student);
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("student") Student s) {
		ModelAndView mv = new ModelAndView();
		String res=studentService.insert(s);
		mv.addObject("msg", res);
		mv.setViewName("insert");

		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("update");
		Student student=new Student();
		mv.addObject("id", id);
		mv.addObject("student", student);
		return mv;

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("student") Student student) {
		// Read the request parameter
		ModelAndView mv = new ModelAndView("display");
		String res = studentService.update(student);
		mv.addObject("msg", res);
		

		return getAll();
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deletePage(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		String Res=studentService.delete(id);
		mv.addObject("msg", Res);
		mv.setViewName("display");
		return getAll();

	}

	/*@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		// Read the request parameter
		int id = Integer.parseInt(request.getParameter("id"));

		System.out.println("id to be removed " + id);
		String res = studentService.delete(id);
		request.setAttribute("msg", res);

		return "delete";
	}
*/
	@RequestMapping(value = "display")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView("display");
		List<Student> list = studentService.getAll();
		mv.addObject("list", list);
		
		return mv;

	}
}
