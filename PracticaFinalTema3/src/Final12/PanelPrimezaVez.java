package Final12;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrimezaVez extends JPanel {
	private JLabel seccionEconomia;
	private JCheckBox seleccionEconomia_1;
	private JCheckBox seleccionEconomia_2;
	private JCheckBox seleccionEconomia_3;

	private JLabel seccionDeporte;
	private JCheckBox seleccionDeporte_1;
	private JCheckBox seleccionDeporte_2;
	private JCheckBox seleccionDeporte_3;

	private JLabel seccionNacional;
	private JCheckBox seleccionNacional_1;
	private JCheckBox seleccionNacional_2;
	private JCheckBox seleccionNacional_3;

	public PanelPrimezaVez() {
		setLayout(null);

		seccionEconomia = new JLabel(TipoNoticia.ECONOMIA.toString());
		seccionEconomia.setBounds(100, 50, 70, 20);
		add(seccionEconomia);

		seleccionEconomia_1 = new JCheckBox("El Mundo");
		seleccionEconomia_1.setBounds(100, 70, 120, 20);
		add(seleccionEconomia_1);
		
		seleccionEconomia_2 = new JCheckBox("El Economista");
		seleccionEconomia_2.setBounds(100, 90, 120, 20);
		add(seleccionEconomia_2);
		
		seleccionEconomia_3 = new JCheckBox("Expansion");
		seleccionEconomia_3.setBounds(100, 110, 120, 20);
		add(seleccionEconomia_3);


		seccionDeporte = new JLabel(TipoNoticia.DEPORTE.toString());
		seccionDeporte.setBounds(350, 50, 70, 20);
		add(seccionDeporte);

		seleccionDeporte_1 = new JCheckBox("Marca");
		seleccionDeporte_1.setBounds(350, 90, 120, 20);
		add(seleccionDeporte_1);

		seleccionDeporte_2 = new JCheckBox("AS");
		seleccionDeporte_2.setBounds(350, 110, 120, 20);
		add(seleccionDeporte_2);

		seleccionDeporte_3 = new JCheckBox("ESPN Deportes");
		seleccionDeporte_3.setBounds(350, 70, 120, 20);
		add(seleccionDeporte_3);

		seccionNacional = new JLabel(TipoNoticia.NACIONAL.toString());
		seccionNacional.setBounds(575, 50, 70, 20);
		add(seccionNacional);

		seleccionNacional_1 = new JCheckBox("El Confidencial");
		seleccionNacional_1.setBounds(575, 70, 120, 20);
		add(seleccionNacional_1);

		seleccionNacional_2 = new JCheckBox("El Pais");
		seleccionNacional_2.setBounds(575, 90, 120, 20);
		add(seleccionNacional_2);

		seleccionNacional_3 = new JCheckBox("El Español");
		seleccionNacional_3.setBounds(575, 110, 120, 20);
		add(seleccionNacional_3);

		// TODO
	}
}
