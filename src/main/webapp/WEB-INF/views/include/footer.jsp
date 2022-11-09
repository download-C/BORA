<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<footer id="footer">

    <div class="footer-newsletter">
      <div class="container">
        <div class="row justify-content-center">

        </div>
      </div>
    </div>

    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6 footer-contact">
            <h3>BORA<span>.</span></h3>
            <p>
              개인정보처리방침 <br>
              영업점 안내<br>
               <br><br>
              <strong>고객센터 번호:</strong> 051-803-0909<br>
              <strong>영업시간:</strong> 09:00 ~ 18:00<br>
            </p>
          </div>

        </div>
      </div>
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <!-- Vendor JS Files -->
    <script src="${pageContext.request.contextPath}/resources/vendor/purecounter/purecounter_vanilla.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/aos/aos.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<%--     <script src="${pageContext.request.contextPath}/resources/vendor/swiper/swiper-bundle.min.js"></script> --%>
    <script src="${pageContext.request.contextPath}/resources/vendor/waypoints/noframework.waypoints.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/php-email-form/validate.js"></script>

<%--     <script src="${pageContext.request.contextPath}/resources/js/core/bootstrap.min.js"></script> --%>
  <script src="${pageContext.request.contextPath}/resources/js/perfect-scrollbar.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<%--   <script src="${pageContext.request.contextPath}/resources/js/soft-ui-dashboard.min.js?v=1.0.6"></script> --%>

  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

<%} //헤더에 있는 세션값 존재 여부 확인하는 코드 닫는 괄호
	//절대 삭제XXXX%>

</body>
</html>