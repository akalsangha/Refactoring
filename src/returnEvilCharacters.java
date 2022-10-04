import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;


class Character{

    String name;
    int age;
    String characteristic;
    int strength;

    public Character(String name, int age, String characteristic, int strength)
    {
        this.name = name;
        this.age = age;
        this.characteristic = characteristic;
        this.strength = strength;

    }
}


class compareByName implements Comparator<Character>
{
    @Override
    public int compare(Character c1, Character c2) {
        return c1.name.compareTo(c2.name);
    }
}

class ageCompare implements Comparator<Character>{



    @Override
    public int compare(Character c1, Character c2) {
        return c2.age - c1.age;
    }
}

class strengthCompare implements Comparator<Character>
{


    @Override
    public int compare(Character c1, Character c2) {
        return c2.strength - c1.strength;
    }
}




public class returnEvilCharacters {
    public static void main(String[] args)throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\akalj\\OneDrive\\Desktop\\CPSC513\\input.txt"));

        ArrayList<Character> records = new ArrayList<Character>();
        String currentLineBeingRead = reader.readLine();

        while (currentLineBeingRead != null)
            {
                String[] details = currentLineBeingRead.split(" ");
                String firstPart = details[0];

                int secondPart = Integer.valueOf(details[1]);

                String thirdPart = details[2];

                int fourthPart = Integer.valueOf(details[3]);

                records.add(new Character(firstPart, secondPart, thirdPart, fourthPart));

                currentLineBeingRead = reader.readLine();


            }

        Collections.sort(records, new strengthCompare());

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\akalj\\OneDrive\\Desktop\\CPSC513\\output.txt"));

        String testString = "Evil";
        for (Character character : records)
        {
            if (Objects.equals(character.characteristic, testString))
            {
                writer.write(character.name);
                writer.write(" "+character.age);
                writer.write(" "+character.characteristic);
                writer.write(" "+character.strength);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();












    }
}


