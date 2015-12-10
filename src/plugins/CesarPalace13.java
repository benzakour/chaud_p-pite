package plugins;

public class CesarPalace13 implements Plugin{

	@Override
	public String transform(String curentString) {
		char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String newString = "";
		for(int i=0; i< curentString.length(); i++){
			int pos = nextPos(curentString.charAt(i));
			if(pos != -1)
				if(Character.isUpperCase(curentString.charAt(i)))
					newString += Character.toUpperCase(alphabet[pos]);
				else
					newString += alphabet[pos];
			else
				newString += curentString.charAt(i);
		}
		return newString;
	}

	@Override
	public String getLabel() {
		return "Cesar Palace 13";
	}

	private int nextPos(char caracter){
		int cara = (int) caracter;
		if(cara <= 90 && cara >= 65){
			return (((cara - 65) + 13)% 26);
		}
		if(cara <= 122 && cara >= 97){
			return (((cara - 97) + 13)% 26);
		}
		return -1;
	}
}