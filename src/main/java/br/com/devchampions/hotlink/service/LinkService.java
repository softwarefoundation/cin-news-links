package br.com.devchampions.hotlink.service;

import br.com.devchampions.hotlink.entity.Link;
import br.com.devchampions.hotlink.repository.LinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public void salvar(Link link) {
        log.info("LinkService:salvar");
        this.linkRepository.save(link);
    }

}
