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
        File f = new File("C:\\Users\\Carlita\\Desktop\\ArquiCarlita.xlsx");
        Leyendome mateo = new Leyendome(f);

        BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese Fecha de inicio del periodo Formato DD-MM-AAAA: ");
        String fecha1 = lector.readLine();
        System.out.println("Ingrese Fecha de término del periodo Formato DD-MM-AAAA: ");
        String fecha2 = lector.readLine();


        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date fechaInicio = format.parse(fecha1);
        Date fechaFin = format.parse(fecha2);


        ArrayList<Despacho> datos = mateo.sumaArticulos(fechaInicio, fechaFin);
        mostrarPorConsola(datos);
    }



    public static void mostrarPorConsola(ArrayList<Despacho> datos){
        System.out.println("Nombre Artículo--Cantidad de Unidades--Monto Total");
        int uno = Calculando.calcularCuartil(datos,1);
        int dos = Calculando.calcularCuartil(datos,2);
        int tres = Calculando.calcularCuartil(datos,3);
        for(int i=0; i<datos.size(); i++){
            if (datos.get(i).getMontoTotal()< uno){
                System.out.println("Cuartil 1:");
                System.out.println(datos.get(i).getNombreArticulo()+"--"+datos.get(i).getCantidadUnidades()+"--"+datos.get(i).getMontoTotal());
            }
            else if (datos.get(i).getMontoTotal()< dos){
                System.out.println("Cuartil 2:");
                System.out.println(datos.get(i).getNombreArticulo()+"--"+datos.get(i).getCantidadUnidades()+"--"+datos.get(i).getMontoTotal());
            }
            else if (datos.get(i).getMontoTotal()< tres){
                System.out.println("Cuartil 3:");
                System.out.println(datos.get(i).getNombreArticulo()+"--"+datos.get(i).getCantidadUnidades()+"--"+datos.get(i).getMontoTotal());
            }
            else if (datos.get(i).getMontoTotal()>= tres){
                System.out.println("Cuartil 4:");
                System.out.println(datos.get(i).getNombreArticulo()+"--"+datos.get(i).getCantidadUnidades()+"--"+datos.get(i).getMontoTotal());
            }
        }
    }
}
