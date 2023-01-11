import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //Read the lines into an array named lang (this gets everything, no buffer overflow)
        ArrayList<String> lang = new ArrayList<>();

        try (FileReader f = new FileReader("en_us.json")) {
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '\n') {
                    lang.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                lang.add(sb.toString());
            }
        }

        // Clear the output file before use
        PrintWriter writer = new PrintWriter("en_ud.json");
        writer.print("");
        writer.close();

        // Get output initialized
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("en_ud.json", true));
        bufferedWriter.write("{\n");

        // Alter the lang files
        int endPoint = lang.size() - 1;
        for (int i = 1; i < endPoint; i++) { // Skip the '{' and '}'
            String line = lang.get(i); // The current line being worked on
            //System.out.println(line); //Testing purposes

            //Only run this if the line contains a colon (thus not on blank lines
            if (line.contains(":")) {
                String codeName = line.substring(0, line.indexOf(':'));
                String langName = line.substring(line.indexOf(':') + 1);
                //System.out.println(codeName + ": " + langName); //Testing purposes

                //Get the lang name without the parenthesis, comma, and line break (these can't end up changed)
                String alteredLangName = langName.substring(langName.indexOf("\"") + 1, langName.lastIndexOf("\""));

                if (codeName.contains(".color")) {
                    // This is the final point and this item cannot be altered without breaking the lang
                } else {
                    // Change this sequence first
                    alteredLangName = alteredLangName.replace("\\\"", ",,");

                    //Set to distinct character first, if they need to be changed
                    alteredLangName = alteredLangName.replace('a', 'ɐ');
                    alteredLangName = alteredLangName.replace('b', 'α'); // -> q
                    alteredLangName = alteredLangName.replace('c', 'ɔ');
                    alteredLangName = alteredLangName.replace('d', 'β'); // -> p
                    alteredLangName = alteredLangName.replace('e', 'ǝ');
                    alteredLangName = alteredLangName.replace('f', 'ɟ');
                    alteredLangName = alteredLangName.replace('g', 'ƃ');
                    alteredLangName = alteredLangName.replace('h', 'ɥ');
                    alteredLangName = alteredLangName.replace('i', 'ᴉ');
                    alteredLangName = alteredLangName.replace('j', 'ɾ');
                    alteredLangName = alteredLangName.replace('k', 'ʞ');
                    alteredLangName = alteredLangName.replace('m', 'ɯ');
                    alteredLangName = alteredLangName.replace('n', 'γ'); // -> u
                    alteredLangName = alteredLangName.replace('p', 'δ'); // -> d
                    alteredLangName = alteredLangName.replace('q', 'ε'); // -> b
                    alteredLangName = alteredLangName.replace('r', 'ɹ');
                    alteredLangName = alteredLangName.replace('t', 'ʇ');
                    alteredLangName = alteredLangName.replace('u', 'ζ'); // -> n
                    alteredLangName = alteredLangName.replace('v', 'ʌ');
                    alteredLangName = alteredLangName.replace('w', 'ʍ');
                    alteredLangName = alteredLangName.replace('y', 'ʎ');

                    alteredLangName = alteredLangName.replace('A', 'Ɐ');
                    alteredLangName = alteredLangName.replace('B', 'ᗺ');
                    alteredLangName = alteredLangName.replace('C', 'Ɔ');
                    alteredLangName = alteredLangName.replace('D', 'ᗡ');
                    alteredLangName = alteredLangName.replace('E', 'Ǝ');
                    alteredLangName = alteredLangName.replace('F', 'Ⅎ');
                    alteredLangName = alteredLangName.replace('G', '⅁');
                    alteredLangName = alteredLangName.replace('J', 'Ր');
                    alteredLangName = alteredLangName.replace('L', 'Ꞁ');
                    alteredLangName = alteredLangName.replace('M', 'η'); // -> W
                    alteredLangName = alteredLangName.replace('P', 'Ԁ');
                    alteredLangName = alteredLangName.replace('Q', 'Ꝺ');
                    alteredLangName = alteredLangName.replace('R', 'ᴚ');
                    alteredLangName = alteredLangName.replace('T', '⟘');
                    alteredLangName = alteredLangName.replace('U', '∩');
                    alteredLangName = alteredLangName.replace('V', 'Λ');
                    alteredLangName = alteredLangName.replace('W', 'θ'); // -> M
                    alteredLangName = alteredLangName.replace('Y', '⅄');

                    alteredLangName = alteredLangName.replace('1', 'Ɩ');
                    alteredLangName = alteredLangName.replace('2', 'ᄅ');
                    alteredLangName = alteredLangName.replace('3', 'Ɛ');
                    alteredLangName = alteredLangName.replace('4', 'ㄣ');
                    alteredLangName = alteredLangName.replace('5', 'ϛ');
                    alteredLangName = alteredLangName.replace('6', 'ι'); // -> 9
                    alteredLangName = alteredLangName.replace('7', 'ㄥ');
                    alteredLangName = alteredLangName.replace('9', 'κ'); // -> 6

                    alteredLangName = alteredLangName.replace(',', 'λ'); // -> '
                    alteredLangName = alteredLangName.replace('.', '˙');
                    alteredLangName = alteredLangName.replace('?', '¿');
                    alteredLangName = alteredLangName.replace('!', '¡');
                    alteredLangName = alteredLangName.replace('\"', 'μ'); // -> ,,
                    alteredLangName = alteredLangName.replace('\'', 'ξ'); // -> ,
                    alteredLangName = alteredLangName.replace('`', 'ξ'); // ->

                    //Set to the character they need to be
                    alteredLangName = alteredLangName.replace('α', 'q'); // b -> q
                    alteredLangName = alteredLangName.replace('β', 'p'); // d -> p
                    alteredLangName = alteredLangName.replace('γ', 'u'); // n -> u
                    alteredLangName = alteredLangName.replace('δ', 'd'); // p -> d
                    alteredLangName = alteredLangName.replace('ε', 'b'); // q -> b
                    alteredLangName = alteredLangName.replace('ζ', 'n'); // u -> n
                    alteredLangName = alteredLangName.replace('η', 'w'); // M -> W
                    alteredLangName = alteredLangName.replace('θ', 'm'); // W -> M
                    alteredLangName = alteredLangName.replace('λ', '\''); // , -> '
                    alteredLangName = alteredLangName.replace("μ", ",,"); // " -> ,,
                    alteredLangName = alteredLangName.replace('ξ', ','); // ' -> , or ` -> ,
                }

                //Reverse the text
                StringBuilder stringBuilder = new StringBuilder(alteredLangName);
                stringBuilder.reverse();

                // Create the correct output
                try {
                    if (i == endPoint - 1) { //The final line does not get a trailing comma
                        bufferedWriter.write(codeName + ": \"" + alteredLangName + "\"\n");
                    } else {
                        bufferedWriter.write(codeName + ": \"" + alteredLangName + "\",\n");
                    }
                } catch (IOException e){}
            }
        }

        // Finish the file
        bufferedWriter.write("}");
        bufferedWriter.close();
    }
}