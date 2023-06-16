
$(".user-information").click(function(){
  $(".user-wish").removeClass("active");
  $(".user-like").removeClass("active");
  $(".user-review").removeClass("active");
  $(".user-modify").removeClass("active");
  $(".user-info").addClass("active");
});

$(".user-wishlist").click(function(){
  $(".user-info").removeClass("active");
  $(".user-like").removeClass("active");
  $(".user-review").removeClass("active");
  $(".user-modify").removeClass("active");
  $(".user-wish").addClass("active");
});

$(".user-reviewlist").click(function(){
  $(".user-info").removeClass("active");
  $(".user-like").removeClass("active");
  $(".user-wish").removeClass("active");
  $(".user-modify").removeClass("active");
  $(".user-review").addClass("active");
});


$(".user-likelist").click(function(){
  $(".user-info").removeClass("active");
  $(".user-review").removeClass("active");
  $(".user-wish").removeClass("active");
  $(".user-modify").removeClass("active");
  $(".user-like").addClass("active");
});


$(".user-information-modify").click(function(){
  $(".user-info").removeClass("active");
  $(".user-review").removeClass("active");
  $(".user-wish").removeClass("active");
  $(".user-like").removeClass("active");
  $(".user-modify").addClass("active");
});