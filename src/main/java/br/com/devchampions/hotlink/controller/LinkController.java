package br.com.devchampions.hotlink.controller;

import br.com.devchampions.hotlink.entity.Link;
import br.com.devchampions.hotlink.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping
    public String listarLinks(){
        return "links";
    }

    @PostMapping
    public String salvar(Link link){
        log.info("Salvar link");
        linkService.salvar(link);
        return "redirect:/index.html";
    }


}
