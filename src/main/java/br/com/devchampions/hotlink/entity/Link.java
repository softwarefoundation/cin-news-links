package br.com.devchampions.hotlink.entity;

import br.com.devchampions.hotlink.utils.http.FaviconUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "tb01_link")
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @NotBlank(message = "Campo obrigatório")
    @Column(name = "endereco", length = 1000, nullable = false, unique = true)
    private String endereco;

    public Link() {
    }

    public Long getId() {
        return id;
    }

    public String getDominio() {
        return FaviconUtil.getFavionFromUrl(this.endereco);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
