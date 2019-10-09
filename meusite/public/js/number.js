var count = new Number();
var count = 0; //limite maximo

var count1 = new Number();
var count1 = 0; //limite maximo

var count2 = new Number();
var count2 = 0; //limite maximo
var limite = [80, 60, 100];



function start() {

    if ((count + 1) >= 0 && count <= (limite[1])) {//limite minimo
        count++;
        document.getElementById("tempo").innerHTML = count;
        setTimeout('start();', 10000)
    }
    if ((count1 + 1) >= 0 && count1 <= (limite[0])) {//limite minimo
        count1++;
        document.getElementById("tempo2").innerHTML = count1;
        setTimeout('start();', 10000)
    }
    if ((count2 + 1) >= 0 && count2 <= (limite[2])) {//limite minimo
        count2++;
        document.getElementById("tempo3").innerHTML = count2;
        setTimeout('start();', 100)//tempo que carrega
    }
}