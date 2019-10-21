!(function (s) {
    s(function () {
        function a(s) {
            s.appendTo(s.parents("svg>g"));
        }
        s(".mapa-svg-estados").click(function () {
            s(this)
                .siblings()
                .removeClass("mapa-svg-estados-active"),
                s(this).addClass("mapa-svg-estados-active"),
                s(".class-select")
                    .val(s(this).attr("id"))
                    .trigger("change"),
                a(s(this));
            optionCheck()

        }),
            s(".class-select > option").each(function () {
                s(this).addClass(s(this).attr("value"));

            }),
            s(".class-select").change(function () {
                s("." + s(this).val() + "-class")
                    .siblings()
                    .removeClass("mapa-svg-estados-active"),
                    s("." + s(this).val() + "-class").addClass(
                        "mapa-svg-estados-active"
                    ),
                    a(s("." + s(this).val() + "-class"));
            });

    });
})(jQuery);


function selecionaLocal() {
    var confirma = confirm("Deseja ir ao Dashboard?");

    if (confirma == true) {

        window.location.href = "dashboard.html";
    }
}


function optionCheck() {
    var option = document.getElementById("estados").value;
    document.getElementById("DivOculta").style.visibility = "visible";
}