package bufonova_igla;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Program extends Frame {
	Platno platno;

	Label piLabel = new Label("Pi = ");
	TextField piField = new TextField("0");
	Panel piPanel = new Panel(new GridLayout(1, 2));

	Label nLabel = new Label("n = ");
	TextField nField = new TextField("1");
	Panel nPanel = new Panel(new GridLayout(1, 2));

	Label a2Label = new Label("2 * a = ");
	TextField a2Field = new TextField("100");
	Panel a2Panel = new Panel(new GridLayout(1, 2));

	Label l2Label = new Label("2 * l = ");
	TextField l2Field = new TextField("50");
	Panel l2Panel = new Panel(new GridLayout(1, 2));

	Button simOnceButton = new Button("Baci iglu");
	Button simNTimesButton = new Button("Baci iglu n puta");
	Button newSimulationButton = new Button("Pokreni novu simulaciju");

	int n = 0;
	
	
	public Program() {

		this.setBounds(200, 200, 400, 400);
		this.setResizable(false);
		platno = new Platno(Integer.parseInt(a2Field.getText()), Integer.parseInt(l2Field.getText()));
		dodajKomponente();
		dodajEventove();

		this.setVisible(true);
	}

	private void dodajKomponente() {

		// adding the canvas
		Panel centerPanel = new Panel(new GridLayout(1, 1));
		centerPanel.add(platno);
		this.add(centerPanel, BorderLayout.CENTER);

		// creating the panel for the buttons
		Panel southPanel = new Panel(new GridLayout(4, 2));

		piPanel.add(piLabel);
		piField.setEditable(false);
		piField.setBackground(Color.white);
		piPanel.add(piField);
		southPanel.add(piPanel);

		southPanel.add(simOnceButton);

		nPanel.add(nLabel);
		nPanel.add(nField);
		southPanel.add(nPanel);

		southPanel.add(simNTimesButton);

		a2Panel.add(a2Label);
		a2Panel.add(a2Field);
		southPanel.add(a2Panel);

		southPanel.add(newSimulationButton);

		l2Panel.add(l2Label);
		l2Panel.add(l2Field);
		southPanel.add(l2Panel);

		this.add(southPanel, BorderLayout.SOUTH);
	}

	private void dodajEventove() {

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

		// dodavanje akcije za dugme za jednu simulaciju
		simOnceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				platno.setL2(Integer.parseInt(l2Field.getText()));
				platno.makeIgla();
				platno.drawIgla();
				piField.setText(Double.toString(platno.piValue));
				
			}
		});

		simNTimesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				for(int i = 0; i <  Integer.parseInt(nField.getText());i++) {
					platno.setL2(Integer.parseInt(l2Field.getText()));
					platno.makeIgla();
					platno.drawIgla();
					
					piField.setText(Double.toString(platno.piValue));
				}
				
			
			
			}
		});
		
		newSimulationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				platno.resetParams(Integer.parseInt(a2Field.getText()));
				l2Field.setText((new Integer(platno.l2)).toString());
				a2Field.setText((new Integer(platno.a2)).toString());	
				piField.setText((new Double(platno.piValue)).toString());
			}
		});
		
		l2Field.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
			System.out.println("TEXT FIELD EVENT");
				platno.resetParams(Integer.parseInt(a2Field.getText()));
				a2Field.setText((new Integer(platno.a2)).toString());	
				piField.setText((new Double(platno.piValue)).toString());
				
			}
		});

	}

	public static void main(String[] args) {
		new Program();
	}
}
