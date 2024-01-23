console.log('join check');

//js
// const password = document.getElementById("password");
// const passwordResult = document.getElementById("passwordResult");
// const passwordCheck = document.getElementById("passwordCheck");
// const passwordCheckResult = document.getElementById("passwordCheckResult");



// password.addEventListener('blur', function(){
//     let p = password.value;
//     if(p.length>7){
//         passwordResult.innerHTML='OK'
//     }else {
//         passwordResult.innerHTML='비번은 8글자 이상 이어야 함'
//     }
// })

// passwordCheck.addEventListener('keyup', function(){
//     if(passwordCheck.value==password.value){
//         passwordCheckResult.innerHTML='일치 한다'
//     }else {
//         passwordCheckResult.innerHTML='일치 하지 않는다'
//     }

// });


/// jquery
$('#password').blur(function(){
    if($('#password').val().length>7){
        $('#passwordResult').html('OK');
    }else {
        $('#passwordResult').html('비번은 8글자 이상 이어야 함');
    }
});

$('#passwordCheck').keyup(function(){
    if($('#passwordCheck').val()==$('#password').val()){
        $('#passwordCheckResult').html('일치 한다')
    }else {
        $('#passwordCheckResult').html('일치하지 않는다')
    }

});

