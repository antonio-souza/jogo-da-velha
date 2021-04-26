package br.com.aaas.jogovelha.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

  public static void lancarMensagemDeErro(Exception e) {
    String mensagemErro =  e.getMessage();
    if (e.getCause() instanceof IllegalArgumentException) {
      mensagemErro = mensagemErro.substring(mensagemErro.indexOf(":") + 2);
    }
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, mensagemErro));
  }
  
  public static void lancarMensagemDeErro(String mensagem) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, mensagem));
  }
  
  public static void lancarMensagemInformativa(String mensagem) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
  }
}
