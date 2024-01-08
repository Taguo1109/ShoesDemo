package tw.taguo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	 @GetMapping("/hello")
	    public String hello(Model model) {
	        model.addAttribute("message", "Hello, World!");
	        return "hello"; // 这里假设你有一个名为 "hello.jsp" 的视图文件
	    }

}
