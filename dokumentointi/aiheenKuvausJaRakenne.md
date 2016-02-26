**Aihe:** Yksinkertainen laskin joka osaa laskea peruslaskutoimitukset (plus, miinus, kerto, jako) kokonais ja desimaaliluvuille. Laskin osaa myös potenssilaskut ja ottaa juuren. Tulokset ilmoitetaan desimaalilukuna tai kokonaislukuna.


Laskin muistaa muutamat yleisimmin käytetyt vakiot (esim. pii). Vakioihin viitataan laskutoimituksessa kirjaimella tai sanalla. Käyttäjä voi listata laskimen sisältämät vakiot niin että näkee kirjaimen/sanan sekä vastaava luvun. Käyttäjä voi laittaa mistiin omia lukuja ja valita niitä vastaavan kirjaimen/sanan. 

**Toiminnot:** 
- peruslaskutoimitukset: plus, miinus, jako, kerto, potenssilaskut ja neliöjuuri.
- muistissa olevien vakioiden listaus. 
- muistissa olevia vakioita voi käyttää laskutoimituksissa numeroiden tavoin.
- käyttäjä voi laittaa laskimen muistiin omia lukuja.
   * onnistuu jos käyttäjän valitsema kirjain/sana ei ole varattu toiselle luvulle.

**Ohjelman rakenteen kuvaus:** 
ohjelmassa on kolme pakkausta: laskin.logiikka, laskin.main ja laskin.ui.
  - laskin.logiikka sisältää luokat Laskutoimitus, Vakiomuistio ja Valinta.
    * Laskutoimitus suorittaa laskun
    * Vakiomuistio sisältää HashMapin johon tallennetaan vakio ja sitä vastaava arvo, siitä voidaan hakea arvot laskutoimitusta varten
    * Valinta luokka kommunikoi laskutoimituksen ja valinnan kanssa, sekä tarkistelee käyttäjän syötteiden oikeellisuuksia.   - laskin.main sisältää vain Main luokan
    * Main käynnistää ohjelman
  -laskin.ui sisältää luokat Laskin, Komponentit ja Toiminta
    *Laskin luokka rakentaa laskimen näkyvät osat: napit, panelit tekstikentän, sekä lisää näihin toiminnallisuuden.
    *Komponentit luokka luo osan komponenteista esim. napit ja asettelee ne paneliin.
    *Toiminta luokka sisältää nappien toiminnallisuuden.


**Luokkakaavio:** 

![Alt text](https://github.com/anliski/laskin/blob/master/dokumentointi/luokkakaavio1.png)

**Sekvenssikaaviot:** 

- laskutoimintusken suorittaminen.
![Alt text](https://github.com/anliski/laskin/blob/master/dokumentointi/laskutoimitus.png)


- Uuden vakion lisääminen vakiomuistioon.
![Alt text](https://github.com/anliski/laskin/blob/master/dokumentointi/vakiomuistio.png)

