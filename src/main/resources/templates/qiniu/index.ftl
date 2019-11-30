<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>七牛图片上传</title>

    <link rel="stylesheet" href="/static/plugins/ckeditor_4.7.0_full/contents.css" />
</head>
<body>
    <textarea id="ck"></textarea>
</body>
</html>
<script type="application/javascript" src="/static/plugins/ckeditor_4.7.0_full/ckeditor.js"></script>
<script type="application/javascript">
    // CKEDITOR.replace("ck", {
    //     filebrowserBrowseUrl: '/qiniu/service?type=Files',
    //     filebrowserUploadUrl: '/uploader/upload.php?type=Files'
    // });
    CKEDITOR.replace('ck');
    SetCKEditor("ck");

    function SetCKEditor(ckname, data) {
        CKEDITOR.instances[ckname].on('instanceReady', function (event) {
            var _data = (event.data || "");
            if (_data != "") {
                this.setData(HTMLEncode(_data));
            }
            this.document.on("paste", function (e) {//重写该ckeditor实例的粘贴事件
                var items = e.data.$.clipboardData.items;//获取该ckeditor实例的所有剪切板数据
                for (var i = 0; i < items.length; ++i) {//循环该数据并只获取类型为image/png格式的数据
                    var item = items[i];
                    if (item.kind == 'file' && item.type == 'image/png') {
                        var imgFile = item.getAsFile();
                        if (!imgFile) {
                            return true;
                        }
                        var reader = new FileReader();
                        reader.readAsDataURL(imgFile);//转化为base64格式
                        reader.onload = function (e) {//在控件中插入该图片
                            CKEDITOR.instances["description"].insertHtml('<img src="' + this.result + '" alt="" />');
                        }
                        return false;
                    }
                }
            });
        });
    }
</script>
