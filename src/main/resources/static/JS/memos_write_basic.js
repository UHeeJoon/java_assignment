function writePost() {
    let title = $('#floatingInput').val();
    let name = $('#floatingPassword').val();
    let desc = $('#floatingTextarea2').val();
    $.ajax({
        type: "POST",
        url: "api/memos",
        contentType: "application/json",
        data: JSON.stringify({'title': title, 'name': name, 'memos': desc}),
        success: function (response) {
            alert("글 작성이 완료되었습니다");
            window.location.href = "/";
        }
    })
}