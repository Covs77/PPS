package bmicalc;


public class BMICalcImpl implements CardiovascularMetrics, MetabolicMetrics {

	public double calculateBodyMassIndex(double mass, double height) {
		if (mass <= 0 || height <= 0) {
			throw new ArithmeticException("Values cannot be a zero or a negative number");
		}
		double bmi = mass / (Math.pow(height, 2));
		return bmi;
	}

	@Override 
	public ObesityCategory getObesityCategory(double bmi){
		if (bmi == 0 || bmi < 0) {
			throw new RuntimeException("BMI cannot be a zero or a negative number");
		}
		if (bmi < 18.5) {
			return ObesityCategory.UNDERWEIGHT;
		} else if(bmi > 18.5 && bmi < 24.9) {
			return ObesityCategory.NORMAL;
		} else if(bmi > 25.0 && bmi < 29.9) {
			return ObesityCategory.OVERWEIGHT;
		} else {
			return ObesityCategory.OBESE;
		}
	}
	
	@Override

	public boolean abdominalObesity(double waistCircumference, Gender gender) {
		if (gender != Gender.FEMALES && gender != Gender.MALE) {
			throw new IllegalArgumentException("That value is not possible");
		}
		if (waistCircumference > 80 && gender == Gender.FEMALES) {
			return true;
		} else if (waistCircumference > 90 && gender == Gender.MALE){
			return true;
		} else {
			return false;
		}
		
	}

}
