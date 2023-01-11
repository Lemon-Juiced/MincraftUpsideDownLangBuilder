import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("en_us.json"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("en_ud.json"));
        writer.write("{\n"); //Begin the file

        // Loop through the original lang file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line == null || line.equals("") ){/*Skip*/} //If line is null or line is blank
            else if(line.startsWith("{") || line.startsWith("}")){/*Skip*/} // If begins or ends file
            else {
                //Split the line to code name and lang name
                String part0 = line.substring(0, line.indexOf(':')); //Not needed until print out
                String part1 = line.substring(line.indexOf(':'));

                String part1aug = ": \"";
                for (int i = 0; i < part1.length(); i++) {
                    part1aug = ": \"";
                    char c = part1.charAt(i);
                    switch (c) {
                        case ':', ' ' -> { } // Skip ':' and ' '
                        case 'a' -> part1aug = part1aug +"ɐ";
                        case 'b' -> part1aug = part1aug +"q";
                        case 'c' -> part1aug = part1aug + "ɔ";
                        case 'd' -> part1aug = part1aug + "p";
                        case 'e' -> part1aug = part1aug + "ǝ";
                        case 'f' -> part1aug = part1aug + "ɟ";
                        case 'g' -> part1aug = part1aug + "ƃ";
                        case 'h' -> part1aug = part1aug + "ɥ";
                        case 'i' -> part1aug = part1aug + "ᴉ";
                        case 'j' -> part1aug = part1aug + "ɾ";
                        case 'k' -> part1aug = part1aug + "ʞ";
                        case 'l' -> part1aug = part1aug + "l";
                        case 'm' -> part1aug = part1aug + "ɯ";
                        case 'n' -> part1aug = part1aug + "u";
                        case 'o' -> part1aug = part1aug + "o";
                        case 'p' -> part1aug = part1aug + "d";
                        case 'q' -> part1aug = part1aug + "b";
                        case 'r' -> part1aug = part1aug + "ɹ";
                        case 's' -> part1aug = part1aug + "s";
                        case 't' -> part1aug = part1aug + "ʇ";
                        case 'u' -> part1aug = part1aug + "n";
                        case 'v' -> part1aug = part1aug + "ʌ";
                        case 'w' -> part1aug = part1aug + "ʍ";
                        case 'x' -> part1aug = part1aug + "x";
                        case 'y' -> part1aug = part1aug + "ʎ";
                        case 'z' -> part1aug = part1aug + "z";
                        case 'A' -> part1aug = part1aug + "∀";
                        case 'B' -> part1aug = part1aug + "B";
                        case 'C' -> part1aug = part1aug + "Ɔ";
                        case 'D' -> part1aug = part1aug + "D";
                        case 'E' -> part1aug = part1aug + "Ǝ";
                        case 'F' -> part1aug = part1aug + "Ⅎ";
                        case 'G' -> part1aug = part1aug + "פ";
                        case 'H' -> part1aug = part1aug + "H";
                        case 'I' -> part1aug = part1aug + "I";
                        case 'J' -> part1aug = part1aug + "ſ";
                        case 'K' -> part1aug = part1aug + "K";
                        case 'L' -> part1aug = part1aug + "˥";
                        case 'M' -> part1aug = part1aug + "W";
                        case 'N' -> part1aug = part1aug + "N";
                        case 'O' -> part1aug = part1aug + "O";
                        case 'P' -> part1aug = part1aug + "Ԁ";
                        case 'Q' -> part1aug = part1aug + "Q";
                        case 'R' -> part1aug = part1aug + "R";
                        case 'S' -> part1aug = part1aug + "S";
                        case 'T' -> part1aug = part1aug + "┴";
                        case 'U' -> part1aug = part1aug + "∩";
                        case 'V' -> part1aug = part1aug + "Λ";
                        case 'W' -> part1aug = part1aug + "M";
                        case 'X' -> part1aug = part1aug + "X";
                        case 'Y' -> part1aug = part1aug + "⅄";
                        case 'Z' -> part1aug = part1aug + "Z";
                        case '0' -> part1aug = part1aug + "0";
                        case '1' -> part1aug = part1aug + "Ɩ";
                        case '2' -> part1aug = part1aug + "ᄅ";
                        case '3' -> part1aug = part1aug + "Ɛ";
                        case '4' -> part1aug = part1aug + "ㄣ";
                        case '5' -> part1aug = part1aug + "ϛ";
                        case '6' -> part1aug = part1aug + "9";
                        case '7' -> part1aug = part1aug + "ㄥ";
                        case '8' -> part1aug = part1aug + "8";
                        case '9' -> part1aug = part1aug + "6";
                        case ',' -> part1aug = part1aug + "'";
                        case '.' -> part1aug = part1aug + "˙";
                        case '?' -> part1aug = part1aug + "¿";
                        case '!' -> part1aug = part1aug + "¡";
                        case '"' -> part1aug = part1aug + ",,";
                        case '\'' -> part1aug = part1aug + ",";
                        case '`' -> part1aug = part1aug + ",";
                    }
                }
                writer.write(part0 + part1aug + "\",\n");
            }
        }
        writer.write("}");
    }
}