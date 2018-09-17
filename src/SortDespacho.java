import java.util.Comparator;

public class SortDespacho implements Comparator<Despacho> {
    public int compare(Despacho a, Despacho b){
        return a.getCodArticulo() - b.getCodArticulo();
    }
}