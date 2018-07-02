package bufonova_igla;

import java.awt.Color;
import java.awt.Graphics;

public class Igla {

	int x0, y0;
	int x1, y1;
	double alpha;
	int l2;
	Platno platno;

	Igla(Platno platno, int l2) {

		makeIgla(platno, l2);

	}

	public void makeIgla(Platno platno, int l2) {

		this.platno = platno;
		this.x0 = (int) (Math.random() * 394);
		this.y0 = (int) (Math.random() * platno.a2 + (platno.getHeight() - platno.a2) / 2 + 1);

		this.l2 = l2;

		//alpha = Math.random() * Math.PI * 2;

		alpha = Math.random() * 360;
		
		this.x1 = (int) (this.x0 + (Math.cos(alpha) * this.l2));
		this.y1 = (int) (this.y0 + (Math.sin(alpha) * this.l2));

		boolean uslov1 = (y0 < (274 - platno.a2) / 2 && y1 < (274 - platno.a2) / 2)
				|| (y0 > (274 + platno.a2) / 2 && y1 > (274 + platno.a2) / 2);
		if (uslov1) {
			System.out.println("OPET POZVAO" + platno.count);
			makeIgla(platno, l2);
		}
	}

	public void drawIgla() {

	}
}
