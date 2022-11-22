<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- alert 모달 필수  --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<style>

@media (max-width: 768px) {
	.main-table {
		width: 95%;
	}
	.card-col{
		min-height:280px; 
	}
	.title-content{
	 min-height: 260px;
	}
	
}


@media (min-width: 992px ) {
	.main-table {
		width: 45%;
	}
		.card-col{
		min-height: 320px; 
	}
	.title-content{
	min-height: 230px;
	}
}


@media (min-width: 1400px) {
	.main-table {
		width: 45%;
	}
	.title-content{
		height: 200px;
	}
	.card-col {
		height: 280px;
	}
}
</style>

<!-- login 성공 메세지 불러오기 -->
<script>
$(document).ready(function(){	
	let message = "${msg}";
	if(message!="") {
		login(message);
	}
 });
</script>

<!-- login 성공 alert 모달 -->
<script>
function login(message) {
  	Swal.fire({
	  title: message,
	  text: '',
	  padding: '3em',
// 	  background: '#fff',
// 	  backdrop: 'rgba(122, 28, 246, 0.2)',	  
	  confirmButtonColor: '#7A1CF6'
   	})
}
</script>


<!-- 뉴스 JS 시작 -->
<script type="text/javascript">
$(document).ready(function(){
		$.ajax({
			url:"https://fs.jtbc.co.kr//RSS/economy.xml",
			success:function(rData){
				$(rData).find("item").each(function(index){
					if (index < 3) {
						// 기사 3개만 나타나도록 (0, 1, 2)
						var title = $(this).find("title").text();
						var desc = $(this).find("description").text();
						var link = $(this).find("link").text();
						
						switch(index) {
						case 0:
							$('#newsTitle1').html(title);
							$('#newsDesc1').html(desc + '...');
							$('#newsLink1').attr('href', link);
							$('#newsLink1').attr('target', '_blank');
							break;
						case 1:
							$('#newsTitle2').html(title);
							$('#newsDesc2').html(desc + '...');
							$('#newsLink2').attr('href', link);
							$('#newsLink2').attr('target', '_blank');
							break;
						case 2:
							$('#newsTitle3').html(title);
							$('#newsDesc3').html(desc + '...');
							$('#newsLink3').attr('href', link);
							$('#newsLink3').attr('target', '_blank');
							break;
						}
					} else return false;
				}); // each
			}, // success
			error:function(){
				alert("페이지 다녀오기 실패");
			}
		}); // ajax
});//jquery
</script>

<div class="container">
<!-- 뉴스 JS 끝 -->


<!-- mainslide -->
  <section id="mainslide">
    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
          aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000" style="display: flex;">
          <img src="${pageContext.request.contextPath}/resources/img/002.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <img src="${pageContext.request.contextPath}/resources/img/001.png" class="d-block w-100" alt="...">
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </section>
  <!-- End mainslide -->

  <!-- 뉴스 공간 =============================================== -->
  <section id="cardnews" class="mt-5">
    <div class="container">
      <h2 class="ms-5"><b>금융뉴스</b></h2>
      <p class="me-5" align="right">
      	<b><a href="https://news.jtbc.co.kr/section/index.aspx?scode=20" target="_blank"
      			style="color: #444444;">더보기> </a></b>
      </p>
      <div class="row row-cols-1 row-cols-md-3 g-3 me-5 ms-5">
        
        <!-- 뉴스 1 =========================== -->
        <div class="col ">
          <div class="card text-center card-col">
            <div class="card-body">	
            	<div class="title-content">
	              <h5 class="card-title" id="newsTitle1"></h5>
	              <p class="card-text" id="newsDesc1"></p>
            	</div>
              <a id="newsLink1" href="#" class="btn btn-primary" style="border: none; background: #5107B0;">자세히보기</a>
            </div>
          </div>
        </div>
        
        <!-- 뉴스 2 =========================== -->
        <div class="col ">
          <div class="card text-center card-col">
            <div class="card-body">
            <div class="title-content">
              <h5 class="card-title" id="newsTitle2"></h5>
              <p class="card-text" id="newsDesc2"></p>
             </div>
              <a id="newsLink2" href="#" class="btn btn-primary" style="border: none; background: #5107B0;">자세히보기</a>
            </div>
          </div>
        </div>
        
        <!-- 뉴스 3 =========================== -->
        <div class="col">
          <div class="card text-center card-col">
            <div class="card-body">
            <div class="title-content">
              <h5 class="card-title" id="newsTitle3"></h5>
              <p class="card-text" id="newsDesc3"></p>
              </div>
              <a id="newsLink3" href="#" class="btn btn-primary" style="border: none; background: #5107B0;">자세히보기</a>
            </div>
          </div>
        </div>
        
      </div>
    </div>
  </section>
  <!-- 뉴스 공간 끝 =============================================== -->

  <br><br>
  <hr><br><br>
  <div class="m-4">
    <div class="container">
      <!-- <div class="row row-cols-md-3 g-3" style="display: flex; justify-content: space-between; flex-flow: row nowrap; margin-bottom: 10px;"> -->
      <div class="row row-cols-md-3 g-3" >
        <!-- News! -->
        <div class="container main-table" style="margin: 0px 20px; ">
          <h2><b>공지사항</b></h2>
          <p align="right"><b><a href="/main/noticeList?page=1" style="color: #444444;">더보기 ></a></b></p>
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th>No.</th>
                  <th>제목</th>
                  <th>작성일자</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="list" items="${noticeList }" >
                <tr>
                  <td>${list.nno}</td>
                  <td><a href="/main/noticeRead?nno=${list.nno }&page=1" style="color: #444444;	">${list.n_title}</a></td>
                  <td><fmt:formatDate value="${list.n_regdate}" pattern="yyyy.MM.dd."/>  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <!-- End News! -->

        <!-- community -->
        <div class="container main-table" style="margin: 0px 20px;">
          <h2><b>커뮤니티</b></h2>
          <p align="right"><b><a href="/board/list" style="color: #444444;">더보기 ></a></b></p>
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th>No.</th>
                  <th>제목</th>
                  <th>작성일자</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${cmntList }" var="cList">
                	<tr>
                	  <td>${cList.bno}</td>
                  	  <td><a href="/board/read?bno=${cList.bno}&page=1", style="color: #444444;">${cList.b_title}</a></td>
                 	  <td><fmt:formatDate value="${cList.b_regdate }" pattern="yyyy.MM.dd." /></td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div> <!-- cmnt container -->
        
      </div> <!-- row -->
    </div> <!-- container -->
  </div> <!-- m-4 -->
  <!-- End community -->
</div>

<%@ include file="../include/footer.jsp"%>