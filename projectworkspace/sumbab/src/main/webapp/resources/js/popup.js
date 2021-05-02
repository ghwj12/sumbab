function popup() {
	var url = "addPhoto";
	var name = "사진 첨부하기";
	var option = "width = 500, height = 500, toolbar=no,location=no, status=no, scrollbars=no";
		
	window.open(url, name, option);
}

function popupForCancel(reserveSeq) {
	var url = "cancelReserve/"+reserveSeq;
	var name = "예약 취소 안내";
	var option = "width = 500, height = 500, toolbar=no,location=no, status=no, scrollbars=no";

	window.open(url, name, option);
}