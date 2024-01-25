
$("#del").click(function(){

    let nums = [];
    let checkElement=[];
    $(".checks").each(function(idx, item){
        if($(item).prop("checked")){
           nums.push($(item).val());
           checkElement.push(item);
        }
    });

    $.ajax({
        method:"post",
        url:"./delete",
        traditional:true,
        data:{
            productNum:nums, 
        },
        success:function(result){
            if(result.trim()>0){
               //1. location.reload();

               //2. Element들 삭제
            //    checkElement.forEach((element)=>{
            //         $(element).parent().parent().parent().remove();
            //    })
                //3. DB에서 조회를 다시 해서 html()

            }
        },
        error:function(){
            alert('알수없는 에러 발생 관리자에 문의');
        }
    })
    console.log(nums);

});

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