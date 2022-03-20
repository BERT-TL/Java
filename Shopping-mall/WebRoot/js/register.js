// 判断所有的输入值是否符合规则

//检测昵称是否符合规则
function checkName(){  
    var name = document.getElementById("name").value;  
    var spanNode = document.getElementById("nameSpan");  
    //用户名的规则： 昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号
    var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/i;      
    if(reg.test(name)){  
        //符合规则   
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "昵称的长度为1-15，只能是任意的字母、数字、中文";  
        return false;  
    }     
}   
//2.检查密码
function checkPassword(){  
    var password = document.getElementById("password").value;  
    var spanNode = document.getElementById("passwordSpan");  
    //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
    var reg = /^([a-zA-Z0-9]){6,16}$/i;      
    if(reg.test(password)){  
        //符合规则  
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "密码的长度为6-16，只能是任意的字母、数字";    
        return false;  
    }     
}   
//3.检查邮箱  
function checkEmail(){  
    var email = document.getElementById("email").value;  
    var spanNode = document.getElementById("emailSpan");  
       //编写邮箱的正则  
    var reg = /^[a-z0-9]\w+@[a-z0-9]+(\.[a-z]{2,3}){1,2}$/i;   
    if(reg.test(email)){  
        //符合规则    
        return true;  
    }else{  
        //不符合规则   
        spanNode.innerHTML = "邮箱格式不正确，请重新填写！";  
        return false;  
    }     
}  
//4.检查两次输入的密码是否一致
function checkSame(){  
  var password = document.getElementById("password").value; 
  var password2 = document.getElementById("password2").value;  
  var spanNode = document.getElementById("passwordSpan2");  
     //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
     var reg = /^([a-zA-Z0-9]){6,16}$/i;   
     //确认密码输入符合规则  
     if(reg.test(password2)){  
         //符合规则  
         if(password==password2){ 
              return true;  
         }else{
            spanNode.innerHTML = "两次输入的密码不一致！";     
             return false;  
         }
     }
     //确认输入密码不符合规则  
     else{  
        spanNode.innerHTML = "密码的长度为 6-16，只能是任意的字母、数字";   
         return false;  
     }     
}  
    
//5.检查学号是否符合输入规则
function checkId(){  
    var id = document.getElementById("id").value;  
    var spanNode = document.getElementById("idSpan");  
    //学号的规则： 12，包含任意的字母、数字，不可以使用其他符号
    var reg = /^20([0-9]){10}$/i;      
    if(reg.test(id)){  
        //符合规则  
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "学号的长度为12，只能是数字，不可以使用其他符号";  
        return false;  
    }     
}  

//6.检查手机号是否符合输入规则
function checkPhone(){  
    var manner = document.getElementById("phone").value;  
    var spanNode = document.getElementById("phoneSpan");  
    //手机号的规则： 11，包含任意的字母、数字，不可以使用其他符号
    var reg = /^1[^12]([0-9]){9}$/i;      
    if(reg.test(manner)){  
        //符合规则   
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "手机号的长度为11位";   
        return false;  
    }     
}  

//7.检查联系方式是否符合输入规则
function checkManner(){  
    var manner = document.getElementById("manner").value;  
    var spanNode = document.getElementById("mannerSpan");  
    //账号的规则： 11，包含任意的字母、数字，不可以使用其他符号
    var reg = /^1[^12]([0-9]){9}$/i;      
    if(reg.test(manner)){  
        //符合规则     
        return true;  
    }else{  
        //不符合规则     
        spanNode.innerHTML = "手机号的长度为11位";     
        return false;  
    }     
}  


    //8.检查用户所有的输入的所有是否符合规则
    function checkAll(){  
        var email = checkEmail();  
        var name = checkName();  
        var id = checkId();  
        var password = checkPassword();  
        var same = checkSame();  
        var phone = checkPhone();
        var manner = checkManner();
        if((email&&name&&id&&password&&same&&manner)||(email&&name&&phone&&password&&same&&manner)){  
            return true;  
        }else{  
            return false;  
        } 
    }    

    $(function () {
    	$('#phone').removeAttr('required');
        $('#id').attr('required','true');
        $('#id').attr('name','id');
        $(".phone_register").hide();
        $(".manner .id").click(function () {
            $(".id_register").show().siblings(".phone_register").hide();
            $("li>input").val("");
            $('#id').attr('required','true');
            $('#phone').removeAttr('required');

            $('#id').attr('name','id');
            $('#phone').removeAttr('name');
            
            for(var i=0; i<8; i++){
                $("li>span")[i].innerHTML="";
            }
            
         })
         $(".manner .phone").click(function () {
            $(".id_register").hide().siblings(".phone_register").show();
            $("li>input").val("");
            $('#phone').attr('required','true');
            $('#id').removeAttr('required');
            
            $('#id').removeAttr('name');
            $('#phone').attr('name','id');
            for(var i=0; i<8; i++){
                $("li>span")[i].innerHTML="";
            }
            
         })
         $("#reset").click(function () {
                for(var i=0; i<8; i++){
                    $("li>span")[i].innerHTML="";
                }
            })
    
         // 当再次获取焦点时，提醒消失
        $("#name").focus(function () {
            $("#nameSpan")[0].innerHTML=" ";
        })
        $("#phone").focus(function () {
            $("#phoneSpan")[0].innerHTML=" ";
        })
        $("#id").focus(function () {
            $("#idSpan")[0].innerHTML=" ";
        })
        $("#email").focus(function () {
            $("#emailSpan")[0].innerHTML=" ";
        })
        $("#password").focus(function () {
            $("#passwordSpan")[0].innerHTML=" ";
        })
        $("#password2").focus(function () {
            $("#passwordSpan2")[0].innerHTML=" ";
        })
        $("#manner").focus(function () {
            $("#mannerSpan")[0].innerHTML=" ";
        })
    
               
    })
    
