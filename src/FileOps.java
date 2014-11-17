
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author john
 */
public class FileOps
{

    private String filename;

    /**
     * No Argument Class Constructor
     */
    public FileOps()
    {
        filename = "contacts.txt";
    }

    /**
     * Single Argument Class Constructor
     *
     * @param f String to name the file
     */
    public FileOps(String f)
    {
        filename = f;
    }

    /**
     * A method to create a .txt file containing 1 person per line in the
     * format:
     * firstName;lastName;amtPledged;Charity
     *
     * @param people an ArrayList of Person objects
     */
    public void saveFile(ArrayList<Person> people)
    {
        // this code comes from Starting out with Java:Early Objects 4th ed
        // by Tony Gaddis Published Addison-Wesley
        JFileChooser fileChooser = new JFileChooser(".");
        int status = fileChooser.showSaveDialog(null);

        if (status == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            filename = selectedFile.getPath();
        }

        try (PrintWriter outputFile = new PrintWriter(filename))
        {

            for (Person p : people)
            {
                outputFile.println(p.writeToFile(';'));
            }

        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * A method to load a .txt file containing 1 person per line in the format:
     * firstName;lastName;amtPledged;Charity
     *
     * @return ArrayList<Person> an ArrayList of person objects
     */
    public ArrayList<Person> loadFile()
    {
        ArrayList<Person> people = new ArrayList<>();
        // this code comes from Starting out with Java:Early Objects 4th ed
        // by Tony Gaddis Published Addison-Wesley

        JFileChooser fileChooser = new JFileChooser(".");
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            filename = selectedFile.getPath();
        }

        File file = new File(filename);
        try (Scanner inputFile = new Scanner(file))
        {

            while (inputFile.hasNext())
            {
                String line = inputFile.nextLine();
                String[] data = line.split(";");

                double amt = Double.parseDouble(data[2]);

                Person person = new Person(data[0], data[1], amt, data[3]);

                people.add(person);

            }
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return people;
    }

}
