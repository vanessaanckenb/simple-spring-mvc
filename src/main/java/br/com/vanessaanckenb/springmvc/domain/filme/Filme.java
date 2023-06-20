package br.com.vanessaanckenb.springmvc.domain.filme;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "filmes")
@Getter
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer year;
    private String type;

    public Filme(DadosCadastroFilmeRecord dadosCadastroFilmeRecord){
        this.name = dadosCadastroFilmeRecord.name();
        this.year = dadosCadastroFilmeRecord.year();
        this.type = dadosCadastroFilmeRecord.type();
    }

    public void update(DadosAlteracaoFilmeRecord request) {
        this.name = request.name();
        this.year = request.year();
        this.type = request.type();
    }
}
