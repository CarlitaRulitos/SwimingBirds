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
            List ejlist = (List) data.get(i);
            ArrayList ejem = new ArrayList();
            for (int j = 0; j < ejlist.size(); j++) {
                XSSFCell celda = (XSSFCell) ejlist.get(j);
                String celdaSt = celda.toString();
                if (j == 0) {
                    id_tran = (int) (Double.parseDouble(celdaSt));
                    ejem.add(id_tran);
                }
                if (j == 1) {
                    SimpleDateFormat fecha = new SimpleDateFormat("dd-MMM-yyyy");
                    fecha_sol = fecha.parse(celdaSt);
                    ejem.add(fecha_sol);
                }
                if (j == 2) {
                    cod_clien = (int) (Double.parseDouble(celdaSt));
                    ejem.add(cod_clien);
                }
                if (j == 3) {
                    raz_soc = celdaSt;
                    ejem.add(raz_soc);
                }
                if (j == 4) {
                    cod_artic = (int) (Double.parseDouble(celdaSt));
                    ejem.add(cod_artic);
                }
                if (j == 5) {
                    nom_artic = celdaSt;
                    ejem.add(nom_artic);
                }
                if (j == 6) {
                    valor_uni = (int) (Double.parseDouble(celdaSt));
                    ejem.add(valor_uni);
                }
                if (j == 7) {
                    cant_unid = (int) (Double.parseDouble(celdaSt));
                    ejem.add(cant_unid);
                }
                if (j == 8) {
                    monto_total = (int) (Double.parseDouble(celdaSt));
                    ejem.add(monto_total);
                }
                if (j == 9) {
                    estado = celdaSt;
                    ejem.add(estado);
                }
                if (j == 10) {
                    if ("".equals(celdaSt)) {

                        fecha_desp = null;
                        ejem.add(fecha_desp);
                    } else {
                        SimpleDateFormat fecha = new SimpleDateFormat("dd-MMM-yyyy");
                        fecha_desp = fecha.parse(celdaSt);
                        ejem.add(fecha_desp);
                    }
                }
                if (j == 10 && ejem.get(10) != "") {
                    d = new Despacho((int) (ejem.get(0)), (Date) (ejem.get(1)), (int) (ejem.get(2)), (String) (ejem.get(3)), (int) ejem.get(4), (String) ejem.get(5), (int) ejem.get(6), (int) ejem.get(7), (int) ejem.get(8), (String) ejem.get(9), (Date) ejem.get(10));
                    todos.add(d);
                }
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

            if (fechaInicio.compareTo(solicitud) >= 0 && fechaFin.compareTo(solicitud) <= 0) {
                if (fechaDespacho != null && fechaInicio.compareTo(fechaDespacho) >= 0 && fechaFin.compareTo(fechaDespacho) <= 0) {
                    rangito.add(aux);
                }
            }
        }

        return rangito;
    }

    
}
