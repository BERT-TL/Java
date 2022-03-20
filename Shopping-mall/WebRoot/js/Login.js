$(function () {

	$(".alert").hide();
	if( $(".alert font").html() == "" ){ 
        $(".alert").hide();
    }else{
        $(".alert").show();
    }

    $("#id").focus(function () {
        $(".alert").hide();
    })
    $("#password").focus(function () {
        $(".alert").hide();
    })
})

