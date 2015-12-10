/**
 * Happy : happy plugin transform the curent string with the happy encrytpion
 */
package plugins;

public class Happy implements Plugin{

	/**
	 * this method transform the current string with the happy encryption
	 * replace the vowels with happy smile
	 * @param curentString : the curent string to transform
	 * @return the string transforming
	 */
	@Override
	public String transform(String curentString) {
		String happyString = "";
		for(int i=0; i<curentString.length(); i++){
			char letter = Character.toLowerCase(curentString.charAt(i));
			switch(letter){
			case 'a':
				happyString += " :) ";
				break;
			case 'e':
				happyString += " <3 ";
				break;
			case 'i':
				happyString += " ;) ";
				break;
			case 'o':
				happyString += " :D ";
				break;
			case 'u':
				happyString += " 8-) ";
				break;
			case 'y':
				happyString += " ;) ";
				break;
				default:
					happyString += curentString.charAt(i);
			}
		}
		return happyString;
	}

	/**
     * get the label of the plugin
     * @return the plugin name "Happy string"
     */
	@Override
	public String getLabel() {
		return "Happy string";
	}

}
