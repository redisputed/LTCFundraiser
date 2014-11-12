/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert rall
 */
public class Person
{

    private String firstName;
    private String lastName;
    private double amtPledged;
    private String Charity;

    public Person(String fname, String lname, double amt, String charity)
    {
        firstName = fname;
        lastName = lname;
        this.setAmt(amt);
        Charity = charity;
    }

    public String getName()
    {
        return firstName + " " + lastName;
    }

    public void setName(String fname, String lname)
    {
        firstName = fname;
        lastName = lname;
    }

    public double getAmt()
    {
        return amtPledged;
    }

    public String getAmtAsFormattedString()
    {
        return String.format("$%.2f", amtPledged);
    }

    public final void setAmt(double amt)
    {
        if (amt > 0)
        {
            amtPledged = amt;
        }
        else
        {
            amtPledged = 0.0;
        }

    }

    public String getCharity()
    {
        return Charity;
    }

    public void setCharity(String charity)
    {
        Charity = charity;
    }

    public String writeToFile(char delim)
    {
        //Written by John
        String output = firstName + delim;
        output += lastName + delim;
        output += String.valueOf(amtPledged) + delim;
        output += Charity + delim;

        return output;
    }

}
