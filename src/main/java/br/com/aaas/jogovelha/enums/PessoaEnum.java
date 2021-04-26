package br.com.aaas.jogovelha.enums;

public enum PessoaEnum {
  ANTHONY("Anthony", "anthony"), 
  PAI("Pai", "antonio"), 
  ANDREO("Andreo", "andreo"), 
  MAE("Mãe", "michele");
  
  private String nome;
  
  private String imagem;

  private PessoaEnum(String nome, String imagem) {
    this.nome = nome;
    this.imagem = imagem;
  }

  public String getNome() {
    return nome;
  }

  public String getImagem() {
    return imagem;
  }  
}
