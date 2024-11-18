package br.com.devchampions.hotlink.repository;

import br.com.devchampions.hotlink.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {


}
