# ☕ Kopi & Nyemil - Android Application

Aplikasi pemesanan kopi dan cemilan berbasis Android yang dibangun menggunakan **Kotlin** dan **Material Design 3**,dibuat untuk UTS mata kuliah **Pengembangan Aplikasi Mobile**. Aplikasi ini mengimplementasikan alur pemesanan lengkap sebanyak 8 layar utama dengan navigasi antar-fragment yang terstruktur serta pengelolaan state keranjang belanja dinamis.

## 📸 Antarmuka Layar (8 Screens Wireframe)

Aplikasi ini terdiri dari 8 alur layar utama:

### 1. Alur Autentikasi & Landing
| 1. Splash Screen | 2. Sign Up Options | 3. Login User | 4. Register |
|:---:|:---:|:---:|:---:|
| <img src="SecreenShoot/1_Splash.png" width="200"/> | <img src="SecreenShoot/2_Sign up.png" width="200"/> | <img src="SecreenShoot/3_Login (1).png" width="200"/> | <img src="SecreenShoot/4_Register.png" width="200"/> |
| Layar penyambung utama dengan tombol *Start Now*. | Pilihan awal pendaftaran atau masuk pengguna. | Form autentikasi dengan toggle *Password Visibility*. | Form pendaftaran akun baru bagi pengguna baru. |

### 2. Fitur Utama & Pemesanan
| 5. Home Screen | 6. Profile Screen | 7. Alamat (Order) | 8. Confirmation |
|:---:|:---:|:---:|:---:|
| <img src="SecreenShoot/5_Home.png" width="200"/> | <img src="SecreenShoot/6_Profile.png" width="200"/> | <img src="SecreenShoot/7_AlamatOrder.png" width="200"/> | <img src="SecreenShoot/8_Konfirmasi.png" width="200"/> |
| Katalog menu `RecyclerView` dengan filter kategori & *Add to Cart*. | Manajemen profil pengguna dengan avatar inisial otomatis & tombol *Logout*. | Form alamat pengiriman terintegrasi dengan ringkasan *Cart Summary* & total harga. | Layar sukses pemesanan dengan ucapan terima kasih & konfirmasi kurir. |

## 🛠️ Teknologi & Fitur Utama

* **Bahasa Pemrograman**: Kotlin

* **Arsitektur Navigasi**: Single-Activity Architecture menggunakan `Navigation Component` (`NavHostFragment` & `nav_graph.xml`).

- **Antarmuka Pengguna (UI)**:
  * Material Design Components (`TextInputLayout` dengan *Password Visibility Toggle*, `BottomNavigationView`, `CardView`).
  * Desain form input responsif menggunakan `ScrollView` untuk mencegah elemen terpotong pada berbagai ukuran layar.
  * Katalog menu `RecyclerView` dengan kustom `MenuAdapter` dan filter kategori dinamis (*Semua*, *Minuman*, *Makanan*).
  * Penanganan dinamis marjin atas layar (*notch / punch-hole camera inset padding*).

## 📁 Struktur Direktori Proyek

```
app/src/main/
├── java/lat/pam/kopidannyemil/
│   ├── MainActivity.kt          # Host utama navigasi & Bottom Navigation global
│   ├── HomeFragment.kt          # Fragment beranda & filter menu
│   ├── AddressFragment.kt       # Fragment alamat & ringkasan keranjang
│   ├── ProfileFragment.kt       # Fragment profil & manajemen sesi
│   ├── ConfirmationFragment.kt  # Fragment sukses pesanan
│   ├── MenuAdapter.kt           # Adapter RecyclerView untuk item menu
│   └── DummyData.kt             # Data singleton & helper format rupiah
└── res/
    ├── layout/                  # Layout XML untuk seluruh 8 layar & adapter item
    ├── menu/                    # Resource menu Bottom Navigation
    └── navigation/              # Navigation Graph (nav_graph.xml)

```

## 🚀 Cara Menjalankan Proyek

1. **Clone Repositori**:

   ```bash
   git clone https://github.com/Dam-afk03/KopiDanNyemil.git
   ```

2. **Buka Proyek**:
   Buka aplikasi **Android Studio** (direkomendasikan versi Hedgehog / Jellyfish ke atas), lalu pilih `Open` dan arahkan ke folder proyek.

3. **Sync Gradle**:
   Pastikan koneksi internet stabil dan tunggu hingga proses **Gradle Sync** selesai.

4. **Jalankan Aplikasi**:
   Pilih emulator Android (API 26+) atau perangkat fisik, lalu tekan tombol **Run (Shift + F10)**.

## 👤 Identitas

- Nama: Adam Halawi
- NIM: 1247050024
- Mata kuliah: Pengembangan Aplikasi Mobile
