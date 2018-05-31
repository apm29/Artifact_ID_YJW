package com.yjw.shirly.controller;

import com.yjw.shirly.model.bean.Response;
import com.yjw.shirly.model.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class PageController {
    @ResponseBody
    @GetMapping()
    public Response hi(ModelMap modelMap) {
        modelMap.addAttribute("message","Hello MVC");
        Response<User> response = new Response<>();
        response.setData(new User());
        return response;
    }

//    @RequestMapping(value = "/index2", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String redirect() {
//
//        return "redirect:/jsp/index.jsp";
//    }
}
