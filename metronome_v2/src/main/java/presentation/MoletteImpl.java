package presentation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import materiel.Molette;

public class MoletteImpl extends JPanel implements Molette {

	// Un slider pour le tempo
	private JSlider molette;

	// boolea si actif
	private boolean hasChanged;
	private float value;

	public MoletteImpl() {

		molette = new JSlider(JSlider.HORIZONTAL, 0, 10, 10);// direction , min
		// , max ,
		// current
		molette.setFont(new Font("Tahoma", Font.BOLD, 12));
		molette.setMajorTickSpacing(2);
		molette.setMinorTickSpacing(1);

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("0.0"));
		labelTable.put(new Integer(2), new JLabel("0.2"));
		labelTable.put(new Integer(4), new JLabel("0.4"));
		labelTable.put(new Integer(6), new JLabel("0.6"));
		labelTable.put(new Integer(8), new JLabel("0.8"));
		labelTable.put(new Integer(10), new JLabel("1.0"));

		molette.setLabelTable(labelTable);
		molette.setPaintLabels(true);
		molette.setPaintTicks(true);
		molette.setPaintTrack(true);
		molette.setAutoscrolls(true);
		molette.setPreferredSize(new Dimension(250, 250));

		add(molette);

		molette.addMouseListener(

		new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(" Mouse released ");

				hasChanged = true;
				value = molette.getValue() * 0.1f;
				System.out.println("Value has chaged to the new value :"
						+ value);
			}

		}

		);

		molette.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// controler.updateMolette(molette.getValue() * 0.1);
			}
		});

	}

	public float getPosition() {
		return 0;
	}

}
