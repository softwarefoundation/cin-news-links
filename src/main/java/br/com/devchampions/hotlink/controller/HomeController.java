package br.com.devchampions.hotlink.controller;

import br.com.devchampions.hotlink.entity.Link;
import br.com.devchampions.hotlink.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class HomeController {

    @Autowired
    private LinkService linkService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String viewHome(ModelMap modelMap) {

        List<Link> links = this.linkService.listar();

        modelMap.addAttribute("links", links);
        return "index";
    }

}
