/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Endereco;

/**
 *
 * @author Thyago
 */
public class EnderecoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirEndereco(Conexao cx, Endereco p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateEndereco(Conexao cx, Endereco p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirEndereco(Conexao cx, Endereco p){ 
        try{
            cx.conectar();
            String query = "delete from Endereco where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Endereco procuraCodEndereco(Conexao cx, int codigo){
        cx.conectar();
        return (Endereco)cx.s.get(Endereco.class,codigo);
    }

    public Endereco procuraNomeExato(Conexao cx, String nome) {
        String query = "from Endereco where nome = '" + nome + "'";
        Endereco c     = new Endereco();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Endereco)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Endereco> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Endereco where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    
  
    public List<Endereco> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Endereco";
        return cx.s.createQuery(query).list();
    }      

     public List<Endereco> procuraCodPessoa(Conexao cx, Integer codigo) {
        cx.conectar();
        String      query = "from Endereco where pessoa.codigo = '" + codigo + "' order by pessoa.nome ASC";
        return cx.s.createQuery(query).list();
     }
    
}
