$(".user-wishlist").click(function () {
  
  $(".user-info").removeClass("active").css('display','none');
  $(".user-like").removeClass("active").css('display','none');
  $(".user-review").removeClass("active").css('display','none');
  $(".user-modify").removeClass("active").css('display','none');
  $(".user-wish").addClass("active").css('display','block');
});

$(".user-reviewlist").click(function () {
  $(".user-info").removeClass("active").css('display','none');
  $(".user-like").removeClass("active").css('display','none');
  $(".user-wish").removeClass("active").css('display','none');
  $(".user-modify").removeClass("active").css('display','none');
  $(".user-review").addClass("active").css('display','block');
});

$(".user-likelist").click(function () {
  $(".user-info").removeClass("active").css('display','none');
  $(".user-review").removeClass("active").css('display','none');
  $(".user-wish").removeClass("active").css('display','none');
  $(".user-modify").removeClass("active").css('display','none');
  $(".user-like").addClass("active").css('display','block');
});

$(".user-information-modify").click(function () {
  $(".user-info").removeClass("active").css('display','none');
  $(".user-review").removeClass("active").css('display','none');
  $(".user-wish").removeClass("active").css('display','none');
  $(".user-like").removeClass("active").css('display','none');
  $(".user-modify").addClass("active").css('display','block');
});
