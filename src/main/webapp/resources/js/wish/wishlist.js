
$("#del").click(function(){

    let nums = [];
    let checkElement=[];
    $(".checks").each(function(idx, item){
        if($(item).prop("checked")){
           nums.push($(item).val());
           checkElement.push(item);
        }
    });

    //deleteWithJquery(nums);
    deleteWithFetch(nums);
    console.log(nums);

});

function deleteWithFetch(nums){
    let param ="";
    nums.forEach(element => {
        param=param+"productNum="+element+"&";
    });

    fetch("./delete",{
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:param
    } )
    .then(response=> response.text())
    .then(response=>{
        console.log(response);
        $("#ajaxList").html(response);
    })
}

function deleteWithJquery(nums){
    $.ajax({
        method:"post",
        url:"./delete",
        traditional:true,
        data:{
            productNum:nums, 
        },
        success:function(result){
            //if(result.trim()>0){
                //1. location.reload();
                
                //2. Element들 삭제
                //    checkElement.forEach((element)=>{
                    //         $(element).parent().parent().parent().remove();
                    //    })
                    
                    
                    //}
            //3. DB에서 조회를 다시 해서 html()
            $("#ajaxList").html(result.trim());
        },
        error:function(){
            alert('알수없는 에러 발생 관리자에 문의');
        }
    })

}

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