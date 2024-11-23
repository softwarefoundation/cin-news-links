package br.com.devchampions.hotlink.controller;

import br.com.devchampions.hotlink.entity.Link;
import br.com.devchampions.hotlink.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/cadastro")
    public String viewCadastro() {
        return "link/cadastro";
    }

    @PostMapping
    public String salvar(Link link) {
        linkService.salvar(link);
        return "redirect:";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("excluir/{linkId}")
    public String excluir(@PathVariable("linkId") Long linkId) {
        log.info("Excluindo o link ID: {}", linkId);
        this.linkService.excluir(linkId);
        log.info("Link ID: {}, excluido", linkId);
        return "redirect:/";
    }


}
