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
  
## Lab 3 (CSS)
- `<link rel="stylesheet" href="styles/style.css"/>`
- ```css
  .row-container {
	display: flex;
	flex-wrap: wrap;
	flex-direction: row;
	flex-grow: 1;
   }
   ```
- Vertikalno poravnanje teksta `height: 70px` i `line-height:70px`
- `position:absolute`, `left: 0` right, top, bottom
- `overflow-y: auto` nad `.content` skroluje se samo content ne i footer
-  ```css
   .list li:nth-child(even) {
	color: blue;
    }
    ```
- `overflow:hidden` `text-overflow: ellipsis`
- `display: inline-block`, `none`, `block`

## Lab 4 (Javascript)
- `<script src="script.js"></script>`
-  `document.getElementById("user").innerHTML = "nesto"`
-  `document.getElementsByTagName("input")`
-  `var storage = localStorage.getItem(storageKey)`
-  `data = JSON.parse(storage)`
-   `localStorage.setItem(storageKey, JSON.stringify(data))`

## Lab 5 (Servleti)
```java
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	PrintWriter pw = response.getWriter();
	response.setContentType("text/html");
	pw.print(
			"<html><head><meta http-equiv='Content-Type' content='text/html' charset='UTF-8'/><title>First</title></head>");
	pw.print("<body><form method='post' action='SecondServlet'>Ime: <input type='text' name='ime'/><br/>");
	pw.print(
			"Prezime: <input type=\"text\" name=\"prezime\"/><br/> Godina rodjenja: <input type=\"text\" name=\"godinaRodjenja\"/><br/>");
	pw.print(
			"Korisnicko ime: <input type=\"text\" name=\"korisnickoIme\"/><br/><input type=\"submit\" value=\"Prijava\"/></form></body></html>");
	pw.close();
}
```
- `response.sendRedirect("FirstServlet");`
- `String username = request.getParameter("korisnickoIme");`
- ```java
	HttpSession session = request.getSession();
	session.setAttribute("igrac", p);
	session.setAttribute("igraci", users);
  ```
- ```html
	<script type=\"text/javascript\">function second(){document.getElementById('forma').submit();}</script>
	<a href='javascript:second()'>Third</a>
  ```
- ```java
	HttpSession session = request.getSession();
	Player p = (Player) session.getAttribute("igrac");
  ```
- ```java
	BufferedReader fr = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("fajlovi/BP.txt")));
	pitanje = fr.readLine();
  ```

## Lab 6 (JSP)
- ```jsp
	<%@page import="net.etfbl.ip.lab06.beans.UserBean"%>
	<jsp:useBean id="userBean" class="net.etfbl.ip.lab06.beans.UserBean" scope="session"></jsp:useBean>
	<jsp:useBean id="userManager" class="net.etfbl.ip.lab06.service.UserManager" scope="application"></jsp:useBean>
	<jsp:setProperty property="username" name="userBean" param="username" />
	<jsp:setProperty property="password" name="userBean" param="password" />
  ```
- `<%@include file="WEB-INF/header.jsp"%>` header i footer su sakriveni u WEB-INF, ostale stranice u WebContent
- `session.invalidate()`

## Lab 7 (JSP M2)
- U `WEB-INF` sakriti JSP stranice od korisnika
- paketi: `dto`, `dao`, `controller`, `beans`
- Contoroller je Servlet
- ```java
   RequestDispatcher dispatcher = request.getRequestDispatcher(address);
   dispatcher.forward(request, response);
   ```

## Lab 8 (REST i Ajax)
- paketi: `api`, `beans`, `servlet`, `model`
- ```xml
  <servlet>
		<servlet-name>Jersey RESTful Application</servlet-name>
		<servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
		<init-param>
			<param-name>jersey.config.server.provider.packages</param-name>
			<param-value>net.etfbl</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>Jersey RESTful Application</servlet-name>
		<url-pattern>/api/*</url-pattern>
	</servlet-mapping>
  ```
- 

## Angular
- Instaliranje node.js
- `npm install -g @angular/cli`
- `ng new my-app`
- `ng serve --open`
- `ng add @angular/material`
- `ng g c naziv`
