import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Program {
    //kelas program merupakan anak dari kelas pemesanan travel
    static final String USERNAME = "agen1";
    static final String PASSWORD = "pass1";
    static boolean isLoggedIn = false;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PemesananTravel> listPemesanan = new ArrayList<>();

    public static void main(String[] args) {
        tampilkanLogin();

        while (!isLoggedIn) {
            tampilkanLogin();
        }

        // Setelah login berhasil
        tampilkanMenu();
    }

    static void tampilkanLogin() {
        System.out.println("=== Chill Travell ===");

        // Menghasilkan CAPTCHA acak
        String captcha = generateCaptcha();
        System.out.println("Captcha: " + captcha);

        System.out.print("Masukkan Captcha di atas: ");
        String enteredCaptcha = scanner.next();

        if (!captcha.equals(enteredCaptcha)) {
            System.out.println("Captcha salah. Coba lagi.");
            return;
        }

        System.out.print("Masukkan username: ");
        String enteredUsername = scanner.next();

        System.out.print("Masukkan password: ");
        String enteredPassword = scanner.next();

        // Periksa login
        if (login(enteredUsername, enteredPassword)) {
            System.out.println("Login berhasil!");
            isLoggedIn = true;
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    static boolean login(String enteredUsername, String enteredPassword) {
        return USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword);
    }

    static void tampilkanMenu() {
        while (true) {
            System.out.println("\n=== Menu Manajemen Pemesanan Travel ===");
            System.out.println("1. Tambah Data Pemesanan");
            System.out.println("2. Tampilkan Data Pemesanan");
            System.out.println("3. Perbarui Data Pemesanan");
            System.out.println("4. Hapus Data Pemesanan");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahDataPemesanan();
                    break;
                case 2:
                    tampilkanDataPemesanan();
                    break;
                case 3:
                    perbaruiDataPemesanan();
                    break;
                case 4:
                    hapusDataPemesanan();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
    }
    //menu menambah pesanan
    static void tambahDataPemesanan() {
        System.out.println("\n=== Tambah Data Pemesanan ===");

        System.out.print("Masukkan noPembelian: ");
        int noPembelian = scanner.nextInt();

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.next();

        System.out.print("Masukkan alamat: ");
        String alamat = scanner.next();

        System.out.print("Masukkan tujuan: ");
        String tujuan = scanner.next();

        System.out.print("Masukkan jumlah pemesanan: ");
        int jumlahPemesanan = scanner.nextInt();

        System.out.print("Masukkan total bayar: ");
        double totalBayar = scanner.nextDouble();

        System.out.print("Masukkan tanggal pemesanan (format: dd/MM/yyyy): ");
        String tanggalPemesananStr = scanner.next();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date tanggalPemesanan = dateFormat.parse(tanggalPemesananStr);

            //inheritance
            PemesananTravel pemesanan = new PemesananTravel(noPembelian, namaPelanggan, alamat, tujuan, jumlahPemesanan, totalBayar, tanggalPemesanan);
            listPemesanan.add(pemesanan);

            System.out.println("Data pemesanan berhasil ditambahkan.");
        } catch (ParseException e) {
            //exception digunakan untuk menentukan format tanggal benar atau tidak
            System.out.println("Format tanggal tidak valid. Tidak dapat menambahkan data pemesanan.");
        }
    }
    //menu menampilkan
    static void tampilkanDataPemesanan() {
        System.out.println("\n=== Data Pemesanan Travel ===");

        for (PemesananTravel pemesanan : listPemesanan) {
            System.out.println(pemesanan);
        }
    }
    //memperbarui data
    static void perbaruiDataPemesanan() {
        System.out.println("\n=== Perbarui Data Pemesanan ===");

        System.out.print("Masukkan noPembelian yang akan diperbarui: ");
        int noPembelian = scanner.nextInt();

        for (PemesananTravel pemesanan : listPemesanan) {
            if (pemesanan.getNoPembelian() == noPembelian) {
                System.out.print("Masukkan total bayar baru: ");
                double totalBayarBaru = scanner.nextDouble();

                pemesanan.setTotalBayar(totalBayarBaru);
                System.out.println("Data pemesanan berhasil diperbarui.");
                return;
            }
        }

        System.out.println("NoPembelian tidak ditemukan. Tidak ada perubahan yang dilakukan.");
    }
    //hapus data
    static void hapusDataPemesanan() {
        System.out.println("\n=== Hapus Data Pemesanan ===");

        System.out.print("Masukkan noPembelian yang akan dihapus: ");
        int noPembelian = scanner.nextInt();

        for (PemesananTravel pemesanan : listPemesanan) {
            if (pemesanan.getNoPembelian() == noPembelian) {
                listPemesanan.remove(pemesanan);
                System.out.println("Data pemesanan berhasil dihapus.");
                return;
            }
        }

        System.out.println("NoPembelian tidak ditemukan. Tidak ada penghapusan yang dilakukan.");
    }

    static String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 6;
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            captcha.append(randomChar);
        }

        return captcha.toString();
    }
}
