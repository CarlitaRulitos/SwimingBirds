import java.util.ArrayList;

public class Calculando {

    public static int calcularMinimo(ArrayList<Despacho> datos){
        int minimo = 0;
        for(int i = 0; i < datos.size(); i++){
            if(i == 0){
                minimo = datos.get(i).getMontoTotal();
            }
            if(datos.get(i).getMontoTotal() < minimo){
                minimo = datos.get(i).getMontoTotal();
            }
        }
        return minimo;
    }

    public static int calcularRango(ArrayList<Despacho> datos){
        int minimo = calcularMinimo(datos);
        int maximo = 0;

        for(int i = 0; i < datos.size(); i++){
            if(i == 0){
                maximo = datos.get(i).getMontoTotal();
            }
            if(datos.get(i).getMontoTotal() > maximo){
                maximo = datos.get(i).getMontoTotal();
            }
        }
        return maximo - minimo;
    }

    public static int calcularCuartil(ArrayList<Despacho> datos, int cuartil){
        int rango = calcularRango(datos);
        int minimo = calcularMinimo(datos);
        if(cuartil == 1){
            return (int)(rango*0.25 + minimo);
        }
        if(cuartil == 2){
            return (int)(rango*0.5 + minimo);
        }
        if(cuartil == 3){
            return (int)(rango*0.75 + minimo);
        }
        else{
            return -1;
        }
    }

}
