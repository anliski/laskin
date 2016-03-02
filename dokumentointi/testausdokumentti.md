
**TESTAUS**

Automaattisia testejä ei ole generoitu ollenkaan vaan kaikki testit on tehty käsin. Tesit on kirjoitettu vain laskin.logiikka -paketille jossa on testattu kaikkia luokkia. Kutakin luokkaa vastaa oma testiluokka ja se on nimetty <LUOKANNIMI>Test. Bugeja ei ole havaittu.

**LaskutoimitusTest**

Testeissä tarkastellaan laskutoimistusten toimivuutta vertailemalla odotettua arvoa ja ohjelman laskemaa arvoa keskenään. Vertailu tapahtuu assertEquals -metodilla johon on laitettu kahtena ensimmäisenä parametrina aikaisemmin mainitut ja viimeiseksi parametriksi suurin sallittu eroavaisuus niiden välillä. Kaksi testeitä testaa poikkaustapauksia laskutoimitusten suorittamisessa: nollaalla jakamista ja juuren ottamista negetiivistesta arvosta, näissä molemmissa katsotaan että tuloksen arvo ei muutu.

**VakiomuistioTest**

Sisältää vain neljä testiä joissa tutkitaan Vakiomuistion toimivuutta. Ensimmäisessä tarkastetaan että ohjelma tallentaa automaattisesti muistiin tietyt vakiot kun luokan olio luodaan, assertTrue ja assertFalse -metodeilla. Toisessa tarkastellaan vakion arvon hakua, kolmannessa lisätään uusi vakio muistioon ja katsotaan onnistuuko lisääminen. Neljäs metodi katsoo että toString palauttaa oikeassa muodossa.

**ValintaTest**

Testit testailevat Valintaluokan metodeja jotka monet käsittelevät käyttäjän syötteiden oikeellisuuden tarkistamista. Näitä on tarkisteltu tarjoamalla metodien parametreiksi sekä oikeita että virheellisiä arvoja. Osa testeistä testaa samoja asioita kuin vakiomuistiotesteissä mutta valinta luokan kautta. Esimerkiksi että vakion lisääminen muistioon onnistuu valintaluokasta. 

