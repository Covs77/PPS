
package gui;

import bmicalc.BMICalcImpl;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalcImpl modelo = new BMICalcImpl();
					BMIcalculator vista = new BMIcalculator();
					Controlador controlador = new Controlador(modelo, vista);
					vista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
