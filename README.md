# Përkthyesi i Kodit me 3-Drejtimet
Ky është projekti përfundimtar që kam përfunduar në kursin e Përpunuesve të Gjuhës gjatë vitit të tretë të Inxhinierisë Kompjuterike. Ky detyrë përfshin zbatimin, duke përdorur JFlex dhe Cup, të një kompajleri për një gjuhë të vogël programimi të ngjashme me C, të quajtur gjuha PLX. PLX është një zgjerim i gjuhës PL, e cila përshkruhet si pjesë e praktikës së kursit, por kjo version i zgjeruar kërkon disa funksione shtesë. Supozohet që të gjitha elementet e gjuhës PL janë të pranishme në gjuhën PLX dhe që funksionaliteti i tyre nuk ndryshohet nga përfshirja e elementeve të reja në këtë zgjerim. Dallimi kryesor midis PL dhe PLX është se PLX kërkon deklarimin paraprak të variablave. Kodi ndërmjetës i gjeneruar nga të dyja gjuhët është i njëjtë, ashtu si dhe skema e kompilimit. Imazhi i mëposhtëm përfaqëson një diagram rrjedhjeje që përshkruan procesin e kompilimit dhe ekzekutimit të një programi.

<p align="center">
   <br>
   <img src="https://github.com/rorro6787/rorro6787/blob/main/Images/plxc.png" width = 100%/>
</p>

## Përshkrimi i Kompilatorit

- **Aspektet Leksikore**: nga një perspektivë leksikore, gjuha PLX është e ngjashme me C, C++, dhe Java, dhe ndjek të njëjtat rregulla për fushën e deklarimit të variablave. PLX pranon të njëjtin lloj komentesh si C++. Çdo paqartësi që lind gjatë zbatimit, që nuk është sqaruar mjaftueshëm në këtë deklaratë, duhet të zgjidhet sipas specifikimeve të këtyre gjuhëve.
  
- **Llojet**: gjuha PLX ka katër lloje bazë që korrespondojnë me llojet në Java: int, float, boolean dhe char. Secili nga këto lloje ka konstante të lidhura; numrat të plotë përdorin notacionin dhjetor, numrat me presje dhjetore përdorin notacionin me pikë dhjetore dhe eksponent, dhe karakteret shfaqen në thonjëza të vetme. Lloji i përbërë String gjithashtu përdoret, me konstantet që janë sekuenca karakteresh në thonjëza të dyfishta, ashtu si në Java. Mund të përkufizohen vargje njëdimensionale të cilitdo prej llojeve të thjeshta të përmendura më parë, me vargjet e karaktereve që janë ekuivalente me llojin String.
- **Deklarimi i Variablave**: variablat duhet të deklarohen duke u caktuar atyre një lloj përpara se të mund të përdoren. Identifikuesit e variablave përbëhen nga karaktere alfanumerike, duke filluar me një karakter jo numerik, të ngjashëm me Java. Mund të deklarohen disa variabla në të njëjtën rresht, të ndara me presje, dhe mundësisht t'u caktohet një vlerë fillestare. Nëse një variabël nuk inicializohet, ajo konsiderohet të ketë një vlerë zero (ose ekuivalente sipas llojit të saj).
- **Shprehjet Aritmetike**: gjuha përfshin shprehje aritmetike me katër operatorët: mbledhje, zbritje, shumëzim dhe pjesëtim. Operacioni i përkthyer në nivelin e kodit ndërmjetës varet nga tipi i shprehjes, me numrat e plotë dhe realë që interoperohen, duke kryer konvertime implicit ose eksplicit midis numrave të plotë dhe realë nëse është e nevojshme. Operacioni i mbledhjes i aplikuar dy karaktereve nënkupton concatenimin e tyre (si në Java), duke rezultuar në një objekt String.
- **Kushtet**: kushtet rezultojnë nga aplikimi i operatorëve relacionale (barabartë, jo barabartë, më pak se, më shumë se, më pak ose barabartë me, etj.) midis dy shprehjeve. Kushtet mund të përbëhen duke përdorur operatorët logjikë të konjunksionit, disjunksionit dhe mohimit (&&, ||, dhe !) me vlerësim të shkurtër.
- **Deklarata e Daljes**: deklarata e vetme e daljes është udhëzimi print, i cili mund të aplikohet për cilindo nga llojet e gjuhës PLX. Kodi i gjeneruar do të ndryshojë në varësi të llojit.
- **Deklaratat e Kontrollit**: thelbi i gjuhës do të përfshijë deklarata të caktimit dhe deklaratat e kontrollit if-else, while, do-while, dhe for, me të njëjtën semantikë si në gjuhën Java. Deklaratat e kontrollit mund të nguliten brenda njëra-tjetrës.
- **Zbulimi i Gabimeve**: kompajleri nuk përfshin rikuperimin e gabimeve, kështu që ndalon ekzekutimin sapo të haset udhëzimi i parë i pasaktë, qoftë në analizën leksikore, sintaksore apo semantike. Në këto raste, dalja duhet të përmbajë vetëm udhëzimin "error", pa pasur nevojë të tregojë shkakun.

