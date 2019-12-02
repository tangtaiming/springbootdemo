<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>七牛图片上传</title>

    <link rel="stylesheet" href="/static/plugins/ckeditor/contents.css" />
</head>
<body>
    <textarea id="ck"></textarea>
</body>
</html>
<script type="application/javascript" src="/static/plugins/ckeditor/ckeditor.js"></script>
<script type="application/javascript">
    CKEDITOR.replace("ck", {
        uploadUrl:'/qiniu/upload?type=Files&responseType=json',
        filebrowserBrowseUrl: '/qiniu/service?type=Files&responseType=json',
        // filebrowserUploadUrl: '/qiniu/upload?type=Files&responseType=json'
        filebrowserUploadUrl: '/qiniu/upload',
    });
</script>
