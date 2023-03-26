import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		menu();
	}		

	public static void menu() {
		String[] opciones = {"Convertir Moneda","Convertir Masa","SALIR"};
		int seleccion = JOptionPane.showOptionDialog(null, "Selccione una opcion", "Menu de Conversion",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
		
		if (seleccion == 0) {
			Conversor_monedas conversor = new Conversor_monedas();
			conversor.convertirMoneda();
		}else if(seleccion == 1){
			Conversor_Masa conversor = new Conversor_Masa();
			conversor.convertirMasa();
		}else if (seleccion == 2) {
			int continuar = JOptionPane.showOptionDialog(null, "Programa Finalizado. ¿Desea Continuar?", "Confirmacion",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, new Object[] {"Si","No","Cancelar"},"Si");
			if (continuar == JOptionPane.YES_OPTION) {
				menu();
			}else {
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
			}
		}
	}

}
