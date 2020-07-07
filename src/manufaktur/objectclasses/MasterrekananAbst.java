/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manufaktur.objectclasses;


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


public abstract class MasterrekananAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Masterrekanan";

    public static final String TABLE = "manufaktur.masterrekanan";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_KODEREKANAN = "KodeRekanan";
    public static final String PROPERTY_KODEREKANANACC = "KodeRekananAcc";
    public static final String PROPERTY_NAMAREKANAN = "NamaRekanan";
    public static final String PROPERTY_ALAMATREKANAN = "AlamatRekanan";
    public static final String PROPERTY_ALAMATPENGIRIMAN = "AlamatPengiriman";
    public static final String PROPERTY_NOMORNPWP = "NomorNPWP";
    public static final String PROPERTY_NOMORNPWPACC = "NomorNPWPAcc";
    public static final String PROPERTY_PAJAK = "Pajak";
    public static final String PROPERTY_JATUHTEMPO = "JatuhTempo";
    public static final String PROPERTY_PROSENDP = "ProsenDP";
    public static final String PROPERTY_NOMORTELPON = "NomorTelpon";
    public static final String PROPERTY_NOMORFAX = "NomorFax";
    public static final String PROPERTY_CONTACTPERSON = "ContactPerson";
    public static final String PROPERTY_EMAIL = "Email";
    public static final String PROPERTY_KODEHUTANG = "KodeHutang";
    public static final String PROPERTY_KODEFAKTUR = "KodeFaktur";
    public static final String PROPERTY_EXTERNAL = "External";
    public static final String PROPERTY_SALES = "Sales";
    public static final String PROPERTY_SUPPLIER = "Supplier";
    public static final String PROPERTY_GUDANGMB = "GudangMB";
    public static final String PROPERTY_PIF = "Pif";
    public static final String PROPERTY_STATUSHARGAPERIODIK = "statushargaperiodik";
    public static final String PROPERTY_CLOSEORDER = "CloseOrder";
    public static final String PROPERTY_GABUNGMAKLON = "GabungMaklon";
    public static final String PROPERTY_DP_STS = "dp_sts";
    public static final String PROPERTY_UMURKWITANSI = "UmurKwitansi";
    public static final String PROPERTY_TANGGALENTRY = "TanggalEntry";
    public static final String PROPERTY_TANGGALUPDATE = "TanggalUpdate";
    public static final String PROPERTY_USERID = "UserId";
    public static final String PROPERTY_SESSIONID = "SessionId";
    
     public static final String PRIMARYKEY = PROPERTY_KODEREKANAN;
    
    
    private long id_;
    private String KodeRekanan_;
    private String KodeRekananAcc_;
    private String NamaRekanan_;
    private String AlamatRekanan_;
    private String AlamatPengiriman_;
    private String NomorNPWP_;
    private String NomorNPWPAcc_;
    private long Pajak_;
    private long JatuhTempo_;
    private double ProsenDP_;
    private String NomorTelpon_;
    private String NomorFax_;
    private String ContactPerson_;
    private String Email_;
    private String KodeHutang_;
    private String KodeFaktur_;
    private long External_;
    private long Sales_;
    private long Supplier_;
    private long GudangMB_;
    private long Pif_;
    private String statushargaperiodik_;
    private String CloseOrder_;
    private String GabungMaklon_;
    private String dp_sts_;
    private long UmurKwitansi_;
    private Timestamp TanggalEntry_;
    private Timestamp TanggalUpdate_;
    private String UserId_;
    private String SessionId_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public MasterrekananAbst() throws CodeException {
        loadNew();
    }
    
    public MasterrekananAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public MasterrekananAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public MasterrekananAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public MasterrekananAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create MasterrekananAbst for Key : " + key + " val : " + val);
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
            
            
            
           KodeRekanan_ = rs.getString(PROPERTY_KODEREKANAN); 
           KodeRekananAcc_ = rs.getString(PROPERTY_KODEREKANANACC); 
           NamaRekanan_ = rs.getString(PROPERTY_NAMAREKANAN); 
           AlamatRekanan_ = rs.getString(PROPERTY_ALAMATREKANAN); 
           AlamatPengiriman_ = rs.getString(PROPERTY_ALAMATPENGIRIMAN); 
           NomorNPWP_ = rs.getString(PROPERTY_NOMORNPWP); 
           NomorNPWPAcc_ = rs.getString(PROPERTY_NOMORNPWPACC); 
           Pajak_ = rs.getLong(PROPERTY_PAJAK); 
           JatuhTempo_ = rs.getLong(PROPERTY_JATUHTEMPO); 
           ProsenDP_ = rs.getDouble(PROPERTY_PROSENDP); 
           NomorTelpon_ = rs.getString(PROPERTY_NOMORTELPON); 
           NomorFax_ = rs.getString(PROPERTY_NOMORFAX); 
           ContactPerson_ = rs.getString(PROPERTY_CONTACTPERSON); 
           Email_ = rs.getString(PROPERTY_EMAIL); 
           KodeHutang_ = rs.getString(PROPERTY_KODEHUTANG); 
           KodeFaktur_ = rs.getString(PROPERTY_KODEFAKTUR); 
           External_ = rs.getLong(PROPERTY_EXTERNAL); 
           Sales_ = rs.getLong(PROPERTY_SALES); 
           Supplier_ = rs.getLong(PROPERTY_SUPPLIER); 
           GudangMB_ = rs.getLong(PROPERTY_GUDANGMB); 
           Pif_ = rs.getLong(PROPERTY_PIF); 
           statushargaperiodik_ = rs.getString(PROPERTY_STATUSHARGAPERIODIK); 
           CloseOrder_ = rs.getString(PROPERTY_CLOSEORDER); 
           GabungMaklon_ = rs.getString(PROPERTY_GABUNGMAKLON); 
           dp_sts_ = rs.getString(PROPERTY_DP_STS); 
           UmurKwitansi_ = rs.getLong(PROPERTY_UMURKWITANSI); 
           TanggalEntry_ = rs.getTimestamp(PROPERTY_TANGGALENTRY); 
           TanggalUpdate_ = rs.getTimestamp(PROPERTY_TANGGALUPDATE); 
           UserId_ = rs.getString(PROPERTY_USERID); 
           SessionId_ = rs.getString(PROPERTY_SESSIONID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading MasterrekananAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Masterrekanan obj = (Masterrekanan)cache.get(getID());
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
                    throw new CodeException("Error Reading Masterrekanan " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getKodeRekanan(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : KodeRekanan can not be Empty"); 
        } 
 
         o = getdp_sts(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : dp_sts can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from masterrekanan ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Masterrekanan " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_KODEREKANAN , KodeRekanan_ ); 
            rs.updateString(PROPERTY_KODEREKANANACC , KodeRekananAcc_ ); 
            rs.updateString(PROPERTY_NAMAREKANAN , NamaRekanan_ ); 
            rs.updateString(PROPERTY_ALAMATREKANAN , AlamatRekanan_ ); 
            rs.updateString(PROPERTY_ALAMATPENGIRIMAN , AlamatPengiriman_ ); 
            rs.updateString(PROPERTY_NOMORNPWP , NomorNPWP_ ); 
            rs.updateString(PROPERTY_NOMORNPWPACC , NomorNPWPAcc_ ); 
            rs.updateLong(PROPERTY_PAJAK , Pajak_ ); 
            rs.updateLong(PROPERTY_JATUHTEMPO , JatuhTempo_ ); 
            rs.updateDouble(PROPERTY_PROSENDP , ProsenDP_ ); 
            rs.updateString(PROPERTY_NOMORTELPON , NomorTelpon_ ); 
            rs.updateString(PROPERTY_NOMORFAX , NomorFax_ ); 
            rs.updateString(PROPERTY_CONTACTPERSON , ContactPerson_ ); 
            rs.updateString(PROPERTY_EMAIL , Email_ ); 
            rs.updateString(PROPERTY_KODEHUTANG , KodeHutang_ ); 
            rs.updateString(PROPERTY_KODEFAKTUR , KodeFaktur_ ); 
            rs.updateLong(PROPERTY_EXTERNAL , External_ ); 
            rs.updateLong(PROPERTY_SALES , Sales_ ); 
            rs.updateLong(PROPERTY_SUPPLIER , Supplier_ ); 
            rs.updateLong(PROPERTY_GUDANGMB , GudangMB_ ); 
            rs.updateLong(PROPERTY_PIF , Pif_ ); 
            rs.updateString(PROPERTY_STATUSHARGAPERIODIK , statushargaperiodik_ ); 
            rs.updateString(PROPERTY_CLOSEORDER , CloseOrder_ ); 
            rs.updateString(PROPERTY_GABUNGMAKLON , GabungMaklon_ ); 
            rs.updateString(PROPERTY_DP_STS , dp_sts_ ); 
            rs.updateLong(PROPERTY_UMURKWITANSI , UmurKwitansi_ ); 
            if (getTanggalEntry()==null) {
               rs.updateTimestamp(PROPERTY_TANGGALENTRY ,   null ); 
            }else{
               rs.updateTimestamp(PROPERTY_TANGGALENTRY ,  getTanggalEntry()); 
            }
            if (getTanggalUpdate()==null) {
               rs.updateTimestamp(PROPERTY_TANGGALUPDATE ,   null ); 
            }else{
               rs.updateTimestamp(PROPERTY_TANGGALUPDATE ,  getTanggalUpdate()); 
            }
            rs.updateString(PROPERTY_USERID , UserId_ ); 
            rs.updateString(PROPERTY_SESSIONID , SessionId_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Masterrekanan obj = (Masterrekanan) jCob;
        id_ = obj.getID();

        
          KodeRekanan_ = obj.getKodeRekanan();
          KodeRekananAcc_ = obj.getKodeRekananAcc();
          NamaRekanan_ = obj.getNamaRekanan();
          AlamatRekanan_ = obj.getAlamatRekanan();
          AlamatPengiriman_ = obj.getAlamatPengiriman();
          NomorNPWP_ = obj.getNomorNPWP();
          NomorNPWPAcc_ = obj.getNomorNPWPAcc();
          Pajak_ = obj.getPajak();
          JatuhTempo_ = obj.getJatuhTempo();
          ProsenDP_ = obj.getProsenDP();
          NomorTelpon_ = obj.getNomorTelpon();
          NomorFax_ = obj.getNomorFax();
          ContactPerson_ = obj.getContactPerson();
          Email_ = obj.getEmail();
          KodeHutang_ = obj.getKodeHutang();
          KodeFaktur_ = obj.getKodeFaktur();
          External_ = obj.getExternal();
          Sales_ = obj.getSales();
          Supplier_ = obj.getSupplier();
          GudangMB_ = obj.getGudangMB();
          Pif_ = obj.getPif();
          statushargaperiodik_ = obj.getstatushargaperiodik();
          CloseOrder_ = obj.getCloseOrder();
          GabungMaklon_ = obj.getGabungMaklon();
          dp_sts_ = obj.getdp_sts();
          UmurKwitansi_ = obj.getUmurKwitansi();
          TanggalEntry_ = obj.getTanggalEntry();
          TanggalUpdate_ = obj.getTanggalUpdate();
          UserId_ = obj.getUserId();
          SessionId_ = obj.getSessionId();
                
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

    
      public void setKodeRekanan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeRekanan_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeRekanan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeRekanan_; 
      } 

      public void setKodeRekananAcc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeRekananAcc_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeRekananAcc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeRekananAcc_; 
      } 

      public void setNamaRekanan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaRekanan_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaRekanan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaRekanan_; 
      } 

      public void setAlamatRekanan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         AlamatRekanan_ = param; 
         _isDirty_ = true; 
      } 

      public String getAlamatRekanan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return AlamatRekanan_; 
      } 

      public void setAlamatPengiriman(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         AlamatPengiriman_ = param; 
         _isDirty_ = true; 
      } 

      public String getAlamatPengiriman() throws CodeException {
         if (!_isLoaded_) { read();} 
         return AlamatPengiriman_; 
      } 

      public void setNomorNPWP(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorNPWP_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorNPWP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorNPWP_; 
      } 

      public void setNomorNPWPAcc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorNPWPAcc_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorNPWPAcc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorNPWPAcc_; 
      } 

      public void setPajak(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Pajak_ = param; 
         _isDirty_ = true; 
      } 

      public long getPajak() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Pajak_; 
      } 

      public void setJatuhTempo(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         JatuhTempo_ = param; 
         _isDirty_ = true; 
      } 

      public long getJatuhTempo() throws CodeException {
         if (!_isLoaded_) { read();} 
         return JatuhTempo_; 
      } 

      public void setProsenDP(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ProsenDP_ = param; 
         _isDirty_ = true; 
      } 

      public double getProsenDP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ProsenDP_; 
      } 

      public void setNomorTelpon(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorTelpon_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorTelpon() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorTelpon_; 
      } 

      public void setNomorFax(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorFax_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorFax() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorFax_; 
      } 

      public void setContactPerson(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ContactPerson_ = param; 
         _isDirty_ = true; 
      } 

      public String getContactPerson() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ContactPerson_; 
      } 

      public void setEmail(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Email_ = param; 
         _isDirty_ = true; 
      } 

      public String getEmail() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Email_; 
      } 

      public void setKodeHutang(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeHutang_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeHutang() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeHutang_; 
      } 

      public void setKodeFaktur(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeFaktur_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeFaktur() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeFaktur_; 
      } 

      public void setExternal(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         External_ = param; 
         _isDirty_ = true; 
      } 

      public long getExternal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return External_; 
      } 

      public void setSales(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Sales_ = param; 
         _isDirty_ = true; 
      } 

      public long getSales() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Sales_; 
      } 

      public void setSupplier(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Supplier_ = param; 
         _isDirty_ = true; 
      } 

      public long getSupplier() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Supplier_; 
      } 

      public void setGudangMB(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         GudangMB_ = param; 
         _isDirty_ = true; 
      } 

      public long getGudangMB() throws CodeException {
         if (!_isLoaded_) { read();} 
         return GudangMB_; 
      } 

      public void setPif(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Pif_ = param; 
         _isDirty_ = true; 
      } 

      public long getPif() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Pif_; 
      } 

      public void setstatushargaperiodik(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         statushargaperiodik_ = param; 
         _isDirty_ = true; 
      } 

      public String getstatushargaperiodik() throws CodeException {
         if (!_isLoaded_) { read();} 
         return statushargaperiodik_; 
      } 

      public void setCloseOrder(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         CloseOrder_ = param; 
         _isDirty_ = true; 
      } 

      public String getCloseOrder() throws CodeException {
         if (!_isLoaded_) { read();} 
         return CloseOrder_; 
      } 

      public void setGabungMaklon(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         GabungMaklon_ = param; 
         _isDirty_ = true; 
      } 

      public String getGabungMaklon() throws CodeException {
         if (!_isLoaded_) { read();} 
         return GabungMaklon_; 
      } 

      public void setdp_sts(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dp_sts_ = param; 
         _isDirty_ = true; 
      } 

      public String getdp_sts() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dp_sts_; 
      } 

      public void setUmurKwitansi(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         UmurKwitansi_ = param; 
         _isDirty_ = true; 
      } 

      public long getUmurKwitansi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return UmurKwitansi_; 
      } 

      public void setTanggalEntry(Timestamp param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalEntry_ = param; 
         _isDirty_ = true; 
      } 

      public Timestamp getTanggalEntry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalEntry_; 
      } 

      public void setTanggalUpdate(Timestamp param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalUpdate_ = param; 
         _isDirty_ = true; 
      } 

      public Timestamp getTanggalUpdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalUpdate_; 
      } 

      public void setUserId(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         UserId_ = param; 
         _isDirty_ = true; 
      } 

      public String getUserId() throws CodeException {
         if (!_isLoaded_) { read();} 
         return UserId_; 
      } 

      public void setSessionId(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         SessionId_ = param; 
         _isDirty_ = true; 
      } 

      public String getSessionId() throws CodeException {
         if (!_isLoaded_) { read();} 
         return SessionId_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_KODEREKANAN)) return getKodeRekanan(); 
           else if (param.equals(PROPERTY_KODEREKANANACC)) return getKodeRekananAcc(); 
           else if (param.equals(PROPERTY_NAMAREKANAN)) return getNamaRekanan(); 
           else if (param.equals(PROPERTY_ALAMATREKANAN)) return getAlamatRekanan(); 
           else if (param.equals(PROPERTY_ALAMATPENGIRIMAN)) return getAlamatPengiriman(); 
           else if (param.equals(PROPERTY_NOMORNPWP)) return getNomorNPWP(); 
           else if (param.equals(PROPERTY_NOMORNPWPACC)) return getNomorNPWPAcc(); 
           else if (param.equals(PROPERTY_PAJAK)) return String.valueOf(getPajak()); 
           else if (param.equals(PROPERTY_JATUHTEMPO)) return String.valueOf(getJatuhTempo()); 
           else if (param.equals(PROPERTY_PROSENDP)) return decform.format(getProsenDP()); 
           else if (param.equals(PROPERTY_NOMORTELPON)) return getNomorTelpon(); 
           else if (param.equals(PROPERTY_NOMORFAX)) return getNomorFax(); 
           else if (param.equals(PROPERTY_CONTACTPERSON)) return getContactPerson(); 
           else if (param.equals(PROPERTY_EMAIL)) return getEmail(); 
           else if (param.equals(PROPERTY_KODEHUTANG)) return getKodeHutang(); 
           else if (param.equals(PROPERTY_KODEFAKTUR)) return getKodeFaktur(); 
           else if (param.equals(PROPERTY_EXTERNAL)) return String.valueOf(getExternal()); 
           else if (param.equals(PROPERTY_SALES)) return String.valueOf(getSales()); 
           else if (param.equals(PROPERTY_SUPPLIER)) return String.valueOf(getSupplier()); 
           else if (param.equals(PROPERTY_GUDANGMB)) return String.valueOf(getGudangMB()); 
           else if (param.equals(PROPERTY_PIF)) return String.valueOf(getPif()); 
           else if (param.equals(PROPERTY_STATUSHARGAPERIODIK)) return getstatushargaperiodik(); 
           else if (param.equals(PROPERTY_CLOSEORDER)) return getCloseOrder(); 
           else if (param.equals(PROPERTY_GABUNGMAKLON)) return getGabungMaklon(); 
           else if (param.equals(PROPERTY_DP_STS)) return getdp_sts(); 
           else if (param.equals(PROPERTY_UMURKWITANSI)) return String.valueOf(getUmurKwitansi()); 
           else if (param.equals(PROPERTY_TANGGALENTRY)) return getTanggalEntry()  == null || getTanggalEntry().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalEntry()) ; 
           else if (param.equals(PROPERTY_TANGGALUPDATE)) return getTanggalUpdate()  == null || getTanggalUpdate().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalUpdate()) ; 
           else if (param.equals(PROPERTY_USERID)) return getUserId(); 
           else if (param.equals(PROPERTY_SESSIONID)) return getSessionId(); 
       
        
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
        
           else if (param.equals(PROPERTY_KODEREKANAN))  setKodeRekanan(value); 
           else if (param.equals(PROPERTY_KODEREKANANACC))  setKodeRekananAcc(value); 
           else if (param.equals(PROPERTY_NAMAREKANAN))  setNamaRekanan(value); 
           else if (param.equals(PROPERTY_ALAMATREKANAN))  setAlamatRekanan(value); 
           else if (param.equals(PROPERTY_ALAMATPENGIRIMAN))  setAlamatPengiriman(value); 
           else if (param.equals(PROPERTY_NOMORNPWP))  setNomorNPWP(value); 
           else if (param.equals(PROPERTY_NOMORNPWPACC))  setNomorNPWPAcc(value); 
           else if (param.equals(PROPERTY_PAJAK)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setPajak(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_JATUHTEMPO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setJatuhTempo(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PROSENDP)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setProsenDP(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NOMORTELPON))  setNomorTelpon(value); 
           else if (param.equals(PROPERTY_NOMORFAX))  setNomorFax(value); 
           else if (param.equals(PROPERTY_CONTACTPERSON))  setContactPerson(value); 
           else if (param.equals(PROPERTY_EMAIL))  setEmail(value); 
           else if (param.equals(PROPERTY_KODEHUTANG))  setKodeHutang(value); 
           else if (param.equals(PROPERTY_KODEFAKTUR))  setKodeFaktur(value); 
           else if (param.equals(PROPERTY_EXTERNAL)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setExternal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SALES)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setSales(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SUPPLIER)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setSupplier(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_GUDANGMB)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setGudangMB(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PIF)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setPif(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_STATUSHARGAPERIODIK))  setstatushargaperiodik(value); 
           else if (param.equals(PROPERTY_CLOSEORDER))  setCloseOrder(value); 
           else if (param.equals(PROPERTY_GABUNGMAKLON))  setGabungMaklon(value); 
           else if (param.equals(PROPERTY_DP_STS))  setdp_sts(value); 
           else if (param.equals(PROPERTY_UMURKWITANSI)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setUmurKwitansi(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TANGGALENTRY)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalEntry(null); 
                   else { 
                        try{ 
                             java.util.Date d = datetimeformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             String time = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds() + ".0"; 
                             setTanggalEntry(Timestamp.valueOf(date + " " + time)); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_TANGGALUPDATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalUpdate(null); 
                   else { 
                        try{ 
                             java.util.Date d = datetimeformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             String time = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds() + ".0"; 
                             setTanggalUpdate(Timestamp.valueOf(date + " " + time)); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_USERID))  setUserId(value); 
           else if (param.equals(PROPERTY_SESSIONID))  setSessionId(value); 
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
            throw new CodeException("Masterrekanan : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, KodeRekanan_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Masterrekanan : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, KodeRekanan_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Masterrekanan : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Masterrekanan : Cannot Move Last " + ex.getMessage());
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



