/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.ImagemProdutoPers;
import vo.ImagemProduto;

/**
 *
 * @author Thyago
 */
public class ImagemProdutoRN {
   
    ImagemProdutoPers pp = new ImagemProdutoPers();
    
    public String valida(ImagemProduto ip){
         String msg = "";
         if(ip.getNome() == null || ip.getNome().isEmpty()){
              msg += "Nome em branco\n";
         }
         if(ip.getProduto() == null || ip.getProduto().getNome() == null){
              msg += "Produto em branco\n";
         }
         return msg;
    }
    
    public String inserirImagemProduto(Conexao cx, ImagemProduto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirImagemProduto(cx, p);
         }
    }
    
    public String updateImagemProduto(Conexao cx, ImagemProduto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateImagemProduto(cx, p);
         }    
    } 
    
    public String excluirImagemProduto(Conexao cx, ImagemProduto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirImagemProduto(cx, p);
         }    
    }     
   
    public ImagemProduto procuraCodigo(Conexao cx, int codigo){
        return pp.procuraCodigo(cx, codigo);
    }    
    
    public List<ImagemProduto> procuraCodImagemProduto(Conexao cx, int codigo){
        return pp.procuraCodImagemProduto(cx, codigo);
    }
    
    public List<ImagemProduto> procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<ImagemProduto> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       

    public List<ImagemProduto> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}
