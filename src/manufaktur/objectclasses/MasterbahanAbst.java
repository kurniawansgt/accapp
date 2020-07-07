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


public abstract class MasterbahanAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Masterbahan";

    public static final String TABLE = "manufaktur.masterbahan";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_AKTIF = "Aktif";
    public static final String PROPERTY_KODEBAHAN = "KodeBahan";
    public static final String PROPERTY_KODEBAHANLAIN = "KodeBahanLain";
    public static final String PROPERTY_PERUNTUKAN = "Peruntukan";
    public static final String PROPERTY_KODESUBBAHAN = "KodeSubBahan";
    public static final String PROPERTY_NAMABAHAN = "NamaBahan";
    public static final String PROPERTY_NAMAASLI = "NamaAsli";
    public static final String PROPERTY_KODEPRODUK = "KodeProduk";
    public static final String PROPERTY_KODEJENISBAHAN = "KodeJenisBahan";
    public static final String PROPERTY_KODEBRAND = "KodeBrand";
    public static final String PROPERTY_SATUAN = "Satuan";
    public static final String PROPERTY_SPESIFIKASIBAHAN = "SpesifikasiBahan";
    public static final String PROPERTY_STATUSTEMP = "StatusTemp";
    public static final String PROPERTY_PARETO = "Pareto";
    public static final String PROPERTY_STATUS = "Status";
    public static final String PROPERTY_STATUSLAMA = "StatusLama";
    public static final String PROPERTY_POSISI = "Posisi";
    public static final String PROPERTY_BUFFER = "Buffer";
    public static final String PROPERTY_HARGASTANDARDBULK = "HargaStandardBulk";
    public static final String PROPERTY_HARGASTANDARD = "HargaStandard";
    public static final String PROPERTY_HARGAACTUAL = "HargaActual";
    public static final String PROPERTY_FAKTOR = "Faktor";
    public static final String PROPERTY_HARGAJUAL = "HargaJual";
    public static final String PROPERTY_LEAD = "Lead";
    public static final String PROPERTY_TRADENAME = "TradeName";
    public static final String PROPERTY_INCINAME = "InciName";
    public static final String PROPERTY_FUNCTION = "Function";
    public static final String PROPERTY_KETERANGAN = "Keterangan";
    public static final String PROPERTY_LOKASI = "Lokasi";
    public static final String PROPERTY_LINK = "Link";
    public static final String PROPERTY_IDFILE = "IdFile";
    public static final String PROPERTY_MINIMAL = "Minimal";
    public static final String PROPERTY_PERSENMCKEMAS = "PersenMcKemas";
    public static final String PROPERTY_SERTIFIKATHALAL = "SertifikatHalal";
    public static final String PROPERTY_STATUSHALAL = "StatusHalal";
    public static final String PROPERTY_TANGGALHALAL = "TanggalHalal";
    public static final String PROPERTY_MASABERLAKUHALAL = "MasaBerlakuHalal";
    public static final String PROPERTY_TANGGALAKHIRSTFHALAL = "TanggalAkhirStfHalal";
    public static final String PROPERTY_NOMORHALAL = "NomorHalal";
    public static final String PROPERTY_PENERBITHALAL = "PenerbitHalal";
    public static final String PROPERTY_STATUSSENSITIVITAS = "StatusSensitivitas";
    public static final String PROPERTY_KLASIFIKASIBAHAN = "KlasifikasiBahan";
    public static final String PROPERTY_TANGGALENTRY = "TanggalEntry";
    public static final String PROPERTY_TANGGALUPDATE = "TanggalUpdate";
    public static final String PROPERTY_USERID = "UserId";
    public static final String PROPERTY_PKB = "PKB";
    public static final String PROPERTY_MSTBB021_S = "MSTBB021_S";
    public static final String PROPERTY_MSTBB01_SP = "MSTBB01_SP";
    public static final String PROPERTY_SPECIFICATIONPIF = "SpecificationPif";
    public static final String PROPERTY_SAFETYDATA = "SafetyData";
    public static final String PROPERTY_IFRA = "Ifra";
    public static final String PROPERTY_REGULATION = "Regulation";
    public static final String PROPERTY_NOAEL = "Noael";
    public static final String PROPERTY_LDORAL = "LdOral";
    public static final String PROPERTY_LDDERMAL = "LdDermal";
    public static final String PROPERTY_SENSITIZATION = "Sensitization";
    public static final String PROPERTY_IRRITATIONDERMAL = "IrritationDermal";
    public static final String PROPERTY_IRRITATIONOCULAR = "IrritationOcular";
    public static final String PROPERTY_HUMANPATCH = "HumanPatch";
    public static final String PROPERTY_LABELLEDWITH = "LabelledWith";
    public static final String PROPERTY_OTHERS = "Others";
    public static final String PROPERTY_MANUFACTUR = "Manufactur";
    public static final String PROPERTY_NOMORLUP = "NomorLUP";
    public static final String PROPERTY_SESSIONID = "SessionId";
    
     public static final String PRIMARYKEY = PROPERTY_PERUNTUKAN;
    
    
    private long id_;
    private long Aktif_;
    private String KodeBahan_;
    private String KodeBahanLain_;
    private String Peruntukan_;
    private String KodeSubBahan_;
    private String NamaBahan_;
    private String NamaAsli_;
    private String KodeProduk_;
    private String KodeJenisBahan_;
    private String KodeBrand_;
    private String Satuan_;
    private String SpesifikasiBahan_;
    private String StatusTemp_;
    private String Pareto_;
    private String Status_;
    private String StatusLama_;
    private long Posisi_;
    private double Buffer_;
    private double HargaStandardBulk_;
    private double HargaStandard_;
    private double HargaActual_;
    private double Faktor_;
    private double HargaJual_;
    private double Lead_;
    private String TradeName_;
    private String InciName_;
    private String Function_;
    private String Keterangan_;
    private String Lokasi_;
    private String Link_;
    private long IdFile_;
    private double Minimal_;
    private double PersenMcKemas_;
    private long SertifikatHalal_;
    private String StatusHalal_;
    private Date TanggalHalal_;
    private long MasaBerlakuHalal_;
    private Date TanggalAkhirStfHalal_;
    private String NomorHalal_;
    private String PenerbitHalal_;
    private String StatusSensitivitas_;
    private String KlasifikasiBahan_;
    private Timestamp TanggalEntry_;
    private Timestamp TanggalUpdate_;
    private String UserId_;
    private String PKB_;
    private String MSTBB021_S_;
    private String MSTBB01_SP_;
    private String SpecificationPif_;
    private String SafetyData_;
    private String Ifra_;
    private String Regulation_;
    private double Noael_;
    private String LdOral_;
    private String LdDermal_;
    private String Sensitization_;
    private String IrritationDermal_;
    private String IrritationOcular_;
    private String HumanPatch_;
    private String LabelledWith_;
    private String Others_;
    private String Manufactur_;
    private String NomorLUP_;
    private String SessionId_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public MasterbahanAbst() throws CodeException {
        loadNew();
    }
    
    public MasterbahanAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public MasterbahanAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public MasterbahanAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public MasterbahanAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create MasterbahanAbst for Key : " + key + " val : " + val);
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
            
            
            
           Aktif_ = rs.getLong(PROPERTY_AKTIF); 
           KodeBahan_ = rs.getString(PROPERTY_KODEBAHAN); 
           KodeBahanLain_ = rs.getString(PROPERTY_KODEBAHANLAIN); 
           Peruntukan_ = rs.getString(PROPERTY_PERUNTUKAN); 
           KodeSubBahan_ = rs.getString(PROPERTY_KODESUBBAHAN); 
           NamaBahan_ = rs.getString(PROPERTY_NAMABAHAN); 
           NamaAsli_ = rs.getString(PROPERTY_NAMAASLI); 
           KodeProduk_ = rs.getString(PROPERTY_KODEPRODUK); 
           KodeJenisBahan_ = rs.getString(PROPERTY_KODEJENISBAHAN); 
           KodeBrand_ = rs.getString(PROPERTY_KODEBRAND); 
           Satuan_ = rs.getString(PROPERTY_SATUAN); 
           SpesifikasiBahan_ = rs.getString(PROPERTY_SPESIFIKASIBAHAN); 
           StatusTemp_ = rs.getString(PROPERTY_STATUSTEMP); 
           Pareto_ = rs.getString(PROPERTY_PARETO); 
           Status_ = rs.getString(PROPERTY_STATUS); 
           StatusLama_ = rs.getString(PROPERTY_STATUSLAMA); 
           Posisi_ = rs.getLong(PROPERTY_POSISI); 
           Buffer_ = rs.getDouble(PROPERTY_BUFFER); 
           HargaStandardBulk_ = rs.getDouble(PROPERTY_HARGASTANDARDBULK); 
           HargaStandard_ = rs.getDouble(PROPERTY_HARGASTANDARD); 
           HargaActual_ = rs.getDouble(PROPERTY_HARGAACTUAL); 
           Faktor_ = rs.getDouble(PROPERTY_FAKTOR); 
           HargaJual_ = rs.getDouble(PROPERTY_HARGAJUAL); 
           Lead_ = rs.getDouble(PROPERTY_LEAD); 
           TradeName_ = rs.getString(PROPERTY_TRADENAME); 
           InciName_ = rs.getString(PROPERTY_INCINAME); 
           Function_ = rs.getString(PROPERTY_FUNCTION); 
           Keterangan_ = rs.getString(PROPERTY_KETERANGAN); 
           Lokasi_ = rs.getString(PROPERTY_LOKASI); 
           Link_ = rs.getString(PROPERTY_LINK); 
           IdFile_ = rs.getLong(PROPERTY_IDFILE); 
           Minimal_ = rs.getDouble(PROPERTY_MINIMAL); 
           PersenMcKemas_ = rs.getDouble(PROPERTY_PERSENMCKEMAS); 
           SertifikatHalal_ = rs.getLong(PROPERTY_SERTIFIKATHALAL); 
           StatusHalal_ = rs.getString(PROPERTY_STATUSHALAL); 
           TanggalHalal_ = rs.getDate(PROPERTY_TANGGALHALAL); 
           MasaBerlakuHalal_ = rs.getLong(PROPERTY_MASABERLAKUHALAL); 
           TanggalAkhirStfHalal_ = rs.getDate(PROPERTY_TANGGALAKHIRSTFHALAL); 
           NomorHalal_ = rs.getString(PROPERTY_NOMORHALAL); 
           PenerbitHalal_ = rs.getString(PROPERTY_PENERBITHALAL); 
           StatusSensitivitas_ = rs.getString(PROPERTY_STATUSSENSITIVITAS); 
           KlasifikasiBahan_ = rs.getString(PROPERTY_KLASIFIKASIBAHAN); 
           TanggalEntry_ = rs.getTimestamp(PROPERTY_TANGGALENTRY); 
           TanggalUpdate_ = rs.getTimestamp(PROPERTY_TANGGALUPDATE); 
           UserId_ = rs.getString(PROPERTY_USERID); 
           PKB_ = rs.getString(PROPERTY_PKB); 
           MSTBB021_S_ = rs.getString(PROPERTY_MSTBB021_S); 
           MSTBB01_SP_ = rs.getString(PROPERTY_MSTBB01_SP); 
           SpecificationPif_ = rs.getString(PROPERTY_SPECIFICATIONPIF); 
           SafetyData_ = rs.getString(PROPERTY_SAFETYDATA); 
           Ifra_ = rs.getString(PROPERTY_IFRA); 
           Regulation_ = rs.getString(PROPERTY_REGULATION); 
           Noael_ = rs.getDouble(PROPERTY_NOAEL); 
           LdOral_ = rs.getString(PROPERTY_LDORAL); 
           LdDermal_ = rs.getString(PROPERTY_LDDERMAL); 
           Sensitization_ = rs.getString(PROPERTY_SENSITIZATION); 
           IrritationDermal_ = rs.getString(PROPERTY_IRRITATIONDERMAL); 
           IrritationOcular_ = rs.getString(PROPERTY_IRRITATIONOCULAR); 
           HumanPatch_ = rs.getString(PROPERTY_HUMANPATCH); 
           LabelledWith_ = rs.getString(PROPERTY_LABELLEDWITH); 
           Others_ = rs.getString(PROPERTY_OTHERS); 
           Manufactur_ = rs.getString(PROPERTY_MANUFACTUR); 
           NomorLUP_ = rs.getString(PROPERTY_NOMORLUP); 
           SessionId_ = rs.getString(PROPERTY_SESSIONID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading MasterbahanAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Masterbahan obj = (Masterbahan)cache.get(getID());
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
                    throw new CodeException("Error Reading Masterbahan " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getKodeBahan(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : KodeBahan can not be Empty"); 
        } 
 
         o = getPeruntukan(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : Peruntukan can not be Empty"); 
        } 
 
         o = getStatusSensitivitas(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : StatusSensitivitas can not be Empty"); 
        } 
 
         o = getKlasifikasiBahan(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : KlasifikasiBahan can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from masterbahan ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Masterbahan " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateLong(PROPERTY_AKTIF , Aktif_ ); 
            rs.updateString(PROPERTY_KODEBAHAN , KodeBahan_ ); 
            rs.updateString(PROPERTY_KODEBAHANLAIN , KodeBahanLain_ ); 
            rs.updateString(PROPERTY_PERUNTUKAN , Peruntukan_ ); 
            rs.updateString(PROPERTY_KODESUBBAHAN , KodeSubBahan_ ); 
            rs.updateString(PROPERTY_NAMABAHAN , NamaBahan_ ); 
            rs.updateString(PROPERTY_NAMAASLI , NamaAsli_ ); 
            rs.updateString(PROPERTY_KODEPRODUK , KodeProduk_ ); 
            rs.updateString(PROPERTY_KODEJENISBAHAN , KodeJenisBahan_ ); 
            rs.updateString(PROPERTY_KODEBRAND , KodeBrand_ ); 
            rs.updateString(PROPERTY_SATUAN , Satuan_ ); 
            rs.updateString(PROPERTY_SPESIFIKASIBAHAN , SpesifikasiBahan_ ); 
            rs.updateString(PROPERTY_STATUSTEMP , StatusTemp_ ); 
            rs.updateString(PROPERTY_PARETO , Pareto_ ); 
            rs.updateString(PROPERTY_STATUS , Status_ ); 
            rs.updateString(PROPERTY_STATUSLAMA , StatusLama_ ); 
            rs.updateLong(PROPERTY_POSISI , Posisi_ ); 
            rs.updateDouble(PROPERTY_BUFFER , Buffer_ ); 
            rs.updateDouble(PROPERTY_HARGASTANDARDBULK , HargaStandardBulk_ ); 
            rs.updateDouble(PROPERTY_HARGASTANDARD , HargaStandard_ ); 
            rs.updateDouble(PROPERTY_HARGAACTUAL , HargaActual_ ); 
            rs.updateDouble(PROPERTY_FAKTOR , Faktor_ ); 
            rs.updateDouble(PROPERTY_HARGAJUAL , HargaJual_ ); 
            rs.updateDouble(PROPERTY_LEAD , Lead_ ); 
            rs.updateString(PROPERTY_TRADENAME , TradeName_ ); 
            rs.updateString(PROPERTY_INCINAME , InciName_ ); 
            rs.updateString(PROPERTY_FUNCTION , Function_ ); 
            rs.updateString(PROPERTY_KETERANGAN , Keterangan_ ); 
            rs.updateString(PROPERTY_LOKASI , Lokasi_ ); 
            rs.updateString(PROPERTY_LINK , Link_ ); 
            rs.updateLong(PROPERTY_IDFILE , IdFile_ ); 
            rs.updateDouble(PROPERTY_MINIMAL , Minimal_ ); 
            rs.updateDouble(PROPERTY_PERSENMCKEMAS , PersenMcKemas_ ); 
            rs.updateLong(PROPERTY_SERTIFIKATHALAL , SertifikatHalal_ ); 
            rs.updateString(PROPERTY_STATUSHALAL , StatusHalal_ ); 
           if (getTanggalHalal()==null) {
              rs.updateDate(PROPERTY_TANGGALHALAL , null ); 
           }else{
              rs.updateDate(PROPERTY_TANGGALHALAL , getTanggalHalal()); 
           }
            rs.updateLong(PROPERTY_MASABERLAKUHALAL , MasaBerlakuHalal_ ); 
           if (getTanggalAkhirStfHalal()==null) {
              rs.updateDate(PROPERTY_TANGGALAKHIRSTFHALAL , null ); 
           }else{
              rs.updateDate(PROPERTY_TANGGALAKHIRSTFHALAL , getTanggalAkhirStfHalal()); 
           }
            rs.updateString(PROPERTY_NOMORHALAL , NomorHalal_ ); 
            rs.updateString(PROPERTY_PENERBITHALAL , PenerbitHalal_ ); 
            rs.updateString(PROPERTY_STATUSSENSITIVITAS , StatusSensitivitas_ ); 
            rs.updateString(PROPERTY_KLASIFIKASIBAHAN , KlasifikasiBahan_ ); 
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
            rs.updateString(PROPERTY_PKB , PKB_ ); 
            rs.updateString(PROPERTY_MSTBB021_S , MSTBB021_S_ ); 
            rs.updateString(PROPERTY_MSTBB01_SP , MSTBB01_SP_ ); 
            rs.updateString(PROPERTY_SPECIFICATIONPIF , SpecificationPif_ ); 
            rs.updateString(PROPERTY_SAFETYDATA , SafetyData_ ); 
            rs.updateString(PROPERTY_IFRA , Ifra_ ); 
            rs.updateString(PROPERTY_REGULATION , Regulation_ ); 
            rs.updateDouble(PROPERTY_NOAEL , Noael_ ); 
            rs.updateString(PROPERTY_LDORAL , LdOral_ ); 
            rs.updateString(PROPERTY_LDDERMAL , LdDermal_ ); 
            rs.updateString(PROPERTY_SENSITIZATION , Sensitization_ ); 
            rs.updateString(PROPERTY_IRRITATIONDERMAL , IrritationDermal_ ); 
            rs.updateString(PROPERTY_IRRITATIONOCULAR , IrritationOcular_ ); 
            rs.updateString(PROPERTY_HUMANPATCH , HumanPatch_ ); 
            rs.updateString(PROPERTY_LABELLEDWITH , LabelledWith_ ); 
            rs.updateString(PROPERTY_OTHERS , Others_ ); 
            rs.updateString(PROPERTY_MANUFACTUR , Manufactur_ ); 
            rs.updateString(PROPERTY_NOMORLUP , NomorLUP_ ); 
            rs.updateString(PROPERTY_SESSIONID , SessionId_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Masterbahan obj = (Masterbahan) jCob;
        id_ = obj.getID();

        
          Aktif_ = obj.getAktif();
          KodeBahan_ = obj.getKodeBahan();
          KodeBahanLain_ = obj.getKodeBahanLain();
          Peruntukan_ = obj.getPeruntukan();
          KodeSubBahan_ = obj.getKodeSubBahan();
          NamaBahan_ = obj.getNamaBahan();
          NamaAsli_ = obj.getNamaAsli();
          KodeProduk_ = obj.getKodeProduk();
          KodeJenisBahan_ = obj.getKodeJenisBahan();
          KodeBrand_ = obj.getKodeBrand();
          Satuan_ = obj.getSatuan();
          SpesifikasiBahan_ = obj.getSpesifikasiBahan();
          StatusTemp_ = obj.getStatusTemp();
          Pareto_ = obj.getPareto();
          Status_ = obj.getStatus();
          StatusLama_ = obj.getStatusLama();
          Posisi_ = obj.getPosisi();
          Buffer_ = obj.getBuffer();
          HargaStandardBulk_ = obj.getHargaStandardBulk();
          HargaStandard_ = obj.getHargaStandard();
          HargaActual_ = obj.getHargaActual();
          Faktor_ = obj.getFaktor();
          HargaJual_ = obj.getHargaJual();
          Lead_ = obj.getLead();
          TradeName_ = obj.getTradeName();
          InciName_ = obj.getInciName();
          Function_ = obj.getFunction();
          Keterangan_ = obj.getKeterangan();
          Lokasi_ = obj.getLokasi();
          Link_ = obj.getLink();
          IdFile_ = obj.getIdFile();
          Minimal_ = obj.getMinimal();
          PersenMcKemas_ = obj.getPersenMcKemas();
          SertifikatHalal_ = obj.getSertifikatHalal();
          StatusHalal_ = obj.getStatusHalal();
          TanggalHalal_ = obj.getTanggalHalal();
          MasaBerlakuHalal_ = obj.getMasaBerlakuHalal();
          TanggalAkhirStfHalal_ = obj.getTanggalAkhirStfHalal();
          NomorHalal_ = obj.getNomorHalal();
          PenerbitHalal_ = obj.getPenerbitHalal();
          StatusSensitivitas_ = obj.getStatusSensitivitas();
          KlasifikasiBahan_ = obj.getKlasifikasiBahan();
          TanggalEntry_ = obj.getTanggalEntry();
          TanggalUpdate_ = obj.getTanggalUpdate();
          UserId_ = obj.getUserId();
          PKB_ = obj.getPKB();
          MSTBB021_S_ = obj.getMSTBB021_S();
          MSTBB01_SP_ = obj.getMSTBB01_SP();
          SpecificationPif_ = obj.getSpecificationPif();
          SafetyData_ = obj.getSafetyData();
          Ifra_ = obj.getIfra();
          Regulation_ = obj.getRegulation();
          Noael_ = obj.getNoael();
          LdOral_ = obj.getLdOral();
          LdDermal_ = obj.getLdDermal();
          Sensitization_ = obj.getSensitization();
          IrritationDermal_ = obj.getIrritationDermal();
          IrritationOcular_ = obj.getIrritationOcular();
          HumanPatch_ = obj.getHumanPatch();
          LabelledWith_ = obj.getLabelledWith();
          Others_ = obj.getOthers();
          Manufactur_ = obj.getManufactur();
          NomorLUP_ = obj.getNomorLUP();
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

    
      public void setAktif(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Aktif_ = param; 
         _isDirty_ = true; 
      } 

      public long getAktif() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Aktif_; 
      } 

      public void setKodeBahan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeBahan_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeBahan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeBahan_; 
      } 

      public void setKodeBahanLain(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeBahanLain_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeBahanLain() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeBahanLain_; 
      } 

      public void setPeruntukan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Peruntukan_ = param; 
         _isDirty_ = true; 
      } 

      public String getPeruntukan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Peruntukan_; 
      } 

      public void setKodeSubBahan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSubBahan_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSubBahan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSubBahan_; 
      } 

      public void setNamaBahan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaBahan_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaBahan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaBahan_; 
      } 

      public void setNamaAsli(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaAsli_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaAsli() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaAsli_; 
      } 

      public void setKodeProduk(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeProduk_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeProduk() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeProduk_; 
      } 

      public void setKodeJenisBahan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeJenisBahan_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeJenisBahan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeJenisBahan_; 
      } 

      public void setKodeBrand(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeBrand_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeBrand() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeBrand_; 
      } 

      public void setSatuan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Satuan_ = param; 
         _isDirty_ = true; 
      } 

      public String getSatuan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Satuan_; 
      } 

      public void setSpesifikasiBahan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         SpesifikasiBahan_ = param; 
         _isDirty_ = true; 
      } 

      public String getSpesifikasiBahan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return SpesifikasiBahan_; 
      } 

      public void setStatusTemp(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusTemp_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatusTemp() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusTemp_; 
      } 

      public void setPareto(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Pareto_ = param; 
         _isDirty_ = true; 
      } 

      public String getPareto() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Pareto_; 
      } 

      public void setStatus(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Status_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatus() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Status_; 
      } 

      public void setStatusLama(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusLama_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatusLama() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusLama_; 
      } 

      public void setPosisi(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Posisi_ = param; 
         _isDirty_ = true; 
      } 

      public long getPosisi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Posisi_; 
      } 

      public void setBuffer(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Buffer_ = param; 
         _isDirty_ = true; 
      } 

      public double getBuffer() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Buffer_; 
      } 

      public void setHargaStandardBulk(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HargaStandardBulk_ = param; 
         _isDirty_ = true; 
      } 

      public double getHargaStandardBulk() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HargaStandardBulk_; 
      } 

      public void setHargaStandard(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HargaStandard_ = param; 
         _isDirty_ = true; 
      } 

      public double getHargaStandard() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HargaStandard_; 
      } 

      public void setHargaActual(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HargaActual_ = param; 
         _isDirty_ = true; 
      } 

      public double getHargaActual() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HargaActual_; 
      } 

      public void setFaktor(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Faktor_ = param; 
         _isDirty_ = true; 
      } 

      public double getFaktor() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Faktor_; 
      } 

      public void setHargaJual(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HargaJual_ = param; 
         _isDirty_ = true; 
      } 

      public double getHargaJual() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HargaJual_; 
      } 

      public void setLead(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Lead_ = param; 
         _isDirty_ = true; 
      } 

      public double getLead() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Lead_; 
      } 

      public void setTradeName(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TradeName_ = param; 
         _isDirty_ = true; 
      } 

      public String getTradeName() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TradeName_; 
      } 

      public void setInciName(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         InciName_ = param; 
         _isDirty_ = true; 
      } 

      public String getInciName() throws CodeException {
         if (!_isLoaded_) { read();} 
         return InciName_; 
      } 

      public void setFunction(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Function_ = param; 
         _isDirty_ = true; 
      } 

      public String getFunction() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Function_; 
      } 

      public void setKeterangan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Keterangan_ = param; 
         _isDirty_ = true; 
      } 

      public String getKeterangan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Keterangan_; 
      } 

      public void setLokasi(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Lokasi_ = param; 
         _isDirty_ = true; 
      } 

      public String getLokasi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Lokasi_; 
      } 

      public void setLink(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Link_ = param; 
         _isDirty_ = true; 
      } 

      public String getLink() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Link_; 
      } 

      public void setIdFile(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         IdFile_ = param; 
         _isDirty_ = true; 
      } 

      public long getIdFile() throws CodeException {
         if (!_isLoaded_) { read();} 
         return IdFile_; 
      } 

      public void setMinimal(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Minimal_ = param; 
         _isDirty_ = true; 
      } 

      public double getMinimal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Minimal_; 
      } 

      public void setPersenMcKemas(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PersenMcKemas_ = param; 
         _isDirty_ = true; 
      } 

      public double getPersenMcKemas() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PersenMcKemas_; 
      } 

      public void setSertifikatHalal(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         SertifikatHalal_ = param; 
         _isDirty_ = true; 
      } 

      public long getSertifikatHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return SertifikatHalal_; 
      } 

      public void setStatusHalal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusHalal_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatusHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusHalal_; 
      } 

      public void setTanggalHalal(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalHalal_ = param; 
         _isDirty_ = true; 
      } 

      public Date getTanggalHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalHalal_; 
      } 

      public void setMasaBerlakuHalal(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MasaBerlakuHalal_ = param; 
         _isDirty_ = true; 
      } 

      public long getMasaBerlakuHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MasaBerlakuHalal_; 
      } 

      public void setTanggalAkhirStfHalal(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalAkhirStfHalal_ = param; 
         _isDirty_ = true; 
      } 

      public Date getTanggalAkhirStfHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalAkhirStfHalal_; 
      } 

      public void setNomorHalal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorHalal_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorHalal_; 
      } 

      public void setPenerbitHalal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PenerbitHalal_ = param; 
         _isDirty_ = true; 
      } 

      public String getPenerbitHalal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PenerbitHalal_; 
      } 

      public void setStatusSensitivitas(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusSensitivitas_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatusSensitivitas() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusSensitivitas_; 
      } 

      public void setKlasifikasiBahan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KlasifikasiBahan_ = param; 
         _isDirty_ = true; 
      } 

      public String getKlasifikasiBahan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KlasifikasiBahan_; 
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

      public void setPKB(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PKB_ = param; 
         _isDirty_ = true; 
      } 

      public String getPKB() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PKB_; 
      } 

      public void setMSTBB021_S(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MSTBB021_S_ = param; 
         _isDirty_ = true; 
      } 

      public String getMSTBB021_S() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MSTBB021_S_; 
      } 

      public void setMSTBB01_SP(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MSTBB01_SP_ = param; 
         _isDirty_ = true; 
      } 

      public String getMSTBB01_SP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MSTBB01_SP_; 
      } 

      public void setSpecificationPif(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         SpecificationPif_ = param; 
         _isDirty_ = true; 
      } 

      public String getSpecificationPif() throws CodeException {
         if (!_isLoaded_) { read();} 
         return SpecificationPif_; 
      } 

      public void setSafetyData(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         SafetyData_ = param; 
         _isDirty_ = true; 
      } 

      public String getSafetyData() throws CodeException {
         if (!_isLoaded_) { read();} 
         return SafetyData_; 
      } 

      public void setIfra(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Ifra_ = param; 
         _isDirty_ = true; 
      } 

      public String getIfra() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Ifra_; 
      } 

      public void setRegulation(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Regulation_ = param; 
         _isDirty_ = true; 
      } 

      public String getRegulation() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Regulation_; 
      } 

      public void setNoael(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Noael_ = param; 
         _isDirty_ = true; 
      } 

      public double getNoael() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Noael_; 
      } 

      public void setLdOral(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         LdOral_ = param; 
         _isDirty_ = true; 
      } 

      public String getLdOral() throws CodeException {
         if (!_isLoaded_) { read();} 
         return LdOral_; 
      } 

      public void setLdDermal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         LdDermal_ = param; 
         _isDirty_ = true; 
      } 

      public String getLdDermal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return LdDermal_; 
      } 

      public void setSensitization(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Sensitization_ = param; 
         _isDirty_ = true; 
      } 

      public String getSensitization() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Sensitization_; 
      } 

      public void setIrritationDermal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         IrritationDermal_ = param; 
         _isDirty_ = true; 
      } 

      public String getIrritationDermal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return IrritationDermal_; 
      } 

      public void setIrritationOcular(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         IrritationOcular_ = param; 
         _isDirty_ = true; 
      } 

      public String getIrritationOcular() throws CodeException {
         if (!_isLoaded_) { read();} 
         return IrritationOcular_; 
      } 

      public void setHumanPatch(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HumanPatch_ = param; 
         _isDirty_ = true; 
      } 

      public String getHumanPatch() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HumanPatch_; 
      } 

      public void setLabelledWith(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         LabelledWith_ = param; 
         _isDirty_ = true; 
      } 

      public String getLabelledWith() throws CodeException {
         if (!_isLoaded_) { read();} 
         return LabelledWith_; 
      } 

      public void setOthers(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Others_ = param; 
         _isDirty_ = true; 
      } 

      public String getOthers() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Others_; 
      } 

      public void setManufactur(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Manufactur_ = param; 
         _isDirty_ = true; 
      } 

      public String getManufactur() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Manufactur_; 
      } 

      public void setNomorLUP(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorLUP_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorLUP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorLUP_; 
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
        
           else if (param.equals(PROPERTY_AKTIF)) return String.valueOf(getAktif()); 
           else if (param.equals(PROPERTY_KODEBAHAN)) return getKodeBahan(); 
           else if (param.equals(PROPERTY_KODEBAHANLAIN)) return getKodeBahanLain(); 
           else if (param.equals(PROPERTY_PERUNTUKAN)) return getPeruntukan(); 
           else if (param.equals(PROPERTY_KODESUBBAHAN)) return getKodeSubBahan(); 
           else if (param.equals(PROPERTY_NAMABAHAN)) return getNamaBahan(); 
           else if (param.equals(PROPERTY_NAMAASLI)) return getNamaAsli(); 
           else if (param.equals(PROPERTY_KODEPRODUK)) return getKodeProduk(); 
           else if (param.equals(PROPERTY_KODEJENISBAHAN)) return getKodeJenisBahan(); 
           else if (param.equals(PROPERTY_KODEBRAND)) return getKodeBrand(); 
           else if (param.equals(PROPERTY_SATUAN)) return getSatuan(); 
           else if (param.equals(PROPERTY_SPESIFIKASIBAHAN)) return getSpesifikasiBahan(); 
           else if (param.equals(PROPERTY_STATUSTEMP)) return getStatusTemp(); 
           else if (param.equals(PROPERTY_PARETO)) return getPareto(); 
           else if (param.equals(PROPERTY_STATUS)) return getStatus(); 
           else if (param.equals(PROPERTY_STATUSLAMA)) return getStatusLama(); 
           else if (param.equals(PROPERTY_POSISI)) return String.valueOf(getPosisi()); 
           else if (param.equals(PROPERTY_BUFFER)) return decform.format(getBuffer()); 
           else if (param.equals(PROPERTY_HARGASTANDARDBULK)) return decform.format(getHargaStandardBulk()); 
           else if (param.equals(PROPERTY_HARGASTANDARD)) return decform.format(getHargaStandard()); 
           else if (param.equals(PROPERTY_HARGAACTUAL)) return decform.format(getHargaActual()); 
           else if (param.equals(PROPERTY_FAKTOR)) return decform.format(getFaktor()); 
           else if (param.equals(PROPERTY_HARGAJUAL)) return decform.format(getHargaJual()); 
           else if (param.equals(PROPERTY_LEAD)) return decform.format(getLead()); 
           else if (param.equals(PROPERTY_TRADENAME)) return getTradeName(); 
           else if (param.equals(PROPERTY_INCINAME)) return getInciName(); 
           else if (param.equals(PROPERTY_FUNCTION)) return getFunction(); 
           else if (param.equals(PROPERTY_KETERANGAN)) return getKeterangan(); 
           else if (param.equals(PROPERTY_LOKASI)) return getLokasi(); 
           else if (param.equals(PROPERTY_LINK)) return getLink(); 
           else if (param.equals(PROPERTY_IDFILE)) return String.valueOf(getIdFile()); 
           else if (param.equals(PROPERTY_MINIMAL)) return decform.format(getMinimal()); 
           else if (param.equals(PROPERTY_PERSENMCKEMAS)) return decform.format(getPersenMcKemas()); 
           else if (param.equals(PROPERTY_SERTIFIKATHALAL)) return String.valueOf(getSertifikatHalal()); 
           else if (param.equals(PROPERTY_STATUSHALAL)) return getStatusHalal(); 
           else if (param.equals(PROPERTY_TANGGALHALAL)) return getTanggalHalal()  == null ? "" :dateformat.format(getTanggalHalal()); 
           else if (param.equals(PROPERTY_MASABERLAKUHALAL)) return String.valueOf(getMasaBerlakuHalal()); 
           else if (param.equals(PROPERTY_TANGGALAKHIRSTFHALAL)) return getTanggalAkhirStfHalal()  == null ? "" :dateformat.format(getTanggalAkhirStfHalal()); 
           else if (param.equals(PROPERTY_NOMORHALAL)) return getNomorHalal(); 
           else if (param.equals(PROPERTY_PENERBITHALAL)) return getPenerbitHalal(); 
           else if (param.equals(PROPERTY_STATUSSENSITIVITAS)) return getStatusSensitivitas(); 
           else if (param.equals(PROPERTY_KLASIFIKASIBAHAN)) return getKlasifikasiBahan(); 
           else if (param.equals(PROPERTY_TANGGALENTRY)) return getTanggalEntry()  == null || getTanggalEntry().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalEntry()) ; 
           else if (param.equals(PROPERTY_TANGGALUPDATE)) return getTanggalUpdate()  == null || getTanggalUpdate().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalUpdate()) ; 
           else if (param.equals(PROPERTY_USERID)) return getUserId(); 
           else if (param.equals(PROPERTY_PKB)) return getPKB(); 
           else if (param.equals(PROPERTY_MSTBB021_S)) return getMSTBB021_S(); 
           else if (param.equals(PROPERTY_MSTBB01_SP)) return getMSTBB01_SP(); 
           else if (param.equals(PROPERTY_SPECIFICATIONPIF)) return getSpecificationPif(); 
           else if (param.equals(PROPERTY_SAFETYDATA)) return getSafetyData(); 
           else if (param.equals(PROPERTY_IFRA)) return getIfra(); 
           else if (param.equals(PROPERTY_REGULATION)) return getRegulation(); 
           else if (param.equals(PROPERTY_NOAEL)) return decform.format(getNoael()); 
           else if (param.equals(PROPERTY_LDORAL)) return getLdOral(); 
           else if (param.equals(PROPERTY_LDDERMAL)) return getLdDermal(); 
           else if (param.equals(PROPERTY_SENSITIZATION)) return getSensitization(); 
           else if (param.equals(PROPERTY_IRRITATIONDERMAL)) return getIrritationDermal(); 
           else if (param.equals(PROPERTY_IRRITATIONOCULAR)) return getIrritationOcular(); 
           else if (param.equals(PROPERTY_HUMANPATCH)) return getHumanPatch(); 
           else if (param.equals(PROPERTY_LABELLEDWITH)) return getLabelledWith(); 
           else if (param.equals(PROPERTY_OTHERS)) return getOthers(); 
           else if (param.equals(PROPERTY_MANUFACTUR)) return getManufactur(); 
           else if (param.equals(PROPERTY_NOMORLUP)) return getNomorLUP(); 
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
        
           else if (param.equals(PROPERTY_AKTIF)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setAktif(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_KODEBAHAN))  setKodeBahan(value); 
           else if (param.equals(PROPERTY_KODEBAHANLAIN))  setKodeBahanLain(value); 
           else if (param.equals(PROPERTY_PERUNTUKAN))  setPeruntukan(value); 
           else if (param.equals(PROPERTY_KODESUBBAHAN))  setKodeSubBahan(value); 
           else if (param.equals(PROPERTY_NAMABAHAN))  setNamaBahan(value); 
           else if (param.equals(PROPERTY_NAMAASLI))  setNamaAsli(value); 
           else if (param.equals(PROPERTY_KODEPRODUK))  setKodeProduk(value); 
           else if (param.equals(PROPERTY_KODEJENISBAHAN))  setKodeJenisBahan(value); 
           else if (param.equals(PROPERTY_KODEBRAND))  setKodeBrand(value); 
           else if (param.equals(PROPERTY_SATUAN))  setSatuan(value); 
           else if (param.equals(PROPERTY_SPESIFIKASIBAHAN))  setSpesifikasiBahan(value); 
           else if (param.equals(PROPERTY_STATUSTEMP))  setStatusTemp(value); 
           else if (param.equals(PROPERTY_PARETO))  setPareto(value); 
           else if (param.equals(PROPERTY_STATUS))  setStatus(value); 
           else if (param.equals(PROPERTY_STATUSLAMA))  setStatusLama(value); 
           else if (param.equals(PROPERTY_POSISI)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setPosisi(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BUFFER)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setBuffer(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HARGASTANDARDBULK)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHargaStandardBulk(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HARGASTANDARD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHargaStandard(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HARGAACTUAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHargaActual(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_FAKTOR)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setFaktor(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HARGAJUAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHargaJual(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LEAD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setLead(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TRADENAME))  setTradeName(value); 
           else if (param.equals(PROPERTY_INCINAME))  setInciName(value); 
           else if (param.equals(PROPERTY_FUNCTION))  setFunction(value); 
           else if (param.equals(PROPERTY_KETERANGAN))  setKeterangan(value); 
           else if (param.equals(PROPERTY_LOKASI))  setLokasi(value); 
           else if (param.equals(PROPERTY_LINK))  setLink(value); 
           else if (param.equals(PROPERTY_IDFILE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setIdFile(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MINIMAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMinimal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PERSENMCKEMAS)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setPersenMcKemas(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SERTIFIKATHALAL)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setSertifikatHalal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_STATUSHALAL))  setStatusHalal(value); 
           else if (param.equals(PROPERTY_TANGGALHALAL)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalHalal(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setTanggalHalal(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_MASABERLAKUHALAL)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setMasaBerlakuHalal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TANGGALAKHIRSTFHALAL)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalAkhirStfHalal(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setTanggalAkhirStfHalal(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_NOMORHALAL))  setNomorHalal(value); 
           else if (param.equals(PROPERTY_PENERBITHALAL))  setPenerbitHalal(value); 
           else if (param.equals(PROPERTY_STATUSSENSITIVITAS))  setStatusSensitivitas(value); 
           else if (param.equals(PROPERTY_KLASIFIKASIBAHAN))  setKlasifikasiBahan(value); 
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
           else if (param.equals(PROPERTY_PKB))  setPKB(value); 
           else if (param.equals(PROPERTY_MSTBB021_S))  setMSTBB021_S(value); 
           else if (param.equals(PROPERTY_MSTBB01_SP))  setMSTBB01_SP(value); 
           else if (param.equals(PROPERTY_SPECIFICATIONPIF))  setSpecificationPif(value); 
           else if (param.equals(PROPERTY_SAFETYDATA))  setSafetyData(value); 
           else if (param.equals(PROPERTY_IFRA))  setIfra(value); 
           else if (param.equals(PROPERTY_REGULATION))  setRegulation(value); 
           else if (param.equals(PROPERTY_NOAEL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setNoael(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LDORAL))  setLdOral(value); 
           else if (param.equals(PROPERTY_LDDERMAL))  setLdDermal(value); 
           else if (param.equals(PROPERTY_SENSITIZATION))  setSensitization(value); 
           else if (param.equals(PROPERTY_IRRITATIONDERMAL))  setIrritationDermal(value); 
           else if (param.equals(PROPERTY_IRRITATIONOCULAR))  setIrritationOcular(value); 
           else if (param.equals(PROPERTY_HUMANPATCH))  setHumanPatch(value); 
           else if (param.equals(PROPERTY_LABELLEDWITH))  setLabelledWith(value); 
           else if (param.equals(PROPERTY_OTHERS))  setOthers(value); 
           else if (param.equals(PROPERTY_MANUFACTUR))  setManufactur(value); 
           else if (param.equals(PROPERTY_NOMORLUP))  setNomorLUP(value); 
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
            throw new CodeException("Masterbahan : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, Peruntukan_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Masterbahan : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, Peruntukan_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Masterbahan : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Masterbahan : Cannot Move Last " + ex.getMessage());
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



