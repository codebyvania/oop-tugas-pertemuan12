/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 *
 * @author User
 */
public class CompileTreatment {
    public static void main(String[] args) {
        try {
            String sourceFile = "src/Transaksi/DataTreatmentReport.jrxml"; // lokasi file jrxml
            String destFile = "src/Transaksi/DataTreatmentReport.jasper"; // hasil compile
            JasperCompileManager.compileReportToFile(sourceFile, destFile);
            System.out.println("Report compiled successfully!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
