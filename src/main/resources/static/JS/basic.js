$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: '/api/memos',
        success: function (response) {
            $('#container').empty();
            for (let i = 0; i < response.length; i++) {
                let memo = response[i];
                let id = response.length - memo.id + 1;
                let tempHtml = addHtml(memo, id);
                $('#container').append(tempHtml);
            }
        }
    })
})

function addHtml(memo, id) {
    let date = memo.createAt.substring(0, 10);
    let time = memo.createAt.substring(11, 19);
    return `<tr>
            <td class="order">${id}</td>
            <td class="title" title="${memo.title}">
                <a onclick="modal(${memo.id})" id="title">${memo.title}</a>
            </td>
            <td class="name">${memo.name}</td>
            <td class="time">${date}, ${time}</td>
        </tr>`
}

function modal(id) {
    $('#modal').empty()
    $.ajax({
        type: "GET",
        url: `api/memos/${id}`,
        success: function (response) {
            let tempModal = createModal(response);
            $('#modal').append(tempModal)
            $('#modal').addClass('active');
        }
    })
}
function createModal(response){
    title = response.title;
    date = response.createAt.substring(0, 10) +", "+ response.createAt.substring(11, 19);
    name = response.name;
    desc = response.memos;
    return `<div class="popup">
            <button id="close" class="close" onclick="removeModal()">
                X
            </button>
            <h1>${title}</h1>
            <hr>
            <p>작성자: ${name}<br/>작성 날짜: ${date}</p>
            <hr>
            <div>
                ${desc}
            </div>
        </div>`
}
function removeModal(){
    $('#modal').removeClass('active')
}