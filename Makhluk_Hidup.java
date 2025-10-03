public class MakhlukHidup {

    private String nama;       // error syntax, string S nya besar
    private String jenis;
    private double berat; //=1.0 (sudah dihapus)  // mengubah -1.0 menjadi 1.0, atribut berat seharusnya private dan tidak boleh minus. dihapus saja, sudah diinisialisasi di constructor (tindakan sia sia)
    private int umur;


    public MakhlukHidup() {
        this.nama = "Unknown";
        this.jenis = "Unknown";
        this.umur = 15;
        this.berat = 10.0;
    }

    public void Makhluk(String nama) { // bukan constructor, sebaiknya nama yang sama dengan class dihindari (dari MakhlukHidup -> Makhluk)
        this.nama = nama;
        this.jenis = "Salah";
        this.umur = 12;
        this.berat = 170.0;
    }

    public MakhlukHidup(String nama, String jenis, int umur, double berat) { // penulisan makhlukHidup, seharusnya MakhlukHidup
        this.nama = nama;  // letak nama dan jenis terbalik. jenis -> nama
        this.jenis = jenis; // letak nama dan jenis terbalik. nama -> jenis
        this.umur = umur;
        this.berat = berat;
    }

    public MakhlukHidup(MakhlukHidup other) {
        this.nama = other.nama; // nama diubah menjadi other.nama, mengikuti yang ada di parameter 
        this.jenis = other.jenis; 
        this.umur = other.umur; // this.umur diubah menjadi other.umur, mengikuti yang ada di parameter
        this.berat = other.berat;
    }


    public void setUmur(int umur) { // salah type data, seharusnya int untuk umur bukan String
        this.umur = umur;
    }

    public void setNama(String nama) { 
        this.nama = nama; // terbalik, awalnya nama=this.nama menjadi this.nama=nama. tidak error, hanya kesalahan logika
    }

    public String getInfo() { // salah type data, harusnya pakai String bukan int
        return "Nama=" + nama + ", Jenis=" + jenis 
        + ", Umur=" + umur + ", Berat=" + berat;
    }
}

class TestAccess {
    public static void main(String[] args) {
        MakhlukHidup m = new MakhlukHidup();
        
        m.setNama("Kucing"); // nama bersifat private, tidak bisa diakses langsung jadi harus lewat method setter
        
        MakhlukHidup m2 = new MakhlukHidup("Harimau", "Hewan", 3, 120.0);
        
        MakhlukHidup m3 = new MakhlukHidup(m2);
 
        System.out.println(m.getInfo());
        
        System.out.println(m2.getInfo());
        
        m2.Makhluk("Kuda"); // mengikuti perubahan di line 16, MakhlukHidup -> Makhluk
                
        System.out.println(m2.getInfo());
        
        m3.setUmur(10); // mengubah -10 menjadi 10, umur tidak boleh negatif
        
        System.out.println(m3.getInfo());

        
    }
}