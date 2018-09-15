import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException, IOException{
        File f = new File("/Users/yian/Desktop/Prueba_Excel.xlsx");
        Leyendome mateo = new Leyendome(f);

        BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese Fecha de inicio del periodo Formato DD-MM-AAAA: ");
        String fecha1 = lector.readLine();
        System.out.println("Ingrese Fecha de término del periodo Formato DD-MM-AAAA: ");
        String fecha2 = lector.readLine();


        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date fechaInicio = format.parse(fecha1);
        Date fechaFin = format.parse(fecha2);
    }

    public ArrayList<Despacho> sumaArticulos(Date fechaInicio, Date fechaFin){
        ArrayList<Despacho> datos =
    }

    public void mostrarPorConsola(ArrayList<Despacho> datos){

    }
}
