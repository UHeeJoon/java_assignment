function writePost() {
    let title = $('#floatingInput').val();
    let desc = $('#floatingTextarea2').val();
    $.ajax({
        type: "POST",
        url: "api/memos/post",
        contentType: "application/json",
        data: JSON.stringify({'title': title, 'memos': desc}),
        success: function (response) {
            alert("글 작성이 완료되었습니다");
            window.location.href = "/";
        }
    })
}