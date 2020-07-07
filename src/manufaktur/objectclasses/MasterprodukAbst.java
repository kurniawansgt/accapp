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


public abstract class MasterprodukAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Masterproduk";

    public static final String TABLE = "manufaktur.masterproduk";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_AKTIF = "Aktif";
    public static final String PROPERTY_TANGGALAKTIF = "TanggalAktif";
    public static final String PROPERTY_KODEPRODUK = "KodeProduk";
    public static final String PROPERTY_KODEPRODUKLAMA = "KodeProdukLama";
    public static final String PROPERTY_KODEUNIVERSAL = "KodeUniversal";
    public static final String PROPERTY_KODESAI = "KodeSAI";
    public static final String PROPERTY_NAMAPRODUK = "NamaProduk";
    public static final String PROPERTY_NAMAJADI = "NamaJadi";
    public static final String PROPERTY_SATUAN = "Satuan";
    public static final String PROPERTY_KODEBRANDLAMA = "KodeBrandLama";
    public static final String PROPERTY_KODEBRAND = "KodeBrand";
    public static final String PROPERTY_KODESUBBRAND = "KodeSubBrand";
    public static final String PROPERTY_KODEKELOMPOK = "KodeKelompok";
    public static final String PROPERTY_KODEFUNGSI = "KodeFungsi";
    public static final String PROPERTY_KODESUBFUNGSI = "KodeSubFungsi";
    public static final String PROPERTY_KODESERI = "KodeSeri";
    public static final String PROPERTY_KODESEDIA = "KodeSedia";
    public static final String PROPERTY_KODEPENGGUNA = "KodePengguna";
    public static final String PROPERTY_KODELOKASI = "KodeLokasi";
    public static final String PROPERTY_TREND = "Trend";
    public static final String PROPERTY_TAHUN = "Tahun";
    public static final String PROPERTY_BULAN = "Bulan";
    public static final String PROPERTY_REVISI = "Revisi";
    public static final String PROPERTY_JENISBENDA = "JenisBenda";
    public static final String PROPERTY_NOMORURUT = "NomorUrut";
    public static final String PROPERTY_KODEKEMAS = "KodeKemas";
    public static final String PROPERTY_ARTIKEL = "Artikel";
    public static final String PROPERTY_PLANT = "Plant";
    public static final String PROPERTY_JENISPRODUK = "JenisProduk";
    public static final String PROPERTY_TIPEPRODUK = "TipeProduk";
    public static final String PROPERTY_HASILJADI = "HasilJadi";
    public static final String PROPERTY_ISI = "Isi";
    public static final String PROPERTY_ISIBOX = "IsiBox";
    public static final String PROPERTY_ISIVOL = "IsiVol";
    public static final String PROPERTY_ISIBOXPERPCS = "IsiBoxPerPcs";
    public static final String PROPERTY_BERATKARTONMASTER = "BeratKartonMaster";
    public static final String PROPERTY_INNERBOXMINWEIGHT = "InnerBoxMinWeight";
    public static final String PROPERTY_INNERBOXMAXWEIGHT = "InnerBoxMaxWeight";
    public static final String PROPERTY_MASTERBOXMINWEIGHT = "MasterBoxMinWeight";
    public static final String PROPERTY_MASTERBOXMAXWEIGHT = "MasterBoxMaxWeight";
    public static final String PROPERTY_PARETO = "Pareto";
    public static final String PROPERTY_VALID = "Valid";
    public static final String PROPERTY_STATUSNA = "StatusNA";
    public static final String PROPERTY_STATUS = "Status";
    public static final String PROPERTY_OUTPUTRAWMATRIAL = "OutputRawMatrial";
    public static final String PROPERTY_OUTPUTPACKINGMATRIAL = "OutputPackingMatrial";
    public static final String PROPERTY_HARGASTANDARD = "HargaStandard";
    public static final String PROPERTY_HARGAFAKTUR = "HargaFaktur";
    public static final String PROPERTY_HARGAMAKLUN = "HargaMaklun";
    public static final String PROPERTY_RAWMATRIAL = "RawMatrial";
    public static final String PROPERTY_PACKINGMATRIAL = "PackingMatrial";
    public static final String PROPERTY_MACHINERAWMATRIAL = "MachineRawMatrial";
    public static final String PROPERTY_MACHINEPACKINGMATRIAL = "MachinePackingMatrial";
    public static final String PROPERTY_DIRECTLABOURRAWMATRIAL = "DirectLabourRawMatrial";
    public static final String PROPERTY_DIRECTLABOURPACKINGMATRIAL = "DirectLabourPackingMatrial";
    public static final String PROPERTY_OVERHEADRAWMATRIAL = "OverHeadRawMatrial";
    public static final String PROPERTY_OVERHEADPACKINGMATRIAL = "OverHeadPackingMatrial";
    public static final String PROPERTY_OTHERS = "Others";
    public static final String PROPERTY_HJP = "HJP";
    public static final String PROPERTY_HJPEXT = "HJPExt";
    public static final String PROPERTY_MARGINCOGM = "MarginCOGM";
    public static final String PROPERTY_MARGINHJP = "MarginHJP";
    public static final String PROPERTY_NOMORREGISTRASI1 = "NomorRegistrasi1";
    public static final String PROPERTY_TANGGALREGISTRASI1 = "TanggalRegistrasi1";
    public static final String PROPERTY_STATUSREGISTRASI = "StatusRegistrasi";
    public static final String PROPERTY_NOMORREGISTRASI2 = "NomorRegistrasi2";
    public static final String PROPERTY_TANGGALREGISTRASI2 = "TanggalRegistrasi2";
    public static final String PROPERTY_STATUSREGISTRASI2 = "StatusRegistrasi2";
    public static final String PROPERTY_NOMORREGISTRASI3 = "NomorRegistrasi3";
    public static final String PROPERTY_TANGGALREGISTRASI3 = "TanggalRegistrasi3";
    public static final String PROPERTY_STATUSREGISTRASI3 = "StatusRegistrasi3";
    public static final String PROPERTY_STATUSHALAL = "StatusHalal";
    public static final String PROPERTY_STATUSHALALXX = "StatusHalalXX";
    public static final String PROPERTY_JENISSALES = "JenisSales";
    public static final String PROPERTY_NAMAINNER = "NamaInner";
    public static final String PROPERTY_NAMABOKS = "NamaBoks";
    public static final String PROPERTY_BARCODE = "Barcode";
    public static final String PROPERTY_TEXTBARCODE = "TextBarcode";
    public static final String PROPERTY_KODEKELOMPOKBARCODE = "KodeKelompokBarcode";
    public static final String PROPERTY_KODESUBKELOMPOKBARCODE = "KodeSubKelompokBarcode";
    public static final String PROPERTY_PP = "PP";
    public static final String PROPERTY_PACK = "PACK";
    public static final String PROPERTY_TIPEKEMAS = "TipeKemas";
    public static final String PROPERTY_UMURSIMPAN = "UmurSimpan";
    public static final String PROPERTY_PENOMORANBATCH = "PenomoranBatch";
    public static final String PROPERTY_MODELSERVICE = "modelservice";
    public static final String PROPERTY_TANGGALUPDATE = "TanggalUpdate";
    public static final String PROPERTY_TANGGALENTRY = "TanggalEntry";
    public static final String PROPERTY_USERID = "UserID";
    public static final String PROPERTY_BPHP = "Bphp";
    public static final String PROPERTY_TANDAPALETTE = "TandaPalette";
    public static final String PROPERTY_SESSIONID = "SessionId";
    
     public static final String PRIMARYKEY = PROPERTY_KODEPRODUK;
    
    
    private long id_;
    private long Aktif_;
    private Date TanggalAktif_;
    private String KodeProduk_;
    private String KodeProdukLama_;
    private String KodeUniversal_;
    private String KodeSAI_;
    private String NamaProduk_;
    private String NamaJadi_;
    private String Satuan_;
    private String KodeBrandLama_;
    private String KodeBrand_;
    private String KodeSubBrand_;
    private String KodeKelompok_;
    private String KodeFungsi_;
    private String KodeSubFungsi_;
    private String KodeSeri_;
    private String KodeSedia_;
    private String KodePengguna_;
    private String KodeLokasi_;
    private String Trend_;
    private String Tahun_;
    private String Bulan_;
    private String Revisi_;
    private String JenisBenda_;
    private String NomorUrut_;
    private String KodeKemas_;
    private String Artikel_;
    private String Plant_;
    private String JenisProduk_;
    private String TipeProduk_;
    private double HasilJadi_;
    private double Isi_;
    private double IsiBox_;
    private double IsiVol_;
    private double IsiBoxPerPcs_;
    private double BeratKartonMaster_;
    private double InnerBoxMinWeight_;
    private double InnerBoxMaxWeight_;
    private double MasterBoxMinWeight_;
    private double MasterBoxMaxWeight_;
    private String Pareto_;
    private String Valid_;
    private String StatusNA_;
    private String Status_;
    private double OutputRawMatrial_;
    private double OutputPackingMatrial_;
    private double HargaStandard_;
    private double HargaFaktur_;
    private double HargaMaklun_;
    private double RawMatrial_;
    private double PackingMatrial_;
    private double MachineRawMatrial_;
    private double MachinePackingMatrial_;
    private double DirectLabourRawMatrial_;
    private double DirectLabourPackingMatrial_;
    private double OverHeadRawMatrial_;
    private double OverHeadPackingMatrial_;
    private double Others_;
    private double HJP_;
    private double HJPExt_;
    private double MarginCOGM_;
    private double MarginHJP_;
    private String NomorRegistrasi1_;
    private Date TanggalRegistrasi1_;
    private long StatusRegistrasi_;
    private String NomorRegistrasi2_;
    private Date TanggalRegistrasi2_;
    private long StatusRegistrasi2_;
    private String NomorRegistrasi3_;
    private Date TanggalRegistrasi3_;
    private long StatusRegistrasi3_;
    private String StatusHalal_;
    private String StatusHalalXX_;
    private long JenisSales_;
    private String NamaInner_;
    private String NamaBoks_;
    private String Barcode_;
    private String TextBarcode_;
    private String KodeKelompokBarcode_;
    private String KodeSubKelompokBarcode_;
    private String PP_;
    private String PACK_;
    private long TipeKemas_;
    private long UmurSimpan_;
    private long PenomoranBatch_;
    private String modelservice_;
    private Timestamp TanggalUpdate_;
    private Timestamp TanggalEntry_;
    private String UserID_;
    private double Bphp_;
    private String TandaPalette_;
    private String SessionId_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public MasterprodukAbst() throws CodeException {
        loadNew();
    }
    
    public MasterprodukAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public MasterprodukAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public MasterprodukAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public MasterprodukAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create MasterprodukAbst for Key : " + key + " val : " + val);
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
           TanggalAktif_ = rs.getDate(PROPERTY_TANGGALAKTIF); 
           KodeProduk_ = rs.getString(PROPERTY_KODEPRODUK); 
           KodeProdukLama_ = rs.getString(PROPERTY_KODEPRODUKLAMA); 
           KodeUniversal_ = rs.getString(PROPERTY_KODEUNIVERSAL); 
           KodeSAI_ = rs.getString(PROPERTY_KODESAI); 
           NamaProduk_ = rs.getString(PROPERTY_NAMAPRODUK); 
           NamaJadi_ = rs.getString(PROPERTY_NAMAJADI); 
           Satuan_ = rs.getString(PROPERTY_SATUAN); 
           KodeBrandLama_ = rs.getString(PROPERTY_KODEBRANDLAMA); 
           KodeBrand_ = rs.getString(PROPERTY_KODEBRAND); 
           KodeSubBrand_ = rs.getString(PROPERTY_KODESUBBRAND); 
           KodeKelompok_ = rs.getString(PROPERTY_KODEKELOMPOK); 
           KodeFungsi_ = rs.getString(PROPERTY_KODEFUNGSI); 
           KodeSubFungsi_ = rs.getString(PROPERTY_KODESUBFUNGSI); 
           KodeSeri_ = rs.getString(PROPERTY_KODESERI); 
           KodeSedia_ = rs.getString(PROPERTY_KODESEDIA); 
           KodePengguna_ = rs.getString(PROPERTY_KODEPENGGUNA); 
           KodeLokasi_ = rs.getString(PROPERTY_KODELOKASI); 
           Trend_ = rs.getString(PROPERTY_TREND); 
           Tahun_ = rs.getString(PROPERTY_TAHUN); 
           Bulan_ = rs.getString(PROPERTY_BULAN); 
           Revisi_ = rs.getString(PROPERTY_REVISI); 
           JenisBenda_ = rs.getString(PROPERTY_JENISBENDA); 
           NomorUrut_ = rs.getString(PROPERTY_NOMORURUT); 
           KodeKemas_ = rs.getString(PROPERTY_KODEKEMAS); 
           Artikel_ = rs.getString(PROPERTY_ARTIKEL); 
           Plant_ = rs.getString(PROPERTY_PLANT); 
           JenisProduk_ = rs.getString(PROPERTY_JENISPRODUK); 
           TipeProduk_ = rs.getString(PROPERTY_TIPEPRODUK); 
           HasilJadi_ = rs.getDouble(PROPERTY_HASILJADI); 
           Isi_ = rs.getDouble(PROPERTY_ISI); 
           IsiBox_ = rs.getDouble(PROPERTY_ISIBOX); 
           IsiVol_ = rs.getDouble(PROPERTY_ISIVOL); 
           IsiBoxPerPcs_ = rs.getDouble(PROPERTY_ISIBOXPERPCS); 
           BeratKartonMaster_ = rs.getDouble(PROPERTY_BERATKARTONMASTER); 
           InnerBoxMinWeight_ = rs.getDouble(PROPERTY_INNERBOXMINWEIGHT); 
           InnerBoxMaxWeight_ = rs.getDouble(PROPERTY_INNERBOXMAXWEIGHT); 
           MasterBoxMinWeight_ = rs.getDouble(PROPERTY_MASTERBOXMINWEIGHT); 
           MasterBoxMaxWeight_ = rs.getDouble(PROPERTY_MASTERBOXMAXWEIGHT); 
           Pareto_ = rs.getString(PROPERTY_PARETO); 
           Valid_ = rs.getString(PROPERTY_VALID); 
           StatusNA_ = rs.getString(PROPERTY_STATUSNA); 
           Status_ = rs.getString(PROPERTY_STATUS); 
           OutputRawMatrial_ = rs.getDouble(PROPERTY_OUTPUTRAWMATRIAL); 
           OutputPackingMatrial_ = rs.getDouble(PROPERTY_OUTPUTPACKINGMATRIAL); 
           HargaStandard_ = rs.getDouble(PROPERTY_HARGASTANDARD); 
           HargaFaktur_ = rs.getDouble(PROPERTY_HARGAFAKTUR); 
           HargaMaklun_ = rs.getDouble(PROPERTY_HARGAMAKLUN); 
           RawMatrial_ = rs.getDouble(PROPERTY_RAWMATRIAL); 
           PackingMatrial_ = rs.getDouble(PROPERTY_PACKINGMATRIAL); 
           MachineRawMatrial_ = rs.getDouble(PROPERTY_MACHINERAWMATRIAL); 
           MachinePackingMatrial_ = rs.getDouble(PROPERTY_MACHINEPACKINGMATRIAL); 
           DirectLabourRawMatrial_ = rs.getDouble(PROPERTY_DIRECTLABOURRAWMATRIAL); 
           DirectLabourPackingMatrial_ = rs.getDouble(PROPERTY_DIRECTLABOURPACKINGMATRIAL); 
           OverHeadRawMatrial_ = rs.getDouble(PROPERTY_OVERHEADRAWMATRIAL); 
           OverHeadPackingMatrial_ = rs.getDouble(PROPERTY_OVERHEADPACKINGMATRIAL); 
           Others_ = rs.getDouble(PROPERTY_OTHERS); 
           HJP_ = rs.getDouble(PROPERTY_HJP); 
           HJPExt_ = rs.getDouble(PROPERTY_HJPEXT); 
           MarginCOGM_ = rs.getDouble(PROPERTY_MARGINCOGM); 
           MarginHJP_ = rs.getDouble(PROPERTY_MARGINHJP); 
           NomorRegistrasi1_ = rs.getString(PROPERTY_NOMORREGISTRASI1); 
           TanggalRegistrasi1_ = rs.getDate(PROPERTY_TANGGALREGISTRASI1); 
           StatusRegistrasi_ = rs.getLong(PROPERTY_STATUSREGISTRASI); 
           NomorRegistrasi2_ = rs.getString(PROPERTY_NOMORREGISTRASI2); 
           TanggalRegistrasi2_ = rs.getDate(PROPERTY_TANGGALREGISTRASI2); 
           StatusRegistrasi2_ = rs.getLong(PROPERTY_STATUSREGISTRASI2); 
           NomorRegistrasi3_ = rs.getString(PROPERTY_NOMORREGISTRASI3); 
           TanggalRegistrasi3_ = rs.getDate(PROPERTY_TANGGALREGISTRASI3); 
           StatusRegistrasi3_ = rs.getLong(PROPERTY_STATUSREGISTRASI3); 
           StatusHalal_ = rs.getString(PROPERTY_STATUSHALAL); 
           StatusHalalXX_ = rs.getString(PROPERTY_STATUSHALALXX); 
           JenisSales_ = rs.getLong(PROPERTY_JENISSALES); 
           NamaInner_ = rs.getString(PROPERTY_NAMAINNER); 
           NamaBoks_ = rs.getString(PROPERTY_NAMABOKS); 
           Barcode_ = rs.getString(PROPERTY_BARCODE); 
           TextBarcode_ = rs.getString(PROPERTY_TEXTBARCODE); 
           KodeKelompokBarcode_ = rs.getString(PROPERTY_KODEKELOMPOKBARCODE); 
           KodeSubKelompokBarcode_ = rs.getString(PROPERTY_KODESUBKELOMPOKBARCODE); 
           PP_ = rs.getString(PROPERTY_PP); 
           PACK_ = rs.getString(PROPERTY_PACK); 
           TipeKemas_ = rs.getLong(PROPERTY_TIPEKEMAS); 
           UmurSimpan_ = rs.getLong(PROPERTY_UMURSIMPAN); 
           PenomoranBatch_ = rs.getLong(PROPERTY_PENOMORANBATCH); 
           modelservice_ = rs.getString(PROPERTY_MODELSERVICE); 
           TanggalUpdate_ = rs.getTimestamp(PROPERTY_TANGGALUPDATE); 
           TanggalEntry_ = rs.getTimestamp(PROPERTY_TANGGALENTRY); 
           UserID_ = rs.getString(PROPERTY_USERID); 
           Bphp_ = rs.getDouble(PROPERTY_BPHP); 
           TandaPalette_ = rs.getString(PROPERTY_TANDAPALETTE); 
           SessionId_ = rs.getString(PROPERTY_SESSIONID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading MasterprodukAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Masterproduk obj = (Masterproduk)cache.get(getID());
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
                    throw new CodeException("Error Reading Masterproduk " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getKodeProduk(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : KodeProduk can not be Empty"); 
        } 
 
         o = getHasilJadi(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : HasilJadi can not be Empty"); 
        } 
 
         o = getIsi(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : Isi can not be Empty"); 
        } 
 
         o = getIsiBox(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : IsiBox can not be Empty"); 
        } 
 
         o = getIsiVol(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : IsiVol can not be Empty"); 
        } 
 
         o = getIsiBoxPerPcs(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : IsiBoxPerPcs can not be Empty"); 
        } 
 
         o = getBeratKartonMaster(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : BeratKartonMaster can not be Empty"); 
        } 
 
         o = getInnerBoxMinWeight(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : InnerBoxMinWeight can not be Empty"); 
        } 
 
         o = getInnerBoxMaxWeight(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : InnerBoxMaxWeight can not be Empty"); 
        } 
 
         o = getMasterBoxMinWeight(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : MasterBoxMinWeight can not be Empty"); 
        } 
 
         o = getMasterBoxMaxWeight(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : MasterBoxMaxWeight can not be Empty"); 
        } 
 
         o = getValid(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : Valid can not be Empty"); 
        } 
 
         o = getOutputRawMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : OutputRawMatrial can not be Empty"); 
        } 
 
         o = getOutputPackingMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : OutputPackingMatrial can not be Empty"); 
        } 
 
         o = getHargaStandard(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : HargaStandard can not be Empty"); 
        } 
 
         o = getRawMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : RawMatrial can not be Empty"); 
        } 
 
         o = getPackingMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : PackingMatrial can not be Empty"); 
        } 
 
         o = getMachineRawMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : MachineRawMatrial can not be Empty"); 
        } 
 
         o = getMachinePackingMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : MachinePackingMatrial can not be Empty"); 
        } 
 
         o = getDirectLabourRawMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : DirectLabourRawMatrial can not be Empty"); 
        } 
 
         o = getDirectLabourPackingMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : DirectLabourPackingMatrial can not be Empty"); 
        } 
 
         o = getOverHeadRawMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : OverHeadRawMatrial can not be Empty"); 
        } 
 
         o = getOverHeadPackingMatrial(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : OverHeadPackingMatrial can not be Empty"); 
        } 
 
         o = getOthers(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : Others can not be Empty"); 
        } 
 
         o = getHJP(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : HJP can not be Empty"); 
        } 
 
         o = getHJPExt(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : HJPExt can not be Empty"); 
        } 
 
         o = getMarginCOGM(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : MarginCOGM can not be Empty"); 
        } 
 
         o = getMarginHJP(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : MarginHJP can not be Empty"); 
        } 
 
         o = getTandaPalette(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : TandaPalette can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from masterproduk ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Masterproduk " + e.getMessage());
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
           if (getTanggalAktif()==null) {
              rs.updateDate(PROPERTY_TANGGALAKTIF , null ); 
           }else{
              rs.updateDate(PROPERTY_TANGGALAKTIF , getTanggalAktif()); 
           }
            rs.updateString(PROPERTY_KODEPRODUK , KodeProduk_ ); 
            rs.updateString(PROPERTY_KODEPRODUKLAMA , KodeProdukLama_ ); 
            rs.updateString(PROPERTY_KODEUNIVERSAL , KodeUniversal_ ); 
            rs.updateString(PROPERTY_KODESAI , KodeSAI_ ); 
            rs.updateString(PROPERTY_NAMAPRODUK , NamaProduk_ ); 
            rs.updateString(PROPERTY_NAMAJADI , NamaJadi_ ); 
            rs.updateString(PROPERTY_SATUAN , Satuan_ ); 
            rs.updateString(PROPERTY_KODEBRANDLAMA , KodeBrandLama_ ); 
            rs.updateString(PROPERTY_KODEBRAND , KodeBrand_ ); 
            rs.updateString(PROPERTY_KODESUBBRAND , KodeSubBrand_ ); 
            rs.updateString(PROPERTY_KODEKELOMPOK , KodeKelompok_ ); 
            rs.updateString(PROPERTY_KODEFUNGSI , KodeFungsi_ ); 
            rs.updateString(PROPERTY_KODESUBFUNGSI , KodeSubFungsi_ ); 
            rs.updateString(PROPERTY_KODESERI , KodeSeri_ ); 
            rs.updateString(PROPERTY_KODESEDIA , KodeSedia_ ); 
            rs.updateString(PROPERTY_KODEPENGGUNA , KodePengguna_ ); 
            rs.updateString(PROPERTY_KODELOKASI , KodeLokasi_ ); 
            rs.updateString(PROPERTY_TREND , Trend_ ); 
            rs.updateString(PROPERTY_TAHUN , Tahun_ ); 
            rs.updateString(PROPERTY_BULAN , Bulan_ ); 
            rs.updateString(PROPERTY_REVISI , Revisi_ ); 
            rs.updateString(PROPERTY_JENISBENDA , JenisBenda_ ); 
            rs.updateString(PROPERTY_NOMORURUT , NomorUrut_ ); 
            rs.updateString(PROPERTY_KODEKEMAS , KodeKemas_ ); 
            rs.updateString(PROPERTY_ARTIKEL , Artikel_ ); 
            rs.updateString(PROPERTY_PLANT , Plant_ ); 
            rs.updateString(PROPERTY_JENISPRODUK , JenisProduk_ ); 
            rs.updateString(PROPERTY_TIPEPRODUK , TipeProduk_ ); 
            rs.updateDouble(PROPERTY_HASILJADI , HasilJadi_ ); 
            rs.updateDouble(PROPERTY_ISI , Isi_ ); 
            rs.updateDouble(PROPERTY_ISIBOX , IsiBox_ ); 
            rs.updateDouble(PROPERTY_ISIVOL , IsiVol_ ); 
            rs.updateDouble(PROPERTY_ISIBOXPERPCS , IsiBoxPerPcs_ ); 
            rs.updateDouble(PROPERTY_BERATKARTONMASTER , BeratKartonMaster_ ); 
            rs.updateDouble(PROPERTY_INNERBOXMINWEIGHT , InnerBoxMinWeight_ ); 
            rs.updateDouble(PROPERTY_INNERBOXMAXWEIGHT , InnerBoxMaxWeight_ ); 
            rs.updateDouble(PROPERTY_MASTERBOXMINWEIGHT , MasterBoxMinWeight_ ); 
            rs.updateDouble(PROPERTY_MASTERBOXMAXWEIGHT , MasterBoxMaxWeight_ ); 
            rs.updateString(PROPERTY_PARETO , Pareto_ ); 
            rs.updateString(PROPERTY_VALID , Valid_ ); 
            rs.updateString(PROPERTY_STATUSNA , StatusNA_ ); 
            rs.updateString(PROPERTY_STATUS , Status_ ); 
            rs.updateDouble(PROPERTY_OUTPUTRAWMATRIAL , OutputRawMatrial_ ); 
            rs.updateDouble(PROPERTY_OUTPUTPACKINGMATRIAL , OutputPackingMatrial_ ); 
            rs.updateDouble(PROPERTY_HARGASTANDARD , HargaStandard_ ); 
            rs.updateDouble(PROPERTY_HARGAFAKTUR , HargaFaktur_ ); 
            rs.updateDouble(PROPERTY_HARGAMAKLUN , HargaMaklun_ ); 
            rs.updateDouble(PROPERTY_RAWMATRIAL , RawMatrial_ ); 
            rs.updateDouble(PROPERTY_PACKINGMATRIAL , PackingMatrial_ ); 
            rs.updateDouble(PROPERTY_MACHINERAWMATRIAL , MachineRawMatrial_ ); 
            rs.updateDouble(PROPERTY_MACHINEPACKINGMATRIAL , MachinePackingMatrial_ ); 
            rs.updateDouble(PROPERTY_DIRECTLABOURRAWMATRIAL , DirectLabourRawMatrial_ ); 
            rs.updateDouble(PROPERTY_DIRECTLABOURPACKINGMATRIAL , DirectLabourPackingMatrial_ ); 
            rs.updateDouble(PROPERTY_OVERHEADRAWMATRIAL , OverHeadRawMatrial_ ); 
            rs.updateDouble(PROPERTY_OVERHEADPACKINGMATRIAL , OverHeadPackingMatrial_ ); 
            rs.updateDouble(PROPERTY_OTHERS , Others_ ); 
            rs.updateDouble(PROPERTY_HJP , HJP_ ); 
            rs.updateDouble(PROPERTY_HJPEXT , HJPExt_ ); 
            rs.updateDouble(PROPERTY_MARGINCOGM , MarginCOGM_ ); 
            rs.updateDouble(PROPERTY_MARGINHJP , MarginHJP_ ); 
            rs.updateString(PROPERTY_NOMORREGISTRASI1 , NomorRegistrasi1_ ); 
           if (getTanggalRegistrasi1()==null) {
              rs.updateDate(PROPERTY_TANGGALREGISTRASI1 , null ); 
           }else{
              rs.updateDate(PROPERTY_TANGGALREGISTRASI1 , getTanggalRegistrasi1()); 
           }
            rs.updateLong(PROPERTY_STATUSREGISTRASI , StatusRegistrasi_ ); 
            rs.updateString(PROPERTY_NOMORREGISTRASI2 , NomorRegistrasi2_ ); 
           if (getTanggalRegistrasi2()==null) {
              rs.updateDate(PROPERTY_TANGGALREGISTRASI2 , null ); 
           }else{
              rs.updateDate(PROPERTY_TANGGALREGISTRASI2 , getTanggalRegistrasi2()); 
           }
            rs.updateLong(PROPERTY_STATUSREGISTRASI2 , StatusRegistrasi2_ ); 
            rs.updateString(PROPERTY_NOMORREGISTRASI3 , NomorRegistrasi3_ ); 
           if (getTanggalRegistrasi3()==null) {
              rs.updateDate(PROPERTY_TANGGALREGISTRASI3 , null ); 
           }else{
              rs.updateDate(PROPERTY_TANGGALREGISTRASI3 , getTanggalRegistrasi3()); 
           }
            rs.updateLong(PROPERTY_STATUSREGISTRASI3 , StatusRegistrasi3_ ); 
            rs.updateString(PROPERTY_STATUSHALAL , StatusHalal_ ); 
            rs.updateString(PROPERTY_STATUSHALALXX , StatusHalalXX_ ); 
            rs.updateLong(PROPERTY_JENISSALES , JenisSales_ ); 
            rs.updateString(PROPERTY_NAMAINNER , NamaInner_ ); 
            rs.updateString(PROPERTY_NAMABOKS , NamaBoks_ ); 
            rs.updateString(PROPERTY_BARCODE , Barcode_ ); 
            rs.updateString(PROPERTY_TEXTBARCODE , TextBarcode_ ); 
            rs.updateString(PROPERTY_KODEKELOMPOKBARCODE , KodeKelompokBarcode_ ); 
            rs.updateString(PROPERTY_KODESUBKELOMPOKBARCODE , KodeSubKelompokBarcode_ ); 
            rs.updateString(PROPERTY_PP , PP_ ); 
            rs.updateString(PROPERTY_PACK , PACK_ ); 
            rs.updateLong(PROPERTY_TIPEKEMAS , TipeKemas_ ); 
            rs.updateLong(PROPERTY_UMURSIMPAN , UmurSimpan_ ); 
            rs.updateLong(PROPERTY_PENOMORANBATCH , PenomoranBatch_ ); 
            rs.updateString(PROPERTY_MODELSERVICE , modelservice_ ); 
            if (getTanggalUpdate()==null) {
               rs.updateTimestamp(PROPERTY_TANGGALUPDATE ,   null ); 
            }else{
               rs.updateTimestamp(PROPERTY_TANGGALUPDATE ,  getTanggalUpdate()); 
            }
            if (getTanggalEntry()==null) {
               rs.updateTimestamp(PROPERTY_TANGGALENTRY ,   null ); 
            }else{
               rs.updateTimestamp(PROPERTY_TANGGALENTRY ,  getTanggalEntry()); 
            }
            rs.updateString(PROPERTY_USERID , UserID_ ); 
            rs.updateDouble(PROPERTY_BPHP , Bphp_ ); 
            rs.updateString(PROPERTY_TANDAPALETTE , TandaPalette_ ); 
            rs.updateString(PROPERTY_SESSIONID , SessionId_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Masterproduk obj = (Masterproduk) jCob;
        id_ = obj.getID();

        
          Aktif_ = obj.getAktif();
          TanggalAktif_ = obj.getTanggalAktif();
          KodeProduk_ = obj.getKodeProduk();
          KodeProdukLama_ = obj.getKodeProdukLama();
          KodeUniversal_ = obj.getKodeUniversal();
          KodeSAI_ = obj.getKodeSAI();
          NamaProduk_ = obj.getNamaProduk();
          NamaJadi_ = obj.getNamaJadi();
          Satuan_ = obj.getSatuan();
          KodeBrandLama_ = obj.getKodeBrandLama();
          KodeBrand_ = obj.getKodeBrand();
          KodeSubBrand_ = obj.getKodeSubBrand();
          KodeKelompok_ = obj.getKodeKelompok();
          KodeFungsi_ = obj.getKodeFungsi();
          KodeSubFungsi_ = obj.getKodeSubFungsi();
          KodeSeri_ = obj.getKodeSeri();
          KodeSedia_ = obj.getKodeSedia();
          KodePengguna_ = obj.getKodePengguna();
          KodeLokasi_ = obj.getKodeLokasi();
          Trend_ = obj.getTrend();
          Tahun_ = obj.getTahun();
          Bulan_ = obj.getBulan();
          Revisi_ = obj.getRevisi();
          JenisBenda_ = obj.getJenisBenda();
          NomorUrut_ = obj.getNomorUrut();
          KodeKemas_ = obj.getKodeKemas();
          Artikel_ = obj.getArtikel();
          Plant_ = obj.getPlant();
          JenisProduk_ = obj.getJenisProduk();
          TipeProduk_ = obj.getTipeProduk();
          HasilJadi_ = obj.getHasilJadi();
          Isi_ = obj.getIsi();
          IsiBox_ = obj.getIsiBox();
          IsiVol_ = obj.getIsiVol();
          IsiBoxPerPcs_ = obj.getIsiBoxPerPcs();
          BeratKartonMaster_ = obj.getBeratKartonMaster();
          InnerBoxMinWeight_ = obj.getInnerBoxMinWeight();
          InnerBoxMaxWeight_ = obj.getInnerBoxMaxWeight();
          MasterBoxMinWeight_ = obj.getMasterBoxMinWeight();
          MasterBoxMaxWeight_ = obj.getMasterBoxMaxWeight();
          Pareto_ = obj.getPareto();
          Valid_ = obj.getValid();
          StatusNA_ = obj.getStatusNA();
          Status_ = obj.getStatus();
          OutputRawMatrial_ = obj.getOutputRawMatrial();
          OutputPackingMatrial_ = obj.getOutputPackingMatrial();
          HargaStandard_ = obj.getHargaStandard();
          HargaFaktur_ = obj.getHargaFaktur();
          HargaMaklun_ = obj.getHargaMaklun();
          RawMatrial_ = obj.getRawMatrial();
          PackingMatrial_ = obj.getPackingMatrial();
          MachineRawMatrial_ = obj.getMachineRawMatrial();
          MachinePackingMatrial_ = obj.getMachinePackingMatrial();
          DirectLabourRawMatrial_ = obj.getDirectLabourRawMatrial();
          DirectLabourPackingMatrial_ = obj.getDirectLabourPackingMatrial();
          OverHeadRawMatrial_ = obj.getOverHeadRawMatrial();
          OverHeadPackingMatrial_ = obj.getOverHeadPackingMatrial();
          Others_ = obj.getOthers();
          HJP_ = obj.getHJP();
          HJPExt_ = obj.getHJPExt();
          MarginCOGM_ = obj.getMarginCOGM();
          MarginHJP_ = obj.getMarginHJP();
          NomorRegistrasi1_ = obj.getNomorRegistrasi1();
          TanggalRegistrasi1_ = obj.getTanggalRegistrasi1();
          StatusRegistrasi_ = obj.getStatusRegistrasi();
          NomorRegistrasi2_ = obj.getNomorRegistrasi2();
          TanggalRegistrasi2_ = obj.getTanggalRegistrasi2();
          StatusRegistrasi2_ = obj.getStatusRegistrasi2();
          NomorRegistrasi3_ = obj.getNomorRegistrasi3();
          TanggalRegistrasi3_ = obj.getTanggalRegistrasi3();
          StatusRegistrasi3_ = obj.getStatusRegistrasi3();
          StatusHalal_ = obj.getStatusHalal();
          StatusHalalXX_ = obj.getStatusHalalXX();
          JenisSales_ = obj.getJenisSales();
          NamaInner_ = obj.getNamaInner();
          NamaBoks_ = obj.getNamaBoks();
          Barcode_ = obj.getBarcode();
          TextBarcode_ = obj.getTextBarcode();
          KodeKelompokBarcode_ = obj.getKodeKelompokBarcode();
          KodeSubKelompokBarcode_ = obj.getKodeSubKelompokBarcode();
          PP_ = obj.getPP();
          PACK_ = obj.getPACK();
          TipeKemas_ = obj.getTipeKemas();
          UmurSimpan_ = obj.getUmurSimpan();
          PenomoranBatch_ = obj.getPenomoranBatch();
          modelservice_ = obj.getmodelservice();
          TanggalUpdate_ = obj.getTanggalUpdate();
          TanggalEntry_ = obj.getTanggalEntry();
          UserID_ = obj.getUserID();
          Bphp_ = obj.getBphp();
          TandaPalette_ = obj.getTandaPalette();
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

      public void setTanggalAktif(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalAktif_ = param; 
         _isDirty_ = true; 
      } 

      public Date getTanggalAktif() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalAktif_; 
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

      public void setKodeProdukLama(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeProdukLama_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeProdukLama() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeProdukLama_; 
      } 

      public void setKodeUniversal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeUniversal_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeUniversal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeUniversal_; 
      } 

      public void setKodeSAI(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSAI_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSAI() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSAI_; 
      } 

      public void setNamaProduk(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaProduk_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaProduk() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaProduk_; 
      } 

      public void setNamaJadi(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaJadi_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaJadi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaJadi_; 
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

      public void setKodeBrandLama(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeBrandLama_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeBrandLama() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeBrandLama_; 
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

      public void setKodeSubBrand(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSubBrand_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSubBrand() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSubBrand_; 
      } 

      public void setKodeKelompok(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeKelompok_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeKelompok() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeKelompok_; 
      } 

      public void setKodeFungsi(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeFungsi_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeFungsi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeFungsi_; 
      } 

      public void setKodeSubFungsi(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSubFungsi_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSubFungsi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSubFungsi_; 
      } 

      public void setKodeSeri(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSeri_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSeri() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSeri_; 
      } 

      public void setKodeSedia(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSedia_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSedia() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSedia_; 
      } 

      public void setKodePengguna(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodePengguna_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodePengguna() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodePengguna_; 
      } 

      public void setKodeLokasi(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeLokasi_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeLokasi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeLokasi_; 
      } 

      public void setTrend(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Trend_ = param; 
         _isDirty_ = true; 
      } 

      public String getTrend() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Trend_; 
      } 

      public void setTahun(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Tahun_ = param; 
         _isDirty_ = true; 
      } 

      public String getTahun() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Tahun_; 
      } 

      public void setBulan(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Bulan_ = param; 
         _isDirty_ = true; 
      } 

      public String getBulan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Bulan_; 
      } 

      public void setRevisi(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Revisi_ = param; 
         _isDirty_ = true; 
      } 

      public String getRevisi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Revisi_; 
      } 

      public void setJenisBenda(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         JenisBenda_ = param; 
         _isDirty_ = true; 
      } 

      public String getJenisBenda() throws CodeException {
         if (!_isLoaded_) { read();} 
         return JenisBenda_; 
      } 

      public void setNomorUrut(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorUrut_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorUrut() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorUrut_; 
      } 

      public void setKodeKemas(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeKemas_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeKemas() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeKemas_; 
      } 

      public void setArtikel(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Artikel_ = param; 
         _isDirty_ = true; 
      } 

      public String getArtikel() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Artikel_; 
      } 

      public void setPlant(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Plant_ = param; 
         _isDirty_ = true; 
      } 

      public String getPlant() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Plant_; 
      } 

      public void setJenisProduk(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         JenisProduk_ = param; 
         _isDirty_ = true; 
      } 

      public String getJenisProduk() throws CodeException {
         if (!_isLoaded_) { read();} 
         return JenisProduk_; 
      } 

      public void setTipeProduk(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TipeProduk_ = param; 
         _isDirty_ = true; 
      } 

      public String getTipeProduk() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TipeProduk_; 
      } 

      public void setHasilJadi(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HasilJadi_ = param; 
         _isDirty_ = true; 
      } 

      public double getHasilJadi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HasilJadi_; 
      } 

      public void setIsi(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Isi_ = param; 
         _isDirty_ = true; 
      } 

      public double getIsi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Isi_; 
      } 

      public void setIsiBox(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         IsiBox_ = param; 
         _isDirty_ = true; 
      } 

      public double getIsiBox() throws CodeException {
         if (!_isLoaded_) { read();} 
         return IsiBox_; 
      } 

      public void setIsiVol(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         IsiVol_ = param; 
         _isDirty_ = true; 
      } 

      public double getIsiVol() throws CodeException {
         if (!_isLoaded_) { read();} 
         return IsiVol_; 
      } 

      public void setIsiBoxPerPcs(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         IsiBoxPerPcs_ = param; 
         _isDirty_ = true; 
      } 

      public double getIsiBoxPerPcs() throws CodeException {
         if (!_isLoaded_) { read();} 
         return IsiBoxPerPcs_; 
      } 

      public void setBeratKartonMaster(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         BeratKartonMaster_ = param; 
         _isDirty_ = true; 
      } 

      public double getBeratKartonMaster() throws CodeException {
         if (!_isLoaded_) { read();} 
         return BeratKartonMaster_; 
      } 

      public void setInnerBoxMinWeight(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         InnerBoxMinWeight_ = param; 
         _isDirty_ = true; 
      } 

      public double getInnerBoxMinWeight() throws CodeException {
         if (!_isLoaded_) { read();} 
         return InnerBoxMinWeight_; 
      } 

      public void setInnerBoxMaxWeight(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         InnerBoxMaxWeight_ = param; 
         _isDirty_ = true; 
      } 

      public double getInnerBoxMaxWeight() throws CodeException {
         if (!_isLoaded_) { read();} 
         return InnerBoxMaxWeight_; 
      } 

      public void setMasterBoxMinWeight(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MasterBoxMinWeight_ = param; 
         _isDirty_ = true; 
      } 

      public double getMasterBoxMinWeight() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MasterBoxMinWeight_; 
      } 

      public void setMasterBoxMaxWeight(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MasterBoxMaxWeight_ = param; 
         _isDirty_ = true; 
      } 

      public double getMasterBoxMaxWeight() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MasterBoxMaxWeight_; 
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

      public void setValid(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Valid_ = param; 
         _isDirty_ = true; 
      } 

      public String getValid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Valid_; 
      } 

      public void setStatusNA(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusNA_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatusNA() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusNA_; 
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

      public void setOutputRawMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         OutputRawMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getOutputRawMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return OutputRawMatrial_; 
      } 

      public void setOutputPackingMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         OutputPackingMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getOutputPackingMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return OutputPackingMatrial_; 
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

      public void setHargaFaktur(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HargaFaktur_ = param; 
         _isDirty_ = true; 
      } 

      public double getHargaFaktur() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HargaFaktur_; 
      } 

      public void setHargaMaklun(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HargaMaklun_ = param; 
         _isDirty_ = true; 
      } 

      public double getHargaMaklun() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HargaMaklun_; 
      } 

      public void setRawMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         RawMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getRawMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return RawMatrial_; 
      } 

      public void setPackingMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PackingMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getPackingMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PackingMatrial_; 
      } 

      public void setMachineRawMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MachineRawMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getMachineRawMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MachineRawMatrial_; 
      } 

      public void setMachinePackingMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MachinePackingMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getMachinePackingMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MachinePackingMatrial_; 
      } 

      public void setDirectLabourRawMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         DirectLabourRawMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getDirectLabourRawMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return DirectLabourRawMatrial_; 
      } 

      public void setDirectLabourPackingMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         DirectLabourPackingMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getDirectLabourPackingMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return DirectLabourPackingMatrial_; 
      } 

      public void setOverHeadRawMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         OverHeadRawMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getOverHeadRawMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return OverHeadRawMatrial_; 
      } 

      public void setOverHeadPackingMatrial(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         OverHeadPackingMatrial_ = param; 
         _isDirty_ = true; 
      } 

      public double getOverHeadPackingMatrial() throws CodeException {
         if (!_isLoaded_) { read();} 
         return OverHeadPackingMatrial_; 
      } 

      public void setOthers(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Others_ = param; 
         _isDirty_ = true; 
      } 

      public double getOthers() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Others_; 
      } 

      public void setHJP(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HJP_ = param; 
         _isDirty_ = true; 
      } 

      public double getHJP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HJP_; 
      } 

      public void setHJPExt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         HJPExt_ = param; 
         _isDirty_ = true; 
      } 

      public double getHJPExt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return HJPExt_; 
      } 

      public void setMarginCOGM(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MarginCOGM_ = param; 
         _isDirty_ = true; 
      } 

      public double getMarginCOGM() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MarginCOGM_; 
      } 

      public void setMarginHJP(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         MarginHJP_ = param; 
         _isDirty_ = true; 
      } 

      public double getMarginHJP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return MarginHJP_; 
      } 

      public void setNomorRegistrasi1(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorRegistrasi1_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorRegistrasi1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorRegistrasi1_; 
      } 

      public void setTanggalRegistrasi1(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalRegistrasi1_ = param; 
         _isDirty_ = true; 
      } 

      public Date getTanggalRegistrasi1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalRegistrasi1_; 
      } 

      public void setStatusRegistrasi(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusRegistrasi_ = param; 
         _isDirty_ = true; 
      } 

      public long getStatusRegistrasi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusRegistrasi_; 
      } 

      public void setNomorRegistrasi2(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorRegistrasi2_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorRegistrasi2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorRegistrasi2_; 
      } 

      public void setTanggalRegistrasi2(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalRegistrasi2_ = param; 
         _isDirty_ = true; 
      } 

      public Date getTanggalRegistrasi2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalRegistrasi2_; 
      } 

      public void setStatusRegistrasi2(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusRegistrasi2_ = param; 
         _isDirty_ = true; 
      } 

      public long getStatusRegistrasi2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusRegistrasi2_; 
      } 

      public void setNomorRegistrasi3(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NomorRegistrasi3_ = param; 
         _isDirty_ = true; 
      } 

      public String getNomorRegistrasi3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NomorRegistrasi3_; 
      } 

      public void setTanggalRegistrasi3(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalRegistrasi3_ = param; 
         _isDirty_ = true; 
      } 

      public Date getTanggalRegistrasi3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalRegistrasi3_; 
      } 

      public void setStatusRegistrasi3(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusRegistrasi3_ = param; 
         _isDirty_ = true; 
      } 

      public long getStatusRegistrasi3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusRegistrasi3_; 
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

      public void setStatusHalalXX(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         StatusHalalXX_ = param; 
         _isDirty_ = true; 
      } 

      public String getStatusHalalXX() throws CodeException {
         if (!_isLoaded_) { read();} 
         return StatusHalalXX_; 
      } 

      public void setJenisSales(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         JenisSales_ = param; 
         _isDirty_ = true; 
      } 

      public long getJenisSales() throws CodeException {
         if (!_isLoaded_) { read();} 
         return JenisSales_; 
      } 

      public void setNamaInner(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaInner_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaInner() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaInner_; 
      } 

      public void setNamaBoks(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         NamaBoks_ = param; 
         _isDirty_ = true; 
      } 

      public String getNamaBoks() throws CodeException {
         if (!_isLoaded_) { read();} 
         return NamaBoks_; 
      } 

      public void setBarcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Barcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getBarcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Barcode_; 
      } 

      public void setTextBarcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TextBarcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getTextBarcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TextBarcode_; 
      } 

      public void setKodeKelompokBarcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeKelompokBarcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeKelompokBarcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeKelompokBarcode_; 
      } 

      public void setKodeSubKelompokBarcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeSubKelompokBarcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeSubKelompokBarcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeSubKelompokBarcode_; 
      } 

      public void setPP(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PP_ = param; 
         _isDirty_ = true; 
      } 

      public String getPP() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PP_; 
      } 

      public void setPACK(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PACK_ = param; 
         _isDirty_ = true; 
      } 

      public String getPACK() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PACK_; 
      } 

      public void setTipeKemas(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TipeKemas_ = param; 
         _isDirty_ = true; 
      } 

      public long getTipeKemas() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TipeKemas_; 
      } 

      public void setUmurSimpan(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         UmurSimpan_ = param; 
         _isDirty_ = true; 
      } 

      public long getUmurSimpan() throws CodeException {
         if (!_isLoaded_) { read();} 
         return UmurSimpan_; 
      } 

      public void setPenomoranBatch(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         PenomoranBatch_ = param; 
         _isDirty_ = true; 
      } 

      public long getPenomoranBatch() throws CodeException {
         if (!_isLoaded_) { read();} 
         return PenomoranBatch_; 
      } 

      public void setmodelservice(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         modelservice_ = param; 
         _isDirty_ = true; 
      } 

      public String getmodelservice() throws CodeException {
         if (!_isLoaded_) { read();} 
         return modelservice_; 
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

      public void setTanggalEntry(Timestamp param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalEntry_ = param; 
         _isDirty_ = true; 
      } 

      public Timestamp getTanggalEntry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalEntry_; 
      } 

      public void setUserID(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         UserID_ = param; 
         _isDirty_ = true; 
      } 

      public String getUserID() throws CodeException {
         if (!_isLoaded_) { read();} 
         return UserID_; 
      } 

      public void setBphp(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Bphp_ = param; 
         _isDirty_ = true; 
      } 

      public double getBphp() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Bphp_; 
      } 

      public void setTandaPalette(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TandaPalette_ = param; 
         _isDirty_ = true; 
      } 

      public String getTandaPalette() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TandaPalette_; 
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
           else if (param.equals(PROPERTY_TANGGALAKTIF)) return getTanggalAktif()  == null ? "" :dateformat.format(getTanggalAktif()); 
           else if (param.equals(PROPERTY_KODEPRODUK)) return getKodeProduk(); 
           else if (param.equals(PROPERTY_KODEPRODUKLAMA)) return getKodeProdukLama(); 
           else if (param.equals(PROPERTY_KODEUNIVERSAL)) return getKodeUniversal(); 
           else if (param.equals(PROPERTY_KODESAI)) return getKodeSAI(); 
           else if (param.equals(PROPERTY_NAMAPRODUK)) return getNamaProduk(); 
           else if (param.equals(PROPERTY_NAMAJADI)) return getNamaJadi(); 
           else if (param.equals(PROPERTY_SATUAN)) return getSatuan(); 
           else if (param.equals(PROPERTY_KODEBRANDLAMA)) return getKodeBrandLama(); 
           else if (param.equals(PROPERTY_KODEBRAND)) return getKodeBrand(); 
           else if (param.equals(PROPERTY_KODESUBBRAND)) return getKodeSubBrand(); 
           else if (param.equals(PROPERTY_KODEKELOMPOK)) return getKodeKelompok(); 
           else if (param.equals(PROPERTY_KODEFUNGSI)) return getKodeFungsi(); 
           else if (param.equals(PROPERTY_KODESUBFUNGSI)) return getKodeSubFungsi(); 
           else if (param.equals(PROPERTY_KODESERI)) return getKodeSeri(); 
           else if (param.equals(PROPERTY_KODESEDIA)) return getKodeSedia(); 
           else if (param.equals(PROPERTY_KODEPENGGUNA)) return getKodePengguna(); 
           else if (param.equals(PROPERTY_KODELOKASI)) return getKodeLokasi(); 
           else if (param.equals(PROPERTY_TREND)) return getTrend(); 
           else if (param.equals(PROPERTY_TAHUN)) return getTahun(); 
           else if (param.equals(PROPERTY_BULAN)) return getBulan(); 
           else if (param.equals(PROPERTY_REVISI)) return getRevisi(); 
           else if (param.equals(PROPERTY_JENISBENDA)) return getJenisBenda(); 
           else if (param.equals(PROPERTY_NOMORURUT)) return getNomorUrut(); 
           else if (param.equals(PROPERTY_KODEKEMAS)) return getKodeKemas(); 
           else if (param.equals(PROPERTY_ARTIKEL)) return getArtikel(); 
           else if (param.equals(PROPERTY_PLANT)) return getPlant(); 
           else if (param.equals(PROPERTY_JENISPRODUK)) return getJenisProduk(); 
           else if (param.equals(PROPERTY_TIPEPRODUK)) return getTipeProduk(); 
           else if (param.equals(PROPERTY_HASILJADI)) return decform.format(getHasilJadi()); 
           else if (param.equals(PROPERTY_ISI)) return decform.format(getIsi()); 
           else if (param.equals(PROPERTY_ISIBOX)) return decform.format(getIsiBox()); 
           else if (param.equals(PROPERTY_ISIVOL)) return decform.format(getIsiVol()); 
           else if (param.equals(PROPERTY_ISIBOXPERPCS)) return decform.format(getIsiBoxPerPcs()); 
           else if (param.equals(PROPERTY_BERATKARTONMASTER)) return decform.format(getBeratKartonMaster()); 
           else if (param.equals(PROPERTY_INNERBOXMINWEIGHT)) return decform.format(getInnerBoxMinWeight()); 
           else if (param.equals(PROPERTY_INNERBOXMAXWEIGHT)) return decform.format(getInnerBoxMaxWeight()); 
           else if (param.equals(PROPERTY_MASTERBOXMINWEIGHT)) return decform.format(getMasterBoxMinWeight()); 
           else if (param.equals(PROPERTY_MASTERBOXMAXWEIGHT)) return decform.format(getMasterBoxMaxWeight()); 
           else if (param.equals(PROPERTY_PARETO)) return getPareto(); 
           else if (param.equals(PROPERTY_VALID)) return getValid(); 
           else if (param.equals(PROPERTY_STATUSNA)) return getStatusNA(); 
           else if (param.equals(PROPERTY_STATUS)) return getStatus(); 
           else if (param.equals(PROPERTY_OUTPUTRAWMATRIAL)) return decform.format(getOutputRawMatrial()); 
           else if (param.equals(PROPERTY_OUTPUTPACKINGMATRIAL)) return decform.format(getOutputPackingMatrial()); 
           else if (param.equals(PROPERTY_HARGASTANDARD)) return decform.format(getHargaStandard()); 
           else if (param.equals(PROPERTY_HARGAFAKTUR)) return decform.format(getHargaFaktur()); 
           else if (param.equals(PROPERTY_HARGAMAKLUN)) return decform.format(getHargaMaklun()); 
           else if (param.equals(PROPERTY_RAWMATRIAL)) return decform.format(getRawMatrial()); 
           else if (param.equals(PROPERTY_PACKINGMATRIAL)) return decform.format(getPackingMatrial()); 
           else if (param.equals(PROPERTY_MACHINERAWMATRIAL)) return decform.format(getMachineRawMatrial()); 
           else if (param.equals(PROPERTY_MACHINEPACKINGMATRIAL)) return decform.format(getMachinePackingMatrial()); 
           else if (param.equals(PROPERTY_DIRECTLABOURRAWMATRIAL)) return decform.format(getDirectLabourRawMatrial()); 
           else if (param.equals(PROPERTY_DIRECTLABOURPACKINGMATRIAL)) return decform.format(getDirectLabourPackingMatrial()); 
           else if (param.equals(PROPERTY_OVERHEADRAWMATRIAL)) return decform.format(getOverHeadRawMatrial()); 
           else if (param.equals(PROPERTY_OVERHEADPACKINGMATRIAL)) return decform.format(getOverHeadPackingMatrial()); 
           else if (param.equals(PROPERTY_OTHERS)) return decform.format(getOthers()); 
           else if (param.equals(PROPERTY_HJP)) return decform.format(getHJP()); 
           else if (param.equals(PROPERTY_HJPEXT)) return decform.format(getHJPExt()); 
           else if (param.equals(PROPERTY_MARGINCOGM)) return decform.format(getMarginCOGM()); 
           else if (param.equals(PROPERTY_MARGINHJP)) return decform.format(getMarginHJP()); 
           else if (param.equals(PROPERTY_NOMORREGISTRASI1)) return getNomorRegistrasi1(); 
           else if (param.equals(PROPERTY_TANGGALREGISTRASI1)) return getTanggalRegistrasi1()  == null ? "" :dateformat.format(getTanggalRegistrasi1()); 
           else if (param.equals(PROPERTY_STATUSREGISTRASI)) return String.valueOf(getStatusRegistrasi()); 
           else if (param.equals(PROPERTY_NOMORREGISTRASI2)) return getNomorRegistrasi2(); 
           else if (param.equals(PROPERTY_TANGGALREGISTRASI2)) return getTanggalRegistrasi2()  == null ? "" :dateformat.format(getTanggalRegistrasi2()); 
           else if (param.equals(PROPERTY_STATUSREGISTRASI2)) return String.valueOf(getStatusRegistrasi2()); 
           else if (param.equals(PROPERTY_NOMORREGISTRASI3)) return getNomorRegistrasi3(); 
           else if (param.equals(PROPERTY_TANGGALREGISTRASI3)) return getTanggalRegistrasi3()  == null ? "" :dateformat.format(getTanggalRegistrasi3()); 
           else if (param.equals(PROPERTY_STATUSREGISTRASI3)) return String.valueOf(getStatusRegistrasi3()); 
           else if (param.equals(PROPERTY_STATUSHALAL)) return getStatusHalal(); 
           else if (param.equals(PROPERTY_STATUSHALALXX)) return getStatusHalalXX(); 
           else if (param.equals(PROPERTY_JENISSALES)) return String.valueOf(getJenisSales()); 
           else if (param.equals(PROPERTY_NAMAINNER)) return getNamaInner(); 
           else if (param.equals(PROPERTY_NAMABOKS)) return getNamaBoks(); 
           else if (param.equals(PROPERTY_BARCODE)) return getBarcode(); 
           else if (param.equals(PROPERTY_TEXTBARCODE)) return getTextBarcode(); 
           else if (param.equals(PROPERTY_KODEKELOMPOKBARCODE)) return getKodeKelompokBarcode(); 
           else if (param.equals(PROPERTY_KODESUBKELOMPOKBARCODE)) return getKodeSubKelompokBarcode(); 
           else if (param.equals(PROPERTY_PP)) return getPP(); 
           else if (param.equals(PROPERTY_PACK)) return getPACK(); 
           else if (param.equals(PROPERTY_TIPEKEMAS)) return String.valueOf(getTipeKemas()); 
           else if (param.equals(PROPERTY_UMURSIMPAN)) return String.valueOf(getUmurSimpan()); 
           else if (param.equals(PROPERTY_PENOMORANBATCH)) return String.valueOf(getPenomoranBatch()); 
           else if (param.equals(PROPERTY_MODELSERVICE)) return getmodelservice(); 
           else if (param.equals(PROPERTY_TANGGALUPDATE)) return getTanggalUpdate()  == null || getTanggalUpdate().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalUpdate()) ; 
           else if (param.equals(PROPERTY_TANGGALENTRY)) return getTanggalEntry()  == null || getTanggalEntry().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalEntry()) ; 
           else if (param.equals(PROPERTY_USERID)) return getUserID(); 
           else if (param.equals(PROPERTY_BPHP)) return decform.format(getBphp()); 
           else if (param.equals(PROPERTY_TANDAPALETTE)) return getTandaPalette(); 
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
           else if (param.equals(PROPERTY_TANGGALAKTIF)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalAktif(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setTanggalAktif(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_KODEPRODUK))  setKodeProduk(value); 
           else if (param.equals(PROPERTY_KODEPRODUKLAMA))  setKodeProdukLama(value); 
           else if (param.equals(PROPERTY_KODEUNIVERSAL))  setKodeUniversal(value); 
           else if (param.equals(PROPERTY_KODESAI))  setKodeSAI(value); 
           else if (param.equals(PROPERTY_NAMAPRODUK))  setNamaProduk(value); 
           else if (param.equals(PROPERTY_NAMAJADI))  setNamaJadi(value); 
           else if (param.equals(PROPERTY_SATUAN))  setSatuan(value); 
           else if (param.equals(PROPERTY_KODEBRANDLAMA))  setKodeBrandLama(value); 
           else if (param.equals(PROPERTY_KODEBRAND))  setKodeBrand(value); 
           else if (param.equals(PROPERTY_KODESUBBRAND))  setKodeSubBrand(value); 
           else if (param.equals(PROPERTY_KODEKELOMPOK))  setKodeKelompok(value); 
           else if (param.equals(PROPERTY_KODEFUNGSI))  setKodeFungsi(value); 
           else if (param.equals(PROPERTY_KODESUBFUNGSI))  setKodeSubFungsi(value); 
           else if (param.equals(PROPERTY_KODESERI))  setKodeSeri(value); 
           else if (param.equals(PROPERTY_KODESEDIA))  setKodeSedia(value); 
           else if (param.equals(PROPERTY_KODEPENGGUNA))  setKodePengguna(value); 
           else if (param.equals(PROPERTY_KODELOKASI))  setKodeLokasi(value); 
           else if (param.equals(PROPERTY_TREND))  setTrend(value); 
           else if (param.equals(PROPERTY_TAHUN))  setTahun(value); 
           else if (param.equals(PROPERTY_BULAN))  setBulan(value); 
           else if (param.equals(PROPERTY_REVISI))  setRevisi(value); 
           else if (param.equals(PROPERTY_JENISBENDA))  setJenisBenda(value); 
           else if (param.equals(PROPERTY_NOMORURUT))  setNomorUrut(value); 
           else if (param.equals(PROPERTY_KODEKEMAS))  setKodeKemas(value); 
           else if (param.equals(PROPERTY_ARTIKEL))  setArtikel(value); 
           else if (param.equals(PROPERTY_PLANT))  setPlant(value); 
           else if (param.equals(PROPERTY_JENISPRODUK))  setJenisProduk(value); 
           else if (param.equals(PROPERTY_TIPEPRODUK))  setTipeProduk(value); 
           else if (param.equals(PROPERTY_HASILJADI)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHasilJadi(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ISI)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setIsi(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ISIBOX)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setIsiBox(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ISIVOL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setIsiVol(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ISIBOXPERPCS)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setIsiBoxPerPcs(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BERATKARTONMASTER)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setBeratKartonMaster(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INNERBOXMINWEIGHT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setInnerBoxMinWeight(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INNERBOXMAXWEIGHT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setInnerBoxMaxWeight(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MASTERBOXMINWEIGHT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMasterBoxMinWeight(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MASTERBOXMAXWEIGHT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMasterBoxMaxWeight(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PARETO))  setPareto(value); 
           else if (param.equals(PROPERTY_VALID))  setValid(value); 
           else if (param.equals(PROPERTY_STATUSNA))  setStatusNA(value); 
           else if (param.equals(PROPERTY_STATUS))  setStatus(value); 
           else if (param.equals(PROPERTY_OUTPUTRAWMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setOutputRawMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_OUTPUTPACKINGMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setOutputPackingMatrial(newVal); 
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
           else if (param.equals(PROPERTY_HARGAFAKTUR)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHargaFaktur(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HARGAMAKLUN)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHargaMaklun(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RAWMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setRawMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PACKINGMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setPackingMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MACHINERAWMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMachineRawMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MACHINEPACKINGMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMachinePackingMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DIRECTLABOURRAWMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setDirectLabourRawMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DIRECTLABOURPACKINGMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setDirectLabourPackingMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_OVERHEADRAWMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setOverHeadRawMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_OVERHEADPACKINGMATRIAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setOverHeadPackingMatrial(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_OTHERS)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setOthers(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HJP)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHJP(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_HJPEXT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setHJPExt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MARGINCOGM)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMarginCOGM(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MARGINHJP)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setMarginHJP(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NOMORREGISTRASI1))  setNomorRegistrasi1(value); 
           else if (param.equals(PROPERTY_TANGGALREGISTRASI1)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalRegistrasi1(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setTanggalRegistrasi1(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_STATUSREGISTRASI)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setStatusRegistrasi(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NOMORREGISTRASI2))  setNomorRegistrasi2(value); 
           else if (param.equals(PROPERTY_TANGGALREGISTRASI2)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalRegistrasi2(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setTanggalRegistrasi2(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_STATUSREGISTRASI2)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setStatusRegistrasi2(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NOMORREGISTRASI3))  setNomorRegistrasi3(value); 
           else if (param.equals(PROPERTY_TANGGALREGISTRASI3)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalRegistrasi3(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setTanggalRegistrasi3(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_STATUSREGISTRASI3)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setStatusRegistrasi3(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_STATUSHALAL))  setStatusHalal(value); 
           else if (param.equals(PROPERTY_STATUSHALALXX))  setStatusHalalXX(value); 
           else if (param.equals(PROPERTY_JENISSALES)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setJenisSales(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NAMAINNER))  setNamaInner(value); 
           else if (param.equals(PROPERTY_NAMABOKS))  setNamaBoks(value); 
           else if (param.equals(PROPERTY_BARCODE))  setBarcode(value); 
           else if (param.equals(PROPERTY_TEXTBARCODE))  setTextBarcode(value); 
           else if (param.equals(PROPERTY_KODEKELOMPOKBARCODE))  setKodeKelompokBarcode(value); 
           else if (param.equals(PROPERTY_KODESUBKELOMPOKBARCODE))  setKodeSubKelompokBarcode(value); 
           else if (param.equals(PROPERTY_PP))  setPP(value); 
           else if (param.equals(PROPERTY_PACK))  setPACK(value); 
           else if (param.equals(PROPERTY_TIPEKEMAS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setTipeKemas(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_UMURSIMPAN)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setUmurSimpan(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PENOMORANBATCH)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setPenomoranBatch(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MODELSERVICE))  setmodelservice(value); 
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
           else if (param.equals(PROPERTY_USERID))  setUserID(value); 
           else if (param.equals(PROPERTY_BPHP)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setBphp(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TANDAPALETTE))  setTandaPalette(value); 
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
            throw new CodeException("Masterproduk : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, KodeProduk_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Masterproduk : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, KodeProduk_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Masterproduk : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Masterproduk : Cannot Move Last " + ex.getMessage());
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



