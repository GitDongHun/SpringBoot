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

/*
 $(document).ready(function() {
 let star = $(".rating_star").attr("data-star");
 console.log(star);
 $(".rating_star").css('width', star * 20 + '%');
 });
 */

$(document).ready(function() {
	// 즐겨찾기가 되어있는지
	var isLiked = $('#isLiked').val();
	var $btnlikes = $('.btnlikes');
	if (isLiked == 1) {
		// 이미 즐겨찾기한 경우
		$btnlikes.find('img').attr('src', '/foodexp/images/star_full.png');
		$btnlikes.addClass('on');
		$btnlikes.css('border', '2px solid #ff8100');
	} else {
		// 아직 즐겨찾기하지 않은 경우
		$btnlikes.find('img').attr('src', '/foodexp/images/star_empty.png');
		$btnlikes.removeClass('on');
		$btnlikes.css('border', '2px solid black');
	}

	// 즐겨찾기 버튼을 눌렀을때
	$('.btnlikes').click(function() {
		if ($(this).hasClass('on')) {
			// 즐겨찾기 해제
			console.log("해제");
			$(this).find('img').attr('src', '/foodexp/images/star_empty.png');
			$(this).removeClass('on');
			$(this).css('border', '2px solid black');
			delLikes()
		} else {
			// 즐겨찾기 설정
			$(this).find('img').attr('src', '/foodexp/images/star_full.png');
			$(this).addClass('on');
			$(this).css('border', '2px solid #ff8100');
			addLikes()
		}
	});

	$('.write_rev').click(function() {
		var rst_id = $('#rst_id').val();
		window.location.href = "/foodexp/rst/revwrite?rst_id=" + rst_id;
	});
});

function delLikes() {
	var rst_id = $('#rst_id').val();
	$.ajax({
		type : 'POST',
		url : '/foodexp/rst/delLikes?rst_id=' + rst_id,
		success : function(data) {
			window.location.reload();
		}
	});
}

function addLikes() {
	var rst_id = $('#rst_id').val();
	$.ajax({
		type : 'POST',
		url : '/foodexp/rst/addLikes?rst_id=' + rst_id,
		success : function(data) {
			window.location.reload();
		}
	});
}
