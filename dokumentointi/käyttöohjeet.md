**Käyttöohjeet**

Laskimella voi kirjoittaa vakioita muistiin, laskea peruslaskutoimituksia joko numeroilla tai muistissa olevilla vakioilla. Lisäksi voi tarkastella mitä vakioita muistio sisältää.  

Kun ohjelma käynnistetään ilmastyy näytölle laskin, jossa ylimpänä tummanharmaalla pohjalla on neljä valikkonappia, keskellä valkoisella pohjalla on tekstikenttä ja alimpana on numeronappulat, opertaattorinappulat sekä muut toiminta nappulat.

**Valikkonapit**

- help
 * Valikkonapeista "help"-nappulaa painamalla pongahtaa näytölle lyhyet ohjeet muiden valikkonappien toiminnasta.

- vakio
  * "vakio" nappia painamalla laskimeen voi tallentaa omia vakioita. Käyttäjä kirjoittaa tekstikenttään jonkun kirjainyhdistelmän vakion symboliksi. Symboli saa sisältää mitä tahansa merkkejä, mutta ei saa sisältää pelkkiä numeroita eikä olla sellainen merkkiyhdistelmä jolle on jo muistiossa arvo(tämän tarkistamiseksi katso "listaa"). Symbolin syöttämisen jälkeen käyttäjä painaa yhtäsuuruusmerkkiä joka sijaitsee alimpama keskellä. Tekstikenttä tyhjenee ja käyttäjä voi syöttää nyt numeron, joko kokonaislukuna tai desmaalimuodossa. Kun numero on kirjoitettu painetaan M-nappia oikeassa alakulmassa, jolloin laskin tallentaa vakion muistioon. Laskin ilmoittaa lisäämisen onnistumisesta, tai vaihtoehtoisesti ilmoittaa mikäli käyttäjän syötteissä on ollut jotain vikaa.

- lasku
  * "lasku" -nappia painamalla voi laskimella laskea. Lasku tapahtuu kirjoittamalla ensin numero, sitten painamalla halutusta operaattorinapista(ks. laskutoimitukset) ja tämän jälkeen kirjoitetaan toinen numero ja painetaan yhtäsuuruusnapista, jolloin tekstikenttään ilmestyy ratkaisu. Mikäli käyttäjä haluua käyttää muistiossa olevia vakioita voi kirjoittaa kumman tahansa numeron paikalle vakiota vastaavan kirjainyhdistelmän (esim. pii) ja ohejlma hakee laskuun tätä vastaavan arvon (3.14...). Jos käyttäjän kirjainyhdistelmää ei löydy muistiosta, ohjelma ei tee mitään kunnes syöte on korjattu.

- listaa
  * "listaa" -napista pongahtaa näytölle lista kaikista vakiomuistiossa olevsita vakioista ja niiden arvoista muodossa (pii = 3.41)

**Laskutoimitukset**

Laskimella voi laskea plus, miinus, kerto, jako, potenssi ja juuri-laskuja, painamalla ensin valikkonapeista "lasku"-kohdasta.

- pluslaskuihin valitaan operaattorinapiksi "+"
- miinuslaskuihin valitaan operaattorinapiksi "-"
- kertolaskuihin valitaan operaattorinapiksi "*"
- jakolaskuihin valitaan operaattorinapiksi "/"
  * Mikäli käyttäjä yrittää jakaa nollalla ohjelma ei laske tulosta.
- potenssilaskuihin valitaan operaattorinapiksi "^"
  * ensimmäinen luku on tällöin kantaluku ja toinen eksponentti.
- juurilaskuihin valitaan operaattorinapiksi "r"
  * ensimmäisistä luvutsa otetaan toisen luvun juuri.
  * Jos käyttäjä yrittää ottaa negatiivistesta arvosta juurta, ohjelma ei laske tulosta.

**Muuta huomioitavaa**
 - "C" -nappi tyhjenttä tekstikentän
 - pilkkua ei voi laittaa kahta kertaa.
