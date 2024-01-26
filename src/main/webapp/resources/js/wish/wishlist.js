
$("#add").click(function(){
    $("#deleteForm").attr("action", "../account/add")
    $("#deleteForm").submit();
});

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
    // let param ="";
    // nums.forEach(element => {
    //     param=param+"productNum="+element+"&";
    // });

    let deleteForm = document.getElementById("deleteForm");
    console.log(deleteForm)
    let form = new FormData(deleteForm);

    fetch("./delete",{
        method:"POST",
         headers:{
             "Content-type":"application/x-www-form-urlencoded"
         },
        body:"productNum="+nums
        //body:form
    } )
    .then(response=> response.text())
    .then(response=>{
        console.log(response);
        $("#ajaxList").html(response);
    })
}

function deleteWithJquery(nums){

    let form = new FormData($("#deleteForm")[0]);

    $.ajax({
        method:"post",
        url:"./delete",

        cache:false,
        contentType:false,
        processData:false,
        data:form,
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

$('#ajaxList').on("click", ".checks", function(){
    let flag=true;
    
    $('.checks').each(function(idx, c){
        
        if(!$(c).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    $("#checkAll").prop("checked", flag);
})