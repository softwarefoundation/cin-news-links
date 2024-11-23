package br.com.devchampions.hotlink.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SecurityController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

}
