package SistemaEstoque.model;

/**
 *
 * @author Rafael Borges
 * github.com/RafaelB13
 */
public class Produto {
    
    private String descricao;
    private String codigo;
    private Double preco;
    private Integer quantidade;

    public Produto(String descricao, String codigo, Double preco, Integer quantidade) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "descricao=" + descricao + ", codigo=" + codigo + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }
    
    
    
    

}
