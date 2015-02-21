import static gdi.MakeItSimple.*;

public class BMICalculator {

	public static void main(String[] args) {
		float weight = 0.0f;
		float size = 0.0f;
		float bmi = 0.0f;
		char gender = ' ';
		
		println("Geben Sie Ihr Gewicht in kg ein: ");
		weight = readFloat();
		readLine();
		
		println("Geben Sie Ihre Koerpergroesse in m ein: ");
		size = readFloat(); 
		readLine();
		
		println("Geben Sie Ihr Geschlecht ein (m fuer maennlich oder w fuer weiblich): ");
		gender = readChar(); 
		
		//wenn weight nicht zwischen 1 und 700 kg liegt, size nicht zwischen 0.35 und 3 m liegt und gender nicht m oder w ist, ist die Eingabe ungueltig
		if (weight < 1 || weight > 700 || size < 0.35 || size > 3 || (gender != 'm' && gender != 'w')) {
			println("Eingabe ungueltig.");
		} else {
			bmi = weight / (size * size);
			
			if (gender == 'm') { //wenn maennlich
				if (bmi < 20) {
					println("Ihr BMI ist " + bmi + " und damit zu gering.");
				} else if (bmi > 25) {
					println("Ihr BMI ist " + bmi + " und damit zu hoch.");
				} else {
					println("Ihr BMI ist " + bmi + " und damit normal.");
				}
			} else { //wenn weiblich
				if (bmi < 19) {
					println("Ihr BMI ist " + bmi + " und damit zu gering.");
				} else if (bmi > 24) {
					println("Ihr BMI ist " + bmi + " und damit zu hoch.");
				} else {
					println("Ihr BMI ist " + bmi + " und damit normal.");
				}
			}
		}
	}
}
