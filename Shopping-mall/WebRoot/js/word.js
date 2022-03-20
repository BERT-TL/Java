$(function () {
    $(".return_word .form").hide();
    if($(".return_word .input_bottom").is(':visible')){
        $(".return_word .input_bottom").click(function () {
            $(".return_word .input_bottom").hide().siblings(".form").show();
        })
    }else{
        $(".main *").not(".form").each(function () {
            $(".form").hide().siblings(".input_bottom").show();
        })
    }


    // 置顶
    $(".nav_top img").hide();
    $(".nav_top .top").hide(); 

    $(window).scroll(function () {
        var totalHeight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
        var documentHeight = parseFloat($(document).height());
        var height = documentHeight - totalHeight;
        if ( height <= 200) {
            $(".nav_top img").fadeIn();
        } else {
            $(".nav_top img").fadeOut();
        }
    })

    // 置顶图标显示隐藏
    $(".nav_top img").click(function () {
        $("body,html").animate({scrollTop:0},200);
        $(".nav_top .top").hide(); 
    })
    $(".nav_top img").hover(function () {
        $(".nav_top .top").show(); 
    },function () {
        $(".nav_top .top").hide(); 
    })


})