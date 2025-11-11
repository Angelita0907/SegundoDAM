package controlador;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.CentroLogistico;
import servicio.ServicioBancoAlimentos;
import utils.BancoAlimentosCsv;
import utils.DomXMLBancoAlimentos;

public class GestionaColaboradoresBancos {
	
	private static final Logger logger = LogManager.getLogger(GestionaColaboradoresBancos.class);
	
	public static void main(String[] args) {
        DomXMLBancoAlimentos XMLDomBancoAlimento= new DomXMLBancoAlimentos();


        try {
            List<CentroLogistico> centroLogisticos = XMLDomBancoAlimento.leerCentroLogisticoDesdeXML("bancoAlimentos.xml");
            ServicioBancoAlimentos serviciobanco= new ServicioBancoAlimentos(centroLogisticos);
            BancoAlimentosCsv exportadorcsv = new  BancoAlimentosCsv(centroLogisticos);

            logger.info(centroLogisticos);
           // logger.info(serviciobanco.getColaboradoresPorTipo("Asalariado"));
           exportadorcsv.escribeCentrosYTrabajadoresCSV("voluntarios.csv");
        
      //  exportadorcsv.escribeCentrosYTrabajadoresCSV(centroLogisticos);
        
        
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
