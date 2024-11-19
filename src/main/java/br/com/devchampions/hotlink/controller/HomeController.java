package br.com.devchampions.hotlink.controller;

import br.com.devchampions.hotlink.entity.Link;
import br.com.devchampions.hotlink.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class HomeController {

    @Autowired
    private LinkService linkService;

    @GetMapping
    public String viewHome(ModelMap modelMap) {

        List<Link> links = this.linkService.listar();

        modelMap.addAttribute("links", links);
        modelMap.addAttribute("appnome", "HOTLINK");

        return "index";
    }

}
