/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_lecturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chemo
 */
public class Lecturas
{

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    public static int LeerEntero()
    {
        try
        {
            return Integer.parseInt(br.readLine());
        } catch (IOException ex)
        {
            System.out.println("No se encontro el periferico de entrada...");
            return 0;
        } catch (NumberFormatException Error)
        {
            System.out.println("Se esperaba un entero");
            return 0;
        } catch (Exception Error)
        {
            System.out.println("ERROR..." + Error.toString());
            return 0;
        }
    }

    public static int LeerEntero(boolean b)
    {
        do
        {
            try
            {
                return Integer.parseInt(br.readLine());
            } catch (Exception Error)
            {
                System.out.println("ERROR..." + Error.toString());
                System.out.println("Vuelve a intentarlo...");
            }
        } while (b);
        return 0;
    }

    public static double LeerDoble()
    {
        try
        {
            return Double.parseDouble(br.readLine());
        } catch (IOException ex)
        {
            System.out.println("No se encontro el periferico de entrada...");
            return 0;
        } catch (NumberFormatException Error)
        {
            System.out.println("Se esperaba un doble");
            return 0;
        } catch (Exception Error)
        {
            System.out.println("ERROR..." + Error.toString());
            return 0;
        }
    }

    public static char LeerCaracter()
    {
        char c = ' ';
        try
        {
            String s = br.readLine();
            c = (char) br.read();
        } catch (Exception Error)
        {
            System.out.println("ERROR..." + Error);
        }
        return c;
    }

    public static String LeerCadena()
    {
        String s = " ";
        try
        {
            s = br.readLine();
        } catch (Exception Error)
        {
            System.out.println("ERROR..." + Error);
        }
        return s;
    }

    public static boolean LeerBooleano()
    {
        while (true)
        {
            try
            {
                String input = br.readLine().trim().toLowerCase();
                if (input.equals("true"))
                {
                    return true;
                } else if (input.equals("false"))
                {
                    return false;
                } else
                {
                    System.out.println("Entrada inválida. Por favor, ingresa 'true' o 'false'.");
                }
            } catch (IOException ex)
            {
                System.out.println("No se encontró el periférico de entrada...");
                return false;
            } catch (Exception Error)
            {
                System.out.println("ERROR..." + Error.toString());
                return false;
            }
        }
    }
}
