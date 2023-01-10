package controlador;

import vista.VistaPrincipal;

public class ControladorPrincipal {

	protected VistaPrincipal vprin;

	public ControladorPrincipal() {
		this.vprin = new VistaPrincipal();
	}
	
	public void mostrarMenu() {
		String opcion=" ";
		
		
		while (!opcion.equals("0")) {
			vprin.mostrarMenu();
			opcion = vprin.getOpcion();
			switch (opcion) {
			case "1": {
				
				ControladorPersona cp = new ControladorPersona();
				cp.menu();
				break;
			}

			case "0": {
				System.out.println("Salimos");
				break;
			}
			default:
				System.out.println("Opción errónea");
			}
			
		}
	}
	
	
}
