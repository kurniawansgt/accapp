/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accapp.objectclasses.invoice;

import common.jdbc.DbBean;
import common.tablemodels.GlobalModel;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author windugata
 */
public class InvoiceValidation {
    
    public void getListInvoice(String yop, String mop, DefaultTableModel dtm, Object[] obj){
        GlobalModel.clearRow(dtm);
        
        String sql = "SELECT id, "
                        + " readytcrInv, "
                        + " Company, "
                        + " NoInvoice, "
                        + " NoFakturPajak, "
                        + " DATE(Tanggal) tanggal, "
                        + " totalAmount, "
                        + " discAmount, "
                        + " bfrTaxAmount, "
                        + " taxAmount, "
                        + " aftTaxAmount, "
                        + " accountMngr, "
                        + " crInvSts, "
                        + " base_batchno, "
                        + " base_docentry "
                        + "FROM bankjurnal.`tariksales_invoice_hdr` WHERE yop = " + yop  + " AND mop = " + mop;
        
        try {
            
            DbBean db = DbBean.connect();
            
            Double dtotalamount = 0.0D;
            Double ddiscamount = 0.0D;
            Double dbfrTaxAmount = 0.0D;
            Double dTaxAmount = 0.0D;
            Double daftTaxAmount = 0.0D;
            
            
        
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                
                String crInvSts = rs.getString("crInvSts");
                String InvStatus = crInvSts.contains("1") ? "Created" : "Open";
                boolean toCreate = rs.getString("readytcrInv").equals("1")?true:false;
                        
                dtm.addRow(obj);
                
                dtm.setValueAt(rs.getInt("id"), dtm.getRowCount() - 1, 0);                
                dtm.setValueAt(toCreate, dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("company"), dtm.getRowCount() - 1, 2);
                dtm.setValueAt(rs.getString("NoInvoice"), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(rs.getString("NoFakturPajak"), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(rs.getDate("Tanggal"), dtm.getRowCount() - 1, 5);
                dtm.setValueAt(rs.getDouble("TotalAmount"), dtm.getRowCount() - 1, 6);
                dtotalamount += rs.getDouble("TotalAmount");
                dtm.setValueAt(rs.getDouble("discAmount"), dtm.getRowCount() - 1, 7);
                ddiscamount += rs.getDouble("discAmount");
                dtm.setValueAt(rs.getDouble("bfrTaxAmount"), dtm.getRowCount() - 1, 8);
                dbfrTaxAmount += rs.getDouble("bfrTaxAmount");
                dtm.setValueAt(rs.getDouble("TaxAmount"), dtm.getRowCount() - 1, 9);
                dTaxAmount += rs.getDouble("TaxAmount");
                dtm.setValueAt(rs.getDouble("aftTaxAmount"), dtm.getRowCount() - 1, 10);
                daftTaxAmount += rs.getDouble("aftTaxAmount");
                dtm.setValueAt(rs.getString("accountMngr"), dtm.getRowCount() - 1, 11);
                dtm.setValueAt(InvStatus, dtm.getRowCount() - 1, 12);
                dtm.setValueAt(rs.getString("base_batchno"), dtm.getRowCount() - 1, 13);
                dtm.setValueAt(rs.getString("base_docentry"), dtm.getRowCount() - 1, 14);
            }            
            dtm.addRow(obj);
            dtm.setValueAt("Total ", dtm.getRowCount() - 1, 3);
            dtm.setValueAt(dtotalamount, dtm.getRowCount() - 1, 6);
            dtm.setValueAt(ddiscamount, dtm.getRowCount() - 1, 7);
            dtm.setValueAt(dbfrTaxAmount, dtm.getRowCount() - 1, 8);
            dtm.setValueAt(dTaxAmount, dtm.getRowCount() - 1, 9);
            dtm.setValueAt(daftTaxAmount, dtm.getRowCount() - 1, 10);

            db.close();
            
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean createARInvoice(int batchno){
        boolean bsave = false;
        try {
            DbBean db = DbBean.connect();

            String sqlcreateinv = "call `sp_acc_create_arinvoice_loop`("+batchno+" ,'"+GlobalUtils.audituser+"' , '"+GlobalUtils.company+"')";        
            System.out.println("Call SP: "+sqlcreateinv);
            db.doexecute(sqlcreateinv);
            bsave = true;
            db.close();
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bsave;
    }
    
    public boolean sp_itemprice_mb_update(String kdMB, double dhjp, double dhpd){
        boolean bsave = false;
        try {
            
            DbBean db = DbBean.connect();
            
            String sqlhjp = "call sp_itemprice_mb_update('" + kdMB + "','HJP',"  + dhjp + ",'Admin')";        
            db.doexecute(sqlhjp);
            
            
            String sqlhpd = "call sp_itemprice_mb_update('" + kdMB + "','HPD',"  + dhpd + ",'Admin')";
            db.doexecute(sqlhpd);
            
            db.close();
            
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bsave;
    }
    
    
    public boolean saveInvoice(
            String yop,
            String mop,
            boolean isproduct,
            String noInvoice,
            String noFakturPajak,
            String tanggal,
            Double totalAmount,
            Double discAmount,
            Double bfrTaxAmount,
            Double taxAmount,
            Double aftTaxAmount,
            String accountMngr,
            String company
    ) throws CodeException {
        boolean bsave = false;
        try {
            
            DbBean db = DbBean.connect();
            String sql = "delete from bankjurnal.tariksales_invoice_hdr where company = '" + company + "' and yop ='" + yop + "' and mop='" + mop + "' ";
            
            db.doexecute(sql);
            
            sql = "insert into bankjurnal.tariksales_invoice_hdr (yop,mop, isproduct, noInvoice, noFakturPajak,tanggal,  totalAmount, discAmount, bfrTaxAmount, taxAmount, aftTaxAmount, accountMngr, company )  " 
                    + " Values ("
                    + " '" + yop + "', "
                    + " '" + mop + "', "
                    + isproduct + ", "
                    + " '" + noInvoice + "',"
                    + " '" + noFakturPajak + "', "
                    + " '" + tanggal + "', "
                    + totalAmount + ", "
                    + discAmount + ", "
                    + bfrTaxAmount + ", "
                    + taxAmount + ", "
                    + aftTaxAmount + ","
                    + "'" + accountMngr + "',"
                    + "'" + company + "' "
                    + ") ";
            
            db.doexecute(sql);

            if (!company.equals("CDF")) {
            
                if (company.equals("SAI")) {
                    sql = "update bankjurnal.tariksales    set yop = '" + yop + "', "
                            + " mop = '" + mop + "',"
                            + " noInvoice = '" + noInvoice + "' "
                            + "  where company in ('SAI', 'MB') and yop ='" + yop + "' and mop='" + mop + "'  ";
                }else{
                    sql = "update bankjurnal.tariksales    set yop = '" + yop + "', "
                            + " mop = '" + mop + "',"
                            + " noInvoice = '" + noInvoice + "' "
                            + "  where company = '" + company + "' and yop ='" + yop + "' and mop='" + mop + "'  ";                
                }
                db.doexecute(sql);
            }
            
            db.close();
            bsave = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return bsave;
    }
    public boolean  getInvoice(String yop, String mop, String company, Object[]  objInvoice, boolean bstepback) throws CodeException{
        DbBean db = DbBean.connect();
        if (bstepback ){
            if (mop.equals(1)) {
                mop = "12";
                yop = (Double.parseDouble(mop) - 1) +"";
            }else {
                mop = (Long.parseLong(mop) -  1)+"";
            }
        }
        
        boolean bfound = false;
        String sql = " SELECT a.* FROM `bankjurnal`.`tariksales_invoice_hdr` a "
                + " WHERE a.`Yop` = " + yop + " AND a.`Mop` = " + mop + " and a.company = '" + company + "' limit 1";
        //System.out.println("SQL: "+sql);
        
        ResultSet rs;
        try {
            rs = db.executeQuery(sql);
            if (rs.next()) {
                objInvoice[0] = rs.getLong("id");
                objInvoice[1] = rs.getString("yop");
                objInvoice[2] = rs.getString("mop");
                objInvoice[3] = rs.getString("noInvoice");
                objInvoice[4] = rs.getString("noFakturPajak");
                objInvoice[5] = rs.getDate("tanggal");
                objInvoice[6] = rs.getDouble("totalAmount");
                objInvoice[7] = rs.getDouble("discAmount");
                objInvoice[8] = rs.getDouble("bfrTaxAmount");
                objInvoice[9] = rs.getDouble("taxAmount");
                objInvoice[10] = rs.getDouble("aftTaxAmount");
                objInvoice[11] = rs.getString("accountMngr");
                objInvoice[12] = rs.getString("Company");
                bfound = true;                
            }
            
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        
        return bfound;
        
    }
    
    public String getInvoiceSummary(String yop, String mop, String company, String model) throws CodeException{
        DbBean db = DbBean.connect();
        String sql = "SELECT SUM(qty * " + model + ") Val  "
                + " FROM bankjurnal.tariksales "
                + " WHERE yop = " + yop  
                + " AND mop = " + mop + " AND company = '" + company + "' "; 

        long val = 0;
        
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                val = rs.getLong("Val");
            }
            
            try {
                rs.close();
            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }                

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
        
        return GlobalUtils.formatnumber(val);
    }
    
    public void getInvoiceSummaryByBrand(String yop, String mop, String company, DefaultTableModel dtm, Object[] obj) throws CodeException{
        DbBean db = DbBean.connect();
        String sql = "SELECT kdBrand, "
                + "     NamaBrand, "
                + "     SUM(qty * HPD) HPD, "
                + "     SUM(((qty * HPD) - (qty * hjp))) discount, "
                + "     SUM(qty * hjp) DPP, "
                + "     SUM((qty * hjp) * 0.1) PPN, "
                + "     SUM((qty * hjp) + (qty * hjp) * 0.1) Total "
                + " FROM bankjurnal.tariksales "
                + " WHERE yop = " + yop  
                + " AND mop = " + mop + " AND company = '" + company + "' "
                + " GROUP BY kdBrand "
                + " ORDER BY kdBrand" ;
        
        try {
            GlobalModel.clearRow(dtm);
            
            Double totHPD = 0.0D;
            Double totDiscount = 0.0D;
            Double totDPP = 0.0D;
            Double totPPN = 0.0D;
            Double totTotal = 0.0D;

            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                dtm.addRow(obj);
                
                dtm.setValueAt(dtm.getRowCount(), dtm.getRowCount() - 1, 0);
                dtm.setValueAt(rs.getString("kdBrand"), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("NamaBrand"), dtm.getRowCount() - 1, 2);
                dtm.setValueAt(rs.getDouble("HPD"), dtm.getRowCount() - 1, 3);
                totHPD += rs.getDouble("HPD");
                dtm.setValueAt(rs.getDouble("discount"), dtm.getRowCount() - 1, 4);
                totDiscount += rs.getDouble("discount");
                dtm.setValueAt(rs.getDouble("DPP"), dtm.getRowCount() - 1, 5);
                totDPP += rs.getDouble("DPP");
                dtm.setValueAt(rs.getDouble("PPN"), dtm.getRowCount() - 1, 6);
                totPPN += rs.getDouble("PPN");
                dtm.setValueAt(rs.getDouble("Total"), dtm.getRowCount() - 1, 7);
                totTotal += rs.getDouble("Total");                
            }            
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 2);
            dtm.setValueAt(totHPD, dtm.getRowCount() - 1, 3);
            dtm.setValueAt(totDiscount, dtm.getRowCount() - 1, 4);
            dtm.setValueAt(totDPP, dtm.getRowCount() - 1, 5);
            dtm.setValueAt(totPPN, dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totTotal, dtm.getRowCount() - 1, 7);
            
            rs.close();


        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        

        db.close();
    }
    
    public void getInvoiceDetail(String yop, String mop, String company, DefaultTableModel dtm, Object[] obj) throws CodeException{
        DbBean db = DbBean.connect();
        String sql = "SELECT kdBrand, "
                + " NamaBrand, "
                + " kdMB, "
                + " KdSai, "
                + " mtgCode, "
                + " itemName, "
                + " qty, "
                + " HPD, "
                + " qty * HPD jumlah, "
                + " ((qty * HPD) - (qty * hjp)) discount, "
                + " hjp, "
                + " qty * hjp jumlahhjp "
                + " FROM bankjurnal.tariksales "
                + " WHERE yop = " + yop  
                + " AND mop = " + mop + " AND company = '" + company + "' "
                + " ORDER BY kdBrand, kdMB" ;
        
        try {
            GlobalModel.clearRow(dtm);
            
            Double totQty = 0.0D;
            Double totQTYsub = 0.0D;
            Double totjumlah = 0.0D;
            Double totjumlahsub = 0.0D;
            Double totDiscount = 0.0D;
            Double totDiscountsub = 0.0D;
            Double totHJP = 0.0D;
            Double TotHJPsub = 0.0D;
            String skdBrand = "";
            
            int no = 0;
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                
                dtm.addRow(obj);                
                
                if (no == 0) {
                    skdBrand = rs.getString("kdBrand");
                }
                
                if(!skdBrand.equals(rs.getString("kdBrand")) ) {                          
                    dtm.setValueAt("Sub Total : ", dtm.getRowCount() - 1, 6);
                    dtm.setValueAt(totQTYsub, dtm.getRowCount() - 1, 7);
                    dtm.setValueAt(totjumlahsub, dtm.getRowCount() - 1, 9);
                    dtm.setValueAt(totDiscountsub, dtm.getRowCount() - 1, 10);
                    dtm.setValueAt(TotHJPsub, dtm.getRowCount() - 1, 12);
                    dtm.addRow(obj);
                    dtm.addRow(obj);
                   
                    skdBrand = rs.getString("kdBrand");
                    totQTYsub = 0.0D;
                    totjumlahsub = 0.0D;
                    totDiscountsub = 0.0D;
                    TotHJPsub = 0.0D;
                }else{
                    no++;
                }

                dtm.setValueAt(no, dtm.getRowCount() - 1, 0);
                dtm.setValueAt(rs.getString("kdBrand"), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("NamaBrand"), dtm.getRowCount() - 1, 2);                
                dtm.setValueAt(rs.getString("kdMB"), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(rs.getString("KdSai"), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(rs.getString("MTGCode"), dtm.getRowCount() - 1, 5);
                dtm.setValueAt(rs.getString("itemName"), dtm.getRowCount() - 1, 6);               
                dtm.setValueAt(rs.getDouble("qty"), dtm.getRowCount() - 1, 7);
                totQty += rs.getDouble("qty");
                totQTYsub += rs.getDouble("qty");
                
                dtm.setValueAt(rs.getDouble("hpd"), dtm.getRowCount() - 1, 8);
                dtm.setValueAt(rs.getDouble("jumlah"), dtm.getRowCount() - 1, 9);
                totjumlah += rs.getDouble("jumlah");
                totjumlahsub += rs.getDouble("jumlah");
                
                dtm.setValueAt(rs.getDouble("discount"), dtm.getRowCount() - 1, 10);
                totDiscount += rs.getDouble("discount");
                totDiscountsub += rs.getDouble("discount");
                
                dtm.setValueAt(rs.getDouble("hjp"), dtm.getRowCount() - 1, 11);
                dtm.setValueAt(rs.getDouble("jumlahhjp"), dtm.getRowCount() - 1, 12);
                totHJP += rs.getDouble("jumlahhjp");
                TotHJPsub += rs.getDouble("jumlahhjp");

            }            
            dtm.addRow(obj);
            dtm.setValueAt("Sub Total : ", dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totQTYsub, dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlahsub, dtm.getRowCount() - 1, 9);
            dtm.setValueAt(totDiscountsub, dtm.getRowCount() - 1, 10);
            dtm.setValueAt(TotHJPsub, dtm.getRowCount() - 1, 12);
            dtm.addRow(obj);
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totQty, dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah, dtm.getRowCount() - 1, 9);
            dtm.setValueAt(totDiscount, dtm.getRowCount() - 1, 10);
            dtm.setValueAt(totHJP, dtm.getRowCount() - 1, 12);

            rs.close();


        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        

        db.close();
        
    }

    public void getInvoiceDetailVariance(String yop, String mop, DefaultTableModel dtm, Object[] obj) throws CodeException{
        DbBean db = DbBean.connect();
        String sql = "SELECT a.kdbrand, "
                + " a.NamaBrand, "
                + " a.kdMB, "
                + " a.kdSAI, "
                + " a.MTGCode, "
                + " a.itemName, "
                + " a.qty qtySAI, "
                + " b.qty qtyMB, "
                + " a.hpd hpdSAI, "
                + " b.hpd hpdMB, "
                + " a.hjp hjpSAI, "
                + " b.hjp hjpMB\n" 
                + " FROM (SELECT * FROM bankjurnal.tariksales WHERE company = 'SAI' AND yop = " + yop + " AND mop = " + mop + ") a   \n" 
                + "	cross JOIN (SELECT * FROM bankjurnal.tariksales WHERE company = 'MB' AND yop = " + yop + " AND mop = " + mop + ") b   \n" 
                + "		ON a.yop = b.yop AND a.mop = b.mop AND  a.kdmb = b.kdmb \n" 
                + " WHERE a.qty <> b.qty \n" 
                + "	OR ifnull(a.hpd,0) <> ifnull(b.hpd,0)\n" 
                + "	OR ifnull(a.hjp,0) <> ifnull(b.hjp,0) "
                + " ORDER BY a.kdBrand, a.kdMB ";
        
        try {
            GlobalModel.clearRow(dtm);
            //System.out.println(sql);
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                
                dtm.addRow(obj);                
                               
                dtm.setValueAt(dtm.getRowCount(), dtm.getRowCount() - 1, 0);
                dtm.setValueAt(rs.getString("kdBrand"), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("NamaBrand"), dtm.getRowCount() - 1, 2);                
                dtm.setValueAt(rs.getString("kdMB"), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(rs.getString("KdSai"), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(rs.getString("MTGCode"), dtm.getRowCount() - 1, 5);
                dtm.setValueAt(rs.getString("itemName"), dtm.getRowCount() - 1, 6);               
                dtm.setValueAt(rs.getDouble("qtySAI"), dtm.getRowCount() - 1, 7);
                dtm.setValueAt(rs.getDouble("qtyMB"), dtm.getRowCount() - 1, 8);
                dtm.setValueAt(rs.getDouble("hpdSAI"), dtm.getRowCount() - 1, 9);
                dtm.setValueAt(rs.getDouble("hpdMB"), dtm.getRowCount() - 1, 10);
                dtm.setValueAt(rs.getDouble("hjpSAI"), dtm.getRowCount() - 1, 11);
                dtm.setValueAt(rs.getDouble("hjpMB"), dtm.getRowCount() - 1, 12);
                
               
            }            

            rs.close();


        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        

        db.close();
        
    }
    
    public String getInvoiceSummaryCDF(String yop, String mop, String peruntukan) throws CodeException{
        DbBean db = DbBean.connect();
        String sql = " SELECT SUM(b.`Jumlah` * b.`HargaStandard` ) val\n" +
                    " FROM manufaktur.`gudangsuratjalanrmpm` a \n" +
                    " INNER JOIN manufaktur.`gudangsuratjalanrmpmdetail` b ON a.`NomorDokumen` = b.`NomorDokumen` \n" +
                    " INNER JOIN manufaktur.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` \n" +
                    " INNER JOIN manufaktur.masterbahan d ON b.`KodeBahan` = d.`KodeBahan` \n" +
                    " WHERE a.tanggaldokumen BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' \n" +
                    "     AND a.`KodeDistributor` IN ('2212', 'C33') \n" +
                    "     AND d.peruntukan = '" + peruntukan + "' \n" ;
        
        
//        System.out.println(sql);

        long val = 0;
        
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                val = rs.getLong("Val");
            }
            
            rs.close();

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
        
        return GlobalUtils.formatnumber(val);
    }


    public void saveRevisiDetailCDF(String nomordokumen, String kodebahan, String hargastandard) {
        
        try {
            String sql = " update manufaktur.`gudangsuratjalanrmpmdetail` set HargaStandard = " + hargastandard + " WHERE nomordokumen = '" + nomordokumen + "' AND kodebahan = '"+ kodebahan+ "' ";
            DbBean db = DbBean.connect();
                        
            db.doexecute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean saveInvoiceCDF(String yop, String mop, String NoInvoice, String peruntukan) {
        boolean bsave = false;
        
        
        try {
            DbBean dba = DbBean.connect();

            String sql = "DELETE FROM `bankjurnal`.`tariksales` WHERE yop = " + yop + " AND mop = " + mop + "  AND company = '" + peruntukan + "CDF'";
            dba.doexecute(sql);


            sql = " INSERT INTO `bankjurnal`.tariksales\n" 
                   + "( \n" 
                   + "yop,\n" 
                   + "mop, \n" 
                   + "NoInvoice, \n" 
                   + "SKB, \n" 
                   + "docDate,	 \n" 
                   + "KdMb, \n" 
                   + "itemName, \n" 
                   + "qty, \n" 
                   + "hjp,\n" 
                   + "Company\n" 
                   + ") "
                   + " SELECT "
                   + yop + " yop, "
                   + mop + " mop, " 
                   + "'" + NoInvoice + "' NoInvoice, " 
                   + " a.`NomorDokumen` SKB, "
                   + " a.`TanggalDokumen` docDate,	 "
                   + " b.`KodeBahan` KdMb, "
                   + " d.`NamaAsli`  itemName, "
                   + " b.`Jumlah` qty, "
                   + " b.`HargaStandard` hjp, "
                   + " '" + peruntukan + "CDF' Company "
                   + " FROM manufaktur.`gudangsuratjalanrmpm` a "
                   + "       INNER JOIN manufaktur.`gudangsuratjalanrmpmdetail` b ON a.`NomorDokumen` = b.`NomorDokumen`  "
                   + "         INNER JOIN manufaktur.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` "
                   + "         INNER JOIN manufaktur.masterbahan d ON b.`KodeBahan` = d.`KodeBahan` "
                   + "         WHERE a.tanggaldokumen BETWEEN '"+ yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' "
                   + "             AND a.`KodeDistributor` IN ('2212', 'C33') "
                   + "             AND d.peruntukan = '" + peruntukan + "' "
                   + "             ORDER BY a.tanggaldokumen, b.kodebahan ";

            dba.doexecute(sql);
            
            System.out.println(sql);
                
            bsave = true;
                
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       return bsave; 
    }
    public void getInvoiceCDF(String yop, String mop, String peruntukan, DefaultTableModel dtm, Object[] obj) throws CodeException{
        DbBean db = DbBean.connect();
        List<Object> list = Collections.synchronizedList(new ArrayList<Object>());

        String sql = "SELECT a.`NomorDokumen`, "
                + "     a.`TanggalDokumen`, "
                + "     b.NoPo, "
                + "     b.`KodeBahan`, "
                + "     d.`NamaAsli` NamaBahan, "
                + "     d.Satuan, "
                + "     b.`Jumlah`, "                
                + "     b.`HargaStandard` "
                + " FROM manufaktur.`gudangsuratjalanrmpm` a "
                + " INNER JOIN manufaktur.`gudangsuratjalanrmpmdetail` b ON a.`NomorDokumen` = b.`NomorDokumen` "
                + " INNER JOIN manufaktur.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` "
                + " INNER JOIN manufaktur.masterbahan d ON b.`KodeBahan` = d.`KodeBahan` "
                + " WHERE a.tanggaldokumen BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' "
                + "     AND a.`KodeDistributor` IN ('2212', 'C33') "
                + "     AND d.peruntukan = '" + peruntukan + "' "
                + "     ORDER BY a.tanggaldokumen, b.kodebahan " ;
        
        try {
            GlobalModel.clearRow(dtm);
            
            Double totjumlah = 0.0D;
            Double totqty = 0.0D;
            Double tothrgstandard = 0.0D;
            
            String nomordokumen = "";
            int no = 0;
            Double hargastandard = 0.0D;
            Double value = 0.0D;
            Double jumlah = 0.0D;
            ResultSet rs = db.executeQuery(sql);
            String nopo = "";
                        
            while (rs.next()) {
                Object[] objInvoice = new Object[9];
                objInvoice[0] = rs.getString("NomorDokumen"); //0
                objInvoice[1] = rs.getString("TanggalDokumen"); //1
                objInvoice[2] = rs.getString("NoPo"); //2
                objInvoice[3] = rs.getString("KodeBahan"); //3 
                objInvoice[4] = rs.getString("NamaBahan"); //4
                objInvoice[5] = rs.getString("Satuan"); //5
                objInvoice[6] = rs.getDouble("Jumlah"); //6                
                objInvoice[7] = rs.getDouble("HargaStandard");//7
                
                list.add(objInvoice);
            }
            rs.close();
            db.close();

            for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
                Object[] valobj = (Object[]) it.next();
                dtm.addRow(obj);
                if (nomordokumen.equals(String.valueOf(valobj[0]))){
                    no += 1;
                } else{
//                    dtm.setValueAt(String.valueOf(valobj[0]), dtm.getRowCount() - 1, 0);
//                    dtm.setValueAt(String.valueOf(valobj[1]), dtm.getRowCount() - 1, 1);
                    nomordokumen = String.valueOf(valobj[0]);
                    no = 1;
                }
                dtm.setValueAt(String.valueOf(valobj[0]), dtm.getRowCount() - 1, 0); //No. Dok
                dtm.setValueAt(String.valueOf(valobj[1]), dtm.getRowCount() - 1, 1); //Tgl Dok
                dtm.setValueAt(no, dtm.getRowCount() - 1, 2);                        //No
                dtm.setValueAt(String.valueOf(valobj[2]), dtm.getRowCount() - 1, 3); //No. PO
                dtm.setValueAt(String.valueOf(valobj[3]), dtm.getRowCount() - 1, 4); //Kode Bahan
                dtm.setValueAt(String.valueOf(valobj[4]), dtm.getRowCount() - 1, 5); //Nama Bahan
                dtm.setValueAt(String.valueOf(valobj[5]+""), dtm.getRowCount() - 1, 6); //Satuan                
                jumlah = Double.parseDouble(valobj[6]+"");
                dtm.setValueAt(jumlah, dtm.getRowCount() - 1, 7);                    //Jumlah                
                
                nopo = String.valueOf(valobj[2]);
                if (nopo.length() > 4) {
                    nopo = nopo.substring(0,4);
                }
                
                hargastandard = Double.parseDouble(valobj[7]+"") ;  //getHargaCDF(nopo, String.valueOf(valobj[3]), yop);
                dtm.setValueAt(hargastandard, dtm.getRowCount() - 1, 8); //Harga Standard
                value = jumlah * hargastandard;
                dtm.setValueAt(value, dtm.getRowCount() - 1, 9); //Subtotal
                totjumlah += value;
                totqty += jumlah;
                tothrgstandard += hargastandard;
            }
            
            dtm.addRow(obj);
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totqty, dtm.getRowCount() - 1, 7);
            dtm.setValueAt(tothrgstandard, dtm.getRowCount() - 1, 8);
            dtm.setValueAt(totjumlah, dtm.getRowCount() - 1, 9);
            
            dtm.addRow(obj);
            dtm.setValueAt("PPN : ", dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totjumlah * 0.1, dtm.getRowCount() - 1, 9);
                        
            dtm.addRow(obj);
            dtm.setValueAt("Amount : ", dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totjumlah * 1.1, dtm.getRowCount() - 1, 9);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
    public Double getHargaCDF(String nomorpo, String kodebahanlain, String yop) throws CodeException {
        DbBean dba = DbBean.connect();


        Double harga = 0.0D;
        
        if (nomorpo.length() <= 3 ){
            nomorpo = "0" + nomorpo;
        }
        
        
        String sql = "SELECT a.`HargaAktual`\n" +
                        "FROM bankjurnal.`gudangbppbdetailcdf` a \n" +
                        "	INNER JOIN bankjurnal.`masterbahancdf`  b ON a.`KodeBahan` = b.`KodeBahan`\n" +
                        "WHERE nomorpo LIKE '" + nomorpo + "%\\" + yop + "' AND b.`KodeBahanLain` = '" +  kodebahanlain +"' ";
        
        
        try {
            ResultSet rsa = dba.executeQuery(sql);
            if(rsa.next()){
                harga = rsa.getDouble("HargaAktual");
            }
            rsa.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dba.close();
        
        return harga;
    }
    
    public void getInvoiceDetailCPP(String yop, String mop,  DefaultTableModel dtm, Object[] obj) throws CodeException {
        DbBean db = DbBean.connect();
        String sql = "SELECT Skb, "
                + " date(docdate) tanggal, "
                + " kdBrand, "
                + " NamaBrand, "
                + " kdMB, "
                + " itemName, "
                + " qty, "
                + " hjp, "
                + " qty * hjp jumlah "
                + " FROM bankjurnal.tariksales "
                + " WHERE yop = " + yop  
                + " AND mop = " + mop + " AND company = 'CPP' "
                + " ORDER BY docdate ASC,Skb ASC " ;

        GlobalModel.clearRow(dtm);


        try {
            Double totQty = 0.0D;
            Double totjumlah = 0.0D;

            int no = 0;

            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                
                no++;
                            
                dtm.addRow(obj);
                
                
                
                dtm.setValueAt(no, dtm.getRowCount() - 1, 0);
                dtm.setValueAt(rs.getString("SKB"), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("Tanggal"), dtm.getRowCount() - 1, 2);
                
                dtm.setValueAt(rs.getString("kdMB"), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(rs.getString("itemName"), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(rs.getDouble("hjp"), dtm.getRowCount() - 1, 5);

                dtm.setValueAt(rs.getDouble("qty"), dtm.getRowCount() - 1, 6);
                totQty += rs.getDouble("qty");
                
                dtm.setValueAt(rs.getDouble("jumlah"), dtm.getRowCount() - 1, 7);
                totjumlah += rs.getDouble("jumlah");
                
            }
            dtm.addRow(obj);
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 4);
            dtm.setValueAt(totQty, dtm.getRowCount() - 1, 6);
            dtm.setValueAt(totjumlah, dtm.getRowCount() - 1, 7);
            
            rs.close();
            
            
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveRevisiDetailOtherCompanyPlant1(String nomordokumen, String kodebahan, String hargastandard) {
        
        try {
            String sql = " update manufaktur.`gudangsuratjalanrmpmdetail` set HargaStandard = " + hargastandard + " WHERE nomordokumen = '" + nomordokumen + "' AND kodebahan = '"+ kodebahan+ "' ";
            DbBean db = DbBean.connect();
                        
            db.doexecute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean saveInvoiceOtherCompanyPlant1(String yop, String mop, String NoInvoice, String company) {
        boolean bsave = false;
        String[] companylst = company.split("-");
        
        
        try {
            DbBean dba = DbBean.connect();

            String sql = "DELETE FROM `bankjurnal`.`tariksales` WHERE yop = " + yop + " AND mop = " + mop + "  AND company = '" + companylst[0] + "'";
            dba.doexecute(sql);


            sql = " INSERT INTO `bankjurnal`.tariksales\n" 
                   + "( \n" 
                   + "yop,\n" 
                   + "mop, \n" 
                   + "NoInvoice, \n" 
                   + "SKB, \n" 
                   + "docDate,	 \n" 
                   + "KdMb, \n" 
                   + "itemName, \n" 
                   + "qty, \n" 
                   + "hjp,\n" 
                   + "Company\n" 
                   + ") "
                   + " SELECT "
                   + yop + " yop, "
                   + mop + " mop, " 
                   + "'" + NoInvoice + "' NoInvoice, " 
                   + " a.`NomorDokumen` SKB, "
                   + " a.`TanggalDokumen` docDate,	 "
                   + " b.`KodeBahan` KdMb, "
                   + " d.`NamaAsli`  itemName, "
                   + " b.`Jumlah` qty, "
                   + " b.`HargaStandard` hjp, "
                   + " '" + companylst[0] + "' Company "
                   + " FROM manufaktur.`gudangsuratjalanrmpm` a "
                   + "       INNER JOIN manufaktur.`gudangsuratjalanrmpmdetail` b ON a.`NomorDokumen` = b.`NomorDokumen`  "
                   + "         INNER JOIN manufaktur.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` "
                   + "         INNER JOIN manufaktur.masterbahan d ON b.`KodeBahan` = d.`KodeBahan` "
                   + "         WHERE a.tanggaldokumen BETWEEN '"+ yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' "
                   + "             AND a.`KodeDistributor` = '" + companylst[0] + "' "
                   + "             ORDER BY a.tanggaldokumen, b.kodebahan ";

            dba.doexecute(sql);
                
            bsave = true;
                
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       return bsave; 
    }


    public String getInvoiceSummaryOtherCompaniesPlant1(String yop, String mop, String company) throws CodeException{
        DbBean db = DbBean.connect();
        String[] companylst = company.split("-");

        String sql = " SELECT SUM(b.`Jumlah` * b.`HargaStandard` ) val\n" +
                    " FROM manufaktur.`gudangsuratjalanrmpm` a \n" +
                    " INNER JOIN manufaktur.`gudangsuratjalanrmpmdetail` b ON a.`NomorDokumen` = b.`NomorDokumen` \n" +
                    " INNER JOIN manufaktur.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` \n" +
                    " INNER JOIN manufaktur.masterbahan d ON b.`KodeBahan` = d.`KodeBahan` \n" +
                    " WHERE a.tanggaldokumen BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' \n" +
                    "     AND a.`KodeDistributor` =  '" + companylst[0] + "' ";
               
        long val = 0;
        System.out.println(sql);
        
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                val = rs.getLong("Val");
            }
            
            rs.close();

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
        
        return GlobalUtils.formatnumber(val);
    }


    public void getInvoiceOtherCompaniesPlant1(String yop, String mop, String company, DefaultTableModel dtm, Object[] obj) throws CodeException{
        
        String[] companylst = company.split("-");
        
        DbBean db = DbBean.connect();
        List<Object> list = Collections.synchronizedList(new ArrayList<Object>());

        String sql = "SELECT a.`NomorDokumen`, "
                + "     a.`TanggalDokumen`, "
                + "     b.NoPo, "
                + "     b.`KodeBahan`, "
                + "     d.`NamaAsli` NamaBahan, "
                + "     b.`Jumlah`, "
                + "     d.Satuan, "
                + "     b.`HargaStandard` "
                + " FROM manufaktur.`gudangsuratjalanrmpm` a "
                + " INNER JOIN manufaktur.`gudangsuratjalanrmpmdetail` b ON a.`NomorDokumen` = b.`NomorDokumen` "
                + " INNER JOIN manufaktur.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` "
                + " INNER JOIN manufaktur.masterbahan d ON b.`KodeBahan` = d.`KodeBahan` "
                + " WHERE a.tanggaldokumen BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' "
                + "     AND a.`KodeDistributor` =  '" + companylst[0] + "' "
                + "     ORDER BY a.tanggaldokumen, b.kodebahan " ;
        
        try {
            GlobalModel.clearRow(dtm);
            
            Double subtotjumlah = 0.0D;
            Double totjumlah = 0.0D;
            
            String nomordokumen = "";
            int no = 0;
            Double hargastandard = 0.0D;
            Double value = 0.0D;
            Double subjumlah = 0.0D;
            Double jumlah = 0.0D;
            ResultSet rs = db.executeQuery(sql);
            String nopo = "";
            
            
            while (rs.next()) {
                Object[] objInvoice = new Object[9];
                objInvoice[0] = rs.getString("NomorDokumen"); //0
                objInvoice[1] = rs.getString("TanggalDokumen"); //1
                objInvoice[2] = rs.getString("NoPo"); //2
                objInvoice[3] = rs.getString("KodeBahan"); //3 
                objInvoice[4] = rs.getString("NamaBahan"); //4
                objInvoice[5] = rs.getDouble("Jumlah"); //5
                objInvoice[6] = rs.getString("Satuan"); //6
                objInvoice[7] = rs.getDouble("HargaStandard");//7
                
                list.add(objInvoice);
            }
            rs.close();
            db.close();

            for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
                Object[] valobj = (Object[]) it.next();
                dtm.addRow(obj);
                
                if (no == 0) {
                    nomordokumen = valobj[0]+"";
                }
                if (nomordokumen.equals(String.valueOf(valobj[0]))){
                    no += 1;
                } else{                    
                    dtm.setValueAt("Sub Total : ", dtm.getRowCount() - 1, 5);
                    dtm.setValueAt(subjumlah, dtm.getRowCount() - 1, 6);
                    dtm.setValueAt(subtotjumlah, dtm.getRowCount() - 1, 9);
                    dtm.addRow(obj);                    
                    dtm.addRow(obj);    
                    nomordokumen = String.valueOf(valobj[0]);
                    no = 1;
                    subjumlah = 0.0D;
                    subtotjumlah = 0.0D;
                }
                dtm.setValueAt(String.valueOf(valobj[0]), dtm.getRowCount() - 1, 0);
                dtm.setValueAt(String.valueOf(valobj[1]), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(no, dtm.getRowCount() - 1, 2);
                dtm.setValueAt(String.valueOf(valobj[2]), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(String.valueOf(valobj[3]), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(String.valueOf(valobj[4]), dtm.getRowCount() - 1, 5);
                jumlah = Double.parseDouble(valobj[5]+"");
                subjumlah += jumlah;
                dtm.setValueAt(jumlah, dtm.getRowCount() - 1, 6);
                dtm.setValueAt(String.valueOf(valobj[6]+""), dtm.getRowCount() - 1, 7);  
                
                nopo = String.valueOf(valobj[2]);
                if (nopo.length() > 4) {
                    nopo = nopo.substring(0,4);
                }
                hargastandard = Double.parseDouble(valobj[7]+"") ;  
                dtm.setValueAt(hargastandard, dtm.getRowCount() - 1, 8);
                value = jumlah * hargastandard;
                dtm.setValueAt(value, dtm.getRowCount() - 1, 9);
                totjumlah += value;
                subtotjumlah += value;
            }
            dtm.addRow(obj);    
            dtm.setValueAt("Sub Total : ", dtm.getRowCount() - 1, 5);
            dtm.setValueAt(subjumlah, dtm.getRowCount() - 1, 6);
            dtm.setValueAt(subtotjumlah, dtm.getRowCount() - 1, 9);
            dtm.addRow(obj);                    
            dtm.addRow(obj);    
            
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah, dtm.getRowCount() - 1, 9);
            
            dtm.addRow(obj);
            dtm.setValueAt("PPN : ", dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah * 0.1, dtm.getRowCount() - 1, 9);
                        
            dtm.addRow(obj);
            dtm.setValueAt("Amount : ", dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah * 1.1, dtm.getRowCount() - 1, 9);

            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    public List<String> addListOtherCompaniesPlant1(String yop, String mop) {
        String sql = "SELECT concat(a.kodedistributor, '-' , b.NamaRekanan) rekanan \n" +
                        "FROM manufaktur.gudangsuratjalanrmpm a\n" +
                        "	INNER JOIN manufaktur.`masterrekanan` b ON  a.`KodeDistributor` = b.koderekanan\n" +
                        "WHERE a.`TanggalDokumen` BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31'\n" +
                        "       and a.kodedistributor not in ('2212','C33') " +
                        "GROUP BY kodedistributor ";

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        try {
            
             
            DbBean db = DbBean.connect();
                    ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String company = rs.getString("rekanan");
                list.add(company);
            }

            db.close();
            
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
  
    public void saveRevisiDetailOtherCompanyPlant2(String nomordokumen, String kodeproduk, String hargafaktur, String  noGr, String reff ) {
        
        try {
            String sql = " update manufakturgp.`gudangsuratjalanproduksidetail` set HargaFaktur = " + hargafaktur + ", noGr = '" + noGr + "', Reff = '" + reff + "' WHERE nomordokumen = '" + nomordokumen + "' AND kodeproduk = '"+ kodeproduk+ "' ";
            DbBean db = DbBean.connect();                        
            db.doexecute(sql);
            sql = " update manufakturgp.masterproduk set HargaFaktur = " + hargafaktur + " WHERE  kodeproduk = '"+ kodeproduk+ "' ";
            db.doexecute(sql);
                        
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean saveInvoiceOtherCompanyPlant2(String yop, String mop, String NoInvoice, String company) {
        boolean bsave = false;
        String[] companylst = company.split("-");
                
        try {
            DbBean dba = DbBean.connect();

            String sql = "DELETE FROM `bankjurnal`.`tariksales` WHERE yop = " + yop + " AND mop = " + mop + "  AND company = '" + companylst[0] + "'";
            dba.doexecute(sql);


            sql = " INSERT INTO `bankjurnal`.tariksales\n" 
                   + "( \n" 
                   + "yop,\n" 
                   + "mop, \n" 
                   + "NoInvoice, \n" 
                   + "SKB, \n" 
                   + "docDate,	 \n" 
                   + "KdMb, \n" 
                   + "itemName, \n" 
                   + "qty, \n" 
                   + "hjp,\n" 
                   + "Company\n, "
                   + "NoGr, \n"
                   + "Reff " 
                   + ") "
                   + " SELECT "
                   + yop + " yop, "
                   + mop + " mop, " 
                   + "'" + NoInvoice + "' NoInvoice, " 
                   + " a.`NomorDokumen` SKB, "
                   + " a.`TanggalDokumen` docDate,	 "
                   + " b.`KodeProduk` KdMb, "
                   + " d.`NamaProduk`  itemName, "
                   + " b.`Jumlah` qty, "
                   + " b.`HargaFaktur` hjp, "
                   + " '" + companylst[0] + "' Company,"
                   + " b.NoGr, "
                   + " b.Reff "
                   + " FROM manufakturgp.`gudangsuratjalanproduksi` a "
                   + "       INNER JOIN manufakturgp.`gudangsuratjalanproduksidetail` b ON a.`NomorDokumen` = b.`NomorDokumen`  "
                   + "         INNER JOIN manufakturgp.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` "
                   + "         INNER JOIN manufakturgp.masterproduk d ON b.`KodeProduk` = d.`KodeProduk` "
                   + "         WHERE a.tanggaldokumen BETWEEN '"+ yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' "
                   + "             AND a.`KodeDistributor` = '" + companylst[0] + "' "
                   + "             ORDER BY a.tanggaldokumen, b.kodeproduk ";

            dba.doexecute(sql);
                
            bsave = true;
                
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       return bsave; 
    }

    public String getInvoiceSummaryOtherCompaniesPlant2(String yop, String mop, String company) throws CodeException{
        DbBean db = DbBean.connect();
        String[] companylst = company.split("-");

        String sql = " SELECT SUM(c.`Jumlah` * (case when c.`HargaFaktur` = 0 then c.HargaStandard else c.hargafaktur end)) val\n" +
                        "FROM manufakturgp.`gudangsuratjalanproduksi` a\n" +
                        "	INNER JOIN manufakturgp.`masterrekanan` b ON  a.`KodeDistributor` = b.koderekanan	\n" +
                        "	INNER JOIN manufakturgp.`gudangsuratjalanproduksidetail` c ON a.`NomorDokumen` = c.`NomorDokumen`\n" +
                        " WHERE a.tanggaldokumen BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' \n" +
                        "     AND a.`KodeDistributor` =  '" + companylst[0] + "' ";
        
        
        long val = 0;

        
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                val = rs.getLong("Val");
            }
            
            rs.close();

        } catch (SQLException ex) {
            throw new CodeException("Invoice  : Cannot Set Data " + ex.getMessage());
        }
        db.close();
        
        return GlobalUtils.formatnumber(val);
    }

    public void getInvoiceOtherCompaniesPlant2(String yop, String mop, String company, DefaultTableModel dtm, Object[] obj) throws CodeException{
        
        String[] companylst = company.split("-");
        
        DbBean db = DbBean.connect();
        
        String updatesql = "update manufakturgp.masterproduk  set hargafaktur = hargastandard WHERE hargafaktur = 0 ";
        try {
            db.doexecute(updatesql);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        updatesql = "update manufakturgp.gudangsuratjalanproduksidetail  set hargafaktur = hargastandard WHERE hargafaktur = 0 ";
        try {
            db.doexecute(updatesql);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Object> list = Collections.synchronizedList(new ArrayList<Object>());

        String sql = "SELECT a.`NomorDokumen`, "
                + "     a.`TanggalDokumen`, "
                + "     a.NomorAcuan, "
                + "     b.`KodeProduk`, "
                + "     d.NamaProduk , "
                + "     b.`Jumlah`, "
                + "     d.Satuan, "
                + "     b.hargafaktur ,  "
                + "     d.Isi, "
                + "     b.jumlah / d.isi box , "
                + "     b.hargafaktur * d.Isi  HargaBox, "
                + "     ifnull(b.NoGr, '') NoGr , "
                + "     ifnull(b.Reff, '') Reff"
                + " FROM manufakturgp.`gudangsuratjalanproduksi` a "
                + " INNER JOIN manufakturgp.`gudangsuratjalanproduksidetail` b ON a.`NomorDokumen` = b.`NomorDokumen` "
                + " INNER JOIN manufakturgp.masterrekanan c ON a.`KodeDistributor` = c.`KodeRekanan` "
                + " INNER JOIN manufakturgp.masterproduk d ON b.`KodeProduk` = d.`KodeProduk` "
                + " WHERE a.tanggaldokumen BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31' "
                + "     AND a.`KodeDistributor` =  '" + companylst[0] + "' "
                + "     ORDER BY a.tanggaldokumen, b.kodeproduk " ;
        
        System.out.println(sql);
        
        try {
            GlobalModel.clearRow(dtm);
            
            Double subtotjumlah = 0.0D;
            Double totjumlah = 0.0D;
            
            String nomordokumen = "";
            int no = 0;
            Double hargafaktur = 0.0D;
            Double value = 0.0D;
            Double subjumlah = 0.0D;
            Double jumlah = 0.0D;
            Double subjumlahbox = 0.0D;
            Double jumlahbox = 0.0D;
            Double hargabox = 0.0D;
            
            ResultSet rs = db.executeQuery(sql);
            String nopo = "";
            
            
            while (rs.next()) {
                Object[] objInvoice = new Object[13];
                objInvoice[0] = rs.getString("NomorDokumen"); //0
                objInvoice[1] = rs.getString("TanggalDokumen"); //1
                objInvoice[2] = rs.getString("NomorAcuan"); //2
                objInvoice[3] = rs.getString("KodeProduk"); //3 
                objInvoice[4] = rs.getString("NamaProduk"); //4
                objInvoice[5] = rs.getDouble("Jumlah"); //5
                objInvoice[6] = rs.getString("Satuan"); //6
                objInvoice[7] = rs.getDouble("HargaFaktur");//7
                objInvoice[8] = rs.getDouble("Isi");//8
                objInvoice[9] = rs.getDouble("Box");//9
                objInvoice[10] = rs.getDouble("HargaBox");//10
                objInvoice[11] = rs.getString("NoGr")==null ? "" : rs.getString("NoGr") ;//11
                objInvoice[12] = rs.getString("Reff") == null ? "" : rs.getString("Reff") ;//112
                
                list.add(objInvoice);
            }
            rs.close();
            db.close();

            for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
                Object[] valobj = (Object[]) it.next();
                
                if (no == 0) {
                    nomordokumen = valobj[0]+"";
                }

                dtm.addRow(obj);
                if (nomordokumen.equals(String.valueOf(valobj[0]))){
                    no += 1;
                } else{
                    dtm.setValueAt("Sub Total : ", dtm.getRowCount() - 1, 5);
                    dtm.setValueAt(subjumlah, dtm.getRowCount() - 1, 6);
                    dtm.setValueAt(subtotjumlah, dtm.getRowCount() - 1, 9);
                    dtm.setValueAt(subjumlahbox, dtm.getRowCount() - 1, 11);
                    dtm.addRow(obj);                    
                    dtm.addRow(obj);    
                    nomordokumen = String.valueOf(valobj[0]);
                    no = 1;
                    subjumlah = 0.0D;
                    subtotjumlah = 0.0D;
                    subjumlahbox = 0.0D;
                }
                dtm.setValueAt(String.valueOf(valobj[0]), dtm.getRowCount() - 1, 0);
                dtm.setValueAt(String.valueOf(valobj[1]), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(no, dtm.getRowCount() - 1, 2);
                dtm.setValueAt(String.valueOf(valobj[2]), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(String.valueOf(valobj[3]), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(String.valueOf(valobj[4]), dtm.getRowCount() - 1, 5);
                jumlah = Double.parseDouble(valobj[5]+"");
                subjumlah += jumlah;
                dtm.setValueAt(jumlah, dtm.getRowCount() - 1, 6);
                dtm.setValueAt(String.valueOf(valobj[6]+""), dtm.getRowCount() - 1, 7);  
                
                
                
                nopo = String.valueOf(valobj[2]);
                if (nopo.length() > 4) {
                    nopo = nopo.substring(0,4);
                }
                hargafaktur = Double.parseDouble(valobj[7]+"") ;  //getHargaCDF(nopo, String.valueOf(valobj[3]), yop);
                dtm.setValueAt(hargafaktur, dtm.getRowCount() - 1, 8);
                value = jumlah * hargafaktur;
                dtm.setValueAt(value, dtm.getRowCount() - 1, 9);
                totjumlah += value;
                subtotjumlah += value;
                
                
                dtm.setValueAt(Double.parseDouble(valobj[8]+""), dtm.getRowCount() - 1, 10);                  
                jumlahbox = Double.parseDouble(valobj[9]+"");
                subjumlahbox += jumlahbox;
                dtm.setValueAt(jumlahbox, dtm.getRowCount() - 1, 11);                
                hargabox = Double.parseDouble(valobj[10]+"");
                dtm.setValueAt(hargabox, dtm.getRowCount() - 1, 12);  
                
                dtm.setValueAt(String.valueOf(valobj[11]), dtm.getRowCount() - 1, 13);  
                dtm.setValueAt(String.valueOf(valobj[12]), dtm.getRowCount() - 1, 14);  
                
                
            }
            dtm.addRow(obj);    
            dtm.setValueAt("Sub Total : ", dtm.getRowCount() - 1, 5);
            dtm.setValueAt(subjumlah, dtm.getRowCount() - 1, 6);
            dtm.setValueAt(subtotjumlah, dtm.getRowCount() - 1, 9);
            dtm.setValueAt(subjumlahbox, dtm.getRowCount() - 1, 11);
            dtm.addRow(obj);                    
            dtm.addRow(obj);    
            
            
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah, dtm.getRowCount() - 1, 9);
            
            dtm.addRow(obj);
            dtm.setValueAt("PPN : ", dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah * 0.1, dtm.getRowCount() - 1, 9);
                        
            dtm.addRow(obj);
            dtm.setValueAt("Amount : ", dtm.getRowCount() - 1, 7);
            dtm.setValueAt(totjumlah * 1.1, dtm.getRowCount() - 1, 9);

            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<String> addListOtherCompaniesPlant2(String yop, String mop) {

        String sql = "SELECT concat(a.kodedistributor, '-' , b.NamaRekanan) rekanan \n" +
                        "FROM manufakturgp.`gudangsuratjalanproduksi` a\n" +
                        "	INNER JOIN manufakturgp.`masterrekanan` b ON  a.`KodeDistributor` = b.koderekanan	\n" +
                        "WHERE a.`TanggalDokumen` BETWEEN '" + yop + "-" + mop + "-01' AND '" + yop + "-" + mop + "-31'\n" +
                        "       AND kodedistributor NOT IN ('1103', '1101')\n" +
                        "GROUP BY a.`KodeDistributor`";

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        try {
            
             
            DbBean db = DbBean.connect();
                    ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                String company = rs.getString("rekanan");
                list.add(company);
            }

            db.close();
            
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean saveInvoiceOtherManual(String yop, String mop, String noinvoice, DefaultTableModel dtm, String company ){
        boolean bsave = false;
                        
        try {
            DbBean db = DbBean.connect();
            
            
            
            String sql = "delete from bankjurnal.tariksales where yop='" + yop + "' and mop = '" + mop + "' and company = '" + company + "' ";
            db.doexecute(sql);


            //"No. Dok" 0, "Tgl Dokumen" 1,  "Kode Produk" 2, "Nama Produk" 3, "Jumlah" 4,
            //"Satuan" 5, "Harga Faktur" 6, "Value" 7, "Discount" 8, "Total" 9, "Isi" 10, "Box" 11, "Harga Box" 12, "NoGr" 13, "Reff" 14
            
            for(int i = 0; i<dtm.getRowCount(); i++) {
                if (dtm.getValueAt(i, 2) != null ){
                    String skb  = String.valueOf(dtm.getValueAt(i, 0));
                    String noinv = noinvoice;
                    String docdate = String.valueOf(dtm.getValueAt(i, 1));
                    String kodeMB = String.valueOf(dtm.getValueAt(i, 2));
                    String itemName = String.valueOf(dtm.getValueAt(i, 3));
                    Double qty = Double.valueOf((dtm.getValueAt(i, 4) == null ?  "0" : dtm.getValueAt(i, 4)+ ""));
                    Double hpd = Double.valueOf((dtm.getValueAt(i, 6)==null ? "0" : dtm.getValueAt(i, 6)+ ""));
                    Double discount = Double.valueOf((dtm.getValueAt(i, 8) == null  ?"0" : dtm.getValueAt(i, 8) +""));
                    String noGr = String.valueOf(dtm.getValueAt(i, 13));
                    String reff = String.valueOf(dtm.getValueAt(i, 14));

                    sql = "insert into bankjurnal.tariksales (yop, mop, skb, noInvoice, docdate, kdMB, itemName, qty, hpd, discount, nogr, reff, company) "
                            + " values ('" + yop + "', '" + mop + "', '" + skb + "', '" + noinv + "', '" + docdate + "', '" + kodeMB + "', '" + itemName + "', "
                           + qty + ", " + hpd + ", " + discount + ", '" + noGr + "',  '" + reff + "', '" + company + "') ";
                    
                    
                    System.out.println(sql);
                    db.doexecute(sql);
                    
                }                
            }
            bsave = true;
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bsave;
    }
    public boolean loadOtherManual(String yop, String mop, String koderekanan, Object[] obj){
        boolean bload = false;
        String sql = "SELECT a.yop, "
                + " a.`Mop`, "
                + " b.`KodeRekanan`, "
                + " b.`NamaRekanan`, "
                + " a.isProduct, "
                + " a.`TotalAmount`, "
                + " a.Tanggal, "
                + " a.`discAmount`, "
                + " a.`noInvoice`, "
                + " a.`noFakturPajak`, "
                + " a.`bfrTaxAmount`, "
                + " a.`taxAmount`, "
                + " a.`aftTaxAmount`, "
                + " a.isproduct "
                + "FROM bankjurnal.`tariksales_invoice_hdr` a "
                + "     INNER JOIN manufaktur.`masterrekanan` b ON a.`Company` = b.`KodeRekanan` "
                + " WHERE a.yop = " + yop 
                + "         AND a.mop = " + mop 
                + "         AND koderekanan = '" + koderekanan + "' ";
        
        try {
            DbBean db = DbBean.connect();
        
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                obj[0] = rs.getString("yop");
                obj[1] = rs.getString("mop");
                obj[2] = rs.getString("KodeRekanan");
                obj[3] = rs.getString("NamaRekanan");
                obj[4] = rs.getInt("isproduct");
                obj[5] = rs.getDouble("TotalAmount");
                obj[6] = rs.getString("noInvoice");
                obj[7] = rs.getString("noFakturPajak");
                obj[8] = rs.getDate("tanggal");                
                obj[9] = rs.getDouble("discAmount");
                obj[10] = rs.getDouble("bfrTaxAmount");
                obj[11] = rs.getDouble("taxAmount");
                obj[12] = rs.getDouble("aftTaxAmount");
                
                bload = true;
            }

            rs.close();
            db.close();
            
        } catch (Exception ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bload;
    }
    
    public void loadDetailOtherManual(String yop, String mop, String koderekanan, boolean isproduct, DefaultTableModel dtm,Object[] obj){
        //"No. Dok" 0, "Tgl Dokumen" 1,  "Kode Produk" 2, "Nama Produk" 3, "Jumlah" 4,
        //"Satuan" 5, "Harga Faktur" 6, "Value" 7, "Discount" 8, "Total" 9, "Isi" 10, "Box" 11, "Harga Box" 12, "NoGr" 13, "Reff" 14
        
        String sql = "SELECT a.yop, "
                + " a.`Mop`, "
                + " a.`Skb` nodokumen, "
                + " a.`docdate` , "
                + " a.kdmb , "
                + " a.`itemName`, "
                + " a.`qty`, "
                + " c.`Satuan`, "
                + " a.`HPD`, "
                + " a.`qty` * a.`HPD` `value`, "
                + " a.`Discount`, "
                + " (a.`qty` * a.`HPD`) - a.`Discount` total, ";
                
        if(isproduct){
            sql += " c.isi, "
                + " a.qty / c.isi box, "
                + " a.HPD * c.isi HargaBox, ";
        }else{
            sql += " 1 isi, "
                + " a.qty  box, "
                + " a.HPD  HargaBox, ";            
        }
                
            sql +=" a.NoGr, "
                + " a.Reff "
                + "FROM bankjurnal.`tariksales` a  "
                + "     INNER JOIN manufaktur.`masterrekanan` b ON a.`Company` = b.`KodeRekanan` ";
        if(isproduct){
            sql += "     INNER JOIN manufaktur.masterproduk c ON a.`KdMB` = c.`KodeProduk` ";
        }else{
            sql += "     INNER JOIN manufaktur.masterbahan c ON a.`KdMB` = c.`KodeBahan` ";            
        }
        
            sql += " WHERE a.yop = " + yop 
                + "         AND a.mop = " + mop 
                + "         AND a.company = '" + koderekanan + "' ";
            
        System.out.println(sql);
        
        try {
            DbBean db = DbBean.connect();
        
            GlobalModel.clearRow(dtm);
            
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()) {
                //"No. Dok" 0, "Tgl Dokumen" 1,  "Kode Produk" 2, "Nama Produk" 3, "Jumlah" 4,
                //"Satuan" 5, "Harga Faktur" 6, "Value" 7, "Discount" 8, "Total" 9, "Isi" 10, "Box" 11, "Harga Box" 12, "NoGr" 13, "Reff" 14
                dtm.addRow(obj);

                dtm.setValueAt(rs.getString("nodokumen"),dtm.getRowCount() - 1,0);
                dtm.setValueAt(rs.getString("docdate"),dtm.getRowCount() - 1,1);
                dtm.setValueAt(rs.getString("kdmb"), dtm.getRowCount() - 1 ,2);
                dtm.setValueAt(rs.getString("itemName"),dtm.getRowCount() - 1,3);
                dtm.setValueAt(rs.getDouble("qty"),dtm.getRowCount() - 1,4);
                dtm.setValueAt(rs.getString("Satuan"), dtm.getRowCount() - 1,5);
                dtm.setValueAt(rs.getDouble("HPD"), dtm.getRowCount() -1, 6);
                dtm.setValueAt(rs.getDouble("value"), dtm.getRowCount() -1 ,7);
                dtm.setValueAt(rs.getDouble("Discount"), dtm.getRowCount() - 1, 8);
                dtm.setValueAt(rs.getDouble("total"), dtm.getRowCount() -1, 9);
                dtm.setValueAt(rs.getDouble("isi"), dtm.getRowCount() -1, 10);
                dtm.setValueAt(rs.getDouble("box"), dtm.getRowCount() -1 ,11);
                dtm.setValueAt(rs.getDouble("HargaBox"), dtm.getRowCount() -1, 12);
                dtm.setValueAt(rs.getString("NoGr")==null ? "" : rs.getString("NoGr"), dtm.getRowCount() - 1,13);
                dtm.setValueAt(rs.getString("Reff")==null ? "" :rs.getString("Reff") , dtm.getRowCount() -1, 14);
                
            }

            
            rs.close();
            db.close();

        } catch (Exception ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void saveRevisiDetailCPP(String nomordokumen, String kodeproduk, String hargastandard) {
        try {
            String sql = " update bankjurnal.`tariksales` set "
                    + "HJP = " + hargastandard
                    + "WHERE Skb = '" + nomordokumen + "' AND KdMB = '"+ kodeproduk+ "' ";
            System.out.println(sql);
            DbBean db = DbBean.connect();
                        
            db.doexecute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getInvoiceDetailMTS(String yop, String mop, DefaultTableModel dtm, Object[] obj) throws CodeException {
        DbBean db = DbBean.connect();
        String sql = "SELECT a.`cust_code`,\n" +
                    "a.`doc_num`,\n" +
                    "a.`doc_date`,\n" +
                    "a.`prod_code`,\n" +
                    "a.`prod_name`,\n" +
                    "a.`qty`,\n" +
                    "a.`hpd`,\n" +
                    "a.`het` \n" +
                    "FROM bankjurnal.sales_fg_mts a \n" +
                    "WHERE a.`yop`="+yop+" AND a.`mop`="+mop ;

        GlobalModel.clearRow(dtm);

        try {
            Double totQty = 0.0D;
            Double totSubtotal = 0.0D;
            Double subtotal = 0.0D;
            int no = 0;

            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                
                no++;
                            
                dtm.addRow(obj);                               
                
                dtm.setValueAt(no, dtm.getRowCount() - 1, 0);
                dtm.setValueAt(rs.getString("cust_code"), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("doc_num"), dtm.getRowCount() - 1, 2);                
                dtm.setValueAt(rs.getString("doc_date"), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(rs.getString("prod_code"), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(rs.getString("prod_name"), dtm.getRowCount() - 1, 5);
                dtm.setValueAt(rs.getDouble("hpd"), dtm.getRowCount() - 1, 6);
                dtm.setValueAt(rs.getDouble("het"), dtm.getRowCount() - 1, 7);
                dtm.setValueAt(rs.getDouble("qty"), dtm.getRowCount() - 1, 8);
                
                subtotal = rs.getDouble("qty")*rs.getDouble("het");
                dtm.setValueAt(subtotal, dtm.getRowCount() - 1, 9);
                
                totQty += rs.getDouble("qty");  
                totSubtotal += subtotal;
                                
            }
            dtm.addRow(obj);
            dtm.addRow(obj);
            dtm.setValueAt("Total : ", dtm.getRowCount() - 1, 5);
            dtm.setValueAt(totQty, dtm.getRowCount() - 1, 8);
            dtm.setValueAt(totSubtotal, dtm.getRowCount() - 1, 9);
            
            rs.close();
            
            
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getInvoiceSummaryMTSHPD(String yop, String mop) throws CodeException{
        DbBean db = DbBean.connect();
        String sql = "SELECT SUM(a.`qty`*a.`hpd`) tothpd "
                + "FROM bankjurnal.sales_fg_mts a " 
                + "WHERE a.`yop`="+yop+" AND a.`mop`="+mop+" "
                + "GROUP BY a.`yop`,a.`mop`"; 
        System.out.println(sql );
        long val = 0;
        
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                val = rs.getLong("tothpd");
            }
            
            try {
                rs.close();
            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }                

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
        
        return GlobalUtils.formatnumber(val);
    }

    public String getInvoiceSummaryMTSHET(String yop, String mop) throws CodeException {
        DbBean db = DbBean.connect();
        String sql = "SELECT SUM(a.`qty`*a.`het`) tothet "
                + "FROM bankjurnal.sales_fg_mts a " 
                + "WHERE a.`yop`="+yop+" AND a.`mop`="+mop+" "
                + "GROUP BY a.`yop`,a.`mop`"; 
        System.out.println(sql );
        long val = 0;
        
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                val = rs.getLong("tothet");
            }
            
            try {
                rs.close();
            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }                

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
        
        return GlobalUtils.formatnumber(val);
    }
    
    public void setCreateInvoice(String id, String cmpny, String isCreate){
        try {
            int setCreateInv = (isCreate.equals("true")) ? 1 : 0;
            String sql = " update bankjurnal.`tariksales_invoice_hdr` set "
                    + " readytcrInv = " +setCreateInv
                    + " WHERE id = '" + id + "' AND Company='"+cmpny+"'";
            //System.out.println(sql);
            DbBean db = DbBean.connect();

            db.doexecute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean  cekNoInvoice(String yop, String mop, String noinvoice) throws CodeException{
        DbBean db = DbBean.connect();        
        
        boolean bfound = false;
        String sql = " SELECT count(noInvoice) jmldata FROM `bankjurnal`.`tariksales_invoice_hdr` a "
                + " WHERE a.`Yop` = " + yop + " AND a.`Mop` = " + mop + " and a.noInvoice = '" + noinvoice + "' GROUP BY a.noInvoice";
        //System.out.println("SQL: "+sql);
        long val = 0;
        ResultSet rs;
        try {
            rs = db.executeQuery(sql);
            if (rs.next()) {
                val = rs.getLong("jmldata");
                if(val > 0){
                    bfound = true;
                } else {
                    bfound = false;
                }
            }
            
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        
        return bfound;
        
    }
    
    public boolean saveInvoiceMTS(String yop, String mop, String NoInvoice) {
        boolean bsave = false;
                
        try {
            DbBean dba = DbBean.connect();

            String sql = "DELETE FROM `bankjurnal`.`tariksales` WHERE yop = " + yop + " AND mop = " + mop + "  AND company = 'MTS'";
            dba.doexecute(sql);

            sql = " INSERT INTO `bankjurnal`.`tariksales`\n" +
            "(`id`,`Yop`,`Mop`,`docNum`,`NoInvoice`,`Skb`,`docdate`,\n" +
            "`KdMB`,`KdSai`,`MtgCode`,`itemName`,`KdBrand`,`NamaBrand`,\n" +
            "`qty`,`HJP`,`HPD`,`Discount`,`Company`,`NoGR`,`Reff`)\n" +
            "SELECT\n" +
            "NULL,`yop` `Yop`,`mop` `Mop`,`doc_num` `docNum`,'"+NoInvoice+"' `NoInvoice`,'' `Skb`,`doc_date` `docdate`,\n" +
            "`prod_code` `KdMB`,`prod_code_sai` `kdSai`,`prod_universal` `MtgCode`,`prod_name` `ItemName`,\n" +
            "`brand_code` `KdBrand`,'' `NamaBrand`,\n" +
            "`qty`,`het`,`hpd`,0 `Discount`,'MTS' `Company`,'' `NoGR`,'' `Reff`\n" +
            "FROM `bankjurnal`.`sales_fg_mts`\n" +
            "WHERE yop='"+yop+"' AND mop='"+mop+"'";

            dba.doexecute(sql);
            
            //System.out.println(sql);
                
            bsave = true;
                
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CodeException ex) {
            Logger.getLogger(InvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       return bsave; 
    }
}
