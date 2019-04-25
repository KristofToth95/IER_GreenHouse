# IER_GreenHouse

 ## 1.     Feladat specifikációja
 
 
### 1.1     Intelligens tér
 
Egy Okos üvegház rendszert fejlesztünk. 
Hőmérséklet érzékelők lesznek beépítve az üvegházunkba. 
Ha a hőmérséklet 30° fölé nő, akkor el kell kezdeni a szabályzó 
folyamatokat, ha 40° fölé nőne, akkor riasztást kell küldeni. 
A növényeknek nem szabad megfagyniuk sem, így, ha a hőmérséklet 5° 
alá csökkenne már el kell kezdeni fűtési szabályozó folyamatokat.
Az üvegházban egy arra kijelölt vezérlőpanel segítségével öntözésre 
kerülhet sor. Öntözni a szabályozó folyamatok alatt nem lehetséges.

 - Kezdetben egy random hőmérséklet értéket kapunk, amelyet bármikor
felülírhatunk (akkor is, ha éppen egy szabályozó folyamat zajlik).
 - 30° felett automatikusan elindul a hűtési folyamat, amihez 40°felett
riasztás is tartozik.
 - 5° alatt automatikusan elkezdődik a fűtési folyamat.
 - Ezen szabályozások addig tartanak, ameddig be nem érünk a normál
tartományba (5°-30°).
 - A reset gomb segítségével bármikor kikapcsolhatók a szabályozó
folyamatok, amelyek ebben az esetben csak akkor indulnak újra, ha
manuálisan újra indítjuk őket. 
 - Az aktuális hőmérsékletet folyamatosan látjuk.
 - Az automatikus szabályozás mellett manuálisan bármikor elindíthatunk 
szabályozó folyamatokat.
 - Ha a rendszer éppen szabályozás alatt áll, mind a Riasztás - Fűtés - 
Öntözés - és Hűtés gombok deaktiválódnak, ezzel biztosítva, hogy egyszerre 
csak egy folyamat mehessen.
 - Reset gomb megnyomására leáll a szabályozó folyamat és újra elérhető az
összes többi szabályozó folyamat.
 - Öntözés hatására megnőnek a növények.


### 1.2   Ágensek:
 
- Hűtő rendszer
- Fűtő rendszer
- Hőmérséklet érzékelők
- Öntöző berendezés
 
 
### 1.3   Kritikus esemény:
 
- Hőmérséklet emelkedés vagy csökkenés.
- Növények kiszáradása, elpusztulása.
 
 
### 1.4   Vezérlőpanel lehetőségek:
 
- Öntöző gomb
- Hűtő gomb
- Fűtő gomb
- Riasztó kikapcsolása
