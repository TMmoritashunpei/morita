var particles = Particles.init({
  selector: '.background',
  sizeVariations: 15,
  color: ['#aaa6a0', '#073d0c', '#d5edd7','#efd1ac','#f28f4d'],
  connectParticles: true
});

$(function() {
    $('.comment').mouseover(function(){
        $('ui',this).show();
    });    
});

$(function() {
    $('.comment').mouseout(function(){
        $('ui',this).hide();
    });    
});

$(function() {
    $('.showbtn').click(function(){
        $('.messagechenge').show();
    });    
});