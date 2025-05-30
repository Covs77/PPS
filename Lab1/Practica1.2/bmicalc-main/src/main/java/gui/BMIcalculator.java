
package gui;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bmicalc.Gender;
import bmicalc.ObesityCategory;

import javax.swing.JRadioButton;
import javax.management.RuntimeErrorException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

public class BMIcalculator extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField height;
	private JTextField mass;
	private JTextField waist_circunference;
	private JTextField bmi_result;
	private JTextField category_result;
	private JTextField abdominal_result;
	private JButton btn_bmi,btn_category, btn_abdominal;
	private JRadioButton male, female;
	
	private ButtonGroup grupo_botones;

	/**
	 * Create the application.
	 */
	public BMIcalculator() {
		
		setBounds(100, 100, 538, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JLabel Label_Height = new JLabel("Height (m)");
		Label_Height.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Label_Height.setBounds(20, 49, 71, 13);
		getContentPane().add(Label_Height);
		
		JLabel Label_mass = new JLabel("Mass (kg)");
		Label_mass.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Label_mass.setBounds(20, 83, 60, 13);
		getContentPane().add(Label_mass);
		
		JLabel Label_waist = new JLabel("Waist Circunference (cm)");
		Label_waist.setFont(new Font("Century Gothic", Font.BOLD, 10));
		Label_waist.setBounds(36, 127, 137, 13);
		getContentPane().add(Label_waist);
		
		
		height = new JTextField();
		height.setBounds(80, 46, 96, 19);
		getContentPane().add(height);
		height.setColumns(10);
		
		mass = new JTextField();
		mass.setBounds(80, 80, 96, 19);
		getContentPane().add(mass);
		mass.setColumns(10);
		
		
		waist_circunference = new JTextField();
		waist_circunference.setBounds(46, 150, 96, 19);
		getContentPane().add(waist_circunference);
		waist_circunference.setColumns(10);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("Century Gothic", Font.BOLD, 10));
		male.setBounds(238, 45, 103, 21);
		getContentPane().add(male);
		
		female = new JRadioButton("Female");
		female.setFont(new Font("Century Gothic", Font.BOLD, 10));
		female.setBounds(238, 79, 103, 21);
		getContentPane().add(female);
		
		grupo_botones = new ButtonGroup();
		
		grupo_botones.add(male);
		grupo_botones.add(female);
		
		btn_bmi = new JButton("Calculate BMI");
		btn_bmi.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btn_bmi.setBackground(new Color(255, 128, 0));
		btn_bmi.setBounds(127, 212, 137, 35);
		getContentPane().add(btn_bmi);
		
		btn_category = new JButton("Determine Category");
		btn_category.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btn_category.setBackground(new Color(255, 128, 0));
		btn_category.setBounds(122, 274, 160, 35);
		getContentPane().add(btn_category);
		
		btn_abdominal = new JButton("Abdominal Obesity");
		btn_abdominal.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btn_abdominal.setBackground(new Color(255, 128, 0));
		btn_abdominal.setBounds(127, 335, 137, 35);
		getContentPane().add(btn_abdominal);
		
		bmi_result = new JTextField();
		bmi_result.setEditable(false);
		bmi_result.setBounds(290, 220, 150, 19);
		getContentPane().add(bmi_result);
		bmi_result.setColumns(10);
		
		category_result = new JTextField();
		category_result.setEditable(false);
		category_result.setBounds(303, 282, 137, 19);
		getContentPane().add(category_result);
		category_result.setColumns(10);
		
		abdominal_result = new JTextField();
		abdominal_result.setEditable(false);
		abdominal_result.setBounds(290, 343, 180, 19);
		getContentPane().add(abdominal_result);
		abdominal_result.setColumns(10);
		
		
		setVisible(true);
	}
	
	
	public double getInputHeight() {
		
		return Double.parseDouble(height.getText());
	}
	
	public double getInputMass() {
		return Double.parseDouble(mass.getText());
	}
	
	public double getInputWaistCircunference() {
		return Double.parseDouble(waist_circunference.getText());
	}
	
	public Gender ValideRadios() {
		if (female.isSelected()) {
			return Gender.FEMALES;
			
		} else if(male.isSelected()) {
			return Gender.MALE;
		} else {
			throw new RuntimeException("Porfavor seleccione el sexo correcto");
		}
	}
	
	
	public void setResultadoBMI(double res) {
		bmi_result.setText(""+ res);
	}
	
	public void setResultadoCategory(ObesityCategory res) {
		category_result.setText(""+ res);
	}
	
	public void setResultadoAbdominalObesity(String res) {
		abdominal_result.setText(""+res);
	}
	
	public void registrarControlador(ActionListener ctrl) {
		btn_bmi.addActionListener(ctrl);
		btn_bmi.setActionCommand("Calculate BMI");
		
		btn_category.addActionListener(ctrl);
		btn_category.setActionCommand("Determine Category");
		
		btn_abdominal.addActionListener(ctrl);
		btn_abdominal.setActionCommand("Abdominal Obesity");
	}
	
	
}
