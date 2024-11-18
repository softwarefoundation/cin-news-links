package br.com.devchampions.hotlink.service;

import br.com.devchampions.hotlink.entity.Link;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LinkService {

    public void salvar(Link link) {
        log.info("LinkService:salvar");
        log.info(link.getTitulo());
    }

}
