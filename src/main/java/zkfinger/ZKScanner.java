package zkfinger;

import com.zkteco.biometric.FingerprintSensorErrorCode;
import com.zkteco.biometric.FingerprintSensorEx;
import factory.DAOFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import models.Empreinte;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import jframes.FrameModel;

public class ZKScanner {
	//for verify test
	private byte[] lastRegTemp = new byte[2048];
	//the length of lastRegTemp
	private int cbRegTemp = 0;
	//pre-register template
	private byte[][] regtemparray = new byte[3][2048];
	//Register
	private boolean bRegister = false;
	//Identify
	private boolean bIdentify = true;
	//finger id
	private int iFid = 1;
	
	private int nFakeFunOn = 1;
	//must be 3
	static final int enroll_cnt = 3;
	//the index of pre-register function
	private int enroll_idx = 0;


    private byte[] imgbuf = null;
    private byte[] template = new byte[2048];
    private int[] templateLen = new int[1];
    
    //the width of fingerprint image
    int fpWidth = 0;
    //the height of fingerprint image
    int fpHeight = 0;
    
    private long mhDevice = 0;
    private long mhDB = 0;
    
    private static ZKScanner scanner;
    public boolean mbStop = true;
    private boolean openned = false;
    
    public static ZKScanner getInstance() {
    
        if (scanner == null) {
            scanner = new ZKScanner();
        }
    
        return scanner;
        
    }
        
   
    public void resetValue(){


}
    
    public void FreeSensor(Thread thread)
	{
		mbStop = true;
		if (0 != mhDB)
		{
			FingerprintSensorEx.DBFree(mhDB);
			mhDB = 0;
		}
		if (0 != mhDevice)
		{
			FingerprintSensorEx.CloseDevice(mhDevice);
			mhDevice = 0;
                        
		}
		FingerprintSensorEx.Terminate();
	}
    
     public void demarrer(FrameModel e){
        
        if (0 != mhDevice)
        {
          /*  JOptionPane.showMessageDialog(e,"Veuillez reconnecter!", "Message", JOptionPane.WARNING_MESSAGE);
            System.out.println("mhDevice 2 = " + mhDevice);*/
 
            return;
        }
	int ret = FingerprintSensorErrorCode.ZKFP_ERR_OK;
        cbRegTemp = 0;
        bRegister = false;
        bIdentify = false;
        iFid = 1;
        enroll_idx = 0;
        if (FingerprintSensorErrorCode.ZKFP_ERR_OK != FingerprintSensorEx.Init())
        {
 JOptionPane.showMessageDialog(e,"Init failed!", "Message", JOptionPane.WARNING_MESSAGE);
                return;
        }
        ret = FingerprintSensorEx.GetDeviceCount();
        if (ret < 0)
        {
JOptionPane.showMessageDialog(e,"No devices connected!", "Message", JOptionPane.WARNING_MESSAGE);
                FreeSensor(e.thread);
                return;
        }
        if (0 == (mhDevice = FingerprintSensorEx.OpenDevice(0)))
        {
JOptionPane.showMessageDialog(e,"Open device fail, ret = " + ret + " !", "Message", JOptionPane.WARNING_MESSAGE);
                FreeSensor(e.thread);
                return;
        }
        if (0 == (mhDB = FingerprintSensorEx.DBInit()))
        {
JOptionPane.showMessageDialog(e,"Init DB fail, ret = " + ret + "!", "Message", JOptionPane.WARNING_MESSAGE);
                 FreeSensor(e.thread);
                return;
        }


        int nFmt = 0;	
        FingerprintSensorEx.DBSetParameter(mhDB,  5010, nFmt);				

        byte[] paramValue = new byte[4];
        int[] size = new int[1];

        size[0] = 4;
        FingerprintSensorEx.GetParameters(mhDevice, 1, paramValue, size);
        fpWidth = byteArrayToInt(paramValue);
        size[0] = 4;
        FingerprintSensorEx.GetParameters(mhDevice, 2, paramValue, size);
        fpHeight = byteArrayToInt(paramValue);
        imgbuf = new byte[fpWidth*fpHeight];
        mbStop = false;
  JOptionPane.showMessageDialog(e,"Scanner connecté", "Message", JOptionPane.WARNING_MESSAGE);
           

    }  


