function popupForCancel(reserveSeq) {
	var url = "cancelReserve/"+reserveSeq;
	var name = "예약 취소 안내";
	var option = "width = 500, height = 500, toolbar=no,location=no, status=no, scrollbars=no";

	window.open(url, name, option);
}

function popupForDelReview(reviewNum) {
	var url = "/sumbab/review/deleteReview/"+reviewNum;
	var name = "리뷰 삭제 팝업";
	var option = "width = 500, height = 500, toolbar=no,location=no, status=no, scrollbars=no";
	
	window.open(url, name, option);
}
