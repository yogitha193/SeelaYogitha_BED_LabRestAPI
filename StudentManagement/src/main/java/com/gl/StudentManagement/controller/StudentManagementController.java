package com.gl.StudentManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.StudentManagement.entity.Student;
import com.gl.StudentManagement.service.StudentManagementService;

@Controller
@RequestMapping("/students")
public class StudentManagementController {

	@Autowired
	private StudentManagementService studentService;

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);
		//System.out.println("entered controller showformforadd");
		return "Student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model theModel) {
		Student theStudent = studentService.findById(id);

		theModel.addAttribute("Student", theStudent);

		return "Student-form";

	}

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("Students", theStudents);
		return "list-Students";

	}

	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		//System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(firstName, lastName, course, country);
		studentService.save(theStudent);

		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		studentService.deleteById(id);

		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		model.setViewName("403");

		return model;

	}

}
