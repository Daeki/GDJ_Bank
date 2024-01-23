console.log("agreement");

//js
// const checkAll = document.getElementById("checkAll");
// const checks = document.getElementsByClassName("checks");
// const btn = document.getElementById("btn");
// const req = document.getElementsByClassName("req");

// checkAll.addEventListener("click", ()=>{
//     let v = checkAll.getAttribute("checked");
//     console.log("CHECK : ", v);
//     v = checkAll.checked;
    
//     for(let check of checks){
//         check.checked=v;
//     }

// })

// for(let c of checks){
//     c.addEventListener("click", function(){
//         let flag=true;
//        for(let ch of checks){
//             if(!ch.checked){
//                 flag=!flag;
//                 break;
//             }
//        }

//        checkAll.checked=flag;

//     })
// }

// //----------------------------
// btn.addEventListener("click", function(e){
//     e.preventDefault();
    
//     let flag=true;

//     for(let r of req){
//         if(!r.checked){
//             flag=!flag;
//             break;
//         }
//     }

//     if(flag){
//         location.href="./join";
//     }else {
//         alert('필수 약관은 동의 해야 함');
//     }

// })



//jquery
$('#checkAll').click(()=>{
    let v = $("#checkAll").prop("checked");
    
    $('.checks').prop("checked", v);
});

$('.checks').click(function(){
    let flag=true;
    
    $('.checks').each(function(idx, c){
        
        if(!$(c).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    $("#checkAll").prop("checked", flag);
})

$('#btn').click(function(e){
    e.preventDefault();
    
    let flag=true;

    $('.req').each(function(idx, r){
        if(!$(r).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    if(flag){
        location.href="join";
    }else {
        alert('필수 약관 동의 필요');
    }


});