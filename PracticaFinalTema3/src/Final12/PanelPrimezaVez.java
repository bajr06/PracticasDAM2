package Final12;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelPrimezaVez extends JPanel {
	private JLabel peticionSeleccion;

	private JLabel seccionEconomia;
	protected static JCheckBox seleccionEconomia_1, seleccionEconomia_2, seleccionEconomia_3;

	private JLabel seccionDeporte;
	protected static JCheckBox seleccionDeporte_1, seleccionDeporte_2, seleccionDeporte_3;

	private JLabel seccionNacional;
	protected static JCheckBox seleccionNacional_1, seleccionNacional_2, seleccionNacional_3;

	private JLabel seccionInternacional;
	protected static JCheckBox seleccionInternacional_1, seleccionInternacional_2, seleccionInternacional_3;

	private JLabel seccionTecnologia;
	protected static JCheckBox seleccionTecnologia_1, seleccionTecnologia_2, seleccionTecnologia_3;

	private JLabel seccionVideojuego;
	protected static JCheckBox seleccionVideojuego_1, seleccionVideojuego_2, seleccionVideojuego_3;

	protected static JButton selecciones;

	public PanelPrimezaVez() {
		setLayout(null);

		peticionSeleccion = new JLabel("Por favor, seleccione los periodicos que quiere ver de cada categoría:");
		peticionSeleccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		peticionSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		peticionSeleccion.setBounds(100, 50, 600, 25);
		add(peticionSeleccion);

		seccionEconomia = new JLabel(TipoNoticia.ECONOMIA.toString());
		seccionEconomia.setBounds(100, 100, 140, 20);
		add(seccionEconomia);

		seleccionEconomia_1 = new JCheckBox("El Mundo");
		seleccionEconomia_1.setBounds(100, 120, 140, 20);
		add(seleccionEconomia_1);
		
		seleccionEconomia_2 = new JCheckBox("El Economista");
		seleccionEconomia_2.setBounds(100, 140, 140, 20);
		add(seleccionEconomia_2);
		
		seleccionEconomia_3 = new JCheckBox("Expansion");
		seleccionEconomia_3.setBounds(100, 160, 140, 20);
		add(seleccionEconomia_3);


		seccionDeporte = new JLabel(TipoNoticia.DEPORTE.toString());
		seccionDeporte.setBounds(350, 100, 140, 20);
		add(seccionDeporte);

		seleccionDeporte_1 = new JCheckBox("Marca");
		seleccionDeporte_1.setBounds(350, 120, 140, 20);
		add(seleccionDeporte_1);

		seleccionDeporte_2 = new JCheckBox("AS");
		seleccionDeporte_2.setBounds(350, 140, 140, 20);
		add(seleccionDeporte_2);

		seleccionDeporte_3 = new JCheckBox("ESPN Deportes");
		seleccionDeporte_3.setBounds(350, 160, 140, 20);
		add(seleccionDeporte_3);

		seccionNacional = new JLabel(TipoNoticia.NACIONAL.toString());
		seccionNacional.setBounds(575, 100, 140, 20);
		add(seccionNacional);

		seleccionNacional_1 = new JCheckBox("El Confidencial");
		seleccionNacional_1.setBounds(575, 120, 140, 20);
		add(seleccionNacional_1);

		seleccionNacional_2 = new JCheckBox("El Pais");
		seleccionNacional_2.setBounds(575, 140, 140, 20);
		add(seleccionNacional_2);

		seleccionNacional_3 = new JCheckBox("El Español");
		seleccionNacional_3.setBounds(575, 160, 140, 20);
		add(seleccionNacional_3);

		seccionInternacional = new JLabel(TipoNoticia.INTERNACIONAL.toString());
		seccionInternacional.setBounds(100, 250, 140, 20);
		add(seccionInternacional);

		seleccionInternacional_1 = new JCheckBox("RTVE");
		seleccionInternacional_1.setBounds(100, 270, 140, 20);
		add(seleccionInternacional_1);
		
		seleccionInternacional_2 = new JCheckBox("CNN Español");
		seleccionInternacional_2.setBounds(100, 290, 140, 20);
		add(seleccionInternacional_2);
		
		seleccionInternacional_3 = new JCheckBox("Europa Press");
		seleccionInternacional_3.setBounds(100, 310, 140, 20);
		add(seleccionInternacional_3);

		seccionTecnologia = new JLabel(TipoNoticia.TECNOLOGIA.toString());
		seccionTecnologia.setBounds(350, 250, 140, 20);
		add(seccionTecnologia);

		seleccionTecnologia_1 = new JCheckBox("La Razon");
		seleccionTecnologia_1.setBounds(350, 270, 140, 20);
		add(seleccionTecnologia_1);
		
		seleccionTecnologia_2 = new JCheckBox("Xataka");
		seleccionTecnologia_2.setBounds(350, 290, 140, 20);
		add(seleccionTecnologia_2);
		
		seleccionTecnologia_3 = new JCheckBox("Vandal El Español");
		seleccionTecnologia_3.setBounds(350, 310, 140, 20);
		add(seleccionTecnologia_3);

		seccionVideojuego = new JLabel(TipoNoticia.VIDEOJUEGO.toString());
		seccionVideojuego.setBounds(575, 250, 140, 20);
		add(seccionVideojuego);

		seleccionVideojuego_1 = new JCheckBox("La Nueva España");
		seleccionVideojuego_1.setBounds(575, 270, 140, 20);
		add(seleccionVideojuego_1);
		
		seleccionVideojuego_2 = new JCheckBox("El Espectador");
		seleccionVideojuego_2.setBounds(575, 290, 140, 20);
		add(seleccionVideojuego_2);
		
		seleccionVideojuego_3 = new JCheckBox("El Periódico");
		seleccionVideojuego_3.setBounds(575, 310, 140, 20);
		add(seleccionVideojuego_3);

		selecciones = new JButton("Confirmar");
		selecciones.setBounds(650, 400, 120, 20);
		selecciones.addActionListener(new Eventos());
		add(selecciones);
	}
}
