var particles = Particles.init({
  selector: '.background',
  sizeVariations: 15,
  color: ['#aaa6a0', '#073d0c', '#d5edd7','#efd1ac','#f28f4d'],
  connectParticles: true
});

$(function() {
    $('.comment').mouseover(function(){
        $('.button',this).show();
    });    
});

$(function() {
    $('.comment').mouseout(function(){
        $('.button',this).hide();
    });    
});

$(function() {
    $('.button,#hide').click(function(){
        $(this).children().show();
        $(this).children('.showbtn').hide();
    });    
});

$(function() {
    $('#cansel').click(function(){
        $(this).hide();
    });    
});
