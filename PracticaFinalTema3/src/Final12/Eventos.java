package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {
    private int i = 0;
    
    public Eventos() {
	}

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getID() == 0) {
            PanelCarga.barraCarga.setValue(i += 20);		
		    
            if(i > 100) {
			    Ventana.pc.setVisible(false);
			    Ventana.ps.setVisible(true);
			    PanelCarga.tiempo.stop();
            }
        } else if(e.getID() + 1 == 1) {
            IO.println(e.getID());
            Ventana.ps.setVisible(false);
		    Ventana.pu.setVisible(true);
        }
    }
}
