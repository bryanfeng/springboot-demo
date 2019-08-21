function myFunction()
{
    var text = "块钱";
    var info = document.getElementById("num").innerHTML;
    var num  = info.replace(text, "");
    num++;
    document.getElementById("num").innerHTML= num + text;
}