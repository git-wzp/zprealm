if(/(iphone|ipad|android|ipod)/.test(navigator.userAgent.toLowerCase())){
	location.href='/mobile/';
	//return ;
}
/**
 * @author star
 */
var Main={};
Main.on=function(){	
    
    var div_tab1_ulli=$('.div_tab1_ul').find('li'),ullist_3=$(".ullist_3")
    $('.div_tab1_ul').on('click','li',function(){    	
    	div_tab1_ulli.removeClass('current');
    	$(this).addClass('current');
    	var index=$(this).index();
    	$('.ullist_3').attr('class','ullist_3 current_'+index)
    })	
    $('.ullist_6').on('click','li',function(){
    	var id=$(this).data('id');
    	//$('html').addClass('html_over')
    	Main.tempjoin(id);
    	//Main.noscroll($('html'));
    	Main.topbool=false;
    	$('.page_box_join').addClass('current')
    })
    $('.box_close').on('click',function(){
    	//$('html').removeClass('html_over')
    	//Main.canscroll($('html'));
    	Main.topbool=true;
    	$('.page_box_join').removeClass('current')
    })
    $('.close_case').on('click',function(){
    	Main.topbool=true;
    	$('.page_case_box').removeClass('current');
    })    
}
Main.scrollBind=function(){
	Main.topindex=0;
    Main.topbool=true;
    Main.page_index=$(".page_index")
    if(document.addEventListener){ 
        document.addEventListener('DOMMouseScroll',scrollFunc,false); 
    }//W3C 
    window.onmousewheel=document.onmousewheel=scrollFunc;//IE/Opera/Chrome 
    function scrollFunc(e){ 
        e=e || window.event; 
        var t1=document.getElementById("wheelDelta"); 
        var t2=document.getElementById("detail"); 
        if(e.wheelDelta){//IE/Opera/Chrome             
            //console.log(e.wheelDelta)// - 向下  + 向上
            Main.scrollTop(e.wheelDelta)
        }else if(e.detail){//Firefox 
            //console.log(e.detail)  //+向下  - 向上
            Main.scrollTop(-e.detail)
        } 
    } 
}
Main.scrollTop=function(num){
	if(Main.topbool==false){
		return ;
	}
	Main.topbool=false;
	if(num<0){//下
		if(Main.topindex<6){
			Main.topindex+=1;
			//Main.page_index.animate({"top":-Main.height*Main.topindex+'px'},400)				
		}
	}else{//上
	    if(Main.topindex>0){
	    	Main.topindex-=1;
			//Main.page_index.animate({"top":-Main.height*Main.topindex+'px'},400)			
	    }	
	}
	var a=['#index','#about','#service','#customer','#case','#join','#contact']
//	location.href='index.html'+a[Main.topindex]
	location.href=a[Main.topindex]
	if(Main.topindex==0){
		//$('.header_1').removeClass('current');
	}else{
		//$('.header_1').addClass('current');
	}
	setTimeout(function(){
		Main.topbool=true;
	},400);		
}
Main.bind=function(){
	$('.but_join_1').off('click').on('click',function(){
		var id=$(this).data('id');		
	})
}
Main.noscroll=function(el){
	el.on('mousewheel',function(e){
		preventscroll(e);
	})
	el.on('DOMMouseScroll',function(e){
		preventscroll(e);
	})
	function preventscroll(e){
    	e=e || window.event;    	
    	if(e && e.preventDefault){
    		e.preventDefault();
    		e.stopPropagation();
    	}else{
    		e.returnvalue=false;
    		return false;
    	}
    }
}
Main.canscroll=function(el){
	el.off('mousewheel')
	el.off('DOMMouseScroll')
}
Main.init=function(){	
	Main.scrollBind();
	Main.ortchange();
	window.onresize = function() {		
		Main.ortchange();
		setTimeout(function(){
		    Main.page_index.animate({"top":-Main.height*Main.topindex+'px'},200)	
	    })	
	}		
	Main.hashchange();
}
Main.ortchange=function(){	
	Main.height=$(window).height()
	$('.page').css({height:Main.height+'px'})	
}
Main.hashchange=function(){
	var index=0;
	function hash(num){
		var a=location.href.split('#')
		if(a.length<2 || a[1].indexOf('index')>-1){
		    //console.log('index')	
		    index=0;
		}else if(a[1].indexOf('about')>-1){
			//console.log('about')
			index=1;
		}else if(a[1].indexOf('service')>-1){
			//console.log('service')
			index=2;
		}else if(a[1].indexOf('customer')>-1){
			//console.log('customer')
			index=3;
		}else if(a[1].indexOf('case')>-1){
			//console.log('case')
			index=4;
		}else if(a[1].indexOf('join')>-1){
			//console.log('join')
			index=5;
		}else if(a[1].indexOf('contact')>-1){
			//console.log('contact')
			index=6;
		}	
		Main.scrolltopanimate(index,num);			
	}
	hash(10);
	window.onhashchange=function(){
		hash();
	}
}
Main.scrolltopanimate=function(index,num){	
	Main.page_index.animate({"top":-Main.height*index+'px'},num || 400)
		if(index==0){
		    $('.header_1').removeClass('current');
	    }else{
		    $('.header_1').addClass('current');
	    }
	Main.topindex=index;	
}

