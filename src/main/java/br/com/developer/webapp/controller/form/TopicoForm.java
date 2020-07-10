package br.com.developer.webapp.controller.form;

import br.com.developer.webapp.model.Curso;
import br.com.developer.webapp.model.Topico;
import br.com.developer.webapp.repository.CursoRepository;
import br.com.developer.webapp.repository.TopicoRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicoForm {


    @NotNull(message = "Campo, obrigatório")
    @NotEmpty(message = "Campo Não Pode ser Vazio")
    @Length(min = 3 , max = 50)
    private String titulo;
    @NotNull(message = "Campo, obrigatório")
    @NotEmpty(message = "Campo Não Pode ser Vazio")
    @Length(min = 3 , max = 50)
    private String mensagem;
    @NotNull(message = "Campo, obrigatório")
    @NotEmpty(message = "Campo Não Pode ser Vazio")
    @Length(min = 3 , max = 50)
    private String nomeCurso;


    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo,mensagem,curso);
    }
}
