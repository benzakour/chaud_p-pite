package plugins;

public class Happy implements Plugin{

	@Override
	public String transform(String curentString) {
		String happyString = "";
		for(int i=0; i<curentString.length(); i++){
			char letter = Character.toLowerCase(curentString.charAt(i));
			if(letter == 'a')
				happyString += " :) ";
			if(letter == 'e')
				happyString += " <3 ";
			if(letter == 'i')
				happyString += " ;) ";
			if(letter == 'o')
				happyString += " :D ";
			if(letter == 'u')
				happyString += " 8-) ";
			if(letter == 'y')
				happyString += " ;) ";
			happyString += curentString.charAt(i);
		}
		return happyString;
	}

	@Override
	public String getLabel() {
		return "happy string";
	}

}
