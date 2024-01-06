-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jan 2024 pada 20.22
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbkepegawaian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_absenmasuk`
--

CREATE TABLE `tb_absenmasuk` (
  `id_absen` int(10) NOT NULL,
  `id_pegawai` int(10) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `jam_masuk` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_absenmasuk`
--

INSERT INTO `tb_absenmasuk` (`id_absen`, `id_pegawai`, `nama`, `jam_masuk`) VALUES
(1, 1, 'DENNY HERMAWAN', '16:00'),
(3, 1, 'DENNY HERMAWAN', '08:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_absenpulang`
--

CREATE TABLE `tb_absenpulang` (
  `id_absen` int(10) NOT NULL,
  `id_pegawai` int(10) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `jam_pulang` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_absenpulang`
--

INSERT INTO `tb_absenpulang` (`id_absen`, `id_pegawai`, `nama`, `jam_pulang`) VALUES
(1, 1, 'DENNY HERMAWAN', '01:00'),
(3, 1, 'DENNY HERMAWAN', '16:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_cuti`
--

CREATE TABLE `tb_cuti` (
  `id_cuti` int(10) NOT NULL,
  `id_pegawai` int(10) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `lama_cuti` varchar(15) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_cuti`
--

INSERT INTO `tb_cuti` (`id_cuti`, `id_pegawai`, `nama`, `lama_cuti`, `keterangan`) VALUES
(1, 1, 'DENNY HERMAWAN', '30 Hari', 'Pengen Hiling'),
(2, 2, 'AMELY ANITYA A. S.', '20', 'Liburan Semester');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_datapegawai`
--

CREATE TABLE `tb_datapegawai` (
  `id_pegawai` int(10) NOT NULL,
  `NIP` int(15) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `jabatan` varchar(15) NOT NULL,
  `no_hp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_datapegawai`
--

INSERT INTO `tb_datapegawai` (`id_pegawai`, `NIP`, `nama`, `alamat`, `jenis_kelamin`, `jabatan`, `no_hp`) VALUES
(1, 2110010279, 'DENNY HERMAWAN', 'JL HANDIL BAKTI INDAH RT 001', 'Laki Laki', 'MANAGER', '085347303790'),
(2, 2110010270, 'AMELY ANITYA A. S.', 'JL SULTAN ADAM', 'Perempuan', 'STAFF', '085347303770');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penggajihan`
--

CREATE TABLE `tb_penggajihan` (
  `id_penggajihan` int(10) NOT NULL,
  `id_pegawai` int(10) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `hari_kerja` int(10) NOT NULL,
  `gajih_pokok` int(50) NOT NULL,
  `tunjangan` int(50) NOT NULL,
  `total_gajih` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_penggajihan`
--

INSERT INTO `tb_penggajihan` (`id_penggajihan`, `id_pegawai`, `nama`, `hari_kerja`, `gajih_pokok`, `tunjangan`, `total_gajih`) VALUES
(1, 1, 'DENNY HERMAWAN', 28, 3000000, 400000, 3200000),
(2, 2, 'AMELY ANITYA A. S.', 30, 3000000, 60000, 3060000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_absenmasuk`
--
ALTER TABLE `tb_absenmasuk`
  ADD PRIMARY KEY (`id_absen`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `tb_absenpulang`
--
ALTER TABLE `tb_absenpulang`
  ADD PRIMARY KEY (`id_absen`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `tb_cuti`
--
ALTER TABLE `tb_cuti`
  ADD PRIMARY KEY (`id_cuti`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `tb_datapegawai`
--
ALTER TABLE `tb_datapegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indeks untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `tb_penggajihan`
--
ALTER TABLE `tb_penggajihan`
  ADD PRIMARY KEY (`id_penggajihan`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_absenmasuk`
--
ALTER TABLE `tb_absenmasuk`
  MODIFY `id_absen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_absenpulang`
--
ALTER TABLE `tb_absenpulang`
  MODIFY `id_absen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_cuti`
--
ALTER TABLE `tb_cuti`
  MODIFY `id_cuti` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tb_datapegawai`
--
ALTER TABLE `tb_datapegawai`
  MODIFY `id_pegawai` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_penggajihan`
--
ALTER TABLE `tb_penggajihan`
  MODIFY `id_penggajihan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_absenmasuk`
--
ALTER TABLE `tb_absenmasuk`
  ADD CONSTRAINT `tb_absenmasuk_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_datapegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tb_absenpulang`
--
ALTER TABLE `tb_absenpulang`
  ADD CONSTRAINT `tb_absenpulang_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_datapegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tb_cuti`
--
ALTER TABLE `tb_cuti`
  ADD CONSTRAINT `tb_cuti_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_datapegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tb_penggajihan`
--
ALTER TABLE `tb_penggajihan`
  ADD CONSTRAINT `tb_penggajihan_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_datapegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
