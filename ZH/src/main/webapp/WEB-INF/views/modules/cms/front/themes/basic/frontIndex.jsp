<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

<title>My Sunshine --未登录</title>

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
<!-- //Custom-Stylesheet-Links -->

<!-- Fonts -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700"	   type="text/css" media="all">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat:400,700"			   type="text/css" media="all">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" type="text/css" media="all">
<!-- //Fonts -->

<!-- Supportive-JavaScript -->
<script src="${ctxStatic}/zh/js/modernizr.js"></script>
<!-- //Supportive-JavaScript -->

</head>
<!-- //Head -->

<!-- Body -->
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">



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
					<li><a class="scroll" href="#portfolio">登录</a></li>
					<li><a class="scroll" href="#agileaboutaitsabout">关于</a></li>
					<li><a class="scroll" href="#w3threespecialityw3ls">图片</a></li>
					<li><a class="scroll" href="#skills">视频</a></li>
					<li><a class="scroll" href="#contact">联系我们</a></li>
				</ul>
			</nav>
			<a href="#0" class="cd-close">Close modal</a>
		</div>
		<!-- //Navigation -->

		<!-- Slider -->
		<div class="w3slideraits">
			<div class="camera_wrap w3layouts agileits camera_magenta_skin" id="camera_wrap_2">
				<c:forEach items="${bgPhoto}" var="bg">
					<div data-src="${uploadfile}${bg.url}" class="w3layouts agileits">
						<div class="camera_caption w3layouts agileits fadeFromBottom">
							<h3 class="w3layouts agileits">${bg.title}</h3>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- //Slider -->
	</div>
	<!-- //Header -->



	<!-- About -->
	<div class="agileaboutaitsabout" id="agileaboutaitsabout">
		<div class="agileaboutaits">
			<div class="container">

				<div class="col-md-6 col-sm-6 agileaboutaits-grid agileaboutaits-info">
					<h1>关于 Ta</h1>
					<P>张杰，1982年12月20日出生于四川成都，毕业于四川师范大学，内地流行男歌手，音乐厂牌“行星文化”创始人。2004年获我型我秀全国总冠军出道。2007年参加快乐男声；推出EP《最美的太阳》。2008年推出专辑《明天过后》；担任北京奥运会火炬手。2010年推出专辑《这，就是爱》；担任博鳌亚洲论坛表演嘉宾；获韩国MAMA颁奖礼亚洲之星奖。2012年在人民大会堂开启巡演；作品《风华正茂》获湖南省五个一 ... </P>
					<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">了解更多<span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
				</div>

				<div class="col-md-6 col-sm-6 agileaboutaits-grid agileaboutaits-image">
					<div class="agileaboutaits-image-1">
						<img src="${ctxStatic}/zh/images/zj02.jpg" alt="Couture">
					</div>
					<div class="agileaboutaits-image-2">
						<img src="${ctxStatic}/zh/images/zj.jpg" alt="Couture">
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>

				<!-- Tooltip -->
				<div class="tooltip-content">

					<div class="modal fade features-modal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title">Rachel Weisz</h4>
								</div>
								<div class="modal-body">
									<img src="${ctxStatic}/zh/images/bgzj06.jpg" alt="Hitech Info">
									<p>张杰，1982年12月20日出生于四川成都，毕业于四川师范大学，内地流行男歌手，音乐厂牌“行星文化”创始人。
										2004年获我型我秀全国总冠军出道 [1]  。2007年参加快乐男声；推出EP《最美的太阳》。2008年推出专辑《明天过后》；担任北京奥运会火炬手 [2]  。2010年推出专辑《这，就是爱》；担任博鳌亚洲论坛表演嘉宾 [3]  ；获韩国MAMA颁奖礼亚洲之星奖 [4]  。2012年在人民大会堂开启巡演；作品《风华正茂》获湖南省五个一工程奖 [5]  。2013年首登央视春晚演唱《给我你的爱》；赴美国伯克利音乐学院进修。2014年献唱南京青奥会主题曲《点亮未来》 [6]  ；获第42届全美音乐奖(AMA)年度国际艺人奖 [7]  。2016年在北京工体场开启张杰我想世界巡回演唱会，为内地首位工人体育场开唱80后歌手。2017年在洛杉矶杜比剧院开唱，为首位在奥斯卡杜比剧院开唱内地歌手；献唱第十三届全运会主题曲《健康赢未来》 [8]  ；入驻重庆杜莎夫人蜡像馆 [9]  ；十月世界巡演登陆欧洲，为首位在欧洲开唱的内地歌手 [10]  。2018年开唱北京鸟巢，创下鸟巢单场演唱会票房纪录 [11]  。
										至今已发行12张唱片，举办51场个人演唱会 [12-13]  ，获33次“最受欢迎男歌手”和16次“最佳男歌手”奖，达成内地乐坛“最受欢迎男歌手”大满贯 [14]  ，三度献唱好莱坞电影（《星际迷航3》《间谍同盟》《变形金刚5》 [15-17]  ），三度献唱央视春晚 [18-20]  。
										此外，张杰致力于慈善公益事业，2012年创立北斗星空爱心基金，累计创建39间“张杰音乐梦想教室” [21]  ，获中国儿童慈善奖-突出贡献奖 [22]  、位列中国慈善名人榜第22位 [23]  。</p>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- //Tooltip -->

			</div>
		</div>
	</div>
	<!-- //About -->



	<!-- Speciality -->
	<div class="w3threespecialityw3ls" id="w3threespecialityw3ls">
		<div class="container">

			<h2>为你代"颜"</h2>
			<div class="grid cs-style-3">
				<c:forEach items="${photoList}" var="p">
					<div class="col-md-4 col-sm-4 w3threespecialityw3ls-grid grid1" style="width: 350px;height: 320px">
						<figure>
							<div class="w3threespecialityw3ls-info">
								<img src="${uploadfile}${p.url}" alt="Couture">
							</div>
							<figcaption>
								<h3>${p.title}</h3>
							</figcaption>
						</figure>
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

				<div class="our-skills wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
					<div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
						<p class="lead">Photography</p>
						<div class="progress">
							<div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar" aria-valuetransitiongoal="90">90%</div>
						</div>
					</div>
					<div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="400ms">
						<p class="lead">Editing</p>
						<div class="progress">
							<div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar" aria-valuetransitiongoal="80">80%</div>
						</div>
					</div>
					<div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="500ms">
						<p class="lead">Direction</p>
						<div class="progress">
							<div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar" aria-valuetransitiongoal="85">85%</div>
						</div>
					</div>
					<div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
						<p class="lead">Quality</p>
						<div class="progress">
							<div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar" aria-valuetransitiongoal="95">95%</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //Skills -->

			<!-- Stats -->
			<div class="stats">
				<h3>生活八卦</h3>

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

		<!-- Default-JavaScript -->   <script type="text/javascript" src="${ctxStatic}/zh/js/jquery.min.js"></script>
		<!-- Bootstrap-JavaScript --> <script type="text/javascript" src="${ctxStatic}/zh/js/bootstrap.min.js"></script>

		<!-- Slider-JavaScript-Files -->
			<script type="text/javascript" src="${ctxStatic}/zh/js/jquery.easing.1.3.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/jquery.mobile.customized.min.js"></script>
			<script type="text/javascript" src="${ctxStatic}/zh/js/camera.js"></script>
			<script>
				jQuery(function(){
					jQuery('#camera_wrap_2').camera({
						loader: 'bar',
						speed: 1000,
						pagination: false,
						thumbnails: false,
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