package br.com.devchampions.hotlink.controller;

import br.com.devchampions.hotlink.entity.Link;
import br.com.devchampions.hotlink.service.LinkService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public String viewCadastro(Link link) {
        return "link/cadastro";
    }

    @PostMapping
    public String salvar(@Valid Link link, BindingResult result, Model model) {

        if (link.getTitulo().startsWith("http://") || link.getTitulo().startsWith("https://")) {
            FieldError fieldError = new FieldError("link", "titulo", link.getTitulo(), false, null, null, "O campo título não deve iniciar com http ou https");
            result.addError(fieldError);
        }

        if (!link.getEndereco().startsWith("http")) {
            FieldError fieldError = new FieldError("link", "endereco", link.getEndereco(), false, null, null, "O campo endereço deve iniciar com http ou https");
            result.addError(fieldError);
        }

        if (result.hasErrors()) {
            model.addAttribute("link", link);
            return "link/cadastro";
        }

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
