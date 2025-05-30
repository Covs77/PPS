
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;
import bmicalc.Gender;
import bmicalc.ObesityCategory;

public class Controlador implements ActionListener{
	
	private BMIcalculator vista;
	private BMICalcImpl modelo;
	
	public Controlador(BMICalcImpl modelo, BMIcalculator vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals("Calculate BMI")) {
			// Calcular bmi
			double a = vista.getInputHeight();
			double b = vista.getInputMass();
			double resultado = modelo.calculateBodyMassIndex(b,a);	
			vista.setResultadoBMI(resultado);
			
		} else if(comando.equals("Determine Category")) {
			//determinar categoria
			double a = vista.getInputHeight();
			double b = vista.getInputMass();
			double resultado = modelo.calculateBodyMassIndex(b,a);
			ObesityCategory categoria = modelo.getObesityCategory(resultado);
			vista.setResultadoCategory(categoria);
			
		} else {
			double a = vista.getInputWaistCircunference();
			Gender b = vista.ValideRadios();
			boolean resultado = modelo.abdominalObesity(a, b);
			String res = "";
			if (resultado == false) {
				res = "You don't have abdominal obesity";
			} else if (resultado == true) {
				res = "You have abdominal obesity";
			} else {
				throw new RuntimeException("Error");
			}
			vista.setResultadoAbdominalObesity(res);
			
		}
	}
	


}
