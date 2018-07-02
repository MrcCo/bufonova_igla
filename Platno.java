package bufonova_igla;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Platno extends Canvas {

	Igla igla;
	int a2;
	int l2;

	// number of needles crossing the line
	int countCrossing;
	// number of attempts
	int count;
	// current value of pi
	double piValue;

	public Platno(int a2, int l2) {
		if (a2 < 273) {
			this.a2 = a2;
		} else {
			this.a2 = 273;
		}
		this.l2 = l2;
		piValue = 0;
		igla = new Igla(this, l2);
	}

	public void setL2(int l2) {
		igla.l2 = l2;
		this.l2 = l2;
	}

	// drawing the needle and calculating the current value of pi
	public void drawIgla() {

		Graphics g = getGraphics();
		g.clearRect(0, 0, getWidth(), getHeight());
		paint(g);

		g.setColor(Color.red);
		System.out.println("X0 = " + igla.x0 + "Y0 = " + igla.y0 + " alpha = " + igla.alpha);
		System.out.println("X1 = " + igla.x1 + "Y1 = " + igla.y1);
		g.drawLine(igla.x0, igla.y0, igla.x1, igla.y1);

		boolean uslov1;
		// boolean uslov2 = igla.y1 > (this.getHeight() - a2) / 2 && igla.y0 <
		// (this.getHeight() - a2) / 2;
		// boolean uslov3 = igla.y1 > (this.getHeight() + a2) / 2 && igla.y0 <
		// (this.getHeight() + a2) / 2;
		// boolean uslov4 = igla.y0 > (this.getHeight() + a2) / 2 && igla.y1 <
		// (this.getHeight() + a2) / 2;
		uslov1 = igla.y0 > (this.getHeight() - a2) / 2 && igla.y1 > (this.getHeight() - a2) / 2
				&& igla.y0 <= (this.getHeight() + a2) / 2 && igla.y1 <= (this.getHeight() + a2) / 2;

		if (!uslov1) {
			System.out.println("Neki uslov je ispunjen");
			countCrossing++;
			System.out.println(countCrossing);
		}



		// if (!uslov1) {
		// count++;
		// }

		count++;

		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (countCrossing != 0)
			piValue = 2 * (double) l2 * (double) count / (double) (a2 * countCrossing);

	}

	public void makeIgla() {
		igla.makeIgla(this, l2);
	}

	public void resetParams(int a2) {

		this.a2 = a2;
		Graphics g = this.getGraphics();
		g.clearRect(0, 0, getWidth(), getHeight());
		count = 0;
		countCrossing = 0;
		piValue = 0;
		repaint();

	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), (this.getHeight() - a2) / 2);
		g.fillRect(0, (this.getHeight() + a2) / 2, this.getWidth(), (this.getHeight() - a2) / 2);

		System.out.println("Sirina platna je: " + getWidth() + ", a visina: " + getHeight());

	}

}