    public void demarrer1(FrameModel e){
        
        if (0 != mhDevice)
        {
          /*  JOptionPane.showMessageDialog(e,"Veuillez reconnecter!", "Message", JOptionPane.WARNING_MESSAGE);
            System.out.println("mhDevice 2 = " + mhDevice);*/
 
            return;
        }
	int ret = FingerprintSensorErrorCode.ZKFP_ERR_OK;
        cbRegTemp = 0;
        bRegister = false;
        bIdentify = false;
        iFid = 1;
        enroll_idx = 0;
        if (FingerprintSensorErrorCode.ZKFP_ERR_OK != FingerprintSensorEx.Init())
        {
 JOptionPane.showMessageDialog(e,"Init failed!", "Message", JOptionPane.WARNING_MESSAGE);
                return;
        }
        ret = FingerprintSensorEx.GetDeviceCount();
        if (ret < 0)
        {
JOptionPane.showMessageDialog(e,"No devices connected!", "Message", JOptionPane.WARNING_MESSAGE);
                FreeSensor(e.thread);
                return;
        }
        if (0 == (mhDevice = FingerprintSensorEx.OpenDevice(0)))
        {
JOptionPane.showMessageDialog(e,"Open device fail, ret = " + ret + " !", "Message", JOptionPane.WARNING_MESSAGE);
                FreeSensor(e.thread);
                return;
        }
        if (0 == (mhDB = FingerprintSensorEx.DBInit()))
        {
JOptionPane.showMessageDialog(e,"Init DB fail, ret = " + ret + "!", "Message", JOptionPane.WARNING_MESSAGE);
                 FreeSensor(e.thread);
                return;
        }


        int nFmt = 0;	
        FingerprintSensorEx.DBSetParameter(mhDB,  5010, nFmt);				

        byte[] paramValue = new byte[4];
        int[] size = new int[1];

        size[0] = 4;
        FingerprintSensorEx.GetParameters(mhDevice, 1, paramValue, size);
        fpWidth = byteArrayToInt(paramValue);
        size[0] = 4;
        FingerprintSensorEx.GetParameters(mhDevice, 2, paramValue, size);
        fpHeight = byteArrayToInt(paramValue);
        imgbuf = new byte[fpWidth*fpHeight];
        mbStop = false;
  //JOptionPane.showMessageDialog(e,"Scanner connecté", "Message", JOptionPane.WARNING_MESSAGE);
           

    }
   

   /* public String open(){
        
        openned = false;
    
        if (0 != mhDevice) {

            return "Fermer ld'abord le scanner"; 
           
        }
        
        if (FingerprintSensorErrorCode.ZKFP_ERR_OK != FingerprintSensorEx.Init()) {
            return "Erreur d'initiation du Scanner";
        }
        
        if(FingerprintSensorEx.GetDeviceCount() < 0){
            return "Aucun n'appareil est connecté";
                 
        }
        
        mhDevice = FingerprintSensorEx.OpenDevice(0); 
        
        if (0 == mhDevice) {
            return "Erreur pendant l'ouverture du scanner";     
        }
        
        mhDB = FingerprintSensorEx.DBInit();
        
        if(0 == mhDB){
            return "Erreur pendant l'initiation du DB";
        }
        
        if (0 == FingerprintSensorEx.DBSetParameter(mhDB,  5010, 0)){
        
            byte[] paramValue = new byte[4];
            int[] size = new int[1];
            size[0] = 4;
            FingerprintSensorEx.GetParameters(mhDevice, 1, paramValue, size);
            fpWidth = byteArrayToInt(paramValue);
            size[0] = 4;
            FingerprintSensorEx.GetParameters(mhDevice, 2, paramValue, size);
            fpHeight = byteArrayToInt(paramValue);

            imgbuf = new byte[fpWidth*fpHeight];
        
        }	// 0 pour AINSI, 1 pour ISO	
       
        openned = true;
        
        return "Scanner connecté et bien activé";
    
    }  */
   
    
    public boolean isOpenned (){
    
        return openned;
    
    }
    
    public boolean capture(){
        templateLen[0] = 2048;
        if (0 == FingerprintSensorEx.AcquireFingerprint(mhDevice, imgbuf, template, templateLen)){
            try {
                writeBitmap(imgbuf, fpWidth, fpHeight, "fingerprint.bmp");
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ZKScanner.class.getName()).log(Level.SEVERE, null, ex);
                
            }         
      
        }
        
