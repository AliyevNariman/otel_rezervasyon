
package pk;


public class OdaTip {
    public Integer OdaTipID;
    public String OdaTipAdi;
    public Double OdaFiyati;
    public Integer OdaKisiSayisi;
    
    public OdaTip(Integer OdaTipID,String OdaTipAdi, Double OdaFiyati, Integer OdaKisiSayisi) {
        this.OdaTipID = OdaTipID;
        this.OdaTipAdi = OdaTipAdi;
        this.OdaFiyati = OdaFiyati;
        this.OdaKisiSayisi = OdaKisiSayisi;
    }
}
