@parametre
Feature: arama_feature

  Background: googlea_git
    Given kullanici google gider

  @smoke
  Scenario: TC01_google_iphone_arama
    When kullanici "iphone" icin arama yapar
    Then sonuclarda "iphone" oldugunu dogrular
    Then close the application

  @smoke
  Scenario: TC02_google_tesla_arama
    When kullanici "tesla" icin arama yapar
    Then sonuclarda "tesla" oldugunu dogrular
    Then close the application

  @smoke
  Scenario: TC03_google_water_arama
    When kullanici "water" icin arama yapar
    Then sonuclarda "water" oldugunu dogrular
    Then close the application

  Scenario: TC04_google_tea_pot_arama
    When kullanici "tea pot" icin arama yapar
    Then sonuclarda "tea pot" oldugunu dogrular
    Then close the application

  Scenario: TC05_google_skateboard_arama
    When kullanici "skateboard" icin arama yapar
    Then sonuclarda "skateboard" oldugunu dogrular
    Then close the application


#      "veri"  -> feature file i parametrize etmek icin kullanilir
