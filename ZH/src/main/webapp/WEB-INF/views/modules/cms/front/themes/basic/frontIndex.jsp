<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

<title>My Sunshine ${starUserName}</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Meta-Tags -->

<!-- Custom-Stylesheet-Links -->
<!-- Bootstrap-CSS -->  <link rel="stylesheet" href="${ctxStatic}/zh/css/bootstrap.min.css" 		 type="text/css" media="all">
<!-- Insex-Page.CSS --> <link rel="stylesheet" href="${ctxStatic}/zh/css/style.css" 				 type="text/css" media="all">
<!-- Slider-CSS --> 	<link rel="stylesheet" href="${ctxStatic}/zh/css/camera.css" id="camera-css" type="text/css" media="all">
<!-- Portfolio-CSS -->	<link rel="stylesheet" href="${ctxStatic}/zh/css/swipebox.css"				 type="text/css" media="all">
<!-- login-CSS -->		<link rel="stylesheet" type="text/css" href="${ctxStatic}/zh/css/login/font-awesome.min.css">
<!-- login-CSS -->		<link rel="stylesheet" type="text/css" href="${ctxStatic}/zh/css/login/material-design-iconic-font.min.css">
<!-- login-CSS -->		<link rel="stylesheet" type="text/css" href="${ctxStatic}/zh/css/login/util_login.css">
<!-- login-CSS -->		<link rel="stylesheet" type="text/css" href="${ctxStatic}/zh/css/login/main_login.css">
<!-- //Custom-Stylesheet-Links -->

<!-- Fonts 演示修改文件 -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700"	   type="text/css" media="all">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat:400,700"			   type="text/css" media="all">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" type="text/css" media="all">
<!-- //Fonts -->

	<style>
		.w3threespecialityw3ls-info {
			width: 380px;
			height: 338px;
		}
		.w3threespecialityw3ls-info img {
			width: 100%;
			/*height: 100%;*/
		}
		.album-front h3 {
			font-size: 18px
		}
		.cs-style-3 figcaption {
			height: 70px;
		}
		/*a{
			color: #eee;
		}*/
		.agileaboutaits-image-1 {
			height: 390px;
			overflow: hidden;
		}
		.agileaboutaits-image-2 {
			height: 260px;
			overflow: hidden;
		}
	</style>
</head>
<!-- //Head -->

<!-- Body1 -->
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<script src="http://www.jq22.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    var $lightGallery = $;	//新的命名
</script>
<script src="${ctxStatic}/zh/js/lightGallery.js"></script>

<link rel="stylesheet"  href="${ctxStatic}/zh/css/lightGallery.css"/>
<script>
    window.onload = function(){
        setTimeout(lightGallery,2000);
    };
    function lightGallery() {
        $(".lightGalleryBox a").each(function(){
            var id = $(this).children("span").text();
            var s  = $(this).parent();
            $.ajax({url:"${ctx}/alubmPhotoList",data:{id:id},async:false,success:function(result){
                    s.append(result);
                }
            });
        });
        $lightGallery(".lightGalleryBox").lightGallery();
    };
</script>
<!-- Supportive-JavaScript -->
<script src="${ctxStatic}/zh/js/modernizr.js"></script>
<!-- //Supportive-JavaScript -->

<script type="text/javascript">
	$(function () {
		$("#loginbtn").on("click",function(){
            $("#resultMsg").hide();
            $("#logining").show();
            //加表单验证
            setTimeout(function(){
                $.ajax({
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "${ctx}/star/login" ,//url
                    data: $('#loginform').serialize(),
                    success: function (result) {
 							console.log("success"+result.success+result.resultMsg)
                        if(result.success==true){
                            $("#logining").hide();
                            $("#resultMsg").text(result.resultMsg);
                            $("#resultMsg").attr("style","color: green");
                            $("#resultMsg").show();
                            setTimeout(function(){
                            	window.location.href="f";
							},3000)
                        }else {
                            $("#logining").hide();
                            $("#resultMsg").attr("style","color: red");
                            $("#resultMsg").text(result.resultMsg);
                            $("#resultMsg").show();
                            console.log("2");
                        }
                    },
                    error : function() {
                        $("#logining").hide();
                        $("#resultMsg").text("500访问异常，请联系管理员");
                    }
                });
            },500)
		})
    })

