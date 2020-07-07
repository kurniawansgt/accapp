/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.cashbook;


import common.classinterface.NavigatorObjectInt;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import common.utils.ClassRegister;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.utils.ObjectCache;
import common.jdbc.DbBean;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


public abstract class Payment_voucherAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Payment_voucher";

    public static final String TABLE = "payment_voucher";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PV_NUMBER = "pv_number";
    public static final String PROPERTY_CASHFLOW_NO = "cashflow_no";
    public static final String PROPERTY_PAYMENT_NUMBER = "payment_number";
    public static final String PROPERTY_TRANS_TYPE_ID = "trans_type_id";
    public static final String PROPERTY_SUPPLIER_ID = "supplier_id";
    public static final String PROPERTY_PV_CURRENCY = "pv_currency";
    public static final String PROPERTY_PV_AMOUNT = "pv_amount";
    public static final String PROPERTY_PV_AMOUNT_RUPIAH = "pv_amount_rupiah";
    public static final String PROPERTY_PV_FINAL_CURRENCY = "pv_final_currency";
    public static final String PROPERTY_PV_FINAL_AMOUNT = "pv_final_amount";
    public static final String PROPERTY_PV_FINAL_CURRENCY_RUPIAH = "pv_final_currency_rupiah";
    public static final String PROPERTY_PV_FINAL_AMOUNT_RUPIAH = "pv_final_amount_rupiah";
    public static final String PROPERTY_CONVERT_CURRENCY = "convert_currency";
    public static final String PROPERTY_CONVERT_AMOUNT = "convert_amount";
    public static final String PROPERTY_PPH_CURRENCY = "pph_currency";
    public static final String PROPERTY_PPH_AMOUNT = "pph_amount";
    public static final String PROPERTY_WITH_PPN = "with_ppn";
    public static final String PROPERTY_WITH_PPH = "with_pph";
    public static final String PROPERTY_RECEIVED_DOC_DATE = "received_doc_date";
    public static final String PROPERTY_TOP_ID = "top_id";
    public static final String PROPERTY_TOP_DATE = "top_date";
    public static final String PROPERTY_BANK_ID = "bank_id";
    public static final String PROPERTY_NOTE_FROM_ACCOUNTING = "note_from_accounting";
    public static final String PROPERTY_NOTE_NON_ACCOUNTING = "note_non_accounting";
    public static final String PROPERTY_PV_STATUS_ID = "pv_status_id";
    public static final String PROPERTY_PV_TYPE_ID = "pv_type_id";
    public static final String PROPERTY_INSERTED_BY = "inserted_by";
    public static final String PROPERTY_INSERTED_DATE = "inserted_date";
    public static final String PROPERTY_UPDATED_BY = "updated_by";
    public static final String PROPERTY_UPDATED_DATE = "updated_date";
    public static final String PROPERTY_TYPE = "type";
    
     public static final String PRIMARYKEY = PROPERTY_PV_NUMBER;
    
    
    private long id_;
    private String pv_number_;
    private String cashflow_no_;
    private String payment_number_;
    private String trans_type_id_;
    private String supplier_id_;
    private String pv_currency_;
    private String pv_amount_;
    private String pv_amount_rupiah_;
    private String pv_final_currency_;
    private String pv_final_amount_;
    private String pv_final_currency_rupiah_;
    private String pv_final_amount_rupiah_;
    private String convert_currency_;
    private String convert_amount_;
    private String pph_currency_;
    private String pph_amount_;
    private String with_ppn_;
    private String with_pph_;
    private Date received_doc_date_;
    private String top_id_;
    private Date top_date_;
    private String bank_id_;
    private String note_from_accounting_;
    private String note_non_accounting_;
    private String pv_status_id_;
    private long pv_type_id_;
    private long inserted_by_;
    private String inserted_date_;
    private long updated_by_;
    private String updated_date_;
    private String type_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Payment_voucherAbst() throws CodeException {
        loadNew();
    }
    
    public Payment_voucherAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Payment_voucherAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Payment_voucherAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Payment_voucherAbst(ResultSet rs) throws CodeException {
        loadRs(rs);
    }
    
    public void loadNew() throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        makeNew();
    }
     
     public void loadID(long id) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        if (id == NULLID) {
            makeNew();
        }else {
            id_=id;
            read();
        }    
    }
    public void loadString(String val)  throws CodeException {
        loadString(PRIMARYKEY, val);
        read();      
    }
    
     public void loadString (String key, String val)  throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        
        DbBean db = DbBean.connect();
        try{

            ResultSet rs = db.retrieve(TABLEPROCESS, key, val);
       
            if (rs.isBeforeFirst()) {
                rs.next();
                load(rs);
            }
            rs.close();
        } catch (SQLException sqle ) {
            throw new CodeException ("Error Create Payment_voucherAbst for Key : " + key + " val : " + val);
        } finally {
            db.close();
        }        
    }
    public void loadRs(ResultSet rs) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        load(rs);        
    }
    private void load(ResultSet rs) throws CodeException {
        try {
            
            long tempID = rs.getLong(PROPERTY_ID);
            long temp;
            String tempS;
            java.sql.Date tempDate;
            Timestamp tempTS;
            Date tempdate;
            id_=tempID;
            
            
            
           pv_number_ = rs.getString(PROPERTY_PV_NUMBER); 
           cashflow_no_ = rs.getString(PROPERTY_CASHFLOW_NO); 
           payment_number_ = rs.getString(PROPERTY_PAYMENT_NUMBER); 
           trans_type_id_ = rs.getString(PROPERTY_TRANS_TYPE_ID); 
           supplier_id_ = rs.getString(PROPERTY_SUPPLIER_ID); 
           pv_currency_ = rs.getString(PROPERTY_PV_CURRENCY); 
           pv_amount_ = rs.getString(PROPERTY_PV_AMOUNT); 
           pv_amount_rupiah_ = rs.getString(PROPERTY_PV_AMOUNT_RUPIAH); 
           pv_final_currency_ = rs.getString(PROPERTY_PV_FINAL_CURRENCY); 
           pv_final_amount_ = rs.getString(PROPERTY_PV_FINAL_AMOUNT); 
           pv_final_currency_rupiah_ = rs.getString(PROPERTY_PV_FINAL_CURRENCY_RUPIAH); 
           pv_final_amount_rupiah_ = rs.getString(PROPERTY_PV_FINAL_AMOUNT_RUPIAH); 
           convert_currency_ = rs.getString(PROPERTY_CONVERT_CURRENCY); 
           convert_amount_ = rs.getString(PROPERTY_CONVERT_AMOUNT); 
           pph_currency_ = rs.getString(PROPERTY_PPH_CURRENCY); 
           pph_amount_ = rs.getString(PROPERTY_PPH_AMOUNT); 
           with_ppn_ = rs.getString(PROPERTY_WITH_PPN); 
           with_pph_ = rs.getString(PROPERTY_WITH_PPH); 
           received_doc_date_ = rs.getDate(PROPERTY_RECEIVED_DOC_DATE); 
           top_id_ = rs.getString(PROPERTY_TOP_ID); 
           top_date_ = rs.getDate(PROPERTY_TOP_DATE); 
           bank_id_ = rs.getString(PROPERTY_BANK_ID); 
           note_from_accounting_ = rs.getString(PROPERTY_NOTE_FROM_ACCOUNTING); 
           note_non_accounting_ = rs.getString(PROPERTY_NOTE_NON_ACCOUNTING); 
           pv_status_id_ = rs.getString(PROPERTY_PV_STATUS_ID); 
           pv_type_id_ = rs.getLong(PROPERTY_PV_TYPE_ID); 
           inserted_by_ = rs.getLong(PROPERTY_INSERTED_BY); 
           inserted_date_ = rs.getString(PROPERTY_INSERTED_DATE); 
           updated_by_ = rs.getLong(PROPERTY_UPDATED_BY); 
           updated_date_ = rs.getString(PROPERTY_UPDATED_DATE); 
           type_ = rs.getString(PROPERTY_TYPE); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Payment_voucherAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Payment_voucher obj = (Payment_voucher)cache.get(getID());
            if (obj!=null) {
                copy(obj);
            }else{
                DbBean db = DbBean.connect();        
                ResultSet rs = db.retrieve(TABLEPROCESS, PROPERTY_ID, getID());
                try{
                    rs.next();
                    load(rs);
                    rs.close();
                    cache.add(this);
                }catch (SQLException e) {
                    throw new CodeException("Error Reading Payment_voucher " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getpv_number(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_number can not be Empty"); 
        } 
 
         o = getcashflow_no(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : cashflow_no can not be Empty"); 
        } 
 
         o = getpayment_number(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : payment_number can not be Empty"); 
        } 
 
         o = gettrans_type_id(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : trans_type_id can not be Empty"); 
        } 
 
         o = getsupplier_id(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : supplier_id can not be Empty"); 
        } 
 
         o = getpv_currency(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_currency can not be Empty"); 
        } 
 
         o = getpv_amount(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_amount can not be Empty"); 
        } 
 
         o = getpv_amount_rupiah(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_amount_rupiah can not be Empty"); 
        } 
 
         o = getpv_final_currency(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_final_currency can not be Empty"); 
        } 
 
         o = getpv_final_amount(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_final_amount can not be Empty"); 
        } 
 
         o = getpv_final_currency_rupiah(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_final_currency_rupiah can not be Empty"); 
        } 
 
         o = getpv_final_amount_rupiah(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_final_amount_rupiah can not be Empty"); 
        } 
 
         o = getconvert_currency(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : convert_currency can not be Empty"); 
        } 
 
         o = getconvert_amount(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : convert_amount can not be Empty"); 
        } 
 
         o = getpph_currency(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pph_currency can not be Empty"); 
        } 
 
         o = getpph_amount(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pph_amount can not be Empty"); 
        } 
 
         o = getwith_ppn(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : with_ppn can not be Empty"); 
        } 
 
         o = getwith_pph(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : with_pph can not be Empty"); 
        } 
 
         o = getreceived_doc_date(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : received_doc_date can not be Empty"); 
        } 
 
         o = gettop_id(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : top_id can not be Empty"); 
        } 
 
         o = gettop_date(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : top_date can not be Empty"); 
        } 
 
         o = getbank_id(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : bank_id can not be Empty"); 
        } 
 
         o = getnote_from_accounting(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : note_from_accounting can not be Empty"); 
        } 
 
         o = getnote_non_accounting(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : note_non_accounting can not be Empty"); 
        } 
 
         o = getpv_status_id(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_status_id can not be Empty"); 
        } 
 
         o = getpv_type_id(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pv_type_id can not be Empty"); 
        } 
 
         o = getinserted_by(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : inserted_by can not be Empty"); 
        } 
 
         o = getinserted_date(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : inserted_date can not be Empty"); 
        } 
 
         o = getupdated_by(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : updated_by can not be Empty"); 
        } 
 
         o = getupdated_date(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : updated_date can not be Empty"); 
        } 
 
         o = gettype(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : type can not be Empty"); 
        } 
 
        
    }
    public void save() throws CodeException {
        cache.remove(this);
        
        checkNotNullFields();
        
        if (!_isDirty_) {
            return ;
        }else if (getID()==NULLID) {
            saveNew();
        }else {
            DbBean db = DbBean.connect();
            ResultSet rs = db.update(TABLEPROCESS, PROPERTY_ID, id_);
            try {
                rs.next();
                saveFields(rs);
                rs.updateRow();
                rs.close();
                _isDirty_ = false;
            }catch (SQLException e) {
                throw new CodeException ("Error Saving Application " + e.getMessage());
            } finally {
                db.close();
            }
        }
        
    }
    
    public void saveNew() throws CodeException {
        checkNotNullFields();

        DbBean db = DbBean.connect();
        ResultSet rs = db.update(TABLEPROCESS, PROPERTY_ID, id_);
        try {
           rs.moveToInsertRow();
           saveFields(rs);
           rs.insertRow();
           rs = db.retrieveSQL("SELECT max(id) from payment_voucher ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Payment_voucher " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_PV_NUMBER , pv_number_ ); 
            rs.updateString(PROPERTY_CASHFLOW_NO , cashflow_no_ ); 
            rs.updateString(PROPERTY_PAYMENT_NUMBER , payment_number_ ); 
            rs.updateString(PROPERTY_TRANS_TYPE_ID , trans_type_id_ ); 
            rs.updateString(PROPERTY_SUPPLIER_ID , supplier_id_ ); 
            rs.updateString(PROPERTY_PV_CURRENCY , pv_currency_ ); 
            rs.updateString(PROPERTY_PV_AMOUNT , pv_amount_ ); 
            rs.updateString(PROPERTY_PV_AMOUNT_RUPIAH , pv_amount_rupiah_ ); 
            rs.updateString(PROPERTY_PV_FINAL_CURRENCY , pv_final_currency_ ); 
            rs.updateString(PROPERTY_PV_FINAL_AMOUNT , pv_final_amount_ ); 
            rs.updateString(PROPERTY_PV_FINAL_CURRENCY_RUPIAH , pv_final_currency_rupiah_ ); 
            rs.updateString(PROPERTY_PV_FINAL_AMOUNT_RUPIAH , pv_final_amount_rupiah_ ); 
            rs.updateString(PROPERTY_CONVERT_CURRENCY , convert_currency_ ); 
            rs.updateString(PROPERTY_CONVERT_AMOUNT , convert_amount_ ); 
            rs.updateString(PROPERTY_PPH_CURRENCY , pph_currency_ ); 
            rs.updateString(PROPERTY_PPH_AMOUNT , pph_amount_ ); 
            rs.updateString(PROPERTY_WITH_PPN , with_ppn_ ); 
            rs.updateString(PROPERTY_WITH_PPH , with_pph_ ); 
           if (getreceived_doc_date()==null) {
              rs.updateDate(PROPERTY_RECEIVED_DOC_DATE , null ); 
           }else{
              rs.updateDate(PROPERTY_RECEIVED_DOC_DATE , getreceived_doc_date()); 
           }
            rs.updateString(PROPERTY_TOP_ID , top_id_ ); 
           if (gettop_date()==null) {
              rs.updateDate(PROPERTY_TOP_DATE , null ); 
           }else{
              rs.updateDate(PROPERTY_TOP_DATE , gettop_date()); 
           }
            rs.updateString(PROPERTY_BANK_ID , bank_id_ ); 
            rs.updateString(PROPERTY_NOTE_FROM_ACCOUNTING , note_from_accounting_ ); 
            rs.updateString(PROPERTY_NOTE_NON_ACCOUNTING , note_non_accounting_ ); 
            rs.updateString(PROPERTY_PV_STATUS_ID , pv_status_id_ ); 
            rs.updateLong(PROPERTY_PV_TYPE_ID , pv_type_id_ ); 
            rs.updateLong(PROPERTY_INSERTED_BY , inserted_by_ ); 
            rs.updateString(PROPERTY_INSERTED_DATE , inserted_date_ ); 
            rs.updateLong(PROPERTY_UPDATED_BY , updated_by_ ); 
            rs.updateString(PROPERTY_UPDATED_DATE , updated_date_ ); 
            rs.updateString(PROPERTY_TYPE , type_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Payment_voucher obj = (Payment_voucher) jCob;
        id_ = obj.getID();

        
          pv_number_ = obj.getpv_number();
          cashflow_no_ = obj.getcashflow_no();
          payment_number_ = obj.getpayment_number();
          trans_type_id_ = obj.gettrans_type_id();
          supplier_id_ = obj.getsupplier_id();
          pv_currency_ = obj.getpv_currency();
          pv_amount_ = obj.getpv_amount();
          pv_amount_rupiah_ = obj.getpv_amount_rupiah();
          pv_final_currency_ = obj.getpv_final_currency();
          pv_final_amount_ = obj.getpv_final_amount();
          pv_final_currency_rupiah_ = obj.getpv_final_currency_rupiah();
          pv_final_amount_rupiah_ = obj.getpv_final_amount_rupiah();
          convert_currency_ = obj.getconvert_currency();
          convert_amount_ = obj.getconvert_amount();
          pph_currency_ = obj.getpph_currency();
          pph_amount_ = obj.getpph_amount();
          with_ppn_ = obj.getwith_ppn();
          with_pph_ = obj.getwith_pph();
          received_doc_date_ = obj.getreceived_doc_date();
          top_id_ = obj.gettop_id();
          top_date_ = obj.gettop_date();
          bank_id_ = obj.getbank_id();
          note_from_accounting_ = obj.getnote_from_accounting();
          note_non_accounting_ = obj.getnote_non_accounting();
          pv_status_id_ = obj.getpv_status_id();
          pv_type_id_ = obj.getpv_type_id();
          inserted_by_ = obj.getinserted_by();
          inserted_date_ = obj.getinserted_date();
          updated_by_ = obj.getupdated_by();
          updated_date_ = obj.getupdated_date();
          type_ = obj.gettype();
                
        _isDirty_ = false;
        _isLoaded_ = true;
    }
    
    public void delete() throws CodeException {
        cache.remove(this);
        DbBean db = DbBean.connect();
        db.delete(TABLEPROCESS, PROPERTY_ID, id_);
        resetID();
        db.close();
    }
    
    
    public void setID(long arg0) throws CodeException {
        id_ = arg0;
        _isLoaded_ = false;
    }

    public long getID() throws CodeException {
        return id_;
    }

    
      public void setpv_number(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_number_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_number() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_number_; 
      } 

      public void setcashflow_no(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cashflow_no_ = param; 
         _isDirty_ = true; 
      } 

      public String getcashflow_no() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cashflow_no_; 
      } 

      public void setpayment_number(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         payment_number_ = param; 
         _isDirty_ = true; 
      } 

      public String getpayment_number() throws CodeException {
         if (!_isLoaded_) { read();} 
         return payment_number_; 
      } 

      public void settrans_type_id(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         trans_type_id_ = param; 
         _isDirty_ = true; 
      } 

      public String gettrans_type_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return trans_type_id_; 
      } 

      public void setsupplier_id(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         supplier_id_ = param; 
         _isDirty_ = true; 
      } 

      public String getsupplier_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return supplier_id_; 
      } 

      public void setpv_currency(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_currency_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_currency() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_currency_; 
      } 

      public void setpv_amount(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_amount_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_amount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_amount_; 
      } 

      public void setpv_amount_rupiah(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_amount_rupiah_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_amount_rupiah() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_amount_rupiah_; 
      } 

      public void setpv_final_currency(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_final_currency_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_final_currency() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_final_currency_; 
      } 

      public void setpv_final_amount(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_final_amount_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_final_amount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_final_amount_; 
      } 

      public void setpv_final_currency_rupiah(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_final_currency_rupiah_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_final_currency_rupiah() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_final_currency_rupiah_; 
      } 

      public void setpv_final_amount_rupiah(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_final_amount_rupiah_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_final_amount_rupiah() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_final_amount_rupiah_; 
      } 

      public void setconvert_currency(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         convert_currency_ = param; 
         _isDirty_ = true; 
      } 

      public String getconvert_currency() throws CodeException {
         if (!_isLoaded_) { read();} 
         return convert_currency_; 
      } 

      public void setconvert_amount(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         convert_amount_ = param; 
         _isDirty_ = true; 
      } 

      public String getconvert_amount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return convert_amount_; 
      } 

      public void setpph_currency(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pph_currency_ = param; 
         _isDirty_ = true; 
      } 

      public String getpph_currency() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pph_currency_; 
      } 

      public void setpph_amount(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pph_amount_ = param; 
         _isDirty_ = true; 
      } 

      public String getpph_amount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pph_amount_; 
      } 

      public void setwith_ppn(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         with_ppn_ = param; 
         _isDirty_ = true; 
      } 

      public String getwith_ppn() throws CodeException {
         if (!_isLoaded_) { read();} 
         return with_ppn_; 
      } 

      public void setwith_pph(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         with_pph_ = param; 
         _isDirty_ = true; 
      } 

      public String getwith_pph() throws CodeException {
         if (!_isLoaded_) { read();} 
         return with_pph_; 
      } 

      public void setreceived_doc_date(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         received_doc_date_ = param; 
         _isDirty_ = true; 
      } 

      public Date getreceived_doc_date() throws CodeException {
         if (!_isLoaded_) { read();} 
         return received_doc_date_; 
      } 

      public void settop_id(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         top_id_ = param; 
         _isDirty_ = true; 
      } 

      public String gettop_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return top_id_; 
      } 

      public void settop_date(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         top_date_ = param; 
         _isDirty_ = true; 
      } 

      public Date gettop_date() throws CodeException {
         if (!_isLoaded_) { read();} 
         return top_date_; 
      } 

      public void setbank_id(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bank_id_ = param; 
         _isDirty_ = true; 
      } 

      public String getbank_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bank_id_; 
      } 

      public void setnote_from_accounting(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         note_from_accounting_ = param; 
         _isDirty_ = true; 
      } 

      public String getnote_from_accounting() throws CodeException {
         if (!_isLoaded_) { read();} 
         return note_from_accounting_; 
      } 

      public void setnote_non_accounting(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         note_non_accounting_ = param; 
         _isDirty_ = true; 
      } 

      public String getnote_non_accounting() throws CodeException {
         if (!_isLoaded_) { read();} 
         return note_non_accounting_; 
      } 

      public void setpv_status_id(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_status_id_ = param; 
         _isDirty_ = true; 
      } 

      public String getpv_status_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_status_id_; 
      } 

      public void setpv_type_id(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pv_type_id_ = param; 
         _isDirty_ = true; 
      } 

      public long getpv_type_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pv_type_id_; 
      } 

      public void setinserted_by(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         inserted_by_ = param; 
         _isDirty_ = true; 
      } 

      public long getinserted_by() throws CodeException {
         if (!_isLoaded_) { read();} 
         return inserted_by_; 
      } 

      public void setinserted_date(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         inserted_date_ = param; 
         _isDirty_ = true; 
      } 

      public String getinserted_date() throws CodeException {
         if (!_isLoaded_) { read();} 
         return inserted_date_; 
      } 

      public void setupdated_by(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         updated_by_ = param; 
         _isDirty_ = true; 
      } 

      public long getupdated_by() throws CodeException {
         if (!_isLoaded_) { read();} 
         return updated_by_; 
      } 

      public void setupdated_date(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         updated_date_ = param; 
         _isDirty_ = true; 
      } 

      public String getupdated_date() throws CodeException {
         if (!_isLoaded_) { read();} 
         return updated_date_; 
      } 

      public void settype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         type_ = param; 
         _isDirty_ = true; 
      } 

      public String gettype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return type_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_PV_NUMBER)) return getpv_number(); 
           else if (param.equals(PROPERTY_CASHFLOW_NO)) return getcashflow_no(); 
           else if (param.equals(PROPERTY_PAYMENT_NUMBER)) return getpayment_number(); 
           else if (param.equals(PROPERTY_TRANS_TYPE_ID)) return gettrans_type_id(); 
           else if (param.equals(PROPERTY_SUPPLIER_ID)) return getsupplier_id(); 
           else if (param.equals(PROPERTY_PV_CURRENCY)) return getpv_currency(); 
           else if (param.equals(PROPERTY_PV_AMOUNT)) return getpv_amount(); 
           else if (param.equals(PROPERTY_PV_AMOUNT_RUPIAH)) return getpv_amount_rupiah(); 
           else if (param.equals(PROPERTY_PV_FINAL_CURRENCY)) return getpv_final_currency(); 
           else if (param.equals(PROPERTY_PV_FINAL_AMOUNT)) return getpv_final_amount(); 
           else if (param.equals(PROPERTY_PV_FINAL_CURRENCY_RUPIAH)) return getpv_final_currency_rupiah(); 
           else if (param.equals(PROPERTY_PV_FINAL_AMOUNT_RUPIAH)) return getpv_final_amount_rupiah(); 
           else if (param.equals(PROPERTY_CONVERT_CURRENCY)) return getconvert_currency(); 
           else if (param.equals(PROPERTY_CONVERT_AMOUNT)) return getconvert_amount(); 
           else if (param.equals(PROPERTY_PPH_CURRENCY)) return getpph_currency(); 
           else if (param.equals(PROPERTY_PPH_AMOUNT)) return getpph_amount(); 
           else if (param.equals(PROPERTY_WITH_PPN)) return getwith_ppn(); 
           else if (param.equals(PROPERTY_WITH_PPH)) return getwith_pph(); 
           else if (param.equals(PROPERTY_RECEIVED_DOC_DATE)) return getreceived_doc_date()  == null ? "" :dateformat.format(getreceived_doc_date()); 
           else if (param.equals(PROPERTY_TOP_ID)) return gettop_id(); 
           else if (param.equals(PROPERTY_TOP_DATE)) return gettop_date()  == null ? "" :dateformat.format(gettop_date()); 
           else if (param.equals(PROPERTY_BANK_ID)) return getbank_id(); 
           else if (param.equals(PROPERTY_NOTE_FROM_ACCOUNTING)) return getnote_from_accounting(); 
           else if (param.equals(PROPERTY_NOTE_NON_ACCOUNTING)) return getnote_non_accounting(); 
           else if (param.equals(PROPERTY_PV_STATUS_ID)) return getpv_status_id(); 
           else if (param.equals(PROPERTY_PV_TYPE_ID)) return String.valueOf(getpv_type_id()); 
           else if (param.equals(PROPERTY_INSERTED_BY)) return String.valueOf(getinserted_by()); 
           else if (param.equals(PROPERTY_INSERTED_DATE)) return getinserted_date(); 
           else if (param.equals(PROPERTY_UPDATED_BY)) return String.valueOf(getupdated_by()); 
           else if (param.equals(PROPERTY_UPDATED_DATE)) return getupdated_date(); 
           else if (param.equals(PROPERTY_TYPE)) return gettype(); 
       
        
        return "";
    
    }

    public void fromString(String param, String value) throws CodeException {
        if (param.equals(PROPERTY_ID)) {
            long newVal;
            try {
                newVal = (long) Double.parseDouble(value);
                setID(newVal);
            }catch (NumberFormatException nfe) {
                throw new CodeException("Unrecognized Number Format " + nfe.getMessage() );
            }
        }
        
           else if (param.equals(PROPERTY_PV_NUMBER))  setpv_number(value); 
           else if (param.equals(PROPERTY_CASHFLOW_NO))  setcashflow_no(value); 
           else if (param.equals(PROPERTY_PAYMENT_NUMBER))  setpayment_number(value); 
           else if (param.equals(PROPERTY_TRANS_TYPE_ID))  settrans_type_id(value); 
           else if (param.equals(PROPERTY_SUPPLIER_ID))  setsupplier_id(value); 
           else if (param.equals(PROPERTY_PV_CURRENCY))  setpv_currency(value); 
           else if (param.equals(PROPERTY_PV_AMOUNT))  setpv_amount(value); 
           else if (param.equals(PROPERTY_PV_AMOUNT_RUPIAH))  setpv_amount_rupiah(value); 
           else if (param.equals(PROPERTY_PV_FINAL_CURRENCY))  setpv_final_currency(value); 
           else if (param.equals(PROPERTY_PV_FINAL_AMOUNT))  setpv_final_amount(value); 
           else if (param.equals(PROPERTY_PV_FINAL_CURRENCY_RUPIAH))  setpv_final_currency_rupiah(value); 
           else if (param.equals(PROPERTY_PV_FINAL_AMOUNT_RUPIAH))  setpv_final_amount_rupiah(value); 
           else if (param.equals(PROPERTY_CONVERT_CURRENCY))  setconvert_currency(value); 
           else if (param.equals(PROPERTY_CONVERT_AMOUNT))  setconvert_amount(value); 
           else if (param.equals(PROPERTY_PPH_CURRENCY))  setpph_currency(value); 
           else if (param.equals(PROPERTY_PPH_AMOUNT))  setpph_amount(value); 
           else if (param.equals(PROPERTY_WITH_PPN))  setwith_ppn(value); 
           else if (param.equals(PROPERTY_WITH_PPH))  setwith_pph(value); 
           else if (param.equals(PROPERTY_RECEIVED_DOC_DATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setreceived_doc_date(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setreceived_doc_date(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_TOP_ID))  settop_id(value); 
           else if (param.equals(PROPERTY_TOP_DATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       settop_date(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             settop_date(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_BANK_ID))  setbank_id(value); 
           else if (param.equals(PROPERTY_NOTE_FROM_ACCOUNTING))  setnote_from_accounting(value); 
           else if (param.equals(PROPERTY_NOTE_NON_ACCOUNTING))  setnote_non_accounting(value); 
           else if (param.equals(PROPERTY_PV_STATUS_ID))  setpv_status_id(value); 
           else if (param.equals(PROPERTY_PV_TYPE_ID)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setpv_type_id(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INSERTED_BY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setinserted_by(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INSERTED_DATE))  setinserted_date(value); 
           else if (param.equals(PROPERTY_UPDATED_BY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setupdated_by(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_UPDATED_DATE))  setupdated_date(value); 
           else if (param.equals(PROPERTY_TYPE))  settype(value); 
    }


    public void resetID() throws CodeException {
        if (!_isLoaded_) {
            read();
        }
        id_= NULLID;
        _isDirty_ = true;
    }

    public String[] getSecurityTokens() throws CodeException {
        String[] token = new String[1];
        return token;
    }

    public void moveFirst() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveFirst(TABLEPROCESS, PRIMARYKEY);
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
            throw new CodeException("Payment_voucher : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, PROPERTY_PV_NUMBER+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Payment_voucher : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, PROPERTY_PV_NUMBER+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Payment_voucher : Cannot Move Next " + ex.getMessage());
       }
    }
    

    public void moveLast() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveLast(TABLEPROCESS, PRIMARYKEY);
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Payment_voucher : Cannot Move Last " + ex.getMessage());
       }
    }

    public String getClassName() {
        return CLASSNAME;
    }

    public String getTable() {
        return TABLEPROCESS;
    }

    public boolean importCsv() {
        try {
            DbBean db = DbBean.connect();
            db.importFromCsv(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean exportCsv() {
        try {
            DbBean db = DbBean.connect();
            db.exportToCSV(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean importText(){
        try {
            DbBean db = DbBean.connect();
            db.importFromText(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean exportText() {
        try {
            DbBean db = DbBean.connect();
            db.exportToTextTabDelimited(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



