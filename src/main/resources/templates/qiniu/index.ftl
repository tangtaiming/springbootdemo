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
    CKEDITOR.replace("ck", {
        filebrowserBrowseUrl: '/qiniu/service?type=Files',
        filebrowserUploadUrl: '/qiniu/upload'
    });
</script>
