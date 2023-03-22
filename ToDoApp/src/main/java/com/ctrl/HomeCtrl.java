package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Todo;

@Controller
public class HomeCtrl {
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model m)
	{
		String str="home";
		
		List<Todo> list = (List<Todo>)context.getAttribute("list");
		
		m.addAttribute("todos", list);
		
		m.addAttribute("page", str);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m)
	{
		Todo t = new Todo();
		String str="add";
		m.addAttribute("page", str);
		m.addAttribute("todo", t);
		return "home";
	}
	
	@RequestMapping(value="/saveTodo", method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m)
	{
		System.out.println(t);
		t.setTodoDate(new Date());
		
		// get the Todo list
		
		List<Todo> list = (List<Todo>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "Successfully added...");
		return "home";
	}
}
