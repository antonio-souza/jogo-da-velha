package br.com.aaas.jogovelha.entidade;

public class Casa {

  private Jogador jogador;
  
  private String cor;

  public Casa() {
    super();
    this.jogador = null;
    this.cor = "white";
  }

  public Jogador getJogador() {
    return jogador;
  }

  public void setJogador(Jogador jogador) {
    this.jogador = jogador;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Casa other = (Casa) obj;
    if (jogador == null) {
      if (other.jogador != null)
        return false;
    } else if (!jogador.equals(other.jogador))
      return false;
    return true;
  }

  public String getJogadorNome() {
    return jogador == null ? "" : jogador.getPessoa().getNome();
  }

  public String getJogadorImagem() {
    return jogador == null ? "" : jogador.getPessoa().getImagem();
  }
}
