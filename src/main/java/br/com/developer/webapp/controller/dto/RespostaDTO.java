package br.com.developer.webapp.controller.dto;

import br.com.developer.webapp.model.Resposta;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RespostaDTO {
    private Long id;
    private String mensagen;
    private LocalDateTime dataCriacao;
    private String nomeAutor;


    public RespostaDTO(Resposta reposta){

        this.id = reposta.getId();
        this.mensagen = reposta.getMensagem();
        this.dataCriacao = reposta.getDataCriacao();
        this.nomeAutor = reposta.getAutor().getNome();
    }


}
