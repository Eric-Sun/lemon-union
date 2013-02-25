function do_alert(x) {
    if (x == 1) {
        $(".body").append("<div class='alert fade in alert-success'><button class='close' data-dismiss='alert'>×</button><strong>操作成功！</strong></div>");
    } else {
        $(".body").append("<div class='alert fade in alert-error'><button class='close' data-dismiss='alert'>×</button><strong>操作失败！</strong></div>");
    }
}

function format_date(x) {
    if (x == null || "" == x)return "";
    var d = new Date(x);
    var s = d.getFullYear() + "年";
    s += ("0" + (d.getMonth() + 1)).slice(-2) + "月";
    s += ("0" + d.getDate()).slice(-2) + "日 ";
    s += ("0" + d.getHours()).slice(-2) + ":";
    s += ("0" + d.getMinutes()).slice(-2) + ":"
    s += ("0" + d.getSeconds()).slice(-2);
    return s;
}