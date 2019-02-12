/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getname() {
    var str = "";
    var id = document.getElementById('sel_name');
    var bk_nm = document.getElementById('book_name');
    var price = document.getElementById('price');
    var au_pb = document.getElementById('auth_pub');

    str += "id=" + id.options[id.selectedIndex].value;
    if ((bk_nm.value.length) > 0)
        str += "&bk_nm=" + bk_nm.value.toString();
    if ((price.value.length) > 0)
        str += "&pr=" + price.value.toString();
    if ((au_pb.value.length) > 0)
        str += "&ap=" + au_pb.value.toString();
    location.href = "./Issues.jsp?" + str;
}

function get2d(num) {
    return (num.toString().length < 2 ? "0" + num : num).toString();
}

function ins_date() {
    n = new Date();
    y = n.getFullYear();
    m = n.getMonth() + 1;
    d = n.getDate();
    document.getElementById("issue_date").value = get2d(d) + "-" + get2d(m) + "-" + y;
}

function validation() {
    var mob = document.getElementById('issuer_cont');
    var id = document.getElementById('sel_name');
    var filter_mob = /^[6-9]+\d{9}/;

    if ((mob.value.length) > 0) {
        if (!filter_mob.test(mob.value.toString()))
        {
            alert('Enter 10 digit Mobile Number');
            mob.focus();
            return false;
        }

    }

    if ((id.options[id.selectedIndex].value) == "0_0") {
        alert('Enter the Issuer ID or Select Other');
        id.focus();
        return false;
    }

    return true;
}
