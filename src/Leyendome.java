import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Leyendome {
    private ArrayList<Despacho> todos;

    public Leyendome(File f) throws ParseException {
        List<List<XSSFCell>> t = new ArrayList<>();
        try {
            FileInputStream a = new FileInputStream(f);
            XSSFWorkbook w = new XSSFWorkbook(a);
            XSSFSheet hssfSheet = w.getSheetAt(0);
            Iterator rowIterator = hssfSheet.rowIterator();
            while (rowIterator.hasNext()) {
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                Iterator i = hssfRow.cellIterator();
                List<XSSFCell> c = new ArrayList<>();
                while (i.hasNext()) {
                    XSSFCell hssfCell = (XSSFCell) i.next();
                    c.add(hssfCell);
                }
                t.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        todos = new ArrayList<>();//------------------------------
        datos(t);
    }

    private void datos(List data) throws ParseException {
        int id_tran;
        Date fecha_sol;
        int cod_clien;
        String raz_soc;
        int cod_artic;
        String nom_artic;
        int valor_uni;
        int cant_unid;
        int monto_total;
        String estado;
        Date fecha_desp;

        Despacho d;
        for (int i = 1; i < data.size(); i++) {
            id_tran = 0;
            fecha_sol = null;
            cod_clien = 0;
            raz_soc = null;
            cod_artic = 0;
            nom_artic = null;
            valor_uni = 0;
            cant_unid = 0;
            monto_total = 0;
            estado = null;
            fecha_desp = null;

            List ejlist = (List) data.get(i);
            for (int j = 0; j < ejlist.size(); j++) {
                XSSFCell celda = (XSSFCell) ejlist.get(j);
                String celdaSt = celda.toString();
                if (j == 0) {
                    id_tran = (int) (Double.parseDouble(celdaSt));
                }
                if (j == 1) {
                    SimpleDateFormat fecha = new SimpleDateFormat("dd-MMM-yyyy");
                    fecha_sol = fecha.parse(celdaSt);
                }
                if (j == 2) {
                    cod_clien = (int) (Double.parseDouble(celdaSt));
                }
                if (j == 3) {
                    raz_soc = celdaSt;
                }
                if (j == 4) {
                    cod_artic = (int) (Double.parseDouble(celdaSt));
                }
                if (j == 5) {
                    nom_artic = celdaSt;
                }
                if (j == 6) {
                    valor_uni = (int) (Double.parseDouble(celdaSt));
                }
                if (j == 7) {
                    cant_unid = (int) (Double.parseDouble(celdaSt));
                }
                if (j == 8) {
                    monto_total = (int) (Double.parseDouble(celdaSt));
                }
                if (j == 9) {
                    estado = celdaSt;
                }
                if (j == 10) {
                    if ("".equals(celdaSt)) {
                        fecha_desp = null;
                    } else {
                        SimpleDateFormat fecha = new SimpleDateFormat("dd-MMM-yyyy");
                        fecha_desp = fecha.parse(celdaSt);
                    }
                }
            }

            if(id_tran != 0) {
                d = new Despacho(id_tran, fecha_sol, cod_clien, raz_soc, cod_artic, nom_artic, valor_uni, cant_unid, monto_total, estado, fecha_desp);
                todos.add(d);
            }
        }
    }

    public ArrayList<Despacho> getTodos() {
        return todos;
    }

    public ArrayList<Despacho> getDespachosenRango(Date fechaInicio, Date fechaFin) {
        ArrayList<Despacho> rangito = new ArrayList<>();
        Despacho aux;
        Date solicitud;
        Date fechaDespacho;
        for (int i = 0; i < todos.size(); i++) {
            aux = todos.get(i);

            solicitud = aux.getFechaSol();
            fechaDespacho = aux.getFechaDesp();

            if (fechaInicio.compareTo(solicitud) <= 0 && fechaFin.compareTo(solicitud) >= 0) {
                if (fechaDespacho != null && fechaInicio.compareTo(fechaDespacho) <= 0 && fechaFin.compareTo(fechaDespacho) >= 0) {
                    rangito.add(aux);
                }
            }
        }

        return rangito;
    }


    public ArrayList<Despacho> sumaArticulos(Date fechaInicio, Date fechaFin){
        ArrayList<Despacho> datos = getDespachosenRango(fechaInicio, fechaFin);
        datos.sort(new SortDespacho());

        ArrayList<Despacho> fin = new ArrayList<Despacho>();
        int valor = 0;
        Despacho despacho= datos.get(valor);
        int cantUn=despacho.getCantidadUnidades();
        int montoTotal=despacho.getMontoTotal();

        for (int i=1; i<datos.size(); i++) {
            if (despacho.getCodArticulo() == datos.get(i).getCodArticulo()) {
                cantUn += datos.get(i).getCantidadUnidades();
                montoTotal += datos.get(i).getMontoTotal();
                valor++;
            } else {
                despacho.setCantidadUnidades(cantUn);
                despacho.setMontoTotal(montoTotal);
                fin.add(despacho);
                valor++;
                despacho = datos.get(valor);
                cantUn = despacho.getCantidadUnidades();
                montoTotal = despacho.getMontoTotal();
            }
        }
        despacho.setCantidadUnidades(cantUn);
        despacho.setMontoTotal(montoTotal);
        fin.add(despacho);

        return fin;
    }

    public ArrayList<Despacho> sortMonto (ArrayList<Despacho> datos){
        return datos;
    }
}