## Kodi me 3-Drejtimet

Kodi i objektit CTD zbaton një makinë abstrakte me regjistra të pafundme të aksesueshme përmes variablave. Të gjitha variablat konsiderohen të jenë të parapërcaktuara dhe vlera e tyre fillestare është 0. Nuk ka ndarje midis numrave të plotë dhe atyre realë, përveç kur kryhen operacione. Grupi i udhëzimeve për kodin ndërmjetës dhe semantika e tyre janë si më poshtë:
<p align="center">
   <br>
   <img src="https://github.com/rorro6787/rorro6787/blob/main/Images/codigo%C3%A7.png" width = 100%/>
</p>

## Përdorshmëria
Së pari, është e nevojshme të vendosni mjedisin "CUP" dhe "JFLEX". Për ta bërë këtë, ndiqni të njëjtët hapa të përshkruar në këtë faqe WEB: https://www2.in.tum.de/repos/cup/develop/testgrammars/calc/ dhe kryeni veprimet e mëposhtme:
1. Për të kompiluar CUP, JFLEX dhe skedarët JAVA, përdorni udhëzimet e mëposhtme (çdo person duhet t'i përshtatë ato me shtigjet në kompjuterin e tij):
   
   ```bash
   java -jar /Applications/cup-0.11b/java-cup-11b.jar Calculadora.cup /Applications/jflex-1.8.2/bin/jflex Calculadora.flex
   javac -cp /Applications/cup-0.11b/java-cup-11b-runtime.jar:. *.java
   java -cp /Applications/cup-0.11b/java-cup-11b-runtime.jar:. Calculadora test1.txt 
2. Për komoditet më të madh, është e këshillueshme të përcaktohet lokalisht variabla e mjedisit CLASSPATH në skedarin e nisjes së shell-it, për shembull në skedarin "$HOME/.profile" (në varësi të shell-it që përdor secili person), dhe të krijohet një skedar "cup" në një vendndodhje të aksesueshme në PATH. Për shembull, krijoni skedarin "/usr/local/bin/cup" me përmbajtjen e mëposhtme:
   
   ```bash
   export CLASSPATH=.:/Applications/cup-0.11b/java-cup-11b-runtime.jar
   java -jar /Applications/cup-0.11b/java-cup-11b.jar $@

3. Pasi të jetë konfiguruar hapi i mëparshëm, sekuenca e mëposhtme duhet të funksionojë drejtpërdrejt:
   
   ```bash
   cup Calculadora.cup
   jflex Calculadora.flex 
   javac *.java
   java Calculadora test1.txt
3. Ju gjithashtu mund të përdorni makron e përfshirë në kodin burimor për të kryer të gjitha udhëzimet e mësipërme njëherësh:
   
   ```bash
   . comp.sh

4. Në direktorinë src të repositorit, mund të gjeni gjithashtu skedarin ctd që kompilon kodin me tre adresa dhe kthen rezultatin e kompilimit:
   
   ```bash
   java PLXC test1.plx tes1.ctd 
   ./ctd test1.ctd
