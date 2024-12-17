package br.com.devchampions.hotlink.controller.rest;

import br.com.devchampions.hotlink.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/link")
public class LinkRestController {

    @Autowired
    private LinkService linkService;


    @GetMapping("excluir/{linkId}")
    public ResponseEntity<?> excluir(@PathVariable("linkId") Long linkId) {
        this.linkService.excluir(linkId);

        return ResponseEntity.ok().build();
    }

}
