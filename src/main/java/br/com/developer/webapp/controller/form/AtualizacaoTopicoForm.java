package br.com.developer.webapp.controller.form;

import br.com.developer.webapp.model.Topico;
import br.com.developer.webapp.repository.TopicoRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AtualizacaoTopicoForm {

    @NotNull
    @NotEmpty
    @Length(min = 3 , max = 50)
    private String titulo;
    @NotNull
    @NotEmpty
    @Length(min = 3 , max = 50)
    private String mensagem;

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }
}
