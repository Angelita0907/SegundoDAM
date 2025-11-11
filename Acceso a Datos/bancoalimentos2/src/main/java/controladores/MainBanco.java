package controladores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.CentroLogistico;
import servicio.ServicioBanco;
import util.ExportadorCSV;
import util.XMLDomBancoAlimento;


public class MainBanco {
	private static final Logger logger= LogManager.getLogger(MainBanco.class);

	public static void main(String[] args) {
		XMLDomBancoAlimento XMLDomBancoAlimento= new XMLDomBancoAlimento();
		
		
		try {
			List<CentroLogistico> centroLogisticos = XMLDomBancoAlimento.leerCentroLogisticoDesdeXML("bancoAlimentos.xml");
			ServicioBanco serviciobanco= new ServicioBanco(centroLogisticos);
			ExportadorCSV exportadorcsv = new  ExportadorCSV(centroLogisticos);

			logger.info(centroLogisticos);
			logger.info(serviciobanco.getcolaboradoresportipo("Asalariado"));
		exportadorcsv.escribeCentrosYTrabajadoresCSV("csvbanco.csv");
		exportadorcsv.generaJSONnoenventa(centroLogisticos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}