        return false;
    
    }
    
    public ZKScannerMatch match(){
    
        ZKScannerMatch match = new ZKScannerMatch(0, null);
        byte[] temp0 = new byte[2048];
        byte []template1 = new byte[2048];
        
        int[] tempLen0 = new int[1];
        int[] templateLen1 = new int[1];
        
        
        tempLen0[0] = 2048;
        FingerprintSensorEx.ExtractFromImage( mhDB, "fingerprint.bmp", 500, temp0, tempLen0);
        
        for (Empreinte empreinte : DAOFactory.getEmpreinteDAO().getAll()) {
            
            templateLen1[0] = 2048;
            
            try{
                InputStream is = empreinte.getImage().getBinaryStream(1, (int) empreinte.getImage().length());

                BufferedImage imag= ImageIO.read(is);


                ImageIO.write(imag, "bmp", new File("fingerprint1.bmp"));

                FingerprintSensorEx.ExtractFromImage( mhDB, "fingerprint1.bmp", 500, template1, templateLen1);
                
                match.score = FingerprintSensorEx.DBMatch(mhDB, template1, temp0);
                File delete=new File("fingerprint1.bmp");
                delete.delete();
                if (match.score > 0) {
                    match.empreinte = empreinte;
                    break;
                }
            
            } catch (IOException | SQLException e){
                Logger.getLogger(ZKScanner.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        return match;
    }
    
     public ZKScannerMatch match(String matricule){
    
        ZKScannerMatch match = new ZKScannerMatch(0, null);
        byte[] temp0 = new byte[2048];
        byte []template1 = new byte[2048];
        
        int[] tempLen0 = new int[1];
        int[] templateLen1 = new int[1];
        
        
        tempLen0[0] = 2048;
        FingerprintSensorEx.ExtractFromImage( mhDB, "fingerprint.bmp", 500, temp0, tempLen0);
        
        for (Empreinte empreinte : DAOFactory.getEmpreinteDAO().getAllEmpreinte(matricule)) {
            
            templateLen1[0] = 2048;
            
            try{
                InputStream is = empreinte.getImage().getBinaryStream(1, (int) empreinte.getImage().length());

                BufferedImage imag= ImageIO.read(is);


                ImageIO.write(imag, "bmp", new File("fingerprint1.bmp"));

                FingerprintSensorEx.ExtractFromImage( mhDB, "fingerprint1.bmp", 500, template1, templateLen1);
                
                match.score = FingerprintSensorEx.DBMatch(mhDB, template1, temp0);
                File delete=new File("fingerprint1.bmp");
                delete.delete();
                if (match.score > 0) {
                    match.empreinte = empreinte;
                    break;
                }
            
            } catch (IOException | SQLException e){
                Logger.getLogger(ZKScanner.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        return match;
    }
    
    public class ZKScannerMatch{
        public int score ;
        public Empreinte empreinte;

        public ZKScannerMatch(int score, Empreinte empreinte) {
            this.score = score;
            this.empreinte = empreinte;
        }
        
        
    }
    
    public static void writeBitmap(byte[] imageBuf, int nWidth, int nHeight,
			String path) throws IOException {
        java.io.FileOutputStream fos = new java.io.FileOutputStream(path);
        java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);

        int w = (((nWidth+3)/4)*4);
        int bfType = 0x424d; 
        int bfSize = 54 + 1024 + w * nHeight;
        int bfReserved1 = 0;
        int bfReserved2 = 0;
        int bfOffBits = 54 + 1024;
        
        dos.writeShort(bfType);
        dos.write(changeByte(bfSize), 0, 4);
        dos.write(changeByte(bfReserved1), 0, 2);
        dos.write(changeByte(bfReserved2), 0, 2);
        dos.write(changeByte(bfOffBits), 0, 4);
        
        int biSize = 40;
        int biWidth = nWidth;
        int biHeight = nHeight;
        int biPlanes = 1; 
        int biBitcount = 8;
        int biCompression = 0;
        int biSizeImage = w * nHeight;
        int biXPelsPerMeter = 0;
        int biYPelsPerMeter = 0;
        int biClrUsed = 0;
        int biClrImportant = 0;
        dos.write(changeByte(biSize), 0, 4);
        dos.write(changeByte(biWidth), 0, 4);
        dos.write(changeByte(biHeight), 0, 4);
        dos.write(changeByte(biPlanes), 0, 2);
        dos.write(changeByte(biBitcount), 0, 2);
        dos.write(changeByte(biCompression), 0, 4);
        dos.write(changeByte(biSizeImage), 0, 4);
        dos.write(changeByte(biXPelsPerMeter), 0, 4);
        dos.write(changeByte(biYPelsPerMeter), 0, 4);
        dos.write(changeByte(biClrUsed), 0, 4);
        dos.write(changeByte(biClrImportant), 0, 4);

        for (int i = 0; i < 256; i++) {
                dos.writeByte(i);
                dos.writeByte(i);
                dos.writeByte(i);
                dos.writeByte(0);
        }

        byte[] filter = null;
        if (w > nWidth)
        {
            filter = new byte[w-nWidth];
        }

        for(int i=0;i<nHeight;i++)
        {
            dos.write(imageBuf, (nHeight-1-i)*nWidth, nWidth);
            if (w > nWidth)
                dos.write(filter, 0, w-nWidth);
        }
        dos.flush();
        dos.close();
        fos.close();
    }
    
    public static byte[] changeByte(int data) {
        return intToByteArray(data);
    }

    public static byte[] intToByteArray (final int number) {
        byte[] abyte = new byte[4];  
        
        abyte[0] = (byte) (0xff & number);  
        
        abyte[1] = (byte) ((0xff00 & number) >> 8);  
        abyte[2] = (byte) ((0xff0000 & number) >> 16);  
        abyte[3] = (byte) ((0xff000000 & number) >> 24);  
        return abyte; 
    }
    
    public static int byteArrayToInt(byte[] bytes) {
        int number = bytes[0] & 0xFF;  
       
        number |= ((bytes[1] << 8) & 0xFF00);  
        number |= ((bytes[2] << 16) & 0xFF0000);  
        number |= ((bytes[3] << 24) & 0xFF000000);  
        return number;  
    }
    
}
