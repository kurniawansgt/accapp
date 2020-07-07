/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accapp.objectclasses.costapp;

import accapp.component.costapp.FrmCostAccounting;
import common.jdbc.DbBean;
import common.tablemodels.GlobalModel;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author windugata
 */
public class Costacc {
    public void showJournalTemp(String mop, String yop, DefaultTableModel dtm, Object[] obj){
        String sql = "SELECT YOP,MOP, -- 1 BATCHNBR,\n" +
                    "	JOURNALID,JURNALDESC,TRANSNBR,ACCTID,ACCDESC,TRANSAMT,SCURNCODE,TRANSDESC,TRANSREF\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT 	a.yop,a.mop,1 BATCHNBR ,a.accgroup JOURNALID ,CONCAT('JVC',RIGHT(100+a.accgroup,2)) JURNALDESC ,\n" +
                    "	@TRANSNBR:=IF(@TRANSNBRKEY!=a.accgroup,1,@TRANSNBR+1) TRANSNBR , a.accid ACCTID ,UPPER(a.accdesc) ACCDESC, a.transamt TRANSAMT ,a.scurncode SCURNCODE,a.transdesc TRANSDESC,\n" +
                    "	CONCAT('JVC',RIGHT(100+a.accgroup,2)) TRANSREF,@TRANSNBRKEY:=a.accgroup TRANSNBRKEY\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT 	a.yop,a.mop,a.accid,UPPER(ga.accdesc) accdesc, a.transamt,a.scurncode,a.transdesc,\n" +
                    "	a.accgroup,a.accgroupdetail,a.accnourut \n" +
                    "FROM bankjurnal.account_format_jurnal_temp a \n" +
                    "LEFT JOIN gl_account ga ON ga.acccode=a.accid\n" +
                    "WHERE a.yop=" + yop + " AND a.mop= " + mop + "\n" +
                    "ORDER BY a.accgroup,a.accgroupdetail,a.accnourut\n" +
                    ") AS a ,(SELECT @jurnalkey:=0,@TRANSNBR:=0,@TRANSNBRKEY:=0) aa  \n" +
                    ") AS a\n";
        
        //System.out.println(sql);
        GlobalModel.clearRow(dtm);

        DbBean db;
        try {
            db = DbBean.connect();
            
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                dtm.addRow(obj);
                
                dtm.setValueAt(rs.getString("YOP"), dtm.getRowCount() - 1, 0);
                dtm.setValueAt(rs.getString("MOP"), dtm.getRowCount() - 1, 1);
                dtm.setValueAt(rs.getString("JOURNALID"), dtm.getRowCount() - 1, 2);
                dtm.setValueAt(rs.getString("JURNALDESC"), dtm.getRowCount() - 1, 3);
                dtm.setValueAt(rs.getString("TRANSNBR"), dtm.getRowCount() - 1, 4);
                dtm.setValueAt(rs.getString("ACCTID"), dtm.getRowCount() - 1, 5);
                dtm.setValueAt(rs.getString("ACCDESC"), dtm.getRowCount() - 1, 6);
                dtm.setValueAt(rs.getInt("TRANSAMT"), dtm.getRowCount() - 1, 7);
                dtm.setValueAt(rs.getString("SCURNCODE"), dtm.getRowCount() - 1, 8);
                dtm.setValueAt(rs.getString("TRANSDESC"), dtm.getRowCount() - 1, 9);
                dtm.setValueAt(rs.getString("TRANSREF"), dtm.getRowCount() - 1, 10);                
                
            }

            db.close();
            
        } catch (CodeException ex) {
            Logger.getLogger(Costacc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Costacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean createJournalTemp(String yop, String mop) {
        boolean bcalculate = false;
        //Call sp_acc_format_jurnal_process (2019,10,’Admin’);

        
        try {
            DbBean db =  DbBean.connect();
            
            String sql = "Call bankjurnal.sp_acc_format_jurnal_process(" + yop + ","+ mop + ",'Admin')"; 
            db.doexecute(sql);
            
            db.close();
            
            
            bcalculate = true;
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Costacc.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        return bcalculate;
    }
    
    public boolean calculateCostAccounting(String yop, String mop) {
        boolean bcalculate = false;
        //Call sp_acc_process_all(2019,10,’Admin’);

        
        try {
            DbBean db =  DbBean.connect();
            
            String sql = "Call bankjurnal.sp_acc_process_all(" + yop + ","+ mop + ","+GlobalUtils.audituser+")"; 
            
            db.close();
            
            
            bcalculate = true;
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        return bcalculate;
    }

    public boolean processCostAccToGL(String yop, String mop, String currCode, int batchid, String audituser, String company) {
        boolean btransftogl = false;
        
        try {
            DbBean db =  DbBean.connect();
            
            String sql = "Call sp_acc_create_jurnal_cost_acc (" + yop + ","+ mop + "," + currCode+ "," + batchid + "," + audituser + "," + company + ")"; 
            
            db.close();
            
            
            btransftogl = true;
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return btransftogl;
    }
}
