# Harjoitustyö: Verkkosivusto artistien ja albumien tarkasteluun


## Projektin tiedostot

Hakemistorakenne:

```tree
embedded-tomcat
│   git-log.txt
│   pom.xml
│   README.md
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───database
│   │   │   │       AlbumDao.java
│   │   │   │       ArtistDao.java
│   │   │   │       Database.java
│   │   │   │       JDBCAlbumDao.java
│   │   │   │       JDBCArtistDao.java
│   │   │   │
│   │   │   ├───launch
│   │   │   │       Main.java
│   │   │   │
│   │   │   ├───model
│   │   │   │       Album.java
│   │   │   │       Artist.java
│   │   │   │
│   │   │   └───servlet
│   │   │           AlbumsServlet.java
│   │   │           ArtistListServlet.java
│   │   │           ResultServlet.java
│   │   │
│   │   ├───resources
│   │   └───webapp
│   │       ├───styles
│   │       │       demo.css
│   │       │
│   │       └───WEB-INF
│   │               albums.jsp
│   │               artistList.jsp
│   │               notFound.jsp
│   │               results.jsp
│   │
│   └───test
│       ├───java
│       │   ├───database
│       │   │       JDBCAlbumDaoTest.java
│       │   │       JDBCArtistDaoTest.java
│       │   │
│       │   └───testserver
│       │           TestServer.java
│       │
│       └───resources
```

### Kuvaus toteutetuista/muokatuista tiedostoista (ei kuvauksia valmiina olleista projektipohjan tiedostoista)

Nimi                        | Tarkoitus
----------------------------|-------------------------------------------------------------------
git-log.txt					| Sisältää linkin GitHubiin, josta nähtävissä versionhallinta
README.md					| Tämä tiedosto
pom.xl						| Project Object Model-tiedosto mm. riippuvuuksien määrittelemiseksi
AlbumDao.java				| Toimii rajapintana Album- ja JDBCAlbumDao-luokkien välillä, määrittelee mitä operaarioita dao-luokan on toteutettava
ArtistDao.java				| Toimii rajapintana Artist- ja JDBCArtistDao-luokkien välillä, määrittelee mitä operaarioita dao-luokan on toteutettava
Database.java				| Sisältää metodit Chinook-tietokannan avaamiseen ja sulkemiseen, käytetään JDBCAlbumDao- ja JDBCArtistDao-luokissa
JDBCAlbumDao.java			| Toteuttaa AlbumDao-rajapinnan ja sisältää konkreettisen SQL-logiikan albumi-tauluun liittyen
JDBCArtistDao.java			| Toteuttaa ArtistDao-rajapinnan ja sisältää konkreettisen SQL-logiikan artisti-tauluun liittyen
Main.java					| Luokka Tomcat-palvelimen käynnistämiseksi
Album.java					| Model-luokka, joka kuvastaa tietokannan albumi-taulua sisältäen samat kentät, jotka ovat Chinook-tietokannassa	
Artist.java					| Model-luokka, joka kuvastaa tietokannan artisti-taulua sisältäen samat kentät, jotka ovat Chinook-tietokannassa
AlbumServlet.java			| HTTP-liikennettä tukeva Java-luokka, joka näyttää valitun artistin albumiluettelon
ArtistListServlet.java		| HTTP-liikennettä tukeva Java-luokka, joka näyttää artistilistauksen, lisäksi ominaisuutena on artistin lisääminen ja 							| artisti-/albumihaku
ResultServlet.java			| HTTP-liikennettä tukeva Java-luokka, joka näyttää artisti-/albumihaun tulokset
albums.jsp					| AlbumServletin käyttämä sivupohja, kun artistiId löytyy Chinook-tietokannasta
artistList.jsp				| ArtistListServletin käyttämä sivupohja
notFound.jsp				| AlbumServletin käyttämä sivupohja, kun artistiId on virheellinen
results.jsp					| ResultServletin käyttämä sivupohja
JDBCAlbumDaoTest.java		| JDBCAlbumDao-luokan JUnit-testit
JDBCArtistDaoTest.java		| JDBCArtistDao-luokan JUnit-testit