<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
function email_check( email ) {    
    var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (email != '' && email != 'undefined' && regex.test(email)); 
}

$("input[type=email]").blur(function(){
  var email = $(this).val();
  if( email == '' || email == 'undefined') return;
  if(! email_check(email) ) {
  	$(".result-email").text('이메일 형식으로 적어주세요');
    $(this).focus();
    return false;
  }else {
	$(".result-email").text('');
  }
});
</script>
   <h1>card/card_update.jsp</h1>
   <form action="/card/card_update" method="post">
       <input type="email" name="update_user_email" value="user_email" id="email" maxlength="30">
       <input type="submit" value="수정하기">
   </form>

   