</script>
<div id="loginWindow" hidden="hidden" style="z-index: 200">
	<div class="limiter">
		<div class="container-login100" style="position:fixed;z-index: 2;top: 28px;" >
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<div style="margin-top: -77px;float:  right;margin-right: -40px;">
					<a href="#0" class="cd-loginclose" style="font-size: 54px;">×</a>
				</div>
				<form id="loginform" onsubmit="return false" action="##" class="login100-form validate-form" >
				<%--<form id="loginform"  class="login100-form validate-form"  >--%>
					<span class="login100-form-title p-b-49">登录</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100">用户名</span>
						<input class="input100" type="text" name="username" placeholder="请输入用户名" autocomplete="off">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span>
						<input class="input100" type="password" name="pass" placeholder="请输入密码">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>

					<div class="text-right p-t-8 p-b-31">
						<a href="javascript:">忘记密码？</a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button   class="login100-form-btn" id="loginbtn">登 录</button>
						</div>
						<span id="logining" hidden="hidden">正在登陆...</span>
						<span id="resultMsg"   hidden="hidden"> </span>
					</div>

					<div class="txt1 text-center p-t-54 p-b-20">
						<span>第三方登录</span>
					</div>

					<div class="flex-c-m">
						<a href="#" class="login100-social-item bg1">
							<i class="fa fa-wechat"></i>
						</a>

						<a href="#" class="login100-social-item bg2">
							<i class="fa fa-qq"></i>
						</a>

						<a href="#" class="login100-social-item bg3">
							<i class="fa fa-weibo"></i>
						</a>
					</div>

					<div class="flex-col-c p-t-25">
						<a href="javascript:" class="txt2">立即注册</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctxStatic}/zh/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/zh/js/login_validate.js"></script>

	<!-- Header -->
	<div class="agileheaderw3ls" id="agilehomewthree">
		<!-- Navigation -->
		<section class="cd-section">
			<a class="cd-bouncy-nav-trigger" href="#0">MENU</a>
		</section>
		<div class="cd-bouncy-nav-modal">
			<nav>
				<ul class="cd-bouncy-nav">
					<li><a class="scroll" href="#agilehomewthree">首页</a></li>
					<c:if test="${not empty starUserName}">
						<li><a   href="${ctx}/star/loginOut">退出登录</a></li>
					</c:if>
					<c:if test="${empty starUserName}">
						<li><a class="cd-login" href="#0">登录</a></li>
					</c:if>
					<%--<li><a class="scroll" href="#agileaboutaitsabout">关于</a></li>
					<li><a class="scroll" href="#w3threespecialityw3ls">图片</a></li>
					<li><a class="scroll" href="#skills">视频</a></li>
					<li><a class="scroll" href="#contact">联系我们</a></li>--%>
				</ul>
			</nav>
			<a href="#0" class="cd-close">Close modal</a>
		</div>
		<!-- //Navigation -->

		<!-- Slider -->
		<div class="w3slideraits">
			<div class="camera_wrap w3layouts agileits camera_magenta_skin" id="camera_wrap_2">
				<c:forEach items="${bgPhoto}" var="bg">
					<div  data-src="${uploadfile}${bg.url}" class="w3layouts agileits">
						<div class="camera_caption w3layouts agileits fadeFromBottom">
							<h3 class="w3layouts agileits">${bg.title}</h3>
							<h2 hidden="hidden">${bg.starId}</h2>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- //Slider -->
	</div>
	<!-- //Header -->
<%-- 个人信息对照轮播图 script--%>
<script>
	$(function(){
		setTimeout(1000);
        fn();
    });
     function fn(){
		 var defult = "";
         var id = $("div.cameracurrent").find("h2").text();
         if(id != defult && id != null){
			$(".agileaboutaits").hide();
			$("#"+id).show();
		 }
        setTimeout(fn, 500)
    }
</script>
<%-- 个人信息对照轮播图 script--%>
<%--ajax 相册访问次数--%>
<script>
	$(function () {
        function albumClick() {
            alert(1);
            $.post("${ctx}/star/starAlbum/albumClick",{id:id},function(data){
            })
        }
    })

