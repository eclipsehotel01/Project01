//paging
function getListData(pageNum, field, word) {
   $("body").load("pay_list", {
      "pageNum" : pageNum,
      "field" : field,
      "word" : word
   }, function(responseText) {
      $("body").html(responseText);
   });
}

function payCancel(){
   var cb = "";
   $("input[name='cb']:checked").each (function (){
      cb = cb + $(this).val()+"," ;
   });
   
   //맨끝 콤마 지우기
   cb = cb.substring(0,cb.lastIndexOf(",")); 

   //체크박스 선택 확인
   if(cb == ''){   
      alert("결제 취소 할 대상을 선택하세요.");
      return false;
   }
   
   //결제취소
   $.get("pay_cancel",
         {"p_num" : cb},
         function(data){
            if(data=='fail'){
               alert("이미 취소된 결제입니다.");
               location.href="pay_list";
            }else {
               alert("결제번호 : " + cb + "가 취소되었습니다.");
               location.href="pay_list";
            }
         }
   );
   
}
//선택취소
function unchecked(){
   $('input:checkbox[id="selectAll"]').attr("checked", false);
   $('input:checkbox[id="cb"]').attr("checked", false);
}

 //전체선택
$(document).ready(function(){
   $("#selectAll").click(function(){
        var chk = $(this).is(":checked");//.attr('checked');
          if(chk) {
        
           $('input:checkbox[id="cb"]').prop("checked", true);
           $("#checked").val("선택해제");
          // $(this).next().text("선택해제");
        }
        else{
           $('input:checkbox[id="cb"]').prop("checked", false);
           $("#checked").val("전체선택");
          // $(this).next().text("전체선택");
        }
    });
   
   $("#checked").click(function(){
      if($(this).val()=="전체선택"){
         var chk =$("#selectAll").prop("checked", true);
               $('input:checkbox[id="cb"]').prop("checked", true);
             // $("#selectAll").next().text("전체선택해제");
              $(this).val("선택해제");
       }
           else{
              $('input:checkbox[id="cb"]').prop("checked", false);
              $("#selectAll").prop("checked", false);
             // $("#selectAll").next().text("전체선택");
              $(this).val("전체선택");
          
           }
      
      
    });
}); 
