package br.com.vanessaanckenb.springmvc.controller;

import br.com.vanessaanckenb.springmvc.domain.filme.DadosAlteracaoFilmeRecord;
import br.com.vanessaanckenb.springmvc.domain.filme.DadosCadastroFilmeRecord;
import br.com.vanessaanckenb.springmvc.domain.filme.Filme;
import br.com.vanessaanckenb.springmvc.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeRepository repository;

    @GetMapping
    public String loadMovies(Model model) {
        model.addAttribute("listaFilmes", repository.findAll());
        //se refere ao html em resources/templates/filmes/listagem.html
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String sendForm(DadosCadastroFilmeRecord request) {
        System.out.println("[POST][FILME]" + request);
        var filme = new Filme(request);
        repository.save(filme);
        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String updateForm(DadosAlteracaoFilmeRecord request) {
        System.out.println("[PUT][FILME]" + request);
        var filme = repository.getReferenceById(request.id());
        filme.update(request);
        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String deleteMovie(Long id) {
        System.out.println("[DELETE][FILME]" + id);
        repository.deleteById(id);
        return "redirect:/filmes";
    }

    @GetMapping("/cadastro")
    public String loadForm(Long id, Model model) {
        System.out.println(id);
        if(id != null){
            final var filme = repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

}
