@data_tables
Feature: data_tables

  Scenario: TC01_Musteri_giris_testi
    Given kullanici "https://www.bluerentalcars.com/login" gider
    When kullanici emaili ve sifresini girer
      | email                       | sifre    |
      | raj.khan@bluerentalcars.com | v7Hg_va^ |
    Then close the application