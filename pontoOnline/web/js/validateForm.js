function checkExist() {
    var xmlhttp = new XMLHttpRequest();
    var usuario = document.forms["cadFuncionario"]["usuario"].value;
    var url = "exists.jsp?usuario=" + usuario;
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            if (xmlhttp.responseText == "\n\n\n\n\n Usuario já existe")
                document.getElementById("isE").style.color = "#222439";
            else
                document.getElementById("isE").style.color = "#222439";
            document.getElementById("isE").innerHTML = xmlhttp.responseText;
        }

    };
    try {
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    } catch (e) {
        alert("Nao foi possível estabelecer conexão");
}
}

