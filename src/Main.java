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
                    alteredLangName = alteredLangName.replace('a', '??');
                    alteredLangName = alteredLangName.replace('b', '??'); // -> q
                    alteredLangName = alteredLangName.replace('c', '??');
                    alteredLangName = alteredLangName.replace('d', '??'); // -> p
                    alteredLangName = alteredLangName.replace('e', '??');
                    alteredLangName = alteredLangName.replace('f', '??');
                    alteredLangName = alteredLangName.replace('g', '??');
                    alteredLangName = alteredLangName.replace('h', '??');
                    alteredLangName = alteredLangName.replace('i', '???');
                    alteredLangName = alteredLangName.replace('j', '??');
                    alteredLangName = alteredLangName.replace('k', '??');
                    alteredLangName = alteredLangName.replace('m', '??');
                    alteredLangName = alteredLangName.replace('n', '??'); // -> u
                    alteredLangName = alteredLangName.replace('p', '??'); // -> d
                    alteredLangName = alteredLangName.replace('q', '??'); // -> b
                    alteredLangName = alteredLangName.replace('r', '??');
                    alteredLangName = alteredLangName.replace('t', '??');
                    alteredLangName = alteredLangName.replace('u', '??'); // -> n
                    alteredLangName = alteredLangName.replace('v', '??');
                    alteredLangName = alteredLangName.replace('w', '??');
                    alteredLangName = alteredLangName.replace('y', '??');

                    alteredLangName = alteredLangName.replace('A', '???');
                    alteredLangName = alteredLangName.replace('B', '???');
                    alteredLangName = alteredLangName.replace('C', '??');
                    alteredLangName = alteredLangName.replace('D', '???');
                    alteredLangName = alteredLangName.replace('E', '??');
                    alteredLangName = alteredLangName.replace('F', '???');
                    alteredLangName = alteredLangName.replace('G', '???');
                    alteredLangName = alteredLangName.replace('J', '??');
                    alteredLangName = alteredLangName.replace('L', '???');
                    alteredLangName = alteredLangName.replace('M', '??'); // -> W
                    alteredLangName = alteredLangName.replace('P', '??');
                    alteredLangName = alteredLangName.replace('Q', '???');
                    alteredLangName = alteredLangName.replace('R', '???');
                    alteredLangName = alteredLangName.replace('T', '???');
                    alteredLangName = alteredLangName.replace('U', '???');
                    alteredLangName = alteredLangName.replace('V', '??');
                    alteredLangName = alteredLangName.replace('W', '??'); // -> M
                    alteredLangName = alteredLangName.replace('Y', '???');

                    alteredLangName = alteredLangName.replace('1', '??');
                    alteredLangName = alteredLangName.replace('2', '???');
                    alteredLangName = alteredLangName.replace('3', '??');
                    alteredLangName = alteredLangName.replace('4', '???');
                    alteredLangName = alteredLangName.replace('5', '??');
                    alteredLangName = alteredLangName.replace('6', '??'); // -> 9
                    alteredLangName = alteredLangName.replace('7', '???');
                    alteredLangName = alteredLangName.replace('9', '??'); // -> 6

                    alteredLangName = alteredLangName.replace(',', '??'); // -> '
                    alteredLangName = alteredLangName.replace('.', '??');
                    alteredLangName = alteredLangName.replace('?', '??');
                    alteredLangName = alteredLangName.replace('!', '??');
                    alteredLangName = alteredLangName.replace('\"', '??'); // -> ,,
                    alteredLangName = alteredLangName.replace('\'', '??'); // -> ,
                    alteredLangName = alteredLangName.replace('`', '??'); // ->

                    //Set to the character they need to be
                    alteredLangName = alteredLangName.replace('??', 'q'); // b -> q
                    alteredLangName = alteredLangName.replace('??', 'p'); // d -> p
                    alteredLangName = alteredLangName.replace('??', 'u'); // n -> u
                    alteredLangName = alteredLangName.replace('??', 'd'); // p -> d
                    alteredLangName = alteredLangName.replace('??', 'b'); // q -> b
                    alteredLangName = alteredLangName.replace('??', 'n'); // u -> n
                    alteredLangName = alteredLangName.replace('??', 'w'); // M -> W
                    alteredLangName = alteredLangName.replace('??', 'm'); // W -> M
                    alteredLangName = alteredLangName.replace('??', '\''); // , -> '
                    alteredLangName = alteredLangName.replace("??", ",,"); // " -> ,,
                    alteredLangName = alteredLangName.replace('??', ','); // ' -> , or ` -> ,
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