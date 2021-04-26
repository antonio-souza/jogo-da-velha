package br.com.aaas.jogovelha.entidade;

import java.io.Serializable;
import java.util.Calendar;

import javax.ejb.Singleton;

import br.com.aaas.jogovelha.util.DataUtil;

@Singleton
public class Jogo implements Serializable {

  private static final long serialVersionUID = 1L;

  private Casa[][]          casa;

  private String            dataHoraInicio;

  private Jogador           jogador1;

  private Jogador           jogador2;

  private Jogador           proximaJogada;

  private Jogador           vencedor;

  public String iniciar(Jogador jogador) {
    this.casa = new Casa[][] { { new Casa(), new Casa(), new Casa() }, { new Casa(), new Casa(), new Casa() }, { new Casa(), new Casa(), new Casa() } };
    this.jogador1 = jogador;
    this.jogador2 = null;
    this.proximaJogada = jogador;
    this.dataHoraInicio = DataUtil.formatarData(Calendar.getInstance(), "dd/MM/yyyy HH:mm:ss");
    this.vencedor = null;
    return dataHoraInicio;
  }

  public void participar(Jogador jogador) {
    if (jogador.equals(jogador1)) {
      return;
    }
    this.jogador2 = jogador;
  }

  public Casa[][] getCasa() {
    return casa;
  }

  public void setCasa(Casa[][] casa) {
    this.casa = casa;
  }

  public Boolean marcarCasa(int i, int j, Jogador jogador) {
    if (this.casa[i][j].getJogador() != null) {
      return false;
    }
    if (vencedor != null) {
      return false;
    }
    if (!jogador.equals(proximaJogada)) {
      return false;
    }
    if (jogador2 == null) {
      return false;
    }
    this.casa[i][j].setJogador(proximaJogada);
    //this.casa[i][j].setCor("blue");
    verificarVitoria();
    this.proximaJogada = proximaJogada.equals(jogador1) ? jogador2 : jogador1;
    return true;
  }

  public void verificarVitoria() {
    verificarVitoria(casa[0][0], casa[0][1], casa[0][2]);
    verificarVitoria(casa[1][0], casa[1][1], casa[1][2]);
    verificarVitoria(casa[2][0], casa[2][1], casa[2][2]);

    verificarVitoria(casa[0][0], casa[1][0], casa[2][0]);
    verificarVitoria(casa[0][1], casa[1][1], casa[2][1]);
    verificarVitoria(casa[0][2], casa[1][2], casa[2][2]);

    verificarVitoria(casa[0][0], casa[1][1], casa[2][2]);
    verificarVitoria(casa[0][2], casa[1][1], casa[2][0]);
  }

  public void verificarVitoria(Casa casa1, Casa casa2, Casa casa3) {
    if (casa1.getJogador() != null && casa2.getJogador() != null && casa1.equals(casa2) && casa2.equals(casa3)) {
      casa1.setCor("blue");
      casa2.setCor("blue");
      casa3.setCor("blue");
      vencedor = casa1.getJogador();
      throw new RuntimeException(String.format("O Jogador %s venceu o jogo!! Parabéns!!!", vencedor.getPessoa().getNome()));
    }
  }

  public String getDataHoraInicio() {
    return dataHoraInicio;
  }

  public Jogador getVencedor() {
    return vencedor;
  }

  public Jogador getJogador1() {
    return jogador1;
  }

  public Jogador getJogador2() {
    return jogador2;
  }

  public Jogador getProximaJogada() {
    return proximaJogada;
  }
}
