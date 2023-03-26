
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Conversor_monedas {
	DecimalFormat formato = new DecimalFormat("#.##");
	private String[] monedas = {"De Soles a Dolar","De Soles a Pesos Chilenos","De Soles a Euros","De Soles a Pesos Mexicanos","De Soles a Yen Japones",};
	private Double[] tiposDeCambio = {0.27,214.86,0.25,4.89,34.66};
	
	public void convertirMoneda() {
		String monedaSeleccionada = (String) JOptionPane.showInputDialog(null,"Seleccione la moneda a que desee convertir: ",
				"Conversión de moneda",JOptionPane.PLAIN_MESSAGE,null,monedas, monedas[0]);
		
		double cantidadMoneda = 0.0;
		boolean esNumero = false;
		
		while (!esNumero) {
			JTextField cantidadMonedaField = new JTextField();
			Dimension dimension = new Dimension(80, 30);
			cantidadMonedaField.setPreferredSize(dimension);
			JPanel panel = new JPanel();
			panel.add(new JLabel("Ingrese la cantidad a convertir " + monedaSeleccionada));
			panel.add(cantidadMonedaField);
			int result = JOptionPane.showConfirmDialog(null, panel, "Conversión de moneda", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String cantidadMonedasStr = cantidadMonedaField.getText();
				try {
					cantidadMoneda = Double.parseDouble(cantidadMonedasStr);
					esNumero = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El valor ingresado no es un caracter númerico, por favor intente de nuevo");
				}
			}else {
				break;
			}
		}
		if (esNumero) {
			String cantidadMonedaConvertida = formato.format(cantidadMoneda * tiposDeCambio[Arrays.asList(monedas).indexOf(monedaSeleccionada)]);
			JOptionPane.showMessageDialog(null, cantidadMoneda + " Soles = " + cantidadMonedaConvertida + " " + monedaSeleccionada);
			
			int continuar = PreguntarContinuar.preguntar("¿Desea Continuar?");
			
			if (continuar == JOptionPane.YES_OPTION) {
				Main.menu();
			}else {
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
			}
		}
	}
}
