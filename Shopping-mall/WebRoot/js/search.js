$(function () {
    // $(".prompt").hide()

    if( ($(".prompt").html() == "")||($(".prompt").html() == "null")){ 
        $(".prompt").hide();
        $("table").show();
    }else{
        $("table").hide();
        $(".prompt").show();

    }

})