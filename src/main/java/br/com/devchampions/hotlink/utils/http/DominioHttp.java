package br.com.devchampions.hotlink.utils.http;

public enum DominioHttp {

    BR(".br"),
    COM(".com"),
    COM_BR(".com.br");

    public String extensao;

    DominioHttp(String extensao) {
        this.extensao = extensao;
    }
}
