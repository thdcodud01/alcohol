$(document).ready(function(){
//   끝
})

$(".btn").click(function(){
  $("html , body").animate({
    "scrollTop":0,
  },300)
})

$(window).scroll(function(){
  let scrollTop = $(this).scrollTop()
  if(scrollTop>=600){
  }
})