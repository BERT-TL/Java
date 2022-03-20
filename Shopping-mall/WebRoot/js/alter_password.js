// 判断所有的输入值是否符合规则

//检测用户名
function checkId(){  
    var id = document.getElementById("id").value;  
    var spanNode = document.getElementById("idSpan");  
    //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
    var reg = /^([0-9]){11,12}$/i;      
    if(reg.test(id)){  
        //符合规则  
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "用户名只能是数字!";   
        return false;  
    }     
}   
//1.检查密码
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

//2.检查两次输入的密码是否一致
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
    



    //3.检查用户所有的输入的所有是否符合规则
    function checkAll(){  
        var id = checkId();
        var password = checkPassword();  
        var same = checkSame();  
        if(id&&password&&same){  
            return true;  
        }else{  
            return false;  
        } 
    }    

    $(function () {
        $("#reset").click(function () {
            for(var i=0; i<3; i++){
                $("li>span")[i].innerHTML="";
            }
        })
    
         // 当再次获取焦点时，提醒消失        
         $("#id").focus(function () {
            $("#idSpan")[0].innerHTML=" ";
        })
        $("#password").focus(function () {
            $("#passwordSpan")[0].innerHTML=" ";
        })
        $("#password2").focus(function () {
            $("#passwordSpan2")[0].innerHTML=" ";
        })
        

    
               
    })
    
