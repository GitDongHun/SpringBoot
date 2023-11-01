		// const rating_input = document.querySelector('.rating input');
		// const rating_star = document.querySelector('.rating_star');

		// // 별점 드래그 할 때
		// rating_input.addEventListener('input', () => {
		// rating_star.style.width = `${rating_input.value * 10}%`;
		// });
		// $('.star_rating > .star').click(function() {
		// 	$(this).parent().children('span').removeClass('on');
		// 	$(this).addClass('on').prevAll('span').addClass('on');
		// })
$(document).ready(function() {
	let star = $(".rating_star").attr("data-star");
	console.log(star);
	$(".rating_star").css('width', star * 20 + '%');
});

$(document).ready(function() {
    $('.btnlikes').click(function() {
        if ($(this).hasClass('on')) {
            console.log("즐겨찾기 해제");
            // 이미지를 star_empty로 변경
            $(this).find('img').attr('src', '/foodexp/images/star_empty.png');
            $(this).removeClass('on');
            $(this).css('border', '2px solid black');
        } else {
            console.log("즐겨찾기 설정");
            // 이미지를 star_full로 변경
            $(this).find('img').attr('src', '/foodexp/images/star_full.png');
            $(this).addClass('on');
            $(this).css('border', '2px solid #ff8100');
        }
    });
    $('.write_rev').click(function(){
        var rst_id = $('#rst_id').val();
        window.location.href = "/foodexp/rst/revwrite?rst_id=" + rst_id;
    });
});