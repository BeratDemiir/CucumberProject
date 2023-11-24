@failed_scenario
Feature: hooks_test

  Background: googlea_git
    Given kullanici google gider

    #  Bu scenariolar bilerek fail ettik.
# Raporlarda Fail durumunda ekran goruntusu eklenmis olacakdir
  Scenario: TC01_google_iphone_arama
    When kullanici "iphone" icin arama yapar
    Then sonuclarda "apple" oldugunu dogrular
    Then close the application

  Scenario: TC02_google_tesla_arama
    When kullanici "tesla" icin arama yapar
    Then sonuclarda "volvo" oldugunu dogrular
    Then close the application