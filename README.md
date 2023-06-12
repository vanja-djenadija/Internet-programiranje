# Internet-programiranje
Priprema za pismeni dio ispita

## Lab 1 (HTML)
- `<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">`
- `rowspan="3"` za `td` protezanje kroz više redova/kolona
- `align="left"`
- `vaalign="bottom"`
- `text-decoration="underline"`, moće i `<u>` tag
- `list-style-position="inside"`
- `text-align="justify"`

## Lab 2 (HTML 5)
![image](https://github.com/vanja-djenadija/Internet-programiranje/assets/130909026/e1face73-7391-4b2e-84d0-93150ae08ea1)
- `section`
-  `<meta name="viewport" content="width=device-width, initial-scale=1.0">`
-  ```css
    nav {
      float: left;
      width: 15%
    }
    ```
- `width: calc(80% - 40px);`
- ```html
  <video width="320" height="240" autoplay="autoplay" controls="controls">
        <source src="https://www.w3schools.com/html/movie.mp4" type="video/mp4">
        <source src="https://www.w3schools.com/html/movie.ogg" type="video/ogg">
  </video>
  ```
- ```html
  <iframe width="420" height="315"
	src="https://www.youtube.com/embed/tgbNymZ7vqY">
  </iframe> 
  ```
- ```javascript
	<script>
		function prikaziPodatke() {
			var elementi = document.forms[0].elements;
			var tekst = "Prezime: " + elementi.prezime.value
						+ " Ime: " + elementi.ime.value
						+ " Broj indeksa: " + elementi.broj_indeksa.value
						+ " Ciklus: " + elementi.ciklus.value
						+ " Godina studija: " + elementi.godina.value
						+ " Broj pol. ispita: " + elementi.brojPolozenihIspita.value
						+ " Prvi put: " + elementi.prvi.value;
			alert(tekst);
		}
	</script>
  ```
- a

