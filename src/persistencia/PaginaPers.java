/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Pagina;

/**
 *
 * @author Thyago
 */
public class PaginaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirPagina(Conexao cx, Pagina p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updatePagina(Conexao cx, Pagina p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirPagina(Conexao cx, Pagina p){ 
        try{
            cx.conectar();
            String query = "delete from Pagina where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Pagina procuraCodPagina(Conexao cx, int codigo){
        cx.conectar();
        return (Pagina)cx.s.get(Pagina.class,codigo);
    }

    public Pagina procuraNomeExato(Conexao cx, String nome) {
        String query = "from Pagina where titulo = '" + nome + "'";
        Pagina c     = new Pagina();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Pagina)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Pagina> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Pagina where titulo like '%" + nome + "%' order by titulo ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<Pagina> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Pagina  order by titulo ASC";
        return cx.s.createQuery(query).list();
    }    

}
