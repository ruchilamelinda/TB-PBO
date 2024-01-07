import java.text.SimpleDateFormat;
import java.util.Date;

class PemesananTravel implements DataPemesanan {
    private int noPembelian;
    private String namaPelanggan;
    private String alamat;
    private String tujuan;
    private int jumlahPemesanan;
    private double totalBayar;
    private Date tanggalPemesanan;

    public PemesananTravel(int noPembelian, String namaPelanggan, String alamat, String tujuan, int jumlahPemesanan, double totalBayar, Date tanggalPemesanan) {
        this.noPembelian = noPembelian;
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
        this.tujuan = tujuan;
        this.jumlahPemesanan = jumlahPemesanan;
        this.totalBayar = totalBayar;
        this.tanggalPemesanan = tanggalPemesanan;
    }

    public int getNoPembelian() {
        return noPembelian;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTujuan() {
        return tujuan;
    }

    public int getJumlahPemesanan() {
        return jumlahPemesanan;
    }

    public double getTotalBayar() {
        return totalBayar= jumlahPemesanan*70000;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "No Pembelian: " + noPembelian +
                ", Nama Pelanggan: " + namaPelanggan +
                ", Alamat: " + alamat +
                ", Tujuan: " + tujuan +
                ", Jumlah Pemesanan: " + jumlahPemesanan +
                ", Total Bayar: " + totalBayar +
                ", Tanggal Pemesanan: " + dateFormat.format(tanggalPemesanan);
    }
}
