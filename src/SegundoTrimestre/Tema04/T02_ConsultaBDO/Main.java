package SegundoTrimestre.Tema04.T02_ConsultaBDO;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos la conexion
        ObjectContainer db = Db4oEmbedded.openFile("ponentes.db4o");

        // Llamamos al metodoAlmacenar
		//FuncionesCRUD.almacenarPonentes(db);
		
		FuncionesCRUD.mostrarConetnido(db);
		
		
	}

}
