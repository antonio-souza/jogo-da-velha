package br.com.aaas.jogovelha.web;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aaas.jogovelha.entidade.Casa;
import br.com.aaas.jogovelha.entidade.Jogador;
import br.com.aaas.jogovelha.entidade.Jogo;
import br.com.aaas.jogovelha.enums.PessoaEnum;
import br.com.aaas.jogovelha.util.FacesUtil;

@Named
@ViewScoped
public class PrincipalMB implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private Jogo              jogo;

  private Jogador           eu;

  private Jogador           outro;

  private String            dataHoraInicio;

  private List<PessoaEnum>  pessoas;

  private PessoaEnum        pessoa;

  @PostConstruct
  public void carregar() {
    this.pessoas = Arrays.asList(PessoaEnum.values());
  }

  public void iniciar() {
    dataHoraInicio = jogo.iniciar(new Jogador(pessoa, "X"));
    eu = jogo.getJogador1();
    outro = null;
  }
  
  public boolean isPodeParticipar() {
    return jogo.getDataHoraInicio() != null && !jogo.getDataHoraInicio().equals(dataHoraInicio) && jogo.getJogador2() == null;
  }

  public void participar() {
    jogo.participar(new Jogador(pessoa, "O"));
    eu = jogo.getJogador2();
    outro = jogo.getJogador1();
  }

  public void atualizar() {
    if (eu != null && eu.equals(jogo.getJogador1()) && jogo.getJogador2() != null) {
      outro = jogo.getJogador2();
    }    
  }

  public Casa[][] getCasa() {
    return jogo.getCasa();
  }

  public void setCasa(Casa[][] casa) {
    jogo.setCasa(casa);
  }

  public void marcarCasa(int i, int j) {
    try {
      jogo.marcarCasa(i, j, eu);
    } catch (Exception e) {
      FacesUtil.lancarMensagemDeErro(e.getMessage());
    }
  }

  public Jogador getEu() {
    return eu;
  }

  public void setEu(Jogador eu) {
    this.eu = eu;
  }

  public Jogador getOutro() {
    return outro;
  }

  public void setOutro(Jogador outro) {
    this.outro = outro;
  }

  public String getDataHoraInicio() {
    return dataHoraInicio;
  }

  public void setDataHoraInicio(String dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
  }

  public Jogador getVencedor() {
    return jogo.getVencedor();
  }

  public List<PessoaEnum> getPessoas() {
    return pessoas;
  }

  public void setPessoas(List<PessoaEnum> pessoas) {
    this.pessoas = pessoas;
  }

  public PessoaEnum getPessoa() {
    return pessoa;
  }

  public void setPessoa(PessoaEnum pessoa) {
    this.pessoa = pessoa;
  }

  public Jogo getJogo() {
    return jogo;
  }

  public void setJogo(Jogo jogo) {
    this.jogo = jogo;
  }
}
