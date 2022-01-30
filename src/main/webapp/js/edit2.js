function loadBrands() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/carSales/loadMark',
        dataType: 'json'
    }).done(function (data) {
        console.log(data)
        for (let brands of data) {
            $('#mark').append(`<option value="${brands.id}">${brands.name}</option>`)
            console.log(brands);
        }
        $('select').formSelect();

    }).fail(function (err) {
        console.log(err);
    });

}

function loadMarks() {
    $('#model').empty();
    let brand = ($('#mark option:selected').text());
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/carSales/loadModels',
        data: 'brand=' + brand,
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (let models of data) {
            console.log(models)
            $('#model').append(`<option value="${models.id}">${models.name}</option>`)
        }
        $('select').formSelect();

    }).fail(function (err) {
        alert(err);
    });
}

function loadTransmissions(f) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/carSales/loadTransmissions',
        dataType: 'json'
    }).done(function (data) {
        console.log(data)
        for (let transmissions of data) {
            console.log(transmissions);
            $('#transmission').append(`<option value="${transmissions.id}">${transmissions.name}</option>`)
        }
        $('#transmission option:contains(' + f + ')').prop('selected', true);
        $('select').formSelect();

    }).fail(function (err) {
        console.log(err);
    });
}

function loadCarBodies(f) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/carSales/loadCarBody',
        dataType: 'json'
    }).done(function (data) {
        console.log(data)
        for (let carBodyes of data) {
            $('#carBody').append(`<option value="${carBodyes.id}">${carBodyes.name}</option>`);
        }
        $('#carBody option:contains(' + f + ')').prop('selected', true);
        $('select').formSelect();

    }).fail(function (err) {
        console.log(err);
    });
}