</script>
<%--ajax 相册访问次数--%>
	<!-- About -->
	<div class="agileaboutaitsabout" >

		<c:forEach items="${starMessageList}" var="starMessage" >
		<div class="agileaboutaits" hidden="hidden" id="${starMessage.id}">
			<div class="container">
				<div class="col-md-6 col-sm-6 agileaboutaits-grid agileaboutaits-info">
					<h1>关于 Ta</h1>
					<P>${fns:abbr(starMessage.about,500 )}</P>
					<button class="btn btn-primary camera_stop"   data-toggle="modal" data-target="#myModal${starMessage.id}">了解更多<span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
				</div>

				<div class="col-md-6 col-sm-6 agileaboutaits-grid agileaboutaits-image">
					<div class="agileaboutaits-image-1">
						<img src="${uploadfile}${starMessage.aboutPhoto1}" alt="Couture" >
					</div>
					<div class="agileaboutaits-image-2">
						<img src="${uploadfile}${starMessage.aboutPhoto2}"  alt="Couture">
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>

				<!-- Tooltip -->
				<div class="tooltip-content">

					<div class="modal fade features-modal" id="myModal${starMessage.id}" tabindex="-1" role="dialog" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title">${starMessage.name}</h4>
								</div>
								<div class="modal-body">
									<img src="${uploadfile}${starMessage.photoUrl}" alt="Hitech Info">
									<p>
											${starMessage.experience}
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- //Tooltip -->
			</div>
		</div>
		</c:forEach>
	</div>
	<!-- //About -->



	<!-- Speciality -->
	<div class="w3threespecialityw3ls" id="w3threespecialityw3ls">
		<div class="container">

			<h2>为你代"颜"</h2>
			<div class="grid cs-style-3">
					<c:forEach items="${starAlbumlist}" var="p">
							<div class="col-md-4 col-sm-4 w3threespecialityw3ls-grid grid1" style="width: 350px;height: 350px;margin-left: 5px">
								<div class="lightGalleryBox" onclick="albumClick();">
									<a data-src="${uploadfile}${p.url}" data-title="${p.name}" >
										<span hidden="hidden">${p.id}</span>
										<figure>
											<div class="w3threespecialityw3ls-info">
												<img src="${uploadfile}${p.url}" alt="Couture" >
											</div>
											<figcaption class="album-front">
												<h3>${p.name}</h3>
											</figcaption>
										</figure>
									</a>
									<%--考虑到打开首页加载图片过多  延迟2秒加载--%>
									<%--<c:forEach items="${p.photoList}" var="img">--%>
										<%--<a data-src="${uploadfile}${img.url}"  title="${img.title}">--%>
											<%--<img src="${uploadfile}${img.url}" hidden="hidden"  alt="Couture">--%>
										<%--</a>--%>
									<%--</c:forEach>--%>
								</div>
							</div>
					</c:forEach>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>

		</div>
	</div>
	<!-- //Speciality -->

	<!-- Progressive-Effects -->
	<div class="progressive-effects" id="skills">
		<div class="container">

			<!-- Skills -->
			<div id="about-us" class="parallax">
				<h3>天籁之音</h3>
				<iframe src="https://www.hackhp.com/demo/MKOnlineMusicPlayer/" border="0" marginwidth="0" marginheight="0" scrolling="+s+" width="100%" height="500" frameborder="0"></iframe>
				<%--<div class="our-skills wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
					<div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
						<p class="lead">Photography</p>
						<div class="progress">
							<div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar" aria-valuetransitiongoal="90">90%</div>
						</div>
					</div>--%>
			</div>
			<!-- //Skills -->

			<!-- Stats -->
			<div class="stats">
				<h3>生活八卦/新闻活动</h3>

				<div class="stats-info">
					<div class="col-md-3 col-sm-3 stats-grid stats-grid-1">
						<div class="stats-img">
							<img src="${ctxStatic}/zh/images/s1.png" alt="Corsa Racer">
						</div>
						<div class='numscroller counter numscroller-big-bottom' data-slno='1' data-min='0' data-max='7000' data-delay='.5' data-increment=4>7000</div>
						<p>Happy Clients</p>
					</div>
					<div class="col-md-3 col-sm-3 stats-grid stats-grid-2">
						<div class="stats-img">
							<img src="${ctxStatic}/zh/images/s2.png" alt="Corsa Racer">
						</div>
						<div class='numscroller counter numscroller-big-bottom' data-slno='1' data-min='0' data-max='170' data-delay='8' data-increment="1">170</div>
						<p>Projects</p>
					</div>
					<div class="col-md-3 col-sm-3 stats-grid stats-grid-3">
						<div class="stats-img">
							<img src="${ctxStatic}/zh/images/s3.png" alt="Corsa Racer">
						</div>
						<div class='numscroller counter numscroller-big-bottom' data-slno='1' data-min='0' data-max='19000' data-delay='.5' data-increment="11">19000</div>
						<p>Followers</p>
					</div>
					<div class="col-md-3 col-sm-3 stats-grid stats-grid-4">
						<div class="stats-img">
							<img src="${ctxStatic}/zh/images/s4.png" alt="Corsa Racer">
						</div>
						<div class='numscroller counter numscroller-big-bottom' data-slno='1' data-min='0' data-max='169' data-delay='8' data-increment="1">169</div>
						<p>Awards</p>
					</div>
					<div class="clearfix"></div>
				</div>

			</div>
			<!-- //Stats -->

		</div>
	</div>
	<!-- //Progressive-Effects -->

	<!-- Portfolio -->
	<div class="portfolio" id="portfolio">
		<h3>影视综艺</h3>

		<div class="tabs tabs-style-bar">
			<nav>
				<ul>
					<li><a href="#section-bar-1" class="icon icon-box"><span>最新</span></a></li>
					<li><a href="#section-bar-2" class="icon icon-display"><span>最热</span></a></li>
					<li><a href="#section-bar-3" class="icon icon-upload"><span>经典</span></a></li>
					<li><a href="#section-bar-4" class="icon icon-tools"><span>精品</span></a></li>
				</ul>
			</nav>

			<div class="content-wrap">

				<!-- Tab-1 -->
				<section id="section-bar-1" class="agileits w3layouts">
					<h4>最新</h4>
					<div class="gallery-grids">
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-1.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-1.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-2.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-2.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-3.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-3.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-4.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-4.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-5.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-5.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-6.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-6.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-7.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-7.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-8.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-8.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/fashion-9.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/fashion-9.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</section>
				<!-- //Tab-1 -->

				<!-- Tab-2 -->
				<section id="section-bar-2" class="agileits w3layouts">
					<h4>最热</h4>
					<div class="gallery-grids">
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-1.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-1.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-2.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-2.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-3.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-3.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-4.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-4.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-5.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-5.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-6.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-6.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-7.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-7.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-8.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-8.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/event-9.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/event-9.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</section>
				<!-- //Tab-2 -->

				<!-- Tab-3 -->
				<section id="section-bar-3" class="agileits w3layouts">
					<h4>经典</h4>
					<div class="gallery-grids">
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-1.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-1.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-2.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-2.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-3.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-3.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-4.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-4.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-5.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-5.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
								<a href="${ctxStatic}/zh/images/nature-6.jpg" class="swipebox">
									<figure class="effect-bubba">
										<img src="${ctxStatic}/zh/images/nature-6.jpg" alt="" class="img-responsive">
										<figcaption>
											<h4>Photography</h4>
										</figcaption>
									</figure>
								</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-7.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-7.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-8.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-8.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/nature-9.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/nature-9.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</section>
				<!-- //Tab-3 -->

				<!-- Tab-4 -->
				<section id="section-bar-4" class="agileits w3layouts">
					<h4>精品</h4>
					<div class="gallery-grids">
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-1.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-1.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-2.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-2.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-3.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-3.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-4.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-4.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-5.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-5.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-6.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-6.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-7.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-7.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-8.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-8.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="col-md-4 col-sm-4 gallery-top">
							<a href="${ctxStatic}/zh/images/model-9.jpg" class="swipebox">
								<figure class="effect-bubba">
									<img src="${ctxStatic}/zh/images/model-9.jpg" alt="" class="img-responsive">
									<figcaption>
										<h4>Photography</h4>
									</figcaption>
								</figure>
							</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</section>
				<!-- //Tab-4 -->
				
			</div><!-- //Content -->
		</div><!-- //Tabs -->
	</div>
	<!-- //Portfolio -->

   <div class="tlinks">Collect from <a href="http://www.cssmoban.com/" ></a></div>
	<!-- Booking -->
