package Final12;

import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel {
    private JTextField miTextoATraducir;
	private JLabel miEtiqueta1;
	private JButton miBotonTraductor;
	private JLabel miEtiqueta2;
	private JLabel miEtiquetaTraducida3;
	
	
	public Panel() {
		setMaximumSize(new Dimension(800, 600)); // Tamaño máximo del panel
		setLayout(null); // Panel absoluto.
		
		miEtiqueta1 = new JLabel("Palabra en inglés:");
		miEtiqueta1.setBounds(60, 70, 114, 14);
		add(miEtiqueta1);
		
		miTextoATraducir = new JTextField();
		miTextoATraducir.setBounds(202, 67, 141, 20);
		add(miTextoATraducir);
		miTextoATraducir.setColumns(10);
		
		miEtiquetaTraducida3 = new JLabel("");
		miEtiquetaTraducida3.setHorizontalAlignment(SwingConstants.CENTER);
		miEtiquetaTraducida3.setBounds(202, 160, 141, 14);
		add(miEtiquetaTraducida3);
		
		miBotonTraductor = new JButton("Traducir");
		miBotonTraductor.setBounds(60, 110, 89, 23);
		add(miBotonTraductor);
		
		miEtiqueta2 = new JLabel("Palabra en español:");
		miEtiqueta2.setBounds(60, 160, 114, 14);
		add(miEtiqueta2);
		
		miBotonTraductor.addActionListener(new EventoTraducir(miTextoATraducir, miEtiquetaTraducida3));
    }
}
