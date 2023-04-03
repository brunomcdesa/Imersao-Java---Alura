package br.com.alura.linguagens.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

    @GetMapping
    public List<Linguagem> getLinguagens() {
        List<Linguagem> linguagens = repository.findAll();
        return linguagens;
    }

    @GetMapping("/{id}")
    public Optional<Linguagem> getLinguagemByTitle(@PathVariable String id){
        Optional<Linguagem> linguageById = repository.findById(id);      
        return linguageById;
    }

    @PostMapping
    public Linguagem postLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemNova = repository.save(linguagem);
        return linguagemNova;
    }

    @PutMapping("/{id}")
    @Transactional
    public Linguagem putLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem){
        Optional<Linguagem> linguagemAntiga  = repository.findById(id);
        linguagemAntiga.get().setRanking(linguagem.getRanking());
        Linguagem linguagem2 = linguagemAntiga.get();
        repository.save(linguagem2);
        return linguagem2;
    }


    @DeleteMapping("/{id}")
    public String delLinguagem(@PathVariable String id){
        repository.deleteById(id);
        return "DELETADO";
    }
}
