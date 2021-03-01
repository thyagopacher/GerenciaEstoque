/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Produto {
     
     private Integer          codigo;
     private String           nome;
     private double           preconormal;
     private double           precovenda;
     private double           precocusto;
     private double           precovarejo;
     private double           precofinal;
     private int              quantidade;
     private int              codvendedor;
     private CategoriaProduto categoria;
     private double           peso;
     private double           altura;
     private double           largura;
     private double           profundidade;
     private int              estoquebaixo;
     private String           codigobarra;
     private String           palavrachave;
     private int              caracteristicavisivel;
     private int              produtovisivel;
     private double           desconto;
     private Pessoa           fabrica;
     
     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public int getQuantidade() {
          return quantidade;
     }

     public void setQuantidade(int quantidade) {
          this.quantidade = quantidade;
     }

     public CategoriaProduto getCategoria() {
          return categoria;
     }

     public void setCategoria(CategoriaProduto categoria) {
          this.categoria = categoria;
     }

     public double getLargura() {
          return largura;
     }

     public void setLargura(double largura) {
          this.largura = largura;
     }

     public int getEstoquebaixo() {
          return estoquebaixo;
     }

     public void setEstoquebaixo(int estoquebaixo) {
          this.estoquebaixo = estoquebaixo;
     }

     public String getCodigobarra() {
          return codigobarra;
     }

     public void setCodigobarra(String codigobarra) {
          this.codigobarra = codigobarra;
     }

     public double getPeso() {
          return peso;
     }

     public void setPeso(double peso) {
          this.peso = peso;
     }

     public double getAltura() {
          return altura;
     }

     public void setAltura(double altura) {
          this.altura = altura;
     }

     public double getProfundidade() {
          return profundidade;
     }

     public void setProfundidade(double profundidade) {
          this.profundidade = profundidade;
     }

     public String getPalavrachave() {
          return palavrachave;
     }

     public void setPalavrachave(String palavrachave) {
          this.palavrachave = palavrachave;
     }

     public int getCaracteristicavisivel() {
          return caracteristicavisivel;
     }

     public void setCaracteristicavisivel(int caracteristicavisivel) {
          this.caracteristicavisivel = caracteristicavisivel;
     }

     public int getProdutovisivel() {
          return produtovisivel;
     }

     public void setProdutovisivel(int produtovisivel) {
          this.produtovisivel = produtovisivel;
     }

     public double getDesconto() {
          return desconto;
     }

     public void setDesconto(double desconto) {
          this.desconto = desconto;
     }

     public Pessoa getFabrica() {
          return fabrica;
     }

     public void setFabrica(Pessoa fabrica) {
          this.fabrica = fabrica;
     }

     public double getPreconormal() {
          return preconormal;
     }

     public void setPreconormal(double preconormal) {
          this.preconormal = preconormal;
     }

     public double getPrecovenda() {
          return precovenda;
     }

     public void setPrecovenda(double precovenda) {
          this.precovenda = precovenda;
     }

     public double getPrecocusto() {
          return precocusto;
     }

     public void setPrecocusto(double precocusto) {
          this.precocusto = precocusto;
     }

     public double getPrecovarejo() {
          return precovarejo;
     }

     public void setPrecovarejo(double precovarejo) {
          this.precovarejo = precovarejo;
     }

     public double getPrecofinal() {
          return precofinal;
     }

     public void setPrecofinal(double precofinal) {
          this.precofinal = precofinal;
     }

     public int getCodvendedor() {
          return codvendedor;
     }

     public void setCodvendedor(int codvendedor) {
          this.codvendedor = codvendedor;
     }
}
