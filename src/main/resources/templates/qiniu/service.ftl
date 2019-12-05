<img src="/static/images/tomtopmayi.gif" id="img1">
<input type="button" id="but" value="选择图片">
<script type="application/javascript" src="/static/plugins/jquery/dist/jquery.min.js"></script>
<script type="application/javascript">
    /**
     * 选择图片
     * @param imageId
     */
    selectImg = function (imageId) {
        $.ajax({
            url: "/qiniu/doService",
            success: function (e) {
                console.log("success");
                window.close();
            }
        });
    }

    $(document).ready(function () {
        var button = $('#but');
        button.click(function() {
            selectImg('img1');
        });
    });
</script>