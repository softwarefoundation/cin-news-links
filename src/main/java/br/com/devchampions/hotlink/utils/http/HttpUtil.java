package br.com.devchampions.hotlink.utils.http;

public class HttpUtil {


    public static String extrairDominioDaUrl(String url) {

        StringBuilder dominio = new StringBuilder();

        if (url.contains(DominioHttp.COM_BR.extensao)) {
            dominio.append(url.substring(0, url.indexOf(DominioHttp.COM_BR.extensao) + DominioHttp.COM_BR.extensao.length()));
        } else if (url.contains(DominioHttp.COM.extensao)) {
            dominio.append(url.substring(0, url.indexOf(DominioHttp.COM.extensao) + DominioHttp.COM.extensao.length()));
        } else if (url.contains(DominioHttp.BR.extensao)) {
            dominio.append(url.substring(0, url.indexOf(DominioHttp.BR.extensao) + DominioHttp.BR.extensao.length()));
        }

        return dominio.toString();
    }


}
