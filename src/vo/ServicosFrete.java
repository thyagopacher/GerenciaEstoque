/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author ThyagoHenrique
 */
@XStreamAlias("Servicos")
public class ServicosFrete {
     
     @XStreamAlias("cServico")
     private FreteServicoVO frete;

     public FreteServicoVO getFrete() {
          return frete;
     }

     public void setFrete(FreteServicoVO frete) {
          this.frete = frete;
     }
}
