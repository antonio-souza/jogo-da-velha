package br.com.aaas.jogovelha.entidade;

import br.com.aaas.jogovelha.enums.PessoaEnum;

public class Jogador {

  private PessoaEnum pessoa;

  private String     simbolo;

  public Jogador(PessoaEnum pessoa, String simbolo) {
    super();
    this.pessoa = pessoa;
    this.simbolo = simbolo;
  }

  public PessoaEnum getPessoa() {
    return pessoa;
  }

  public String getSimbolo() {
    return simbolo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Jogador other = (Jogador) obj;
    if (pessoa != other.pessoa)
      return false;
    return true;
  }
}
