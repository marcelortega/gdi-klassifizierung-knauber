import static gdi.MakeItSimple.*;

public class CalorieCalculator {

	public static void main(String[] args) {
		float weight = 0.0f;
		float size = 0.0f;
		float metabolicRate = 0.0f;
		int age = 0;
		char gender = ' ';
		
		println("Geben Sie Ihr Gewicht in kg ein: ");
		weight = readFloat();
		readLine();

		println("Geben Sie Ihre Koerpergroesse in cm ein: ");
		size = readFloat(); 
		readLine();

		println("Geben Sie Ihr Alter in Jahren ein: ");
		age = readInt(); 
		readLine();

		println("Geben Sie Ihr Geschlecht ein (m fuer maennlich oder w fuer weiblich): ");
		gender = readChar(); 

		/* 
		 * wenn weight nicht zwischen 1 und 700 kg liegt, age nicht zwischen 1 und 140 Jahren liegt, 
		 * size nicht zwischen 35 und 300 cm liegt und gender nicht m oder w ist, ist die Eingabe ungueltig
		 */
		if (weight < 1 || weight > 700 || age < 1 || age > 140 || size < 35 || size > 300 || (gender != 'm' && gender != 'w')) {
			println("Eingabe ungueltig.");
		} else {
			if (gender == 'm') { //wenn maennlich
				metabolicRate = 66.47f + 13.7f * weight + 5 * size - 6.8f * age;
			} else { //wenn weiblich
				metabolicRate = 655.1f + 9.6f * weight + 1.8f * size - 4.7f * age;
			}
			println("Ihr Grundumsatz betraegt " + metabolicRate + " Kalorien pro Tag.");
		}
	}
}