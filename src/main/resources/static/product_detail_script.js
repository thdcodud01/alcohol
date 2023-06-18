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


// 추천 누르면 색깔 칠해짐
$(document).ready(function() {
  $('#recommendation').click(function() {
    $(this).toggleClass('clicked');
  });
});

$(document).ready(function() {
// 공유 버튼 클릭 시 동작하는 함수
$(".share-button").click(function() {
var dummyInput = document.createElement("input");
var currentURL = window.location.href;

$("body").append(dummyInput);
$(dummyInput).val(currentURL);
$(dummyInput).select();
document.execCommand("copy");
$(dummyInput).remove();

alert("URL이 복사되었습니다: " + currentURL);
});