Main.getxml=function(url,call){
	$.ajax({
		url:url,type:'get',dataType:'xml',cache:false,error:function(err){
			call(err,null);			
		},success:function(res){
			call(null,res)			
		}
	})
}
Main.getxml('join.xml',function(err,data){	
	Main.joindata=[];	
	$(data).find('note').each(function(i){
		var obj={};
		obj.id=$(this).attr('id');
		obj.miaoshu=$(this).children('miaoshu').text().replace(/[\;\；]/gi,';<br>')
		obj.xuqui=$(this).children('xuqui').text().replace(/[\;\；]/gi,';<br>')
		obj.title=$(this).children('title').text();
		Main.joindata.push(obj);		
	})	
});



Main.tempcase=function(){
	Main.temp($('.ullist_5'),$("#id_case").html(),{data:Main.casedata});
	Main.casetab=new Main.tab1('.div_tab3');
}
Main.tempjoin=function(id){
	//alert(Main.joindata)
	for(var i=0;i<Main.joindata.length;i++){
	    if(Main.joindata[i].id==id){
	    	temp(Main.joindata[i])
	    	return ;
	    }
	}	
	function temp(obj){		
		Main.temp($('#id_temp_con_join'),$('#id_join_show').html(),obj)
	}
}
//渲染结构    jquery标签     模板    数据
Main.temp=function(dom,temp,obj){
	var temp=_.template(temp);
	var txt=temp(obj);
	dom.html(txt);
}
Main.tab1=function(obj){
	var that=this;
	this.obj=$(obj);
	this.ul=this.obj.find('ul');
	this.next=this.obj.find('.next');
	this.prev=this.obj.find('.prev');
	
	this.next.on('click',function(){		
		if(that.index<that.length-1){
			that.index++;
			that.setleft();
		}
	})
	this.prev.on('click',function(){
		if(that.index>0){
			that.index--;
			that.setleft();
		}
	})
	this.setleft=function(){
		that.ul.animate({'left':-1175*that.index},400);
	}
	this.refresh=function(){
		this.lis=this.ul.find('li').length;
	    this.length=Math.ceil(this.lis/3);
	    that.ul.css({'left':'0px'})
	    this.index=0;
	}
	//全球通史     自私的基因  枪炮病菌和钠铁    失控       时间简史    从黎明到衰落  艺术的故事
	this.refresh();
	this.setdata=function(type){		
		if(!isNaN(type)){//类型
			if(type==0){
				for(var i=0;i<Main.casedata.length;i++){
					Main.casedata[i].show=1;
				}
			}else {
				for(var i=0;i<Main.casedata.length;i++){
					if(Main.casedata[i].type==type){
						Main.casedata[i].show=1;
					}else{
						Main.casedata[i].show=0;
					}
				}
			}
		}else{			
			for(var i=0;i<Main.casedata.length;i++){
				if(Main.casedata[i].biao.indexOf(type)>-1){
					Main.casedata[i].show=1;
				}else{
					Main.casedata[i].show=0;
				}
			}
		}
		Main.temp($('.ullist_5'),$("#id_case").html(),{data:Main.casedata});
		that.refresh();
	}
	
	//分类绑定
	var acu=$(".div_tab2_1").find('a');
	$(".ullist_nav2").on('click','li',function(e){
		var type=$(this).data('type');
		if(!$(this).hasClass('current')){
			$(".ullist_nav2").find('li').removeClass('current');
			$(this).addClass('current');
			that.setdata(type);
			acu.removeClass('current');
		};
	})
	$(".div_tab2_1").on('click','a',function(e){
		var type=$(this).html().replace(' ','');		
		if(!$(this).hasClass('current')){
			$(".ullist_nav2").find('li').removeClass('current');
			acu.removeClass('current');
			$(this).addClass('current');
			that.setdata(type);
		};
	})
	
	//弹出绑定
	$(".ullist_5").on('click','li',function(e){
		var id=$(this).data('id');
		var obj;
		for(var i=0;i<Main.casedata.length;i++){
			if(Main.casedata[i].id==id){
			    obj=Main.casedata[i];				    
			}
		}
		Main.temp($('#show_temp'),$("#id_case_show").html(),obj);
		$('.page_case_box').addClass('current');
		Main.topbool=false;
	})
}
$(function(){
	
    Main.getxml('case.xml',function(err,data){    	
	    Main.casedata=[];
	    $(data).find('note').each(function(i){
		    var obj={};
		    obj.id=$(this).attr('id');
		    obj.type=$(this).attr('type');
		    obj.title=$(this).children('title').text();
		    obj.re=$(this).children('re').text();
		    obj.img=$(this).children('img').text();
		    obj.pai=$(this).children('pai').text();
		    obj.time=$(this).children('time').text();
		    obj.biao=$(this).children('biao').text()//.replace(' ','').split('/');
		    obj.bgimg=$(this).children('bgimg').text();
		    obj.con=$(this).children('con').text();
            obj.ma=$(this).children('ma').text();
		    obj.top=$(this).attr('top');	
		    obj.show=1;
		    Main.casedata.push(obj);
	    });		 
	    var newarr=_.sortBy(Main.casedata,function(num){
	    	return -num.top;
	    })
	    Main.casedata=newarr;
	    setTimeout(function(){
	    	 Main.tempcase();
	    },200)   	   
    });

})
$(function(){
	Main.init()
	Main.on();
	Main.bind();	
	
})



jQuery(function($) {
	
	//Initiat WOW JS
	new WOW().init();
	//smoothScroll
	smoothScroll.init();
	
	// Progress Bar
	$('#about-us').bind('inview', function(event, visible, visiblePartX, visiblePartY) {
		if (visible) {
			$.each($('div.progress-bar'),function(){
				$(this).css('width', $(this).attr('aria-valuetransitiongoal')+'%');
			});
			$(this).unbind('inview');
		}
	});

	//Countdown
	$('#features').bind('inview', function(event, visible, visiblePartX, visiblePartY) {
		if (visible) {
			$(this).find('.timer').each(function () {
				var $this = $(this);
				$({ Counter: 0 }).animate({ Counter: $this.text() }, {
					duration: 2000,
					easing: 'swing',
					step: function () {
						$this.text(Math.ceil(this.Counter));
					}
				});
			});
			$(this).unbind('inview');
		}
	});
	
});
