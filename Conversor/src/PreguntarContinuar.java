import javax.swing.JOptionPane;

public class PreguntarContinuar {
	public static int preguntar(String mensaje) {
		return JOptionPane.showOptionDialog(null, mensaje, "Continuar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] {"si","No","Cancelar"}, "si");
	}
}