<%--	<div class="w3layoutsbooking" id="contact">
		<div class="container">

			<h3>Book Your Project</h3>

			<div class="booking-form-aits">
				<form action="#" method="post">
					<input type="text" class="margin-right" Name="Name" placeholder="NAME" required="">
					<input type="email" Name="Email" placeholder="EMAIL" required="">
					<input type="text" class="margin-right" Name="Phone Number" placeholder="PHONE NUMBER" required="">
					<input type="text" Name="Place" placeholder="PLACE" required="">
					<textarea name="Message" placeholder="PROJECT DETAILS" required></textarea>
					<div class="send-button agileits w3layouts">
						<button class="btn btn-primary">SEND MESSAGE<span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
					</div>
				</form>
			</div>

		</div>
	</div>--%>
	<!-- //Booking -->



	<!-- Footer -->
	<div class="footer">
		<div class="container">

			<h3>联系我们</h3>
			<h5>网站建设中...，欢迎您建议与加入，也诚邀您为网站提供精品素材，为自己喜爱的他打call！ O(∩_∩)O </h5>

			<div class="footer-grids">

				<div class="col-md-3 col-sm-3 footer-grid footer-grid-1 address">
					<h4>Address</h4>
					<address>
						<ul>
							<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> tongzhou,BeiJing,China</li>
							<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> 100000</li>
							<%--<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Sant'Agata Bolognese</li>
							<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> BO, Italy</li>--%>
						</ul>
					</address>
				</div>

				<div class="col-md-2 col-sm-2 footer-grid footer-grid-2 phone">
					<h4>Phone</h4>
					<p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 1871-0161-018</p>
					<p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 1551-6061-545</p>
				</div>

				<div class="col-md-2 col-sm-2 footer-grid footer-grid-3 email">
					<h4>Email</h4>
					<p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> <a href="mailto:mail@example.com"> m17080808680@163.com</a></p>
					<p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> <a href="mailto:mail@example.com"> 201330915@qq.com</a></p>
				</div>

				<!-- Newsletter -->
				<div class="col-md-5 col-sm-5 footer-grid footer-grid-4 newsletter">
					<h4>留下您的联系方式</h4>
					<form action="#" method="post">
						<input type="text" placeholder="Email" name="Email" required="">
						<input type="submit" value="发送">
					</form>
				</div>
				<!-- //Newsletter -->
				<div class="clearfix"></div>
				
			</div>

			<!-- Copyright -->
			<div class="copyright">
				<p>&copy; 2018 zprealm.cn 版权所有 京ICP备18005722号-1 </p>
			</div>
			<!-- //Copyright -->

		</div>
	</div>
	<!-- //Footer -->



	<!-- Custom-JavaScript-File-Links -->

		<!-- Bootstrap-JavaScript --> <script type="text/javascript" src="${ctxStatic}/zh/js/jquery.min1.js"></script>
		<!-- Default-JavaScript --><script type="text/javascript" src="${ctxStatic}/zh/js/bootstrap.min.js"></script>

	<!-- Slider-JavaScript-Files -->
			<script type="text/javascript" src="${ctxStatic}/zh/js/jquery.easing.1.3.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/jquery.mobile.customized.min.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/camera.js"></script>
			<script>
				jQuery(function(){
                    jQuery("#camera_wrap_2").camera({
						loader: 'bar',
						speed: 1000,
						pagination: false,
						thumbnails: false
					});
                    jQuery("#camera_wrap_3").camera({
						loader:'bar',
                        speed: 1000,
                        pagination: false,
                        thumbnails: false
                    });
				});
			</script>
		<!-- //Slider-JavaScript-Files -->

		<!-- Navigation-JavaScript -->
			<script src="${ctxStatic}/zh/js/nav.js"></script>
		<!-- //Navigation-JavaScript -->

		<!-- Progressive-Effects-Animation-JavaScript -->
			<script type="text/javascript" src="${ctxStatic}/zh/js/jquery.inview.min.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/wow.min.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/mousescroll.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/main.js"></script>

		<!-- //Progressive-Effects-Animation-JavaScript -->

		<!-- Stats-Number-Scroller-Animation-JavaScript -->
			<script src="${ctxStatic}/zh/js/waypoints.min.js"></script>
			<script src="${ctxStatic}/zh/js/counterup.min.js"></script>
			<script>
				jQuery(document).ready(function( $ ) {
					$('.counter').counterUp({
						delay: 10,
						time: 1000
					});
				});
			</script>
		<!-- //Stats-Number-Scroller-Animation-JavaScript -->

		<!-- Gallery-Tab-JavaScript -->
			<script src="${ctxStatic}/zh/js/cbpFWTabs.js"></script>
			<script>
				(function() {
					[].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el ) {
						new CBPFWTabs( el );
					});
				})();
			</script>
		<!-- //Gallery-Tab-JavaScript -->

		<!-- Swipe-Box-JavaScript -->
			<script src="${ctxStatic}/zh/js/jquery.swipebox.min.js"></script>
				<script type="text/javascript">
					jQuery(function($) {
						$(".swipebox").swipebox();
					});
			</script>
		<!-- //Swipe-Box-JavaScript -->



		<!-- Smooth-Scrolling-JavaScript -->
			<script type="text/javascript" src="${ctxStatic}/zh/js/move-top.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/easing.js"></script>
			<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll, .navbar li a, .footer li a").click(function(event){
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
			</script>
		<!-- //Smooth-Scrolling-JavaScript -->

	<!-- //Custom-JavaScript-File-Links -->





</body>
<!-- //Body -->



</html>