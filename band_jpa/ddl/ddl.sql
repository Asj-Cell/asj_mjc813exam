CREATE DATABASE band_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE USER 'band_user'@'%' IDENTIFIED BY 'band!@#$1234';
GRANT ALL PRIVILEGES ON band_db . * TO 'band_user'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

 -- band_db.band_tbl definition

CREATE TABLE `band_tbl` (
                            `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                            `leader` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
                            `guitarFirst` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                            `guitarSecond` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                            `drum` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                            `bass` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                            `keyboard` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
                            `vocal` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;