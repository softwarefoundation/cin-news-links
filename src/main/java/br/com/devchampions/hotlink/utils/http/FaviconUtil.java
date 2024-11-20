package br.com.devchampions.hotlink.utils.http;

public class FaviconUtil {

    private static final String API_FAVICON = "https://www.google.com/s2/favicons?domain=";


    public static String getFavionFromUrl(String url) {
        return API_FAVICON.concat(HttpUtil.extrairDominioDaUrl(url));
    }

}
