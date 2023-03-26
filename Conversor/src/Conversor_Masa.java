
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Conversor_Masa {
	DecimalFormat formato = new DecimalFormat("#.####");
	public void convertirMasa() {
		String[] masa = { "De Kilos a Onzas", "De Kilos a libras", "De Kilos a Gramos", "De Kilos a Toneladas",
				"De Kilos a Stone" };
		double[] tiposDeCambio = { 35.274, 2.20462, 1000, 0.001, 0.157473 };
		String MasaSeleccionada = (String) JOptionPane.showInputDialog(null,
				"Seleccione la masa a la cual desea convertir", "Conversion de Moneda", JOptionPane.PLAIN_MESSAGE, null,
				masa, masa[0]);

		double cantidadMasa = 0.0;
		boolean esNumero = false;
		while (!esNumero) {
			JTextField cantidadMasaField = new JTextField();
			Dimension dimension = new Dimension(80, 30);
			cantidadMasaField.setPreferredSize(dimension);
			JPanel panel = new JPanel();
			panel.add(new JLabel("Ingrese la cantidad de Kilos a convertir "));
			panel.add(cantidadMasaField);
			int result = JOptionPane.showConfirmDialog(null, panel, "Conversion de moneda",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String cantidadMasaStr = cantidadMasaField.getText();
				try {
					cantidadMasa = Double.parseDouble(cantidadMasaStr);
					esNumero = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(panel,
							"El valor ingresado no es un numero, Ingrese un valor nuevamente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				break;
			}
		}
		if (esNumero) {
			String cantidadMasaConvertida = formato.format(cantidadMasa * tiposDeCambio[Arrays.asList(masa).indexOf(MasaSeleccionada)]);
			JOptionPane.showMessageDialog(null,
					cantidadMasa + " Kilos = " + cantidadMasaConvertida + " " + MasaSeleccionada);

			int continuar = PreguntarContinuar.preguntar("¿Desea Continuar?");

			if (continuar == JOptionPane.YES_OPTION) {
				Main.menu();
			} else {
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
			}
		}
	}

}
