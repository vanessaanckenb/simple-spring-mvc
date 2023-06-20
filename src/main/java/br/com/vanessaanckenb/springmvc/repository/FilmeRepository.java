package br.com.vanessaanckenb.springmvc.repository;

import br.com.vanessaanckenb.springmvc.domain.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
